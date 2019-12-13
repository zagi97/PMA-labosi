package com.example.prvavjezba.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.prvavjezba.fragments.PersonalInfoFragment;
import com.example.prvavjezba.R;
import com.example.prvavjezba.fragments.StudentInfoFragment;
import com.example.prvavjezba.fragments.SummaryFragment;
import com.example.prvavjezba.adapters.ViewPagerAdapter;


public class CreateNewRecordActivity extends AppCompatActivity implements PersonalInfoFragment.PersonalInfoListener, StudentInfoFragment.StudentInfoListener {
    public static ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_record);

        viewPager = findViewById(R.id.view_pager);
        viewPager.setOffscreenPageLimit(2);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(viewPagerAdapter);
    }

    @Override
    public void onPersonalInfoSent(String ime, String prezime, String datum) {
        String tag = "android:switcher:" + R.id.view_pager + ":" + 2;
        SummaryFragment fragment = (SummaryFragment) getSupportFragmentManager().findFragmentByTag(tag);
        fragment.updatePersonalInfo(ime, prezime, datum);
    }

    @Override
    public void onStudentInfoSent(String predmet, String ime_profesora, String akademska_godina, String sati_predavanja, String sati_LV) {
        String tag = "android:switcher:" + R.id.view_pager + ":" + 2;
        SummaryFragment fragment = (SummaryFragment) getSupportFragmentManager().findFragmentByTag(tag);
        fragment.updateStudentInfo(predmet, ime_profesora, akademska_godina, sati_predavanja, sati_LV);
    }

    public static void setCurrentItem (int item, boolean smoothScroll) {
        viewPager.setCurrentItem(item, smoothScroll);
    }
}
