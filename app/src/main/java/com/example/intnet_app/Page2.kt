package com.example.intnet_app

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class Page2 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page2)

        var i = this.getIntent()
        var b: Bundle? =i.getBundleExtra("name")
        var b2: Bundle? =i.getBundleExtra("nickname")

        var tv:TextView=findViewById(R.id.tv_name)
        tv.setText("Hello , "+ (b?.getString("b2")  ))
        var et:EditText=findViewById(R.id.input_nickname)
        et.setText(b2?.getString("b2"))

        var bt:Button=findViewById(R.id.btn_next)
        bt.setOnClickListener {
            b?.putString("p2",et.getText().toString())
            i.putExtra("p2nickname",b)

            setResult(RESULT_OK,i)
            this.finish()
        }
    }
}