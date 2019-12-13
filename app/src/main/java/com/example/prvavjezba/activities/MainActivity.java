package com.example.prvavjezba.activities;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.prvavjezba.R;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText oInputLayoutIme;
    private TextInputEditText oInputLayoutPrezime;
    private EditText oEditTextDatum;
    private Button oBtnDalje;
    private String sIme;
    private String sPrezime;
    private String sDatum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        oInputLayoutIme = (TextInputEditText)findViewById(R.id.tietIme);
        oInputLayoutPrezime = (TextInputEditText) findViewById(R.id.tietPrezime);
        oEditTextDatum = (EditText) findViewById(R.id.etDatum);

        oBtnDalje = (Button) findViewById(R.id.btnDalje);
        oBtnDalje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                sIme = oInputLayoutIme.getText().toString();
                sPrezime = oInputLayoutPrezime.getText().toString();
                sDatum = oEditTextDatum.getText().toString();

                Intent oStudentInfoActivityIntent = new Intent(getApplicationContext(), StudentInfoActivity.class);
                oStudentInfoActivityIntent.putExtra("ime", sIme);
                oStudentInfoActivityIntent.putExtra("prezime", sPrezime);
                oStudentInfoActivityIntent.putExtra("datum", sDatum);
                startActivity(oStudentInfoActivityIntent);

            }
        });
    }
}
