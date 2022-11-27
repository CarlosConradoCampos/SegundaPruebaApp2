package com.app.segundapruebaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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
    private ArrayList<Tarea>listado;
    private ArrayList<Integer>listaPosition = new ArrayList<>();
    private ArrayAdapter <Tarea> adaptadorTareas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);
        referencias();

        btnFiltrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buscar();
            }
        });

        lstBusqueda.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                if(listado == null){
                    listaTareas.remove(position);
                    buscar();
                }else{
                    for (int x = 0; x < listado.size(); x++){
                        for(int z = 0; z < listaTareas.size(); z++){
                            if (listado.get(x).getDescripcion().equals(listaTareas.get(z).getDescripcion()) || listado.get(x).getTitulo().equals(listaTareas.get(z).getTitulo())){
                                listaTareas.remove(z);
                                buscar();
                                break;
                            }
                        }

                    }
                }
                Toast.makeText(Buscar.this, "Se Elimino La Tarea "+position, Toast.LENGTH_SHORT).show();
                return false;
            }
        });


    }

    private void referencias() {
        lstBusqueda = findViewById(R.id.lstBusqueda);
        btnFiltrar = findViewById(R.id.btnFiltrar);
        tilBuscar = findViewById(R.id.tilBuscar);
        listaTareas = new ArrayList<Tarea>();
        listaTareas = (ArrayList<Tarea>) getIntent().getExtras().getSerializable("lista_tareas");
        adaptadorTareas = new ArrayAdapter<Tarea>(this, android.R.layout.simple_list_item_1,listaTareas);
        lstBusqueda.setAdapter(adaptadorTareas);
    }


    private void buscar(){
        String buscar = "";


        if(tilBuscar.getEditText().getText().toString().isEmpty()){
            listado = new ArrayList<Tarea>();
            adaptadorTareas = new ArrayAdapter<Tarea>(this, android.R.layout.simple_list_item_1,listaTareas);
            lstBusqueda.setAdapter(adaptadorTareas);
        }else{
            buscar = tilBuscar.getEditText().getText().toString();
            listado = new ArrayList<Tarea>();
            for (int x = 0; x < listaTareas.size(); x++){
                if(buscar.equalsIgnoreCase(listaTareas.get(x).getTitulo()) || buscar.equalsIgnoreCase(listaTareas.get(x).getDescripcion())){
                    listado.add(listaTareas.get(x));
                }
            }
            adaptadorTareas = new ArrayAdapter<Tarea>(this, android.R.layout.simple_list_item_1,listado);
            lstBusqueda.setAdapter(adaptadorTareas);

        }
    }


}