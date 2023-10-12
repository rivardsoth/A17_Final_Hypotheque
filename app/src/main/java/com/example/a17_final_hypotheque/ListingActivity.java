package com.example.a17_final_hypotheque;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import modele.DbHypothequeAdapter;

public class ListingActivity extends AppCompatActivity {
    private ListView listView;
    private DbHypothequeAdapter dbAdapter;
    private ArrayAdapter<String> listeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listing);
        dbAdapter = new DbHypothequeAdapter(ListingActivity.this);
        setWidgets();
        afficherData();
    }

    private void afficherData() {
        ArrayList<String> registre = dbAdapter.selectionnerHypotheque();
        listeAdapter = new ArrayAdapter<>(ListingActivity.this, android.R.layout.simple_list_item_1,
                registre);
        listView.setAdapter(listeAdapter);
    }

    private void setWidgets() {
        listView = findViewById(R.id.listView);
    }
}