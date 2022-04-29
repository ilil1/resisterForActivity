package com.project.resisterforactivity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class SubActivity : AppCompatActivity() {

    private lateinit var edt_result: EditText
    private lateinit var btn_back: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        edt_result = findViewById(R.id.edt_result)
        btn_back = findViewById(R.id.btn_back)

        btn_back.setOnClickListener { view ->
            val intent = Intent()
            val result = edt_result.text.toString()

            intent.putExtra("result", result)
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}