package com.example.androidmysql

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONException
import android.view.View
import android.content.Intent


class ActBuscar : AppCompatActivity() {
    lateinit var textView: TextView
    var requestQueue: RequestQueue? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act_buscar)
        title = "KotlinApp"
        textView = findViewById(R.id.textViewResult)
        requestQueue = Volley.newRequestQueue(this)



    }
    fun buscar1(view: View)
    {
        val Id = intent.getStringExtra("Idproducto").toString()
        val url="http://192.168.1.68/php/registro1.php?idproducto=$Id"
        val request = JsonObjectRequest(Request.Method.GET, url, null,  {
                response ->try {
            val jsonArray = response.getJSONArray("Productos")
            for (i in 0 until jsonArray.length()) {
                val Productos = jsonArray.getJSONObject(i)
                val fecha = Productos.getString("Fecha")
                val descrip= Productos.getString("Descripcion")
                val cant = Productos.getInt("Cantidad")
                val  valoru= Productos.getInt("Valor_Unitario")
                val valort = Productos.getInt("Valor_Total")

                textView.append("$fecha, $descrip, $cant , $valoru , $valort \n\n")
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        }, Response.ErrorListener { error -> error.printStackTrace() })
        requestQueue?.add(request)
    }
}