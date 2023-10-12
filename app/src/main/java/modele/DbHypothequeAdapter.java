package modele;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;

public class DbHypothequeAdapter {
    private final Context context;
    //support pour CRUD
    private SQLiteDatabase dbase;
    private HypothequeDbHelper dbHelper;

    public DbHypothequeAdapter(Context context) {
        this.context = context;
        this.dbHelper = new HypothequeDbHelper(context, HypothequeDbHelper.BD_NAME, null, HypothequeDbHelper.VERSION);
    }

    public void openBd() {
        dbase = dbHelper.getWritableDatabase();
    }

    public void fermerBD() {
        dbase.close();
    }

    public void ajouterHypotheque(Hypotheque h) {
        openBd();
        //obtenir les valeurs des colonnes
        double tauxAnnuel = h.getTauxAnnuel();
        double emprunt = h.getEmprunt();
        double Map = h.getMap();
        int nbAnnee = h.getNbAnnee();
        ContentValues cv = new ContentValues();
        cv.put(HypothequeDbHelper.COL_TAUX_ANNUEL, tauxAnnuel);
        cv.put(HypothequeDbHelper.COL_EMPRUNT, emprunt);
        cv.put(HypothequeDbHelper.COL_MAP, Map);
        cv.put(HypothequeDbHelper.COL_NB_ANNEE, nbAnnee);
        dbase.insert(HypothequeDbHelper.TABLE_P, null, cv);
        Toast.makeText(context, "Ajout reussi", Toast.LENGTH_LONG).show();
        fermerBD();
    }

    public ArrayList<String> selectionnerHypotheque() {
        openBd();
        //Indiquer les colonnes à récupérer
        String[] cols = {HypothequeDbHelper.COL_ID, HypothequeDbHelper.COL_TAUX_ANNUEL, HypothequeDbHelper.COL_EMPRUNT,
                HypothequeDbHelper.COL_MAP, HypothequeDbHelper.COL_NB_ANNEE };
        Cursor curseur =dbase.query(HypothequeDbHelper.TABLE_P,cols,null, null, null, null, null
                , null);
        curseur.moveToFirst();
        ArrayList<String> listo = new ArrayList<>();
        while(!curseur.isAfterLast()) {
            int id = curseur.getInt(0);
            double tauxAnnuel = curseur.getDouble(1);
            double emprunt = curseur.getDouble(2);
            double Map = curseur.getDouble(3);
            double nbAnnee = curseur.getDouble(4);
            listo.add(id +"-Taux:"+ tauxAnnuel +"-Emprunt:"+ emprunt + "-MAP:" + Map + "-nbAnnee:" + nbAnnee);
            curseur.moveToNext();
        }
        fermerBD();
        return listo;
    }
}
