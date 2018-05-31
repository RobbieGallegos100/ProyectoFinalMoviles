package com.tec.robert.jexchangeproyecto;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.tec.robert.jexchangeproyecto.Entidades.ConexionSQLiteHelper;
import com.tec.robert.jexchangeproyecto.Entidades.Seeker;
import com.tec.robert.jexchangeproyecto.Utilidades.Utilidades;

import java.util.ArrayList;

public class Fragment_Seeker extends Fragment {

    private static final String TAG = "Fragment_seeker";
    ListView lstViewSeeker;
    ArrayList<String> listaInformacion;
    ArrayList<Seeker> listaSeeker;
    ConexionSQLiteHelper conn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    private void consultarListaSeeker() {
        SQLiteDatabase db = conn.getReadableDatabase();
        //SQLiteDatabase db = conn.getWritableDatabase();

        Seeker seeker = null;
        listaSeeker = new ArrayList<Seeker>();
        //select * from seeker;
        Cursor cursor = db.rawQuery("SELECT * FROM "+ Utilidades.TABLA_SEEKER,null);

        while(cursor.moveToNext()){
            seeker = new Seeker();
            seeker.setNombre(cursor.getString(0));
            seeker.setApellido(cursor.getString(1));
            seeker.setSexo(cursor.getString(2));
            seeker.setFechaNacimiento(cursor.getString(3));
            seeker.setDireccion(cursor.getString(4));
            seeker.setCorreo(cursor.getString(5));
            seeker.setTelefono(cursor.getString(6));
            seeker.setEstudios(cursor.getString(7));
            seeker.setExperienciaLaboral(cursor.getString(8));
            seeker.setAuto(cursor.getString(9));
            seeker.setIngles(cursor.getString(10));
            seeker.setAptitudes(cursor.getString(11));
            seeker.setContraseña(cursor.getInt(12));

            listaSeeker.add(seeker);
        }
        obtenerLista();

    }

    /*

    private void consultarListaFinder() {
        SQLiteDatabase db = conn.getReadableDatabase();
        //SQLiteDatabase db = conn.getWritableDatabase();

        Finder finder = null;
        listaSeeker = new ArrayList<Seeker>();
        //select * from finder;
        Cursor cursor = db.rawQuery("SELECT * FROM "+Utilidades.TABLA_FINDER,null);

        while(cursor.moveToNext()){
            finder = new Finder();
            finder.setNombreEmpresa(cursor.getString(0));
            finder.setTipoEmpresa(cursor.getString(1));
            finder.setAmbito(cursor.getString(2));
            finder.setUbicacion(cursor.getString(3));
            finder.setCiudad(cursor.getString(4));
            finder.setCorreoFinder(cursor.getString(5));
            finder.setTelefonoFinder(cursor.getString(6));
            finder.setEspecialista(cursor.getString(7));
            finder.setDescripcionEmpresa(cursor.getString(8));
            finder.setPorque(cursor.getString(9));
            finder.setComunicarseCon(cursor.getString(10));
            finder.setSebusca(cursor.getString(11));
            finder.setExperienciaFinder(cursor.getString(12));
            finder.setInglesFinder(cursor.getString(13));
            finder.setContraseñaFinder(cursor.getInt(14));

            listaSeeker.add(finder);
        }
        obtenerLista();

    }
    */

    private void obtenerLista() {

        try {

            listaInformacion = new ArrayList<String>();
            String buscador = "SEEKER:";
            //String descubridor = "Finder:";

            //for (int j = 0; j < listaFinder.size(); j++) {
            //   listaInformacion.add(descubridor + "\n" + listaFinder.get(j).getNombreEmpresa() + " \n " + listaFinder.get(j).getSebusca() + " \n " + listaFinder.get(j).getCiudad());
            //}

            for (int i = 0; i < listaSeeker.size(); i++) {
                listaInformacion.add(buscador + "\n" + listaSeeker.get(i).getNombre() + "\n" + listaSeeker.get(i).getEstudios() + "\n" + listaSeeker.get(i).getExperienciaLaboral());
            }

        } catch(Exception e){
            Toast.makeText(getActivity(), "Problema con obtenerLista()", Toast.LENGTH_LONG).show();
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_seeker,container,false);

        //try {

            conn = new ConexionSQLiteHelper(getActivity(), "bd_seeker", null, 1);
            //conn = new ConexionSQLiteHelper(getApplicationContext(), "bd_finder", null, 1);
            lstViewSeeker = view.findViewById(R.id.lstViewSeeker);
            //btnBorrar = (Button)findViewById(R.id.btnBorrar);

        /*

        btnBorrar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SQLiteDatabase db=conn.getWritableDatabase();
                String[] parametros={etNombre.getText().toString()};

                db.delete(Utilidades.TABLA_SEEKER,Utilidades.CAMPO_NOMBRE+"=?",parametros);
                Toast.makeText(getApplicationContext(),"Ya se Eliminó el usuario",Toast.LENGTH_LONG).show();
                campoId.setText("");
                limpiar();
                db.close();
            }
        });

        */

            consultarListaSeeker();
            //consultarListaFinder();

            ArrayAdapter adaptador = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, listaInformacion);
            lstViewSeeker.setAdapter(adaptador);

            lstViewSeeker.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                    //String informacion="id: "+listaSeeker.get(pos).getId()+"\n";
                    //informacion+="Nombre: "+listaSeeker.get(pos).getNombre()+"\n";
                    //informacion+="Telefono: "+listaSeeker.get(pos).getTelefono()+"\n";

                    //Toast.makeText(getApplicationContext(),informacion,Toast.LENGTH_LONG).show();

                    Seeker user = listaSeeker.get(pos);

                    Intent intent = new Intent(getActivity(), DetalleSeeker.class);

                    Bundle bundle = new Bundle();
                    bundle.putSerializable("seeker", user);

                    intent.putExtras(bundle);
                    startActivity(intent);

                }
            });

            /*

        }catch (Exception e){
            Toast.makeText(getActivity(), "Error en el onCreate()", Toast.LENGTH_SHORT).show();
        }

        */


        return view;
    }



}
