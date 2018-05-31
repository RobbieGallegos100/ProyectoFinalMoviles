package com.tec.robert.jexchangeproyecto;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ayuda extends AppCompatActivity {

    TextView txtV;
    Context cntx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayuda);

        txtV = (TextView)findViewById(R.id.txtV);
        cntx = this;
        try {
            StringBuilder strBuilder = myFunction(cntx);
            txtV.setText(strBuilder);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    private StringBuilder myFunction(Context context) throws IOException {
        final Resources resources =  context.getResources();
        InputStream inputStream = resources.openRawResource(R.raw.ayudin);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder strBuild = new StringBuilder();
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                strBuild.append(line+ '\n');
            }
        } finally {
            reader.close();
        }
        return strBuild;

    }

    }


