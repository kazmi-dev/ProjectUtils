package com.kazmi.dev.project.utils

import android.Manifest
import android.os.Build
import android.os.Build.VERSION.SDK_INT
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.kazmi.dev.project.utils.ToastUtils.shortToast
import com.kazmi.dev.project.utils.databinding.ActivityMainBinding
import com.kazmi.dev.project.utils.enums.SortOrder
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val binding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }

    private lateinit var permissionLauncher: ActivityResultLauncher<String>
    private lateinit var andorid13PermissionLauncher: ActivityResultLauncher<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        registerLauncher()

//        lifecycleScope.launch {
//            NetworkUtils.internetObserver(this@MainActivity).collectLatest {
//                if(it){
//                    if (NetworkUtils.isWifiConnected(this@MainActivity)){
//                        shortToast("Wifi Connected")
//                    }else if(NetworkUtils.isCellularConnected(this@MainActivity)){
//                        shortToast("Cellular Connected")
//                    }
//                }else{
//                    shortToast("Disconnected")
//                }
//            }
//        }

//        binding.snaBarBtn.setOnClickListener {
//            SnackBarUtils.showSnackBar(
//                binding.snaBarBtn,
//                "This is my snakbar",
//                actionText = "Undo",
//                action = {
//                    SnackBarUtils.dismissSnackBar()
//                }
//            )
//        }

        binding.snaBarBtn.setOnClickListener {
            if (isPermissionGranted(Manifest.permission.READ_EXTERNAL_STORAGE)){
                lifecycleScope.launch {
                    MediaStoreUtils.getAllLocalMedia(
                        this@MainActivity,
                        sortOrder = SortOrder.ASCENDING
                    )
                }
            }else{
                takePermission(Manifest.permission.READ_EXTERNAL_STORAGE)
            }
        }


    }

    private fun registerLauncher() {
        permissionLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()){
            if (it){
                shortToast("Permission Granted")
                lifecycleScope.launch {
                    MediaStoreUtils.getAllLocalImages(
                        this@MainActivity,
                        sortOrder = SortOrder.ASCENDING
                    )
                }
            }else{
                shortToast("Permission Denied")
            }
        }

        andorid13PermissionLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()){
            if (it){
                shortToast("Permission Granted")
                lifecycleScope.launch {
                    MediaStoreUtils.getAllLocalMedia(
                        this@MainActivity,
                        sortOrder = SortOrder.ASCENDING
                    )
                }
            }else{
                shortToast("Permission Denied")
            }
        }
    }

    private fun takePermission(readExternalStorage: String) {
        if (SDK_INT >= Build.VERSION_CODES.TIRAMISU){
            andorid13PermissionLauncher.launch(Manifest.permission.READ_MEDIA_IMAGES)
        }else{
            permissionLauncher.launch(readExternalStorage)
        }
    }

    private fun isPermissionGranted(
        readExternalStorage: String
    ): Boolean {
        return if(SDK_INT >= Build.VERSION_CODES.TIRAMISU){
            ContextCompat.checkSelfPermission(this, Manifest.permission.READ_MEDIA_IMAGES) == android.content.pm.PackageManager.PERMISSION_GRANTED
        }else{
            ContextCompat.checkSelfPermission(this, readExternalStorage) == android.content.pm.PackageManager.PERMISSION_GRANTED
        }
    }
}