package com.example.myapplication
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText

import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.text.isDigitsOnly
import androidx.databinding.DataBindingUtil
import androidx.databinding.Observable
import androidx.lifecycle.ViewModelProvider
import com.ddd.androidutils.DoubleClick
import com.ddd.androidutils.DoubleClickListener

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val Button = findViewById<Button>(R.id.button)
        val textEd = findViewById<EditText>(R.id.EdT)
        val TextView = findViewById<TextView>(R.id.TT)
        val imgView = findViewById<ImageView>(R.id.IV)
          textEd.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                TextView.text = p0.toString()
                if(resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE){
                    Toast.makeText(applicationContext, p0, Toast.LENGTH_SHORT).show()
                }
            }
        })
        var textC = "white"
        TextView.setOnLongClickListener(){
            if(textC.equals("white")){
                textC = "blue"
                TextView.setTextColor(getColor(R.color.blue))
            }
            else{
                textC = "white"
                TextView.setTextColor(getColor(R.color.white))
            }
            true
        }

        var butBg = "p"
        Button.setOnClickListener(){
            if(butBg.equals("p")){
                butBg="b"
                Button.setBackgroundColor(getColor(R.color.black))
            }
            else{
                butBg="p"
                Button.setBackgroundColor(getColor(R.color.purple))
            }
        }
        var t = false
        val doubleClick = DoubleClick(object : DoubleClickListener {
            override fun onSingleClickEvent(view: View?) {

            }

            override fun onDoubleClickEvent(view: View?) {
                if (!t) {
                    imgView.visibility = View.VISIBLE
                }
               else{
                    imgView.visibility = View.INVISIBLE
               }
                t = !t
            }
        })
        val imgWrap = findViewById<LinearLayout>(R.id.imgWrap)
        imgWrap.setOnClickListener(doubleClick)
        }

}
