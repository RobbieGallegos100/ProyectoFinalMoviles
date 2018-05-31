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
import com.tec.robert.jexchangeproyecto.Entidades.Finder;
import com.tec.robert.jexchangeproyecto.Entidades.Seeker;
import com.tec.robert.jexchangeproyecto.Utilidades.Utilidades;

import java.util.ArrayList;

public class Fragment_Finder extends Fragment {

    private static final String TAG = "Fragment_finder";
    ListView lstViewFinder;
    ArrayList<String> listaInformacion;
    ArrayList<Finder> listaFinder;
    ConexionSQLiteHelper conn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    private void consultarListaFinder() {
        SQLiteDatabase db = conn.getReadableDatabase();
        //SQLiteDatabase db = conn.getWritableDatabase();

        Finder finder = null;
        listaFinder = new ArrayList<Finder>();
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

            listaFinder.add(finder);
        }
        obtenerLista();

    }

    private void obtenerLista() {

        try {

            listaInformacion = new ArrayList<String>();
            String descubridor = "FINDER:";

            for (int j = 0; j < listaFinder.size(); j++) {
               listaInformacion.add(descubridor + "\n" + listaFinder.get(j).getNombreEmpresa() + "\n" + listaFinder.get(j).getSebusca() + " en " + listaFinder.get(j).getEspecialista() + "\n" + listaFinder.get(j).getCiudad());
            }

        } catch(Exception e){
            Toast.makeText(getActivity(), "Problema con obtenerLista()", Toast.LENGTH_LONG).show();
        }
    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_finder,container,false);

        lstViewFinder = view.findViewById(R.id.lstViewFinder);
        try {


            conn = new ConexionSQLiteHelper(getActivity(), "bd_finder", null, 1);




            consultarListaFinder();

            ArrayAdapter adaptador = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, listaInformacion);
            lstViewFinder.setAdapter(adaptador);

            lstViewFinder.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                    //String informacion="id: "+listaSeeker.get(pos).getId()+"\n";
                    //informacion+="Nombre: "+listaSeeker.get(pos).getNombre()+"\n";
                    //informacion+="Telefono: "+listaSeeker.get(pos).getTelefono()+"\n";

                    //Toast.makeText(getApplicationContext(),informacion,Toast.LENGTH_LONG).show();

                    Finder user = listaFinder.get(pos);

                    Intent intent = new Intent(getActivity(), DetalleFinder.class);

                    Bundle bundle = new Bundle();
                    bundle.putSerializable("finder", user);

                    intent.putExtras(bundle);
                    startActivity(intent);

                }
            });


        }catch (Exception e){
            Toast.makeText(getActivity(), "Error en el onCreate()", Toast.LENGTH_SHORT).show();
        }

        return view;
    }

}
