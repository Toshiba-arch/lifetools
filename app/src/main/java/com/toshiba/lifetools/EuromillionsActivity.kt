package com.toshiba.lifetools

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class EuromillionsActivity : AppCompatActivity() {

    private lateinit var generator: EuromillionsGenerator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_euromillions)

        // Inicializar o gerador
        generator = EuromillionsGenerator()

        // Referenciar a TextView e os botões
        val tvRandomNumbers = findViewById<TextView>(R.id.tv_random_generated_numbers)
        val tvStatsNumbers = findViewById<TextView>(R.id.tv_stats_generated_numbers)
        val btnGenerateRandom = findViewById<Button>(R.id.btn_generate_random)
        val btnGenerateStats = findViewById<Button>(R.id.btn_generate_based_on_stats)

        // Configurar o clique nos botões para gerar os números
        btnGenerateRandom.setOnClickListener {
            val (mainNumbers, luckyStars) = generator.generateRandomNumbers()
            tvRandomNumbers.text = formatNumbers(mainNumbers, luckyStars)
        }

        btnGenerateStats.setOnClickListener {
            val (mainNumbers, luckyStars) = generator.generateStatsBasedNumbers()
            tvStatsNumbers.text = formatNumbers(mainNumbers, luckyStars)
        }
    }

    // Formatar os números para exibição: Números principais separados por vírgulas e estrelas após "-"
    private fun formatNumbers(mainNumbers: List<Int>, luckyStars: List<Int>): String {
        return mainNumbers.joinToString(", ") + " - " + luckyStars.joinToString(", ")
    }
}

class EuromillionsGenerator {

    // Função para gerar números aleatórios para o Euromilhões
    fun generateRandomNumbers(): Pair<List<Int>, List<Int>> {
        val mainNumbers = (1..50).shuffled().take(5).sorted()  // 5 números principais
        val luckyStars = (1..12).shuffled().take(2).sorted()  // 2 estrelas
        return Pair(mainNumbers, luckyStars)
    }

    // Função para gerar números com base nas estatísticas
    fun generateStatsBasedNumbers(): Pair<List<Int>, List<Int>> {
        val mainNumbers = generateNumbersBasedOnStatistics()  // Números principais baseados em estatísticas
        val luckyStars = generateLuckyStarsBasedOnStatistics()  // Estrelas baseadas em estatísticas
        return Pair(mainNumbers, luckyStars)
    }

    // Simulação de números principais baseados em estatísticas
    private fun generateNumbersBasedOnStatistics(): List<Int> {
        // Simula números com base em alguma lógica (alterar conforme necessário)
        val numbers = (1..50).toList().shuffled().take(5)
        return numbers.sorted()
    }

    // Simulação de estrelas baseadas em estatísticas
    private fun generateLuckyStarsBasedOnStatistics(): List<Int> {
        // Simula estrelas com base em alguma lógica (alterar conforme necessário)
        val stars = (1..12).toList().shuffled().take(2)
        return stars.sorted()
    }
}
