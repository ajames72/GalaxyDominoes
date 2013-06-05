package andrew.james.games.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;

public class DatabaseHelper extends SQLiteOpenHelper {

	/**
     * The database that the provider uses as its underlying data store
     */
    private static final String DATABASE_NAME = "anddom_results.db";
    /**
     * The database version
     */
    private static final int DATABASE_VERSION = 1;
    /**
     * The table name offered by this provider
     */
    public static final String TABLE_NAME = "result";
    /**
     * URI to provider (AUTHORITY) and table
     */
	public static String AUTHORITY = "andrew.james.games.ResultsDatabase";
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" + TABLE_NAME);
    
    /**
     * Column headers
     */
    public static final String COLUMN_NAME_POSITION = "_id";
    public static final String COLUMN_NAME_ICON = "icon";
    public static final String COLUMN_NAME_PLAYER_NAME = "playername";
    public static final String COLUMN_NAME_SCORE = "score";
    
    /**
     * Query string
     */
    private static final String DICTIONARY_TABLE_CREATE = "CREATE TABLE " + TABLE_NAME + " ("
            + COLUMN_NAME_POSITION + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_NAME_ICON + " INTEGER NOT NULL,"
            + COLUMN_NAME_PLAYER_NAME + " TEXT NOT NULL,"
            + COLUMN_NAME_SCORE + " INTEGER NOT NULL"
            + ");";
    
    /**
     * array of columns that should be included for each row retrieved
     */
    public static final String[] PROJECTION = new String[] {
    	COLUMN_NAME_POSITION,
    	COLUMN_NAME_ICON,
    	COLUMN_NAME_PLAYER_NAME,
    	COLUMN_NAME_SCORE
    };
    
    public static final String SELECTION = null;
    //Order in descending values
    public static final String SORTORDER = COLUMN_NAME_SCORE + " DESC";;
    
    public static final String LIMIT = "10";
    
    public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	public DatabaseHelper(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(DICTIONARY_TABLE_CREATE);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
    
    
    

}
