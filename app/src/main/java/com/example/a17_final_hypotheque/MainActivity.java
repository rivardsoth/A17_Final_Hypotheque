package com.example.a17_final_hypotheque;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

import modele.DbHypothequeAdapter;
import modele.Hypotheque;

public class MainActivity extends AppCompatActivity {
    private RadioGroup radGroup;
    private RadioButton rad5, rad10, rad15, rad25;
    private EditText txtTaux, txtEmprunt;
    private TextView lblError;

    private double tauxAnnuel;
    private double emprunt;
    private double Map;
    private int nbAnnee;
    private DbHypothequeAdapter dbAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setWidgets();
        dbAdapter = new DbHypothequeAdapter(MainActivity.this);
    }

    private void setWidgets() {
        radGroup = findViewById(R.id.radGroup);
        rad5 = findViewById(R.id.rad5);
        rad10 = findViewById(R.id.rad10);
        rad15 = findViewById(R.id.rad15);
        rad25 = findViewById(R.id.rad25);
        txtTaux = findViewById(R.id.txtTaux);
        txtEmprunt = findViewById(R.id.txtEmprunt);
        lblError = findViewById(R.id.lblError);
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
            Map = Double.parseDouble(CalculerHypotheque());
            if (Map< 0) {
                lblError.setText("Erreur dans la saisie de donnée!!");
            } else {
                lblError.setText(String.valueOf(Map));
                Intent intent = new Intent(MainActivity.this, ResultatActivity.class);
                Hypotheque hyp = new Hypotheque(tauxAnnuel,emprunt,Map,nbAnnee);
                dbAdapter.ajouterHypotheque(hyp);
                intent.putExtra("hyp", hyp);
                startActivity(intent);
            }

        } else if (option == R.id.mnReour) {

        } else if (option == R.id.mnListing){
            Intent intent = new Intent(MainActivity.this, ListingActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    private String CalculerHypotheque() {
        if (!validerTaux() || !validerEmprunt()) {
            Toast.makeText(MainActivity.this, "Erreur de donnée!!", Toast.LENGTH_LONG).show();
            return "-1";
        } else {

            nbAnnee = getAnnee();
            tauxAnnuel = getTaux();
            emprunt = getEmprunt();

            double result = (((tauxAnnuel / 12) * emprunt) / (1 - (1 / Math.pow(1 + (tauxAnnuel / 12), 12 * nbAnnee))));

            // Create a DecimalFormat object to format the result to two decimal places
            DecimalFormat df = new DecimalFormat("#.00");

            // Format the result
            String formattedResult = df.format(result);
            return formattedResult;
        }
    }

    private double getEmprunt() {
        return Double.parseDouble(txtEmprunt.getText().toString());
    }

    private int getAnnee() {
        int nbAnnee;
        int id = radGroup.getCheckedRadioButtonId();
        if (id == R.id.rad5) {
            nbAnnee = Integer.parseInt(getResources().getString(R.string._5_ans));
        } else if (id == R.id.rad10) {
            nbAnnee = Integer.parseInt(getResources().getString(R.string._10_ans));
        } else if (id == R.id.rad15) {
            nbAnnee = Integer.parseInt(getResources().getString(R.string._15_ans));
        } else {
            nbAnnee = Integer.parseInt(getResources().getString(R.string._25_ans));
        }
        return nbAnnee;
    }

    private boolean validerTaux() {
        try {
            double tauxM = Double.parseDouble(txtTaux.getText().toString());

            if (tauxM < 0 || tauxM > 100) {
                return false;
            } else {
                return true;
            }
        } catch (NumberFormatException e) {
            return false;
        }

    }

    private boolean validerEmprunt() {
        try {
            double emprunt = Double.parseDouble(txtEmprunt.getText().toString());
            if (emprunt < 0) {
                return false;
            } else {
                return true;
            }
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private double getTaux() {
        double tauxM = Double.parseDouble(txtTaux.getText().toString());
        return tauxM / 100;
    }

}