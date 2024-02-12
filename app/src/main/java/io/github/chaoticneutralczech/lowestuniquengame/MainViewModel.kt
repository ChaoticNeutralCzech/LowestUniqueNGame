package io.github.chaoticneutralczech.lowestuniquengame
import android.content.Context
import android.net.wifi.WifiManager
import android.text.format.Formatter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel(val data: String) : ViewModel() {

    val showInterfaceToast = MutableLiveData<Unit>()
    val joinURL = MutableLiveData<String>() //Kotlin Unit = Java void
    val showSharedVMToast = MutableLiveData<Unit>()

    data class PlayerData(val ip: String, val nick: String, val realname: String, val seqID: Int)
    class PlayerRepo {
        fun getPlayerData(): PlayerData {
            return PlayerData("0.0.0.0", "sample", "johnny", 0)
        }
    }



    /*
    fun getJoinURL() {
        val wifiManager = applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
        var strIp: String = Formatter.formatIpAddress(wifiManager.connectionInfo.ipAddress)
        joinURL.value =
    }
    */
    // Shows a Toast using SharedViewModel implementation
    fun onShowVMToastClick() {
        showSharedVMToast.value = Unit
    }

}