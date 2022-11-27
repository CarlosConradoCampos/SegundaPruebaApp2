package com.app.segundapruebaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class Buscar extends AppCompatActivity {
    private ArrayList <Tarea> listaTareas;
    private ListView lstBusqueda;
    private Button btnFiltrar;
    private TextInputLayout tilBuscar;
    private ArrayList<String>listado;
    private ArrayAdapter <String> adaptadorTareas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);
        referencias();




    }

    private void referencias() {
        lstBusqueda = findViewById(R.id.lstBusqueda);
        btnFiltrar = findViewById(R.id.btnFiltrar);
        tilBuscar = findViewById(R.id.tilBuscar);
        listaTareas = new ArrayList<Tarea>();
        listaTareas = (ArrayList<Tarea>) getIntent().getExtras().getSerializable("lista_tareas");
        listado = new ArrayList<String>();
        for (int x = 0; x < listaTareas.size(); x++){
            listado.add(listaTareas.get(x).getTitulo()+"--"+listaTareas.get(x).getDescripcion());
            Toast.makeText(this, listaTareas.get(x).getTitulo()+"--"+listaTareas.get(x).getDescripcion(), Toast.LENGTH_SHORT).show();
        }
        adaptadorTareas = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listado);
        lstBusqueda.setAdapter(adaptadorTareas);
    }

}