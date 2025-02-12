package com.kazmi.dev.project.utils

import android.content.Context
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.os.LocaleListCompat
import java.util.Locale

object LocaleHelper {

    fun updateLocaleAndroid13Above(languageCode: String) {
        val locale = LocaleListCompat.forLanguageTags(languageCode)
        AppCompatDelegate.setApplicationLocales(locale)
    }

    fun updateLocaleAndroid6Above(context: Context, languageCode: String): Context {
        val locale = Locale(languageCode)
        Locale.setDefault(locale)

        val config = Configuration(context.resources.configuration)
        config.apply {
            setLocale(locale)
            setLayoutDirection(locale)
        }
        return context.createConfigurationContext(config)
    }

    fun saveLanguageCode(context: Context, languageCode: String) {
        val sharedPreference = context.getSharedPreferences("LanguagePref", Context.MODE_PRIVATE)
        sharedPreference.edit().apply {
            putString("LanguageCode", languageCode)
            apply()
        }
    }

    fun getLanguageCode(context: Context): String {
        val sharedPreferences = context.getSharedPreferences("LanguagePref", Context.MODE_PRIVATE)
        return sharedPreferences.getString("LanguageCode", "en") ?: "en"
    }


}