package andrew.james.games;

import andrew.james.games.dominoes.game.Dominoes;
import andrew.james.games.dominoes.game.player.Player;
import andrew.james.games.lib.GameProperties;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GalaxyDominoesActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        final Button blockButton = (Button) findViewById(R.id.blockbutton);
        
        blockButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//Toast.makeText(DominoesActivity.this, "Block Button Clicked", Toast.LENGTH_SHORT);
				Intent i = new Intent(GalaxyDominoesActivity.this, DomioesGameMenuActivity.class);
				i.putExtra(GameProperties.GAME_TYPE_KEY, GameProperties.GAME_TYPE_BLOCK);
				startActivity(i);
				finish();
			}
		});
        
        final Button houseButton = (Button) findViewById(R.id.housebutton);
        
        houseButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(GalaxyDominoesActivity.this, DomioesGameMenuActivity.class);
				i.putExtra(GameProperties.GAME_TYPE_KEY, GameProperties.GAME_TYPE_HOUSE);
				startActivity(i);
				finish();
			}
		});
		
    }
}