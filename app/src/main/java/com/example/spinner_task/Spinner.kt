package com.example.spinner_task

import android.app.Dialog
import android.icu.text.Transliterator.Position
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.spinner_task.databinding.ActivitySpinnerBinding
import com.google.android.material.navigation.NavigationBarView.OnItemSelectedListener

class Spinner : AppCompatActivity() {
    lateinit var binding: ActivitySpinnerBinding
    var spinnerValues = mutableListOf("First", "Second", "Third","fourth")
    lateinit var arrayAdapter: ArrayAdapter<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySpinnerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerValues)
        binding.spDynamic.adapter = arrayAdapter
        binding.spDynamic.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                var selecteditem = binding.spDynamic.selectedItem as String
                Toast.makeText(this@Spinner, "$selecteditem", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }

  binding.spStatic.onItemSelectedListener=object:AdapterView .OnItemSelectedListener{
      override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
      var selecteditem=binding.spStatic.selectedItem as String
          Toast.makeText(this@Spinner,"$selecteditem",Toast.LENGTH_SHORT).show()
      }

      override fun onNothingSelected(p0: AdapterView<*>?) {
          TODO("Not yet implemented")
      }
  }
        binding.btndelete.setOnClickListener{

           spinnerValues.removeAt(0)
         arrayAdapter.notifyDataSetChanged()
        }
        binding.btnupdate.setOnClickListener{
            var dialog=Dialog(this)
          dialog.setContentView(R.layout.data_entry_layout)
        var btn= dialog.findViewById<Button>(R.id.btn2)
            var edtText1=dialog.findViewById<EditText>(R.id.edtf1)
            var edtText2=dialog.findViewById<EditText>(R.id.edtf2)
            var edtText3=dialog.findViewById<EditText>(R.id.edtf3)
            dialog.window?.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            dialog.show()
            btn?.setOnClickListener {
                if (edtText1?.text.isNullOrEmpty()) {
                    edtText1?.error = "Value required"
                } else if (edtText2?.text.isNullOrEmpty()) {
                    edtText2?.error = "Value required"
                } else if (edtText3?.text.isNullOrEmpty()) {
                    edtText3?.error = "Value required"
               } else {
//        spinnerValues.set(0,)=edtText1.text.toString()
//         spinnerValues.add(1)=edtText2.text.toString()
//          spinnerValues.add(2)  =edtText3.text.toString()

                 var a= 0
                    var b=1
                    var c=2
                  spinnerValues[a]=edtText1.text.toString()
                  spinnerValues[b]  =edtText2.text.toString()
                    spinnerValues[c]=edtText3.text.toString()




                    arrayAdapter.notifyDataSetChanged()

                }

                dialog.dismiss()
                dialog.setCancelable(false)

            }
        }
        binding.btnadd.setOnClickListener{
            var newitem ="new item"
            spinnerValues.add(newitem)
            arrayAdapter.notifyDataSetChanged()
        }
    }
}