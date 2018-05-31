package com.tec.robert.jexchangeproyecto;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.tec.robert.jexchangeproyecto.Entidades.ConexionSQLiteHelper;
import com.tec.robert.jexchangeproyecto.Entidades.Seeker;
import com.tec.robert.jexchangeproyecto.Utilidades.Utilidades;

import java.util.ArrayList;

public class BoardPrincipal extends AppCompatActivity {

    private static final String TAG = "BoardPrincipal";
    private SectionsPageAdapter mSectionsPageAdapter;
    private ViewPager mViewPager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board_principal);

        mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());

        //Poner el viewpager con las sectiones de adapter
        mViewPager = (ViewPager)findViewById(R.id.container);
        setupViewPager(mViewPager);

        TabLayout tabLayout = (TabLayout)findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);



    }


    private void setupViewPager(ViewPager viewPager){
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());

        adapter.addFragment(new Fragment_Seeker(), "Seeker");
        adapter.addFragment(new Fragment_Finder(), "Finder");
        viewPager.setAdapter(adapter);
    }

}
