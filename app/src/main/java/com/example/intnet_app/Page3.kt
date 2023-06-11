package com.example.intnet_app

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class Page3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page3)
        var i :Intent=this.getIntent()
        var b : Bundle? =i.getBundleExtra("message")

        var et: EditText=findViewById(R.id.input_message)
        et.setText(b?.getString("b3"))

        var bt:Button=findViewById(R.id.btn_stnd)
        bt.setOnClickListener {
            b?.putString("p3",et.getText().toString())
            i.putExtra("p3message",b)
            setResult(RESULT_OK,i)
            this.finish()
        }

    }
}