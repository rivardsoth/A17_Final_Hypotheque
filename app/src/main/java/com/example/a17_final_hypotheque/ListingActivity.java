package com.example.a17_final_hypotheque;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import modele.DbHypothequeAdapter;
import modele.Hypotheque;

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int option = item.getItemId();
        if (option == R.id.mnCalculer) {

        } else if (option == R.id.mnReour) {
            this.finish();
        } else if (option == R.id.mnListing){

        }
        return super.onOptionsItemSelected(item);
    }
}