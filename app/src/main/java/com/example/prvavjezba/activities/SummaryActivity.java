package com.example.prvavjezba.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.prvavjezba.MyDataStorage;
import com.example.prvavjezba.R;
import com.example.prvavjezba.Student;
import com.example.prvavjezba.activities.PocetniActivity;


public class SummaryActivity extends AppCompatActivity {

    private TextView oTextViewIme;
    private TextView oTextViewPrezime;
    private TextView oTextViewDatumRodenja;
    private TextView oTextViewProfesor;
    private TextView oTextViewPredmet;
    private TextView oTextViewAkademskaGodina;
    private TextView oTextViewBrojSatiPredavanja;
    private TextView oTextViewBrojSatiVjezbe;
    private Button oBtnPovratak;
    private String sIme;
    private String sPrezime;
    private String sDatumRodenja;
    public String sProfesor;
    public String sPredmet;
    public String sAkademskaGodina;
    public String sBrojSatiPredavanja;
    public String sBrojSatiVjezbe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        final Bundle oExtras = getIntent().getExtras();

        sIme = oExtras.getString("ime", sIme);
        sPrezime = oExtras.getString("prezime", sPrezime);
        sDatumRodenja = oExtras.getString("datum", sDatumRodenja);
        sProfesor = oExtras.getString("profesor", sProfesor);
        sPredmet = oExtras.getString("predmet", sPredmet);
        sAkademskaGodina = oExtras.getString("akademskaGodina", sAkademskaGodina);
        sBrojSatiPredavanja = oExtras.getString("brojSatiPredavanja", sBrojSatiPredavanja);
        sBrojSatiVjezbe = oExtras.getString("brojSatiVjezbe", sBrojSatiVjezbe);

        oTextViewIme = (TextView) findViewById(R.id.tvIme);
        oTextViewIme.setText(sIme);

        oTextViewPrezime = (TextView) findViewById(R.id.tvPrezime);
        oTextViewPrezime.setText(sPrezime);

        oTextViewDatumRodenja = (TextView) findViewById(R.id.tvDatumRodenja);
        oTextViewDatumRodenja.setText(sDatumRodenja);

        oTextViewProfesor = (TextView) findViewById(R.id.tvProfesor);
        oTextViewProfesor.setText(sProfesor);

        oTextViewPredmet = (TextView) findViewById(R.id.tvPredmet);
        oTextViewPredmet.setText(sPredmet);

        oTextViewAkademskaGodina = (TextView) findViewById(R.id.tvAkademskaGodina);
        oTextViewAkademskaGodina.setText(sAkademskaGodina);

        oTextViewBrojSatiPredavanja = (TextView) findViewById(R.id.tvPredavanja);
        oTextViewBrojSatiPredavanja.setText(sBrojSatiPredavanja);

        oTextViewBrojSatiVjezbe = (TextView) findViewById(R.id.tvVjezbe);
        oTextViewBrojSatiVjezbe.setText(sBrojSatiVjezbe);

        oBtnPovratak = (Button) findViewById(R.id.btnPovratak);

        oBtnPovratak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student student = new Student(sIme, sPrezime, sPredmet);
                MyDataStorage spremnik = MyDataStorage.getInstance();
                spremnik.setStudents(student);
                Intent oStartActivity = new Intent(getApplicationContext(), PocetniActivity.class);
                //oStartActivity.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(oStartActivity);
            }
        });

    }
}
