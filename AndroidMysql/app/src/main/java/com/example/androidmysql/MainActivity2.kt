package com.example.androidmysql

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.lang.Integer.parseInt

class MainActivity2 : AppCompatActivity() {
    lateinit var textView: TextView
    lateinit var txtnombre: TextView
    lateinit var txtdescrip: TextView
    lateinit var txtimagen: TextView
    lateinit var txtcant: TextView
    lateinit var txtvaloru: TextView
    lateinit var txtbuscar: EditText
    var requestQueue: RequestQueue? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        title = "KotlinApp"
        //textView = findViewById(R.id.eddescripcion)

        txtnombre=findViewById(R.id.ednombre)
        txtdescrip=findViewById(R.id.eddescripcion)
        txtimagen=findViewById(R.id.edimagen)
        txtcant=findViewById(R.id.edcantidad)
        txtvaloru=findViewById(R.id.edvaloru)
        txtbuscar = findViewById(R.id.edbuscar)
/*
        val queue = Volley.newRequestQueue(this)

        val Id : Int  = 3
        val url="http://192.168.1.68/php/registro.php?Idproducto=$Id"
        val StringRequest = StringRequest(Request.Method.GET, url,
        { response->
            val jsonArray = JSONArray(response)
            for(i in 0 until jsonArray.length()) {
                val jsonObject = JSONObject(jsonArray.getString(i))
                var text0 = jsonObject.get("Fecha")
                var text1 = jsonObject.get("Descripcion")
                var text2 = jsonObject.get("Cantidad")
                var text3= jsonObject.get("Valor_Unitario")
                var text4 = jsonObject.get("Valor_Total")

                txtfecha.text = text0.toString()
                txtdescrip.text = text1.toString()
                txtcant.text = text2.toString()
                txtvaloru.text = text3.toString()
                txtvalort.text = text4.toString()

                Toast.makeText(this, jsonObject.toString(), Toast.LENGTH_SHORT).show()
            }
        }, { error->
                Toast.makeText(this, error.toString(), Toast.LENGTH_SHORT).show()
        })

        queue.add(StringRequest)

*/
    }

    fun buscar(view: View)
    {
        var txtId: EditText = findViewById<EditText>(R.id.edbuscar)
        val Id : Int  = txtId.text.toString().toInt()
       // Toast.makeText(this, txtId.text, Toast.LENGTH_SHORT).show()

        val queue = Volley.newRequestQueue(this)



        val url="http://192.168.0.112/php/registro.php?Idproducto=$Id"
        val StringRequest = StringRequest(Request.Method.GET, url,
            { response->
                val jsonArray = JSONArray(response)
                for(i in 0 until jsonArray.length()) {
                    val jsonObject = JSONObject(jsonArray.getString(i))
                    var text0 = jsonObject.get("Nombre")
                    var text1 = jsonObject.get("Descripcion")
                    var text2 = jsonObject.get("Imagen")
                    var text3= jsonObject.get("Cantidad")
                    var text4 = jsonObject.get("Valor_Unitario")

                    txtnombre.text = text0.toString()
                    txtdescrip.text = text1.toString()
                    txtimagen.text = text2.toString()
                    txtcant.text = text3.toString()
                    txtvaloru.text = text4.toString()

                    Toast.makeText(this, jsonObject.toString(), Toast.LENGTH_SHORT).show()
                }
            }, { error->
                Toast.makeText(this, error.toString(), Toast.LENGTH_SHORT).show()
            })

        queue.add(StringRequest)

    }

}