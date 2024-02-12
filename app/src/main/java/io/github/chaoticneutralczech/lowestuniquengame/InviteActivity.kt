package io.github.chaoticneutralczech.lowestuniquengame

import android.content.Context
import android.graphics.Point
import android.net.wifi.WifiManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.text.format.Formatter
import android.view.Display
import android.view.WindowManager
import android.widget.Toast
import androidmads.library.qrgenearator.QRGContents
import androidmads.library.qrgenearator.QRGEncoder
//import R
import androidx.core.internal.view.SupportMenu
import android.graphics.Bitmap
import android.graphics.Color
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import kotlinx.coroutines.time.delay
import java.net.InetAddress
import java.net.NetworkInterface
import androidx.fragment.app.Fragment
import androidx.lifecycle.VIEW_MODEL_STORE_OWNER_KEY
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class InviteActivity : AppCompatActivity() {
    lateinit var qrIV: ImageView
    lateinit var msgEdt: EditText
    lateinit var generateQRBtn: Button
    lateinit var titleTV: TextView
    lateinit var instrTV: TextView
    lateinit var mToolbar: Toolbar
    lateinit var joinURL: String

    // on below line we are creating
    // a variable for bitmap
    lateinit var bitmap: Bitmap

    // on below line we are creating
    // a variable for qr encoder.
    var qrgEncoder = QRGEncoder("inputValue", null, QRGContents.Type.TEXT, 12)
    lateinit var qrEncoder: QRGEncoder



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_invite)
        // The Toolbar defined in the layout has the id "my_toolbar".
        /*setSupportActionBar(findViewById(R.id.goback_toolbar))


        }
        fun onCreate(menu: SupportMenu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_back_from_invite, menu)*/



        // on below line we are
        // initializing our all variables.
        qrIV = findViewById(R.id.idIVQrcode)
        //titleTV = findViewById(R.id.idTVHeading)
        //msgEdt = findViewById(R.id.idEdt)
        //generateQRBtn = findViewById(R.id.idBtnGenerateQR)
        instrTV = findViewById(R.id.idTVtext)
        //titleTV.text = ("strIp")
        val portString: String = ":8080"
        val wifiManager = applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
        var strIp: String = Formatter.formatIpAddress(wifiManager.connectionInfo.ipAddress)
        var strURL: String = "http://" + strIp + portString
        var howtojoin: String = getString(R.string.gi_instructions_public) + "\n" + strURL
        instrTV.text = howtojoin

        val windowManager: WindowManager = getSystemService(WINDOW_SERVICE) as WindowManager
        val display: Display = windowManager.defaultDisplay
        val point: Point = Point()
        display.getSize(point)
        val width = point.x
        val height = point.y
        var dimen = if (width < height) width else height
        dimen = dimen * 3 / 4

     // qrEncoder.colorBlack = R.layout.
        qrEncoder = QRGEncoder(strURL, null, QRGContents.Type.TEXT, dimen)
        qrEncoder.colorBlack = (Color.WHITE) //cannot get theme-based colors?!
        qrEncoder.colorWhite = (Color.BLACK) //cannot get theme-based colors?!
        try {
            bitmap = qrEncoder.bitmap
            qrIV.setImageBitmap(bitmap)
        } catch (e: Exception) { e.printStackTrace() }

        mToolbar = findViewById(R.id.topAppBar)

        setSupportActionBar(mToolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        mToolbar.setNavigationOnClickListener {
            finish()
        }

        //joinURL =
        //titleTV.text = joinURL
    }
}