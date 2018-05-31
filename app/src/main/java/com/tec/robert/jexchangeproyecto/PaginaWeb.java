package com.tec.robert.jexchangeproyecto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Toast;

public class PaginaWeb extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_web);

        WebView myWebView = (WebView) findViewById(R.id.webview);

        try {
            myWebView.loadUrl("http://www.JExchange.com");
        } catch (Exception e){
            Toast.makeText(PaginaWeb.this, "La página web de JExchange no está disponible" +
                    " en este momento, intente más tarde.", Toast.LENGTH_LONG).show();
        }

    }
}
