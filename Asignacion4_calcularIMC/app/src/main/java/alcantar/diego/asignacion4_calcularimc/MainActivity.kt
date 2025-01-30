package alcantar.diego.asignacion4_calcularimc

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Referencias a los elementos del layout
        val etPeso: EditText = findViewById(R.id.etPeso)
        val etAltura: EditText = findViewById(R.id.etEstatura)
        val btnCalcular: Button = findViewById(R.id.btnCalcular)
        val tvResultado: TextView = findViewById(R.id.tvResultado)
        val tvCategoria: TextView = findViewById(R.id.tvCategoria)

        // Evento del botón
        btnCalcular.setOnClickListener {
            val pesoStr = etPeso.text.toString()
            val alturaStr = etAltura.text.toString()


            val peso = pesoStr.toFloat()
            val altura = alturaStr.toFloat()

            val imc = calcularIMC(peso, altura)
            val categoria = obtenerCategoriaIMC(imc)

            tvResultado.text = imc.toString()
            tvCategoria.text = categoria

        }


    }
    private fun calcularIMC(peso: Float, altura: Float): Float {
        return peso / (altura * altura)
    }

    private fun obtenerCategoriaIMC(imc: Float): String {
        return when {
            imc < 18.5 -> "Bajo peso"
            imc in 18.5..24.9 -> "Normal"
            imc in 25.0..29.9 -> "Sobrepeso"
            imc in 30.0..34.9 -> "Obesidad grado 1"
            imc in 35.0..39.9 -> "Obesidad grado 2"
            else -> "Obesidad grado 3"
        }
    }
}