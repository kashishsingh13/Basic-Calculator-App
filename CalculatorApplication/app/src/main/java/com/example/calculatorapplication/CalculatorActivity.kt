package com.example.calculatorapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import com.example.calculatorapplication.databinding.ActivityCalculatorBinding
import javax.script.ScriptEngine
import javax.script.ScriptEngineManager
import javax.script.ScriptException

class CalculatorActivity : AppCompatActivity() {
    private lateinit var binding:ActivityCalculatorBinding
    var check = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityCalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.inputnumber.movementMethod= ScrollingMovementMethod()
        binding.inputnumber.setActivated(true)
        binding.inputnumber.setPressed(true)

        var text:String

        binding.btnOne.setOnClickListener {
            text= binding.inputnumber.text.toString()+"1"
            binding.inputnumber.setText(text)
            binding.result(text)
        }

        binding.btnTwo.setOnClickListener {
            text= binding.inputnumber.text.toString()+"2"
            binding.inputnumber.setText(text)
            binding.result(text)
        }
        binding.btnThree.setOnClickListener {
            text= binding.inputnumber.text.toString()+"3"
            binding.inputnumber.setText(text)
            binding.result(text)
        }
        binding.btnFour.setOnClickListener {
            text= binding.inputnumber.text.toString()+"4"
            binding.inputnumber.setText(text)
            binding.result(text)
        }
        binding.btnFive.setOnClickListener {
            text= binding.inputnumber.text.toString()+"5"
            binding.inputnumber.setText(text)
            binding.result(text)
        }
        binding.btnSix.setOnClickListener {
            text= binding.inputnumber.text.toString()+"6"
            binding.inputnumber.setText(text)
            binding.result(text)
        }
        binding.btnSeven.setOnClickListener {
            text= binding.inputnumber.text.toString()+"7"
            binding.inputnumber.setText(text)
            binding.result(text)
        }
        binding.btnEight.setOnClickListener {
            text= binding.inputnumber.text.toString()+"8"
            binding.inputnumber.setText(text)
            binding.result(text)
        }
        binding.btnNine.setOnClickListener {
            text= binding.inputnumber.text.toString()+"9"
            binding.inputnumber.setText(text)
            binding.result(text)
        }
        binding.btnZero.setOnClickListener {
            text= binding.inputnumber.text.toString()+"0"
            binding.inputnumber.setText(text)
            binding.result(text)
        }
        binding.btnDoublezero.setOnClickListener {
            text= binding.inputnumber.text.toString()+"00"
            binding.inputnumber.setText(text)
            binding.result(text)
        }
        binding.btnDout.setOnClickListener {
            text= binding.inputnumber.text.toString()+"."
            binding.inputnumber.setText(text)
            binding.result(text)
        }

        binding.btnPlus.setOnClickListener {
            text= binding.inputnumber.text.toString()+"+"
            binding.inputnumber.setText(text)
            check=check+1

        }
        binding.btnMuness.setOnClickListener {
            text= binding.inputnumber.text.toString()+"-"
            binding.inputnumber.setText(text)
            check=check+1

        }
        binding.btnMultiple.setOnClickListener {
            text= binding.inputnumber.text.toString()+"*"
            binding.inputnumber.setText(text)
            check=check+1

        }
        binding.btnDiv.setOnClickListener {
            text= binding.inputnumber.text.toString()+"/"
            binding.inputnumber.setText(text)
            check=check+1

        }
        binding.btnPersent.setOnClickListener {
            text= binding.inputnumber.text.toString()+"%"
            binding.inputnumber.setText(text)
            check=check+1

        }
        binding.btnEqual.setOnClickListener {
            text= binding.result.text.toString()
            binding.inputnumber.setText(text)
            binding.result.setText(null)
        }
        binding.btnClear.setOnClickListener {
            binding.inputnumber.setText(null)
            binding.result.setText(null)
        }
        binding.btnBackspace.setOnClickListener {
            var backspace : String?= null
            if(binding.inputnumber.text.length>0){
                val stringBuilder:StringBuilder=StringBuilder(binding.inputnumber.text)
                val find= binding.inputnumber.text.toString()
                val find2= find.last()
                if(find2.equals('+')||find2.equals('-')||find2.equals('*')||find2.equals('/')||find2.equals('%')){
                    check=check-1
                }
                stringBuilder.deleteCharAt(binding.inputnumber.text.length-1)
                backspace=stringBuilder.toString()
                binding.inputnumber.setText(backspace)
                binding.result(backspace)
            }
        }
    }
    private fun ActivityCalculatorBinding.result(text: String) {
        val engine : ScriptEngine=ScriptEngineManager().getEngineByName("rhino")
        try {

            val  result : Any= engine.eval(text)
            val mainr= result.toString()
            if(check==0){
                binding.result.setText(null)
            }
            else{
                binding.result.setText(mainr)
            }
        }
        catch (e: ScriptException){
            Log.d("TAG","ERROR")
        }

    }

}