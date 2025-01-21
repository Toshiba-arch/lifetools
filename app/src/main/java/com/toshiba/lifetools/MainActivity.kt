package com.toshiba.lifetools

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referenciar os botões
        val btnEuromillions = findViewById<Button>(R.id.btn_euromillions)
        val btnOtherTool = findViewById<Button>(R.id.btn_other_tool)
        val btnMatricula = findViewById<Button>(R.id.btn_matricula)

        // Configurar o clique nos botões
        btnEuromillions.setOnClickListener {
            // Iniciar a atividade do Euromilhões
            val intent = Intent(this, EuromillionsActivity::class.java)
            startActivity(intent)
        }

        btnOtherTool.setOnClickListener {
            // Iniciar a atividade de outras ferramentas (se necessário)
            val intent = Intent(this, OtherToolActivity::class.java)
            startActivity(intent)
        }

        btnMatricula.setOnClickListener {
            // Iniciar a atividade de matrícula ou VIN
            val intent = Intent(this, MatriculaActivity::class.java)
            startActivity(intent)
        }
    }
}