package io.github.chaoticneutralczech.lowestuniquengame

import android.content.Context
import android.net.wifi.WifiManager
import android.os.Bundle
import android.text.format.Formatter
import android.util.Log
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import io.github.chaoticneutralczech.lowestuniquengame.databinding.ActivityInviteBinding
import io.github.chaoticneutralczech.lowestuniquengame.databinding.ActivityMainBinding
import io.github.chaoticneutralczech.lowestuniquengame.databinding.FragmentMenuPlayersBinding
import java.net.NetworkInterface



class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private lateinit var ibinding: ActivityInviteBinding
    private lateinit var psbinding: FragmentMenuPlayersBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        ibinding = ActivityInviteBinding.inflate(layoutInflater)
        psbinding = FragmentMenuPlayersBinding.inflate(layoutInflater)
        //val iURLview = ibinding.idTVHeading  //findViewById<TextView>(ibinding.idTVHeading.id)!!
        val iURLview = psbinding.itemNumber

//        setContentView(R.layout.activity_main)

        //var strIp = getLocalIPAddress()
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, MenuSettingsFragment()).commit() //default on app start

        val navListener = NavigationBarView.OnItemSelectedListener {
            lateinit var selectedFragment: Fragment
            when (it.itemId) {
                R.id.settings -> {
                    selectedFragment = MenuSettingsFragment()
                }
                R.id.players -> {
                    selectedFragment = MenuPlayersFragment()
                }
                R.id.play -> {
                    selectedFragment = MenuPlayFragment()
                }
                R.id.stats -> {
                    selectedFragment = MenuStatsFragment()
                }
            }
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, selectedFragment).commit()
            true
        }
        bottomNav.setOnItemSelectedListener(navListener)

        val wifiManager = applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
        var strIp: String = Formatter.formatIpAddress(wifiManager.connectionInfo.ipAddress)
        //strIp = getLocalIPAddress()
        Log.d("a", strIp)
        iURLview.text = strIp


    }
    fun getLocalIPAddress(): String? {
        try {
            val en = NetworkInterface.getNetworkInterfaces()
            while (en.hasMoreElements()) {
                val networkInterface = en.nextElement()
                val enu = networkInterface.inetAddresses
                while (enu.hasMoreElements()) {
                    val inetAddress = enu.nextElement()
                    if (!inetAddress.isLoopbackAddress && inetAddress is java.net.Inet4Address) {
                        return inetAddress.getHostAddress()
                    }
                }
            }
        } catch (ex: Exception) {
            ex.printStackTrace()
        }

        return null
    }
}