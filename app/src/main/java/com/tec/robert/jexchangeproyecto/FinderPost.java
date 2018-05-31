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

public class FinderPost extends AppCompatActivity {

    EditText fp_nombreEmpresa, fp_tipoEmpresa, fp_Ambito, fp_Ubicacion, fp_Ciudad, fp_Telefono, fp_Correo, fp_Especialista, fp_Descripcion, fp_Porque, fp_ComunicarseCon;
    RadioGroup fp_seBusca, fp_Experiencia, fp_Ingles;
    RadioButton fp_Licenciado, fp_Ingeniero, fp_MeI, fp_PoN, fp_Mucho, fp_Medio, fp_Poco;
    Button fp_Regresar, fp_Enviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finder_post);

        fp_nombreEmpresa = (EditText)findViewById(R.id.etNombreEmpresa);
        fp_tipoEmpresa = (EditText)findViewById(R.id.etTipoDeEmpresa);
        fp_Ambito = (EditText)findViewById(R.id.etAmbito);
        fp_Ubicacion = (EditText)findViewById(R.id.etUbicacion);
        fp_Ciudad = (EditText)findViewById(R.id.etCiudad);
        fp_Correo = (EditText)findViewById(R.id.etCorreo);
        fp_Telefono = (EditText)findViewById(R.id.etTelefono);
        fp_Especialista = (EditText)findViewById(R.id.etEspecialista);
        fp_Descripcion = (EditText)findViewById(R.id.etDescripcionEmpresa);
        fp_Porque = (EditText)findViewById(R.id.etPorque);
        fp_ComunicarseCon = (EditText)findViewById(R.id.etComunicarseCon);

        fp_seBusca = (RadioGroup)findViewById(R.id.rgSeBusca);
        fp_Experiencia = (RadioGroup)findViewById(R.id.rgExperiencia);
        fp_Ingles = (RadioGroup)findViewById(R.id.rgIngles);

        fp_Licenciado = (RadioButton) findViewById(R.id.rbLicenciado);
        fp_Ingeniero = (RadioButton) findViewById(R.id.rbIngeniero);
        fp_MeI = (RadioButton) findViewById(R.id.rbMeI);
        fp_PoN = (RadioButton) findViewById(R.id.rbPoN);
        fp_Mucho = (RadioButton) findViewById(R.id.rbMucho);
        fp_Medio = (RadioButton) findViewById(R.id.rbMedio);
        fp_Poco = (RadioButton) findViewById(R.id.rbPoco);

        fp_Regresar = (Button) findViewById(R.id.btnRegresar);
        fp_Enviar = (Button) findViewById(R.id.btnEnviar);

        fp_Regresar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });

        fp_Enviar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                registrarFinder();
            }
        });
    }

    private void registrarFinder(){

        try {

            if (!fp_nombreEmpresa.getText().toString().equals("") && !fp_tipoEmpresa.getText().toString().equals("") && !fp_Ambito.getText().toString().equals("") &&
                    !fp_Ubicacion.getText().toString().equals("") && !fp_Ciudad.getText().toString().equals("") && !fp_Telefono.getText().toString().equals("") &&
                    !fp_Correo.getText().toString().equals("") && !fp_Especialista.getText().toString().equals("") && !fp_Descripcion.getText().toString().equals("") &&
                    !fp_Porque.getText().toString().equals("") && !fp_ComunicarseCon.getText().toString().equals("")) {

                if (fp_seBusca.getCheckedRadioButtonId() != -1 && fp_Experiencia.getCheckedRadioButtonId() != -1 && fp_Ingles.getCheckedRadioButtonId() != -1) {

                    ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "bd_finder", null, 1);
                    SQLiteDatabase db = conn.getWritableDatabase();
                    ContentValues values = new ContentValues();

                    // RADIO BUTTON
                    //RadioButton fp_Licenciado, fp_Ingeniero, fp_MeI, fp_PoN, fp_Mucho, fp_Medio, fp_Poco;

                    String especialidad = "", experiencia = "", ingles = "";

                    if (fp_Licenciado.isChecked() == true) {
                        especialidad = "Licenciado";
                    } else if (fp_Ingeniero.isChecked() == true) {
                        especialidad = "Ingeniero";
                    } else if (!fp_Licenciado.isChecked() || !fp_Ingeniero.isChecked()) {
                        especialidad = "No seleccionado";
                    }

                    if (fp_MeI.isChecked() == true) {
                        experiencia = "Mucha o intermedia experiencia";
                    } else if (fp_PoN.isChecked() == true) {
                        experiencia = "Poca o nula experiencia";
                    } else if (!fp_MeI.isChecked() || !fp_PoN.isChecked()) {
                        experiencia = "No seleccionado";
                    }

                    if (fp_Mucho.isChecked() == true) {
                        ingles = "Maneja un aproximado de 95% del idioma inglés";
                    } else if (fp_Medio.isChecked() == true) {
                        ingles = "Maneja un aproximado de 75% del idioma inglés";
                    } else if (fp_Poco.isChecked() == true) {
                        ingles = "Maneja un aproximado de 50% del idioma inglés";
                    } else if (!fp_Mucho.isChecked() || !fp_Medio.isChecked() || !fp_Poco.isChecked()) {
                        ingles = "No seleccionado";
                    }

                    int auxiliar = AleatorioConRango(1001, 2000);

                    values.put(Utilidades.CAMPO_NOMBRE_FINDER, fp_nombreEmpresa.getText().toString());
                    values.put(Utilidades.CAMPO_TIPOEMPRESA, fp_tipoEmpresa.getText().toString());
                    values.put(Utilidades.CAMPO_AMBITO, String.valueOf(fp_Ambito.getText()));
                    values.put(Utilidades.CAMPO_UBICACION, String.valueOf(fp_Ubicacion.getText()));
                    values.put(Utilidades.CAMPO_CIUDAD, String.valueOf(fp_Ciudad.getText()));
                    values.put(Utilidades.CAMPO_CORREO_FINDER, String.valueOf(fp_Correo.getText()));
                    values.put(Utilidades.CAMPO_TELEFONO_FINDER, String.valueOf(fp_Telefono.getText()));
                    values.put(Utilidades.CAMPO_ESPECIALISTA, String.valueOf(fp_Especialista.getText()));
                    values.put(Utilidades.CAMPO_DESCRIPCION_EMPRESA, String.valueOf(fp_Descripcion.getText()));
                    values.put(Utilidades.CAMPO_PORQUE, String.valueOf(fp_Porque.getText()));
                    values.put(Utilidades.CAMPO_COMUNICARSECON, String.valueOf(fp_ComunicarseCon.getText()));
                    values.put(Utilidades.CAMPO_SEBUSCA, String.valueOf(especialidad));
                    values.put(Utilidades.CAMPO_EXPERIENCIA_FINDER, String.valueOf(experiencia));
                    values.put(Utilidades.CAMPO_INGLES_FINDER, String.valueOf(ingles));
                    values.put(Utilidades.CAMPO_CONTRASEÑA_FINDER, String.valueOf(auxiliar));

                    Long idResultante = db.insert(Utilidades.TABLA_FINDER, Utilidades.CAMPO_CONTRASEÑA_FINDER, values);

                    Toast.makeText(getApplicationContext(), "Datos ingresados correctamente " + fp_nombreEmpresa.getText().toString() + ", su  contraseña generada es: " + auxiliar, Toast.LENGTH_LONG).show();
                    db.close();
                    finish();


                } else {
                    Toast.makeText(getApplicationContext(), "Información incompleta: Error 1", Toast.LENGTH_SHORT).show();
                }

            } else {
                Toast.makeText(getApplicationContext(), "Información incompleta: Error 2", Toast.LENGTH_SHORT).show();
            }

        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "Error en registrarFinder()", Toast.LENGTH_SHORT).show();
        }

    }

    int AleatorioConRango(int min, int max)
    {
        int range = (max - min) + 1;
        return (int)(Math.random() * range) + min;
    }

}
