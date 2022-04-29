package com.project.resisterforactivity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var tv_result: TextView
    private lateinit var btn_start: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv_result = findViewById(R.id.tv_result)
        btn_start = findViewById(R.id.btn_start)

        btn_start.setOnClickListener {
            val intent = Intent(baseContext, SubActivity::class.java)
            launcher.launch(intent)
        }
    }
    var launcher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { data : ActivityResult ->

        Log.d("TAG", "data : ${data.toString()}")

        if (data.resultCode === Activity.RESULT_OK) {
            val intent = data.data

            val result = intent?.getStringExtra("result")
            tv_result!!.text = result
        }
    }
}