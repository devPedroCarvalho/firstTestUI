package app.devpedrocarvalho.firsttestui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         val name = findViewById<EditText>(R.id.writeYourNameEditText)
         val addName = findViewById<Button>(R.id.addNameButton)
         val clear = findViewById<Button>(R.id.clearButton)
         val error = findViewById<TextView>(R.id.errorNameTextView)
         val result = findViewById<TextView>(R.id.resultTextView)

        addName.setOnClickListener {
            val textName = name.text.toString()
            if (textName.isBlank()){
                error.visibility = View.VISIBLE
            }else{
                error.visibility = View.INVISIBLE
                result.text = textName
            }
        }

        clear.setOnClickListener {
            result.text = ""
            name.setText("")
        }

    }

}