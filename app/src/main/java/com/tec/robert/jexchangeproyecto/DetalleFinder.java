package com.tec.robert.jexchangeproyecto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.tec.robert.jexchangeproyecto.Entidades.Finder;

public class DetalleFinder extends AppCompatActivity {

    TextView nombreEmpresa_fp, tipoEmpresa_fp, ambito_fp, ubicacion_fp, ciudad_fp, correoFinder_fp, telefonoFinder_fp, especialista_fp,
            descripcionEmpresa_fp, comunicarseCon_fp, seBusca_fp, experiencia_fp, ingles_fp;
    Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_finder);

        nombreEmpresa_fp = (TextView)findViewById(R.id.tvNombreEmpresa);
        tipoEmpresa_fp = (TextView)findViewById(R.id.tvTipoEmpresa);
        ambito_fp = (TextView)findViewById(R.id.tvAmbito);
        ubicacion_fp = (TextView)findViewById(R.id.tvUbicacion);
        ciudad_fp = (TextView)findViewById(R.id.tvCiudad);
        correoFinder_fp = (TextView)findViewById(R.id.tvCorreoFinder);
        telefonoFinder_fp = (TextView)findViewById(R.id.tvTelefonoFinder);
        especialista_fp = (TextView)findViewById(R.id.tvEspecialista);
        descripcionEmpresa_fp = (TextView)findViewById(R.id.tvDescripcionEmpresa);
        comunicarseCon_fp = (TextView)findViewById(R.id.tvComunicarseCon);
        seBusca_fp = (TextView)findViewById(R.id.tvSeBusca);
        experiencia_fp = (TextView)findViewById(R.id.tvExperienciaFinder);
        ingles_fp = (TextView)findViewById(R.id.tvInglesFinder);

        btn2 = (Button)findViewById(R.id.btnRegresarFinder);

        Bundle objetoEnviadoFinder=getIntent().getExtras();
        Finder userFinder=null;

        if(objetoEnviadoFinder!=null){
            userFinder = (Finder) objetoEnviadoFinder.getSerializable("finder");
            nombreEmpresa_fp.setText(userFinder.getNombreEmpresa().toString());
            tipoEmpresa_fp.setText(userFinder.getTipoEmpresa().toString());
            ambito_fp.setText(userFinder.getAmbito().toString());
            ubicacion_fp.setText(userFinder.getUbicacion().toString());
            ciudad_fp.setText(userFinder.getCiudad().toString());
            correoFinder_fp.setText(userFinder.getCorreoFinder().toString());
            telefonoFinder_fp.setText(userFinder.getTelefonoFinder().toString());
            especialista_fp.setText(userFinder.getEspecialista().toString());
            descripcionEmpresa_fp.setText(userFinder.getDescripcionEmpresa().toString());
            comunicarseCon_fp.setText(userFinder.getComunicarseCon().toString());
            seBusca_fp.setText(userFinder.getSebusca().toString());
            experiencia_fp.setText(userFinder.getExperienciaFinder().toString());
            ingles_fp.setText(userFinder.getInglesFinder().toString());

        }

        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });

    }
}
