package com.tec.robert.jexchangeproyecto;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.tec.robert.jexchangeproyecto.Entidades.ConexionSQLiteHelper;
import com.tec.robert.jexchangeproyecto.Utilidades.Utilidades;

public class SeekerPost extends AppCompatActivity {

    EditText etNombre, apellido_sp, fecha_sp, direccion_sp, correo_sp, telefono_sp, estudios_sp, experiencia_sp, aptitudes_sp;
    RadioGroup sexo_sp, transporte_sp, ingles_sp;
    RadioButton femenino_sp, masculino_sp, auto_sp, publico_sp, mucho_sp, medio_sp, poco_sp;
    Button regresar_sp, enviar_sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seeker_post);

        etNombre = (EditText)findViewById(R.id.etNombre);
        apellido_sp = (EditText)findViewById(R.id.etApellidos);
        fecha_sp = (EditText)findViewById(R.id.etFecha);
        direccion_sp = (EditText)findViewById(R.id.etDireccion);
        correo_sp = (EditText)findViewById(R.id.etCorreo);
        telefono_sp = (EditText)findViewById(R.id.etTelefono);
        estudios_sp = (EditText)findViewById(R.id.etEstudios);
        experiencia_sp = (EditText)findViewById(R.id.etExperiencia);
        aptitudes_sp = (EditText)findViewById(R.id.etAptitudes);

        sexo_sp = (RadioGroup)findViewById(R.id.rgSexo);
        transporte_sp = (RadioGroup)findViewById(R.id.rgTransporte);
        ingles_sp = (RadioGroup)findViewById(R.id.rgIngles);

        femenino_sp = (RadioButton)findViewById(R.id.rbFemenino);
        masculino_sp = (RadioButton)findViewById(R.id.rbMasculino);
        auto_sp = (RadioButton)findViewById(R.id.rbAuto);
        publico_sp = (RadioButton)findViewById(R.id.rbPublico);
        mucho_sp = (RadioButton)findViewById(R.id.rbMucho);
        medio_sp = (RadioButton)findViewById(R.id.rbMedio);
        poco_sp = (RadioButton)findViewById(R.id.rbPoco);

        regresar_sp = (Button)findViewById(R.id.btnRegresar);
        enviar_sp = (Button)findViewById(R.id.btnEnviar);

        regresar_sp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });

        enviar_sp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                registrarSeeker();
            }
        });

    }

    int AleatorioConRango(int min, int max)
    {
        int range = (max - min) + 1;
        return (int)(Math.random() * range) + min;
    }

    private void registrarSeeker() {

        try {

            if (!etNombre.getText().toString().equals("") && !apellido_sp.getText().toString().equals("") && !fecha_sp.getText().toString().equals("") &&
                    !direccion_sp.getText().toString().equals("") && !correo_sp.getText().toString().equals("") && !estudios_sp.getText().toString().equals("") &&
                    !experiencia_sp.getText().toString().equals("") && !aptitudes_sp.getText().toString().equals("") && !telefono_sp.getText().toString().equals("")) {

                if (sexo_sp.getCheckedRadioButtonId() != -1 && transporte_sp.getCheckedRadioButtonId() != -1 && ingles_sp.getCheckedRadioButtonId() != -1) {


                    ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "bd_seeker", null, 1);
                    SQLiteDatabase db = conn.getWritableDatabase();
                    ContentValues values = new ContentValues();

                            // RADIO BUTTON

                            String sexo = "", transporte = "", ingles = "";

                            if (femenino_sp.isChecked() == true) {
                                sexo = "Sexo femenino";
                            } else if (masculino_sp.isChecked() == true) {
                                sexo = "Sexo masculino";
                            } else if (!femenino_sp.isChecked() || !masculino_sp.isChecked()) {
                                sexo = "No seleccionado";
                            }

                            if (auto_sp.isChecked() == true) {
                                transporte = "Cuenta con auto propio";
                            } else if (publico_sp.isChecked() == true) {
                                transporte = "Usa transporte público";
                            } else if (!auto_sp.isChecked() || !publico_sp.isChecked()) {
                                transporte = "No seleccionado";
                            }

                            if (mucho_sp.isChecked() == true) {
                                ingles = "Maneja un aproximado de 95% del idioma inglés";
                            } else if (medio_sp.isChecked() == true) {
                                ingles = "Maneja un aproximado de 75% del idioma inglés";
                            } else if (poco_sp.isChecked() == true) {
                                ingles = "Maneja un aproximado de 50% del idioma inglés";
                            } else if (!mucho_sp.isChecked() || !medio_sp.isChecked() || !poco_sp.isChecked()) {
                                ingles = "No seleccionado";
                            }

                            int contraseñaI = AleatorioConRango(1,1000);

                            values.put(Utilidades.CAMPO_NOMBRE, etNombre.getText().toString());
                            values.put(Utilidades.CAMPO_APELLIDO, apellido_sp.getText().toString());
                            values.put(Utilidades.CAMPO_NACIMIENTO, String.valueOf(fecha_sp.getText()));
                            values.put(Utilidades.CAMPO_DIRECCION, String.valueOf(direccion_sp.getText()));
                            values.put(Utilidades.CAMPO_CORREO, String.valueOf(correo_sp.getText()));
                            values.put(Utilidades.CAMPO_TELEFONO, String.valueOf(telefono_sp.getText()));
                            values.put(Utilidades.CAMPO_ESTUDIOS, String.valueOf(estudios_sp.getText()));
                            values.put(Utilidades.CAMPO_EXPERIENCIA, String.valueOf(experiencia_sp.getText()));
                            values.put(Utilidades.CAMPO_APTITUDES, String.valueOf(aptitudes_sp.getText()));
                            values.put(Utilidades.CAMPO_SEXO, String.valueOf(sexo));
                            values.put(Utilidades.CAMPO_AUTO, String.valueOf(transporte));
                            values.put(Utilidades.CAMPO_INGLES, String.valueOf(ingles));
                            values.put(Utilidades.CAMPO_CONTRASEÑA, String.valueOf(contraseñaI));

                    Long idResultante = db.insert(Utilidades.TABLA_SEEKER,Utilidades.CAMPO_CONTRASEÑA,values);

                    //String insert="INSERT INTO "+Utilidades.TABLA_SEEKER
                    //        +" ( " +Utilidades.CAMPO_CONTRASEÑA+","+Utilidades.CAMPO_NOMBRE+","+Utilidades.CAMPO_APELLIDO+","+Utilidades.CAMPO_NACIMIENTO+","+Utilidades.CAMPO_DIRECCION+","+Utilidades.CAMPO_CORREO+","+Utilidades.CAMPO_TELEFONO+","+Utilidades.CAMPO_ESTUDIOS+","+Utilidades.CAMPO_EXPERIENCIA+","+Utilidades.CAMPO_APTITUDES+","+Utilidades.CAMPO_SEXO+","+Utilidades.CAMPO_SEXO+","+Utilidades.CAMPO_AUTO+","+Utilidades.CAMPO_INGLES+","+Utilidades.CAMPO_CONTRASEÑA+")" +
                    //        " VALUES ("+etNombre.getText().toString()+", '"+apellido_sp.getText().toString()+"','" +fecha_sp.getText().toString()+"'"+direccion_sp.getText().toString()+"','"+correo_sp.getText().toString()+"','"+telefono_sp.getText().toString()+"','"+estudios_sp.getText().toString()+"','"+experiencia_sp.getText().toString()+"','"+aptitudes_sp.getText().toString()+"','"+sexo+"','"+transporte+"',"+ingles+"',"+contraseñaI+"')";

                    //db.execSQL(insert);

                    Toast.makeText(getApplicationContext(), "Datos ingresados correctamente "+etNombre.getText().toString()+", su contraseña generada es: "+contraseñaI, Toast.LENGTH_LONG).show();

                    db.close();
                    finish();

                    } else {
                        Toast.makeText(getApplicationContext(), "Información incompleta: Error 1", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(getApplicationContext(), "Información incompleta: Error 2", Toast.LENGTH_SHORT).show();
                }

            }catch(Exception e){
                Toast.makeText(getApplicationContext(), "Error en registrarSeeker()", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }

        }
    }