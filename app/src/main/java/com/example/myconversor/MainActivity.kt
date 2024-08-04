package com.example.myconversor

import android.os.Bundle
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myconversor.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var dolar  = 5.73
    private var euro = 6.26
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)


        val radiogropu = findViewById<RadioGroup>(R.id.radio)

        val textresul = findViewById<TextView>(R.id.text_result)



        binding.buttonConverter.setOnClickListener {
         var valor = binding.editValor.text.toString()
            if (valor.isEmpty()){
                Snackbar.make(binding.root,"Campos Vazios",Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val valores  = valor.toDouble()

            var selectradio = radiogropu.checkedRadioButtonId
            var resultado = 0.0

            if(selectradio == R.id.radio_dolar){

                resultado = valores/dolar
                textresul.text = String.format("O valor em Dólar é: $ %.2f",resultado)

            }else if (selectradio == R.id.radio_euro){

                resultado = valores/euro
                textresul.text = String.format("O valor em Euro é: $ %.2f",resultado)
            }else{

               Snackbar.make(binding.root,"Selecione o tipo de Moeda!!",Snackbar.LENGTH_SHORT).show()
            }
        }






        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}