package luna.joel.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var num1 = 0.0f
    var num2 = 0.0f
    var operacion = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Botones Numeros
        val btn1: Button = findViewById(R.id.btn1) as Button
        val btnDos: Button = findViewById(R.id.btnDos) as Button
        val btnTres: Button = findViewById(R.id.btnTres) as Button
        val btnCuatro: Button = findViewById(R.id.btnCuatro) as Button
        val btnCinco: Button = findViewById(R.id.btnCinco) as Button
        val btnSeis: Button = findViewById(R.id.btnSeis) as Button
        val btnSiete: Button = findViewById(R.id.btnSiete) as Button
        val btnOcho: Button = findViewById(R.id.btnOcho) as Button
        val btnNueve: Button = findViewById(R.id.btnNueve) as Button
        val btnCero: Button = findViewById(R.id.btnCero) as Button
        val btnPunto: Button = findViewById(R.id.btnPunto) as Button

        //Operaciones
        val btnBorrar: Button = findViewById(R.id.btnBorrar) as Button
        val btnSuma: Button = findViewById(R.id.btnSuma) as Button
        val btnResta: Button = findViewById(R.id.btnResta) as Button
        val btnMulti: Button = findViewById(R.id.btnMulti) as Button
        val btnDivision: Button = findViewById(R.id.btnDivision) as Button
        val btnIgual: Button = findViewById(R.id.btnIgual) as Button
        //Resultado
        var txtResultado: TextView = findViewById(R.id.txtResultado) as TextView


        txtResultado.text = "0"
        operacion = SIN_OPERACION

        btn1.setOnClickListener { Numero("1") }
        btnDos.setOnClickListener { Numero("2") }
        btnTres.setOnClickListener { Numero("3") }
        btnCuatro.setOnClickListener { Numero("4") }
        btnCinco.setOnClickListener { Numero("5") }
        btnSeis.setOnClickListener { Numero("6") }
        btnSiete.setOnClickListener { Numero("7") }
        btnOcho.setOnClickListener { Numero("8") }
        btnNueve.setOnClickListener { Numero("9") }
        btnCero.setOnClickListener { Numero("0") }
        btnPunto.setOnClickListener { Numero(".") }



        btnSuma.setOnClickListener { operacion(SUMA) }
        btnResta.setOnClickListener { operacion(RESTA) }
        btnMulti.setOnClickListener { operacion(MULTIPLICACION) }
        btnDivision.setOnClickListener { operacion(DIVISION) }

        btnIgual.setOnClickListener(){
            var resultado = when(operacion){
                SUMA -> num1 + num2
                RESTA -> num1 - num2
                MULTIPLICACION -> num1 * num2
                DIVISION -> num1/num2
                else -> 0
            }
            txtResultado.text = resultado.toString()
        }

        btnBorrar.setOnClickListener(){
            var txtResultado: TextView = findViewById(R.id.txtResultado) as TextView
            txtResultado.text = "0"
            num1 = 0.0f
            num2 = 0.0f
        }
    }

    fun Numero(num: String){
        var txtResultado: TextView = findViewById(R.id.txtResultado) as TextView
        txtResultado.text = "${txtResultado.text}$num"
        if(operacion == SIN_OPERACION){
            num1 = txtResultado.text.toString().toFloat()
        } else {
            num2 = txtResultado.text.toString().toFloat()
        }
    }

    fun operacion(operacion: Int){
        var txtResultado: TextView = findViewById(R.id.txtResultado) as TextView
        this.operacion = operacion
        num1 = txtResultado.text.toString().toFloat()
        txtResultado.text = ""
    }

    companion object {
        const val SUMA = 1
        const val RESTA = 2
        const val MULTIPLICACION = 3
        const val DIVISION = 4
        const val SIN_OPERACION = 0
    }
}