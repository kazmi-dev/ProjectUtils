package com.kazmi.dev.project.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.ConnectivityManager.NetworkCallback
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

object NetworkUtils {

    fun isNetworkConnected(context: Context): Boolean{
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val network = cm.activeNetwork?: return false
        val networkCapabilities = cm.getNetworkCapabilities(network)?: return false

        return when{
            networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            else -> false
        }
    }

    fun isWifiConnected(context: Context): Boolean{
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val network = cm.activeNetwork?: return false
        val networkCapabilities = cm.getNetworkCapabilities(network)?: return false
        return networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
    }

    fun isCellularConnected(context: Context): Boolean{
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val network = cm.activeNetwork?: return false
        val networkCapabilities = cm.getNetworkCapabilities(network)?: return false
        return networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)
    }

    fun internetObserver(context: Context) : Flow<Boolean>{
        return callbackFlow {
            val networkCallback = object: NetworkCallback(){
                override fun onAvailable(network: Network) {
                   trySend(true)
                }
                override fun onLost(network: Network) {
                    trySend(false)
                }
            }
            val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val networkRequest = NetworkRequest.Builder()
                .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
                .build()
            cm.registerNetworkCallback(networkRequest, networkCallback)

            awaitClose {
                cm.unregisterNetworkCallback(networkCallback)
            }

        }
    }


}