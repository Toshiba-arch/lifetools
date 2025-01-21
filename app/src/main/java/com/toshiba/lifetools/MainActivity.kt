package com.toshiba.lifetools

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Botão para navegar para a ferramenta Euromillions
        val btnEuromillions = findViewById<Button>(R.id.btn_euromillions)
        btnEuromillions.setOnClickListener {
            val intent = Intent(this, EuromillionsActivity::class.java)
            startActivity(intent)
        }

        // Botão para navegar para outra ferramenta (exemplo)
        val btnOtherTool = findViewById<Button>(R.id.btn_other_tool)
        btnOtherTool.setOnClickListener {
            val intent = Intent(this, OtherToolActivity::class.java)
            startActivity(intent)
        }
    }
}