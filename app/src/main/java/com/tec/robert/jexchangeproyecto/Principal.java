package com.tec.robert.jexchangeproyecto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.tec.robert.jexchangeproyecto.Entidades.ConexionSQLiteHelper;

public class Principal extends AppCompatActivity {

    Button btnSeeker, btnSalir, btnBoard, btnAyuda, btnFinder, btnContactanos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        btnSeeker = (Button)findViewById(R.id.btnSeeker);
        btnFinder = (Button)findViewById(R.id.btnFinder);
        btnSalir = (Button)findViewById(R.id.btnSalir);
        btnBoard = (Button)findViewById(R.id.btnBoard);
        btnAyuda = (Button)findViewById(R.id.btnAyuda);
        btnContactanos = (Button)findViewById(R.id.btnContactanos);

        btnSeeker.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Principal.this, SeekerPost.class));
            }
        });

        btnContactanos.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Principal.this, PaginaWeb.class));
            }
        });

        btnFinder.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Principal.this, FinderPost.class));
            }
        });

        btnBoard.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Principal.this, BoardPrincipal.class));
            }
        });

        btnAyuda.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Principal.this, Ayuda.class));
            }
        });

        btnSalir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.exit(0);
            }
        });

    }


}
