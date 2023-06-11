package com.example.intnet_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var s2=""
    var s3=""
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode==2&&resultCode==RESULT_OK&&data!=null){
            s2= data.getBundleExtra("p2nickname")?.get("p2").toString()
            var i = Intent(this,Page3::class.java)
            var b:Bundle=Bundle()
            b.putString("b3",s3)
            i.putExtra("message",b)
            startActivityForResult(i,3)
        }
        if (requestCode==3&&resultCode==RESULT_OK&&data!=null){
            s3= data.getBundleExtra("p3message")?.get("p3").toString()
        }
        var tv1:TextView=findViewById(R.id.tv_nickname)
        var tv2:TextView=findViewById(R.id.tv_message)
        tv1.setText(s2)
        tv2.setText(s3)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var bt2:Button=findViewById(R.id.btn_p2)
        var bt3:Button=findViewById(R.id.btn_p3)
        var et:EditText= findViewById(R.id.input_name)

        bt2.setOnClickListener {
            var i = Intent(this,Page2::class.java)
            var b :Bundle=Bundle()
            var b2 :Bundle=Bundle()
            b.putString("b2",et.getText().toString())
            i.putExtra("name",b)
            b2.putString("b2",s2)
            i.putExtra("nickname",b2)
            startActivityForResult(i,2)
        }
        bt3.setOnClickListener{
            var i = Intent(this,Page3::class.java)
            var b :Bundle=Bundle()
            b.putString("b3",s3)
            i.putExtra("message",b)
            startActivityForResult(i,3)
        }
    }

}