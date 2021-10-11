
package com.example.androidmysql

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.androidmysql.MainActivity
import java.lang.String.format

class ActividadBuscar : AppCompatActivity() {

    var txtfecha: TextView?=null
    var txtdescrip: TextView?=null
    var txtcant: TextView?=null
    var txtvaloru: TextView?=null
    var txtvalort: TextView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad_buscar)
        txtfecha=findViewById(R.id.edfecha)
        txtdescrip=findViewById(R.id.eddescripcion)
        txtcant=findViewById(R.id.edcantidad)
        txtvaloru=findViewById(R.id.edvaloru)
        txtvalort=findViewById(R.id.edvalort)
        val Id: String = intent.getStringExtra("Idproducto").toString()

        val queue = Volley.newRequestQueue(this)
        val url="http://192.168.0.112/php/registro.php?Idproducto=$Id"
        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET,url,null,
            { response ->
                      
                txtfecha?.setText(response.getString("Fecha"))
                txtdescrip?.setText(response.getString("Descripcion"))
                txtcant?.setText(response.getString("Cantidad"))
                txtvaloru?.setText(response.getString("Valor_Unitario"))
                txtvalort?.setText(response.getString("Valor_Total"))

            }, { error ->
                Toast.makeText(this, error.toString(), Toast.LENGTH_SHORT).show()
            }
        )
        queue.add(jsonObjectRequest)
    }

    fun regresar(view:View)
        {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }


