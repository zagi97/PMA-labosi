package com.example.prvavjezba;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.List;
import java.util.Locale;

public class PocetniActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{


    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Button oBtnDodajStudenta;
    private Spinner spinner;
    private boolean userIsInteracting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pocetni);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerViewStudenti);


        MyDataStorage spremnik = MyDataStorage.getInstance();
        List<Student> students = spremnik.getStudents();
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new StudentAdapter(students);
        mRecyclerView.setAdapter(mAdapter);


        oBtnDodajStudenta = (Button) findViewById(R.id.btnDodajStudenta);
        oBtnDodajStudenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent OtvoriPersonalInfo = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(OtvoriPersonalInfo);
            }
        });


        spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.languages, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        if (userIsInteracting) {
            switch (spinner.getSelectedItemPosition()){
                case 1:
                    changeLanguage("hr");
                    break;
                case 2:
                    changeLanguage("en");
                    break;
                case 3:
                    changeLanguage("hu");
                    break;
            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    private void changeLanguage(String lang){
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration config = getBaseContext().getResources().getConfiguration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        recreate();
    }

    @Override
    public void onUserInteraction() {
        super.onUserInteraction();
        userIsInteracting = true;
    }
}
