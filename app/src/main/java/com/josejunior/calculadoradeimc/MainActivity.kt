package com.josejunior.calculadoradeimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.josejunior.calculadoradeimc.databinding.ActivityMainBinding
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    fun Conversao(p: String, a:String):Double{
        var peso:Double = p.toDouble()
        var conversaoAltura = a.toDouble()

        var altura:Double = conversaoAltura / 100
        return peso/(altura * altura)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalcular.setOnClickListener {

            if(binding.txtPeso.text.isEmpty()){
                binding.txtPeso.error = "Campo obrigatório"
                binding.txtPeso.requestFocus()
            }
            else if(binding.txtAltura.text.isEmpty()){
                binding.txtAltura.error = "Campo obrigatório"
                binding.txtAltura.requestFocus()
            }
            else{

                var resultado: Double = Conversao(binding.txtPeso.text.toString(),binding.txtAltura.text.toString())
                binding.txvResult.text = "Seu imc é: ${resultado.roundToInt()}"

                if(resultado < 18){
                    binding.txtMensagem.text = "Abaixo do peso"
                }
                else if(resultado >= 18 && resultado < 25){
                    binding.txtMensagem.text = "Peso normal"
                }
                else if(resultado >= 25 && resultado < 29){
                    binding.txtMensagem.text = "Sobrepeso"
                }
                else if(resultado >= 30 && resultado < 35){
                    binding.txtMensagem.text = "Obesidade Grau I"
                }
                else if(resultado >= 35 && resultado < 39){
                    binding.txtMensagem.text = "Obesidade Grau II"
                }
                else{
                    binding.txtMensagem.text = "Obesidade Grau III ou Mórbida"
                }
            }
         }//btnCalc
    }//onCreate
}//class