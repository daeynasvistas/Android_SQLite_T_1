package pt.compartilhar.ipg.android_sqlite_t_1;

        import android.content.Context;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper{ // extend DatabaseHelper para criar a base de dados e tabela

    public static final int VERSION = 1; // basicamente um inteiro para representar a versão
    public static final String NOME_BASEDADOS = "estudante.db"; // Base de dados
    public static final String NOME_TABELA = "Tabela_Estudante"; // Primeira tabela para colocar os estudantes
    public static final String COL_1 = "id"; // usar COL é mais fácil para fazer updates e visualmente
    public static final String COL_2 = "nome";
    public static final String COL_3 = "morada";
    public static final String COL_4 = "telefone";

    public DataBaseHelper(Context context) {   // Contrutor, só preciso do context
        super(context, NOME_BASEDADOS, null, VERSION); // Super construtor! com statics anteriores
        SQLiteDatabase db = this.getWritableDatabase(); // CRIAR, pela primeira vez..
    }


    @Override
    public void onCreate(SQLiteDatabase db) { // criar as tabelas
        db.execSQL ("CREATE TABLE " + NOME_TABELA +" (" +
                COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_2 + " TEXT NOT NULL, " +
                COL_3 + " TEXT NOT NULL, " +
                COL_4 + " INTEGER );");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXIST "+NOME_TABELA); // apaga tabela se existir
        onCreate(db); // verificação

    }
}
