package com.toshiba.lifetools

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MatriculaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_matricula)

        // Referenciar os elementos do layout
        val etMatricula = findViewById<EditText>(R.id.et_matricula)
        val etVin = findViewById<EditText>(R.id.et_vin)
        val btnSearchByMatricula = findViewById<Button>(R.id.btn_search_by_matricula)
        val btnSearchVehicle = findViewById<Button>(R.id.btn_search_vehicle)
        val tvVehicleInfo = findViewById<TextView>(R.id.tv_vehicle_info)

        // Configurar o clique no botão "Buscar por Matrícula"
        btnSearchByMatricula.setOnClickListener {
            val matricula = etMatricula.text.toString()
            if (matricula.isNotEmpty()) {
                fetchVehicleData(matricula = matricula, vin = "", tvVehicleInfo = tvVehicleInfo)
            } else {
                // Caso o campo matrícula esteja vazio, exibe uma mensagem de erro
                tvVehicleInfo.text = "Por favor, insira a matrícula."
            }
        }

        // Configurar o clique no botão "Buscar Dados"
        btnSearchVehicle.setOnClickListener {
            val matricula = etMatricula.text.toString()
            val vin = etVin.text.toString()

            // Verifica se ao menos um dos campos foi preenchido
            if (matricula.isNotEmpty() || vin.isNotEmpty()) {
                fetchVehicleData(matricula = matricula, vin = vin, tvVehicleInfo = tvVehicleInfo)
            } else {
                // Caso nenhum campo tenha sido preenchido, pode exibir um aviso
                tvVehicleInfo.text = "Por favor, insira uma matrícula ou VIN."
            }
        }
    }

    // Função para buscar os dados do veículo
    private fun fetchVehicleData(matricula: String, vin: String, tvVehicleInfo: TextView) {
        // Aqui será necessário fazer uma chamada à API externa (exemplo fictício)
        // Após a chamada da API, os dados retornados devem ser exibidos no TextView

        // Exemplo fictício de resposta da API
        val vehicleInfo = when {
            matricula.isNotEmpty() -> {
                "Informações da matrícula $matricula:\nMarca: Exemplo Marca\nModelo: Exemplo Modelo\nAno: 2020"
            }
            vin.isNotEmpty() -> {
                "Informações do VIN $vin:\nMarca: Exemplo Marca\nModelo: Exemplo Modelo\nAno: 2021"
            }
            else -> {
                "Nenhuma informação disponível."
            }
        }

        // Atualizar a interface com as informações do veículo
        tvVehicleInfo.text = vehicleInfo
    }
}
