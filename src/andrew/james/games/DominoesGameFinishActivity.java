package andrew.james.games;

import andrew.james.games.database.DatabaseHelper;
import andrew.james.games.database.LazyCursorAdapter;
import andrew.james.games.dominoes.game.player.Player;
import andrew.james.games.lib.GameProperties;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class DominoesGameFinishActivity extends Activity {
	
	private Bundle extras;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.game_finish);
		
		extras = getIntent().getExtras();
		
		
		int noOfWinners = extras.getInt(GameProperties.NUMBER_OF_WINNERS);
		
		//Get DB Helper
		DatabaseHelper rDBHelper = new DatabaseHelper(getBaseContext());
        
		
        for(byte i = 0; i < noOfWinners; i++){
        	//Get winner details
          	Player winner = (Player)extras.getSerializable(GameProperties.WINNER_KEY + i);
          		
            //insert results of winner into database
    		if(winner != null){
    			ContentValues values = new ContentValues();
    			
    			values.put(DatabaseHelper.COLUMN_NAME_ICON, winner.playerIconLrgOnID);
    			values.put(DatabaseHelper.COLUMN_NAME_PLAYER_NAME, "Player " + winner.playerNum);
    			values.put(DatabaseHelper.COLUMN_NAME_SCORE, winner.score);
    			
    	        SQLiteDatabase resultsWritableDatabase = rDBHelper.getWritableDatabase();
    	        
    	        resultsWritableDatabase.insert(DatabaseHelper.TABLE_NAME, null, values);
    		}
        }
        
        //read results
        SQLiteDatabase resultsReadableDatabase = rDBHelper.getReadableDatabase();
        Cursor c = resultsReadableDatabase.query(DatabaseHelper.TABLE_NAME, DatabaseHelper.PROJECTION, DatabaseHelper.SELECTION, null, null, null, DatabaseHelper.SORTORDER, DatabaseHelper.LIMIT);
        
        ListView listView = (ListView) findViewById(R.id.winnerListView);
        
        //Custom cursor adapter to format results in row
        LazyCursorAdapter lazyAdapter = new LazyCursorAdapter(getBaseContext(), c);
        listView.setAdapter(lazyAdapter);

        
        
        
		final Button finishMenuButton = (Button) findViewById(R.id.finishMenuButton);
		
		finishMenuButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(DominoesGameFinishActivity.this, GalaxyDominoesActivity.class);
				startActivity(i);
				finish();
			}
		});
		
		final Button finishExitButton = (Button) findViewById(R.id.finishExitButton);
		
		finishExitButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
	            System.exit(0);
			}
		});
	}
	
	protected void onStart() {
		super.onStart();
	}
	
    protected void onRestart() {
    	super.onRestart();
	}

    protected void onResume() {
    	super.onResume();
	}

    protected void onPause() {
    	super.onPause();
	}

    protected void onStop() {
    	super.onStop();
	}

    protected void onDestroy() {
    	super.onDestroy();
    	this.finish();
	}


}
