package com.app.segundapruebaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class SegundaPantalla extends AppCompatActivity {

    TextView tvTitulo;
    TextInputLayout tilTituloTarea, tilDescripcion;
    ImageButton imbBuscar;
    Button btnIngresar, btnModificar;
    ArrayList <Tarea> listaTareas = new ArrayList<Tarea>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_pantalla);
        referencias();
        poblarLista();

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String titulo = "";
                String descripcion = "";
                boolean noExiste = true;

                if(tilTituloTarea.getEditText().getText().toString().isEmpty()){
                    tilTituloTarea.setError("Para agregar una tarea debe Ingresar el Titulo");
                }else{
                    if(!tilDescripcion.getEditText().getText().toString().isEmpty()) {
                        descripcion = tilDescripcion.getEditText().getText().toString();
                        titulo = tilTituloTarea.getEditText().getText().toString();
                        for(int x = 0; x < listaTareas.size(); x++){
                            if(listaTareas.get(x).getTitulo().equalsIgnoreCase(titulo)){
                                tilTituloTarea.setError("La Tarea ya existe");
                                noExiste = false;
                            }
                        }
                        if(noExiste){
                            Tarea a = new Tarea(listaTareas.size()+1, titulo, descripcion);
                            listaTareas.add(a);
                            tilTituloTarea.setError(null);
                            tilDescripcion.setError(null);
                            Toast.makeText(SegundaPantalla.this, "Tarea Agregada", Toast.LENGTH_SHORT).show();
                        }

                    }else{
                        tilDescripcion.setError("Debe Ingresar Una descripcion");
                    }


                }
            }
        });

        btnModificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String titulo = "";
                String descripcion = "";
                int indice = 0 ;
                boolean existe = false;

                if(tilTituloTarea.getEditText().getText().toString().isEmpty()){
                    tilTituloTarea.setError("Para Modificar una tarea debe escribir su Titulo");
                }else{
                    if(!tilDescripcion.getEditText().getText().toString().isEmpty()) {
                        descripcion = tilDescripcion.getEditText().getText().toString();
                        titulo = tilTituloTarea.getEditText().getText().toString();
                        for(int x = 0; x < listaTareas.size(); x++){
                            if(listaTareas.get(x).getTitulo().equalsIgnoreCase(titulo)){
                                existe = true;
                                indice = x;
                            }
                        }
                        if(existe){
                            listaTareas.get(indice).setDescripcion(descripcion);
                            Toast.makeText(SegundaPantalla.this, "Modificacion Exitosa", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(SegundaPantalla.this, "La Tarea no Existe", Toast.LENGTH_SHORT).show();
                        }
                    }




                }
            }
        });

        imbBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent buscarPantalla = new Intent(SegundaPantalla.this, Buscar.class);
                buscarPantalla.putExtra("lista_tareas",listaTareas);
                startActivity(buscarPantalla);

            }
        });

    }




    private void referencias(){

        tvTitulo = findViewById(R.id.tvTitulo);
        tilTituloTarea = findViewById(R.id.tilTituloTarea);
        tilDescripcion = findViewById(R.id.tilDescripcion);
        imbBuscar = findViewById(R.id.imbBuscar);
        btnIngresar = findViewById(R.id.btnIngresar);
        btnModificar = findViewById(R.id.btnModificar);
        listaTareas = new ArrayList<Tarea>();
    }

    private void poblarLista(){

        for (int x = 1; x <= 1000; x++){
            Tarea a = new Tarea(x,"Tarea N??"+ x, "Descripcion Tarea N??"+ x);
            listaTareas.add(a);
        }


    }
}