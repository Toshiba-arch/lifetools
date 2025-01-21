package com.toshiba.lifetools

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject

class MatriculaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_matricula)

        val etMatricula = findViewById<EditText>(R.id.et_matricula)
        val etVin = findViewById<EditText>(R.id.et_vin)
        val btnSearchByMatricula = findViewById<Button>(R.id.btn_search_by_matricula)
        val btnSearchVehicle = findViewById<Button>(R.id.btn_search_vehicle)
        val tvVehicleInfo = findViewById<TextView>(R.id.tv_vehicle_info)

        btnSearchByMatricula.setOnClickListener {
            val matricula = etMatricula.text.toString().trim()
            if (matricula.isNotEmpty()) {
                fetchVehicleData(matricula, "", tvVehicleInfo)
            } else {
                Toast.makeText(this, "Por favor, insira uma matrícula.", Toast.LENGTH_SHORT).show()
            }
        }

        btnSearchVehicle.setOnClickListener {
            val matricula = etMatricula.text.toString().trim()
            val vin = etVin.text.toString().trim()
            if (matricula.isNotEmpty() || vin.isNotEmpty()) {
                fetchVehicleData(matricula, vin, tvVehicleInfo)
            } else {
                Toast.makeText(this, "Por favor, insira uma matrícula ou VIN.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun fetchVehicleData(matricula: String, vin: String, tvVehicleInfo: TextView) {
        val client = OkHttpClient()
        val url = if (matricula.isNotEmpty()) {
            "https://api.carqueryapi.com/v1/matricula?matricula=$matricula"
        } else {
            "https://api.carqueryapi.com/v1/vin?vin=$vin"
        }

        val request = Request.Builder()
            .url(url)
            .build()

        Thread {
            try {
                val response = client.newCall(request).execute()
                if (response.isSuccessful) {
                    val responseData = response.body?.string()
                    val jsonObject = JSONObject(responseData ?: "")
                    val vehicleInfo = """
                        Marca: ${jsonObject.getString("make")}
                        Modelo: ${jsonObject.getString("model")}
                        Ano: ${jsonObject.getString("year")}
                    """.trimIndent()

                    runOnUiThread {
                        tvVehicleInfo.text = vehicleInfo
                    }
                } else {
                    runOnUiThread {
                        tvVehicleInfo.text = "Erro ao obter dados do veículo."
                    }
                }
            } catch (e: Exception) {
                runOnUiThread {
                    tvVehicleInfo.text = "Erro: ${e.message}"
                }
            }
        }.start()
    }
}
