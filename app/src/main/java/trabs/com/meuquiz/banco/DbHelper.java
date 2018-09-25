package trabs.com.meuquiz.banco;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Crud.db";
    private static final int DATABASE_VERSION = 1;
    private final String CREATE_TABLE_QUESTAO = "CREATE TABLE Questao (ID INTEGER PRIMARY KEY," +
            " PERGUNTA TEXT NOT NULL);";
    private final String CREATE_TABLE_RESPOSTA = "CREATE TABLE Resposta (ID INTEGER PRIMARY KEY AUTOINCREMENT," +
            " IDQUESTAO INTEGER NOT NULL, RESPOSTA TEXT NOT NULL, RESPOSTACERTA INTEGER NOT NULL);";

    public DbHelper(Context context) {
        super(context,DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_QUESTAO);
        db.execSQL(CREATE_TABLE_RESPOSTA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
