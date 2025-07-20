package com.example.testproject

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private var keepSplash = true
    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        splashScreen.setKeepOnScreenCondition { keepSplash }
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        lifecycleScope.launch {
            delay(1500) // Delay for 1.5 seconds
            keepSplash = false
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val button1 = findViewById<LinearLayout>(R.id.button1)
        val button2 = findViewById<LinearLayout>(R.id.button2)
        val button3 = findViewById<LinearLayout>(R.id.button3)
        val button4 = findViewById<LinearLayout>(R.id.button4)

        button1.setOnClickListener {
            startActivity(Intent(this, Page1Activity::class.java))
        }

        button2.setOnClickListener {
            startActivity(Intent(this, Page2Activity::class.java))
        }

        button3.setOnClickListener {
            startActivity(Intent(this, Page3Activity::class.java))
        }

        button4.setOnClickListener {
            startActivity(Intent(this, Page4Activity::class.java))
        }
    }
    fun openPage1(view: View) {
        val intent = Intent(this, Page1Activity::class.java)
        startActivity(intent)
    }

    fun openPage2(view: View) {
        val intent = Intent(this, Page2Activity::class.java)
        startActivity(intent)
    }
    fun openPage3(view: View) {
        val intent = Intent(this, Page3Activity::class.java)
        startActivity(intent)
    }

    fun openPage4(view: View) {
        val intent = Intent(this, Page4Activity::class.java)
        startActivity(intent)
    }
}