package com.example.androidmysql

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.Volley
import com.android.volley.toolbox.StringRequest as StringRequest1

import android.content.Intent

class MainActivity : AppCompatActivity() {
    var txtfecha:EditText?=null
    var txtdescrip:EditText?=null
    var txtcant:EditText?=null
    var txtvaloru:EditText?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txtfecha=findViewById(R.id.edfecha)
        txtdescrip=findViewById(R.id.eddescripcion)
        txtcant=findViewById(R.id.edcantidad)
        txtvaloru=findViewById(R.id.edivaloru)

    }
    fun Insertar(view:View)
    {
       val url="http://192.168.0.112/php/index.php"
       val queue= Volley.newRequestQueue(this)
        var resultadopost = object : StringRequest1(Request.Method.POST,url,
        Response.Listener<String> { response ->
            Toast.makeText(this, "Registro insertado correctamente",Toast.LENGTH_LONG).show()
        },Response.ErrorListener { error ->
                Toast.makeText(this, "Error no hay conexion a BD",Toast.LENGTH_LONG).show()
            }){
            override fun getParams(): MutableMap<String, String> {
               val parametros = HashMap<String,String>()
                parametros.put("Fecha",txtfecha?.text.toString())
                parametros.put("Descripcion",txtdescrip?.text.toString())
                parametros.put("Cantidad",txtcant?.text.toString())
                parametros.put("Valor_Unitario",txtvaloru?.text.toString())
                return parametros
            }
        }
        queue.add(resultadopost)
    }
    fun Buscar(view: View)
    {
        //var txtId: EditText = findViewById<EditText>(R.id.edbuscar)
        var intent = Intent(this,MainActivity2::class.java)
        //intent.putExtra("Idproducto",txtId.text)
        startActivity(intent)
    }
}