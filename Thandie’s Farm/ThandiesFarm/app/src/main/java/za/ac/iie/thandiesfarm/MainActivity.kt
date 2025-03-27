package za.ac.iie.thandiesfarm

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val eggsEditText = findViewById<EditText>(R.id.edtEggs)
        val calculateButton = findViewById<Button>(R.id.btnCalculate)
        val resultTextView = findViewById<TextView>(R.id.txtResults)
        val clearButton = findViewById<Button>(R.id.btnClear)

        calculateButton.setOnClickListener {

            val numberOfEggs = eggsEditText.text.toString().toIntOrNull()

            if (numberOfEggs != null) {
                val dozenPrice = 16.0
                val looseEggPrice = 1.50
                val dozenCount = numberOfEggs / 12
                val looseEggCount = numberOfEggs % 12


                val totalCost = (dozenCount * dozenPrice) + (looseEggCount * looseEggPrice)

                val explanation = "You ordered $numberOfEggs eggs. " +
                        "That’s $dozenCount dozen at R$dozenPrice per dozen and $looseEggCount loose eggs at R$looseEggPrice each " +
                        "for a total of R$totalCost"

                resultTextView.text = explanation
            }
        }

        clearButton.setOnClickListener {
            eggsEditText.text.clear()
            resultTextView.text = "Result will be displayed here"
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}