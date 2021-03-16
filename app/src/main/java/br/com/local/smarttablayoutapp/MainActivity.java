package br.com.local.smarttablayoutapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class MainActivity extends AppCompatActivity {

    SmartTabLayout smartTabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //retira a elevação do appBar
        getSupportActionBar().setElevation(0);

        smartTabLayout = findViewById(R.id.viewPagerTab);
        viewPager = findViewById(R.id.viewPager);

        FragmentPagerAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(),
                FragmentPagerItems.with(getApplicationContext())
                        .add("Home", HomeFragment.class)
                        .add("Inscrições", IncricoesFragment.class)
                        .add("Em alta", EmAltaFragment.class)
                        .add("Mapa", MapsFragment.class)
                        .create()
        );
        viewPager.setAdapter(adapter);
        smartTabLayout.setViewPager(viewPager);
    }
}