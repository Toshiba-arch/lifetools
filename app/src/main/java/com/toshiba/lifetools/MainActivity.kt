package com.toshiba.lifetools

import android.os.Bundle
// import androidx.activity.ComponentActivity
// import androidx.activity.compose.setContent
// import androidx.activity.enableEdgeToEdge
// import androidx.compose.foundation.layout.fillMaxSize
// import androidx.compose.foundation.layout.padding
// import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.toshiba.lifetools.ui.theme.LifeToolsAppTheme
import android.content.Intent
// import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Configurar o botão para a ferramenta "Euromillions"
        val btnEuromillions = findViewById<Button>(R.id.btn_euromillions)
        btnEuromillions.setOnClickListener {
            // Navegar para EuromillionsActivity
            val intent = Intent(this, EuromillionsActivity::class.java)
            startActivity(intent)
        }

        // Exemplo: Adicionar mais botões para outras ferramentas
        val btnOtherTool = findViewById<Button>(R.id.btn_other_tool)
        btnOtherTool.setOnClickListener {
            // Navegar para OtherToolActivity
            val intent = Intent(this, OtherToolActivity::class.java)
            startActivity(intent)
        }
    }
}
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LifeToolsAppTheme {
        Greeting("Android")
    }
}