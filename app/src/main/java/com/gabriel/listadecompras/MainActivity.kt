package com.gabriel.listadecompras

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.RecyclerView


class MainActivity : ComponentActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //chamando nosso layout principal
        setContentView(R.layout.activity_main)
        //declarando a variavel recyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        //declarando a variavel ItemsAdapter
        val itemsAdapter = ItemsAdapter()

        recyclerView.adapter = itemsAdapter
        //declarando a variavel Button
        val button = findViewById<Button>(R.id.button)
        //declarando a variavel EditText
        val editText = findViewById<EditText>(R.id.editText)


        //Declarando um metodo para ao clicar no botão instanciar nosso objeto Item
        button.setOnClickListener {
            //evitando campo de produto nulo
            if (editText.text.isEmpty()){
                editText.error = "Opção Inválida, preencha o campo"
                return@setOnClickListener
            }
            val item = ItemModel(
                nome = editText.text.toString(), onRemove = {
                    itemsAdapter.removeItem(it)
                }
            )
            itemsAdapter.adicionarItem(item)
            editText.text.clear()
        }

    }
}