package com.tec.robert.jexchangeproyecto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.tec.robert.jexchangeproyecto.Entidades.Seeker;

public class DetalleSeeker extends AppCompatActivity {

    TextView nombre_sp, apellido_sp, fecha_sp, direccion_sp, correo_sp, sexo_sp, transporte_sp, ingles_sp,
            telefono_sp, estudios_sp, experiencia_sp, aptitudes_sp;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_seeker);

        nombre_sp = (TextView)findViewById(R.id.tvNombre);
        apellido_sp = (TextView)findViewById(R.id.tvApellido);
        fecha_sp = (TextView)findViewById(R.id.tvFecha);
        direccion_sp = (TextView)findViewById(R.id.tvDireccion);
        correo_sp = (TextView)findViewById(R.id.tvCorreo);
        telefono_sp = (TextView)findViewById(R.id.tvTelefono);
        estudios_sp = (TextView)findViewById(R.id.tvEstudios);
        experiencia_sp = (TextView)findViewById(R.id.tvExperiencia);
        aptitudes_sp = (TextView)findViewById(R.id.tvAptitudes);
        sexo_sp = (TextView)findViewById(R.id.tvSexo);
        transporte_sp = (TextView)findViewById(R.id.tvTransporte);
        ingles_sp = (TextView)findViewById(R.id.tvIngles);
        btn1 = (Button)findViewById(R.id.btnRegresar);

        Bundle objetoEnviadoSeeker=getIntent().getExtras();
        Seeker userSeeker=null;

        if(objetoEnviadoSeeker!=null){
            userSeeker = (Seeker) objetoEnviadoSeeker.getSerializable("seeker");
            nombre_sp.setText(userSeeker.getNombre().toString());
            apellido_sp.setText(userSeeker.getApellido().toString());
            fecha_sp.setText(userSeeker.getFechaNacimiento().toString());
            direccion_sp.setText(userSeeker.getDireccion().toString());
            correo_sp.setText(userSeeker.getCorreo().toString());
            telefono_sp.setText(userSeeker.getTelefono().toString());
            estudios_sp.setText(userSeeker.getEstudios().toString());
            experiencia_sp.setText(userSeeker.getExperienciaLaboral().toString());
            aptitudes_sp.setText(userSeeker.getAptitudes().toString());
            sexo_sp.setText(userSeeker.getSexo().toString());
            transporte_sp.setText(userSeeker.getAuto().toString());
            ingles_sp.setText(userSeeker.getIngles().toString());

        }

        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });

    }
}
