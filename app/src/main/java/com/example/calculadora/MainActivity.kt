package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private var num1 = 0.0
    private var num2 = 0.0
    private var operacion = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultado_TextView.text = "0"
        operacion = SIN_OPERACION

        btn_uno.setOnClickListener { numPresionado("1") }
        btn_dos.setOnClickListener { numPresionado("2") }
        btn_tres.setOnClickListener { numPresionado("3") }
        btn_cuatro.setOnClickListener { numPresionado("4") }
        btn_cinco.setOnClickListener { numPresionado("5") }
        btn_seis.setOnClickListener { numPresionado("6") }
        btn_siete.setOnClickListener { numPresionado("7") }
        btn_ocho.setOnClickListener { numPresionado("8") }
        btn_nueve.setOnClickListener { numPresionado("9") }
        btn_cero.setOnClickListener { numPresionado("0") }
        btn_punto.setOnClickListener { numPresionado(".") }

        btn_borrar.setOnClickListener { borrar() }

        btn_suma.setOnClickListener { operacionPresionada(SUMA) }
        btn_resta.setOnClickListener { operacionPresionada(RESTA) }
        btn_multiplicacion.setOnClickListener { operacionPresionada(MULTIPLICACION) }
        btn_division.setOnClickListener { operacionPresionada(DIVISION) }

        btn_igual.setOnClickListener { resolver() }
    }

    private fun numPresionado(num: String){
        if(resultado_TextView.text == "0" && num != ".") {
            resultado_TextView.text = "$num"
        } else {
            resultado_TextView.text = "${resultado_TextView.text}$num"
        }

        if(operacion == SIN_OPERACION){
            num1 = resultado_TextView.text.toString().toDouble()
        } else {
            num2 = resultado_TextView.text.toString().toDouble()
        }
    }

    private fun operacionPresionada(operacion: Int){
        this.operacion = operacion
        num1 = resultado_TextView.text.toString().toDouble()

        resultado_TextView.text = "0"
    }

    private fun resolver(){

        val result : Double
        if(operacion == SUMA)
        {
            result = num1+num2
        }
        else if(operacion == RESTA)
        {
            result =   num1-num2
        }
        else if (operacion == DIVISION)
        {
            result =  num1/num2
        }else if(operacion == MULTIPLICACION)
        {
            result =   num1*num2
        }else
        {
            result = 0.0
        }
        resultado_TextView.text = if("$result".endsWith(".0")) { "$result".replace(".0","") } else { "%.2f".format(result) }
    }

    private fun borrar(){
        resultado_TextView.text = "0"
        num1 = 0.0
        num2 = 0.0
    }

    companion object {
        const val SUMA = 1
        const val RESTA = 2
        const val MULTIPLICACION = 3
        const val DIVISION = 4
        const val SIN_OPERACION = 0
    }
}