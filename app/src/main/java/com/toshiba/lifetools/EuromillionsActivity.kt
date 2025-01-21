package com.toshiba.lifetools

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class EuromillionsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_euromillions)

        // Referenciar a TextView e o botão
        val tvNumbers = findViewById<TextView>(R.id.tv_numbers)
        val btnGenerate = findViewById<Button>(R.id.btn_generate)

        // Configurar o clique no botão para gerar os números
        btnGenerate.setOnClickListener {
            // Gerar os números
            val numbers = generateEuromillionsNumbers()
            // Exibir os números na TextView
            tvNumbers.text = "Números Gerados: ${numbers.joinToString(", ")}"
        }
    }

    // Função para gerar números aleatórios para o Euromilhões
    private fun generateEuromillionsNumbers(): List<Int> {
        // Gerar 5 números principais aleatórios entre 1 e 50
        val mainNumbers = (1..50).shuffled().take(5).sorted()
        // Gerar 2 números Lucky Stars aleatórios entre 1 e 12
        val luckyStars = (1..12).shuffled().take(2).sorted()
        // Retornar os números gerados
        return mainNumbers + luckyStars
    }
}
