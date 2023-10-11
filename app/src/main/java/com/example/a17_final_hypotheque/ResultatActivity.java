package com.example.a17_final_hypotheque;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import modele.Hypotheque;

public class ResultatActivity extends AppCompatActivity {
    private TextView lblAnnee, lblEmprunt, lblMAP, lblMontantTotalHyp, lblDiff;
    private Intent dataIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultat);
        setWidgets();
        dataIntent = getIntent();
        Hypotheque hyp = (Hypotheque) dataIntent.getSerializableExtra("hyp");
        lblAnnee.setText(String.valueOf(hyp.getTauxAnnuel()));
        lblEmprunt.setText(String.valueOf(hyp.getEmprunt()));
        lblMAP.setText(String.valueOf(hyp.getMap()));
        lblMontantTotalHyp.setText(String.valueOf(hyp.getMontantTotaleApresHyp()));
        lblDiff.setText(String.valueOf(hyp.getDifference()));
    }

    private void setWidgets() {
        lblAnnee = findViewById(R.id.lblAnnee);
        lblEmprunt = findViewById(R.id.lblEmprunt);
        lblMAP = findViewById(R.id.lblMAP);
        lblMontantTotalHyp = findViewById(R.id.lblMontantTotalHyp);
        lblDiff = findViewById(R.id.lblDiff);
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
        } else {

        }
        return super.onOptionsItemSelected(item);
    }
}