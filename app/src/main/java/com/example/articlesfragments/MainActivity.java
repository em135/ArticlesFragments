package com.example.articlesfragments;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity implements MasterFragment.MasterFragmentOnSelectedListener {

    private FragmentManager fragmentManager = getSupportFragmentManager();
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MasterFragment masterFragment = new MasterFragment();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_master_viewgroup, masterFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onMasterFragmentSelected(Article article) {
        DetailFragment detailFragment = new DetailFragment();

        Bundle bundle = new Bundle();
        bundle.putString("title", article.getTitle());
        bundle.putString("body", article.getBody());
        detailFragment.setArguments(bundle);

        fragmentTransaction = fragmentManager.beginTransaction();

        FrameLayout detail = findViewById(R.id.fragment_detail_viewgroup);
        if (detail == null) {
            fragmentTransaction.replace(R.id.fragment_master_viewgroup, detailFragment);
            fragmentTransaction.addToBackStack(null);
        } else {
            fragmentTransaction.replace(R.id.fragment_detail_viewgroup, detailFragment);

        }
        fragmentTransaction.commit();
    }
}
