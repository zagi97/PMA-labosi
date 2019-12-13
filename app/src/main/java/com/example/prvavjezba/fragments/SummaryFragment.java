package com.example.prvavjezba.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.prvavjezba.R;
import com.example.prvavjezba.Student;
import com.example.prvavjezba.activities.PocetniActivity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SummaryFragment extends Fragment {
    private TextView sIme, sPrezime, sDatum, sPredmet, sImeProfesora, sAkademskaGodina, sSatiPredavanja, sSatiLV;
    private Button vrati_se;
    private String mIme, mPrezime, mPredmet;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_student_info,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        sIme = view.findViewById(R.id.tvIme);
        sPrezime = view.findViewById(R.id.tvPrezime);
        sDatum = view.findViewById(R.id.tvDatumRodenja);
        sPredmet = view.findViewById(R.id.tvPredmet);
        sImeProfesora = view.findViewById(R.id.tvProfesor);
        sAkademskaGodina = view.findViewById(R.id.tvAkademskaGodina);
        sSatiPredavanja = view.findViewById(R.id.tvPredavanja);
        sSatiLV = view.findViewById(R.id.tvVjezbe);
        vrati_se = view.findViewById(R.id.btnPovratak);

        vrati_se.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                com.example.prvavjezba.model.MyDataStorage myDataStorage = com.example.prvavjezba.model.MyDataStorage.getInstance();
                Student student = new Student(mIme, mPrezime, mPredmet);
                myDataStorage.setStudents(student);
                Intent intent = new Intent(getActivity(), PocetniActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
    }

    public void updatePersonalInfo(String ime, String prezime, String datum){
        mIme = ime;
        mPrezime = prezime;

        sIme.setText(ime);
        sPrezime.setText(prezime);
        sDatum.setText(datum);

    }

    public void updateStudentInfo(String predmet, String ime_profesora, String akademska_godina, String sati_predavanja, String sati_LV) {
        mPredmet = predmet;

        sPredmet.setText(predmet);
        sImeProfesora.setText(ime_profesora);
        sAkademskaGodina.setText(akademska_godina);
        sSatiPredavanja.setText(sati_predavanja);
        sSatiLV.setText(sati_LV);
    }
}
