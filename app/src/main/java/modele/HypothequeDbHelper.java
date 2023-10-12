package modele;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class HypothequeDbHelper extends SQLiteOpenHelper {

    public static final String BD_NAME = "A17Final";
    public static final int VERSION = 1;
    public static final String TABLE_P = "Hypotheque";
    public static final String COL_ID = "_id";
    public static final String COL_TAUX_ANNUEL = "tauxAnnuel";
    public static final String COL_EMPRUNT = "emprunt";
    public static final String COL_MAP = "map";
    public static final String COL_NB_ANNEE = "nbAnnee";

    public static final String DDL_HYPOTHEQUE = "create table "+TABLE_P+"("+ COL_ID+"" +
            " integer primary key autoincrement, "+COL_TAUX_ANNUEL+" REAL, "+COL_EMPRUNT+" REAL, "
            +COL_MAP+" REAL, "+COL_NB_ANNEE+" REAL)";
    public HypothequeDbHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(DDL_HYPOTHEQUE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
