package andrew.james.games;

import andrew.james.games.lib.GameProperties;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DomioesGameMenuActivity extends Activity {
	
	private Bundle extras;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.game_menu);
		/*
		 * Maybe it does not work on layouts?
		RelativeLayout rl = (RelativeLayout) findViewById(R.id.gamemenucontainer);
		Animation fadeInAnimation = AnimationUtils.loadAnimation(GameMenuActivity.this, R.anim.gamemenuanimation);
		rl.startAnimation(fadeInAnimation);
		*/
		extras = getIntent().getExtras();
		
		GameProperties.roundsCounter = 1;
		
		final Button ch1Button = (Button) findViewById(R.id.ch1_button);
		final Button ch2Button = (Button) findViewById(R.id.ch2_button);
		final Button ch3Button = (Button) findViewById(R.id.ch3_button);
		final Button ch4Button = (Button) findViewById(R.id.ch4_button);
		final Button levelEasyButton = (Button) findViewById(R.id.leveleasybutton);
		final Button levelMediumButton = (Button) findViewById(R.id.levelmediumbutton);
		final Button levelHardButton = (Button) findViewById(R.id.levelhardbutton);
		final Button roundsOneButton = (Button) findViewById(R.id.roundsonebutton);
		final Button roundsThreeButton = (Button) findViewById(R.id.roundsthreebutton);
		final Button roundsFiveButton = (Button) findViewById(R.id.roundsfivebutton);
		
		levelEasyButton.setEnabled(false);
		levelMediumButton.setEnabled(false);
		levelHardButton.setEnabled(false);
		roundsOneButton.setEnabled(false);
		roundsThreeButton.setEnabled(false);
		roundsFiveButton.setEnabled(false);
		
		ch1Button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ch1Button.setFocusable(false);
				ch2Button.setFocusable(false);
				ch3Button.setFocusable(false);
				ch4Button.setFocusable(false);
				
				levelEasyButton.setFocusable(true);
				levelMediumButton.setFocusable(true);
				levelHardButton.setFocusable(true);

				ch1Button.setEnabled(false);
				ch2Button.setEnabled(false);
				ch3Button.setEnabled(false);
				ch4Button.setEnabled(false);
				
				levelEasyButton.setEnabled(true);
				levelMediumButton.setEnabled(true);
				levelHardButton.setEnabled(true);
				
				ch1Button.setBackgroundResource(R.drawable.ch1_on);
				
				extras.putInt(andrew.james.games.lib.GameProperties.CHARACTER_KEY, andrew.james.games.lib.GameProperties.CHARACTER_1);
			}
		});
		
		ch2Button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ch1Button.setFocusable(false);
				ch2Button.setFocusable(false);
				ch3Button.setFocusable(false);
				ch4Button.setFocusable(false);
				
				levelEasyButton.setFocusable(true);
				levelMediumButton.setFocusable(true);
				levelHardButton.setFocusable(true);

				ch1Button.setEnabled(false);
				ch2Button.setEnabled(false);
				ch3Button.setEnabled(false);
				ch4Button.setEnabled(false);
				
				levelEasyButton.setEnabled(true);
				levelMediumButton.setEnabled(true);
				levelHardButton.setEnabled(true);
				
				ch2Button.setBackgroundResource(R.drawable.ch2_on);
				
				extras.putInt(andrew.james.games.lib.GameProperties.CHARACTER_KEY, andrew.james.games.lib.GameProperties.CHARACTER_2);
			}
		});
		
		
		ch3Button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ch1Button.setFocusable(false);
				ch2Button.setFocusable(false);
				ch3Button.setFocusable(false);
				ch4Button.setFocusable(false);
				
				levelEasyButton.setFocusable(true);
				levelMediumButton.setFocusable(true);
				levelHardButton.setFocusable(true);
				
				ch1Button.setEnabled(false);
				ch2Button.setEnabled(false);
				ch3Button.setEnabled(false);
				ch4Button.setEnabled(false);
				
				levelEasyButton.setEnabled(true);
				levelMediumButton.setEnabled(true);
				levelHardButton.setEnabled(true);
				
				ch3Button.setBackgroundResource(R.drawable.ch3_on);
				
				extras.putInt(andrew.james.games.lib.GameProperties.CHARACTER_KEY, andrew.james.games.lib.GameProperties.CHARACTER_3);
			}
		});
		
		
		ch4Button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ch1Button.setFocusable(false);
				ch2Button.setFocusable(false);
				ch3Button.setFocusable(false);
				ch4Button.setFocusable(false);
				
				levelEasyButton.setFocusable(true);
				levelMediumButton.setFocusable(true);
				levelHardButton.setFocusable(true);
				
				ch1Button.setEnabled(false);
				ch2Button.setEnabled(false);
				ch3Button.setEnabled(false);
				ch4Button.setEnabled(false);
				
				levelEasyButton.setEnabled(true);
				levelMediumButton.setEnabled(true);
				levelHardButton.setEnabled(true);
				
				ch4Button.setBackgroundResource(R.drawable.ch4_on);
				
				extras.putInt(andrew.james.games.lib.GameProperties.CHARACTER_KEY, andrew.james.games.lib.GameProperties.CHARACTER_4);
			}
		});
		
		levelEasyButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				levelEasyButton.setFocusable(false);
				levelMediumButton.setFocusable(false);
				levelHardButton.setFocusable(false);
				
				roundsOneButton.setFocusable(true);
				roundsThreeButton.setFocusable(true);
				roundsFiveButton.setFocusable(true);
				
				levelEasyButton.setEnabled(false);
				levelMediumButton.setEnabled(false);
				levelHardButton.setEnabled(false);
				
				roundsOneButton.setEnabled(true);
				roundsThreeButton.setEnabled(true);
				roundsFiveButton.setEnabled(true);
				
				levelEasyButton.setBackgroundResource(R.drawable.level_1on);
				
				extras.putInt(andrew.james.games.lib.GameProperties.LEVEL_KEY, andrew.james.games.lib.GameProperties.LEVEL_EASY);
			}
		});
		
		levelMediumButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				levelEasyButton.setFocusable(false);
				levelMediumButton.setFocusable(false);
				levelHardButton.setFocusable(false);

				roundsOneButton.setFocusable(true);
				roundsThreeButton.setFocusable(true);
				roundsFiveButton.setFocusable(true);
				
				levelEasyButton.setEnabled(false);
				levelMediumButton.setEnabled(false);
				levelHardButton.setEnabled(false);
				
				roundsOneButton.setEnabled(true);
				roundsThreeButton.setEnabled(true);
				roundsFiveButton.setEnabled(true);

				levelMediumButton.setBackgroundResource(R.drawable.level_2on);
				
				extras.putInt(andrew.james.games.lib.GameProperties.LEVEL_KEY, andrew.james.games.lib.GameProperties.LEVEL_MEDIUM);
			}
		});
		
		levelHardButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				levelEasyButton.setFocusable(false);
				levelMediumButton.setFocusable(false);
				levelHardButton.setFocusable(false);

				roundsOneButton.setFocusable(true);
				roundsThreeButton.setFocusable(true);
				roundsFiveButton.setFocusable(true);
				
				levelEasyButton.setEnabled(false);
				levelMediumButton.setEnabled(false);
				levelHardButton.setEnabled(false);
				
				roundsOneButton.setEnabled(true);
				roundsThreeButton.setEnabled(true);
				roundsFiveButton.setEnabled(true);

				levelHardButton.setBackgroundResource(R.drawable.level_3on);
				
				extras.putInt(andrew.james.games.lib.GameProperties.LEVEL_KEY, andrew.james.games.lib.GameProperties.LEVEL_HARD);
			}
		});
		
		roundsOneButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {

				extras.putInt(andrew.james.games.lib.GameProperties.ROUNDS_KEY, andrew.james.games.lib.GameProperties.ROUNDS_ONE);
				extras.putInt(andrew.james.games.lib.GameProperties.CHAR_1_SCORE_KEY, 0);
				extras.putInt(andrew.james.games.lib.GameProperties.CHAR_2_SCORE_KEY, 0);
				extras.putInt(andrew.james.games.lib.GameProperties.CHAR_3_SCORE_KEY, 0);
				extras.putInt(andrew.james.games.lib.GameProperties.CHAR_4_SCORE_KEY, 0);
				

				
				switch(extras.getInt(GameProperties.GAME_TYPE_KEY)){
					case GameProperties.GAME_TYPE_BLOCK:
						Intent intentGameBlock = new Intent(DomioesGameMenuActivity.this, DominoesGameBlockActivity.class);
						intentGameBlock.putExtras(extras);
						startActivity(intentGameBlock);
						finish();
						break;
					case GameProperties.GAME_TYPE_HOUSE:
						Intent intentGameHouse = new Intent(DomioesGameMenuActivity.this, DominoesGameHouseActivity.class);
						intentGameHouse.putExtras(extras);
						startActivity(intentGameHouse);
						finish();
						break;
				}
			}
		});
		
		roundsThreeButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {

				extras.putInt(andrew.james.games.lib.GameProperties.ROUNDS_KEY, andrew.james.games.lib.GameProperties.ROUNDS_THREE);
				extras.putInt(andrew.james.games.lib.GameProperties.CHAR_1_SCORE_KEY, 0);
				extras.putInt(andrew.james.games.lib.GameProperties.CHAR_2_SCORE_KEY, 0);
				extras.putInt(andrew.james.games.lib.GameProperties.CHAR_3_SCORE_KEY, 0);
				extras.putInt(andrew.james.games.lib.GameProperties.CHAR_4_SCORE_KEY, 0);
				
				switch(extras.getInt(GameProperties.GAME_TYPE_KEY)){
				case GameProperties.GAME_TYPE_BLOCK:
					Intent intentGameBlock = new Intent(DomioesGameMenuActivity.this, DominoesGameBlockActivity.class);
					intentGameBlock.putExtras(extras);
					startActivity(intentGameBlock);
					finish();
					break;
				case GameProperties.GAME_TYPE_HOUSE:
					Intent intentGameHouse = new Intent(DomioesGameMenuActivity.this, DominoesGameHouseActivity.class);
					intentGameHouse.putExtras(extras);
					startActivity(intentGameHouse);
					finish();
					break;
				}
				
			}
		});
		
		roundsFiveButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {

				extras.putInt(andrew.james.games.lib.GameProperties.ROUNDS_KEY, andrew.james.games.lib.GameProperties.ROUNDS_FIVE);
				extras.putInt(andrew.james.games.lib.GameProperties.CHAR_1_SCORE_KEY, 0);
				extras.putInt(andrew.james.games.lib.GameProperties.CHAR_2_SCORE_KEY, 0);
				extras.putInt(andrew.james.games.lib.GameProperties.CHAR_3_SCORE_KEY, 0);
				extras.putInt(andrew.james.games.lib.GameProperties.CHAR_4_SCORE_KEY, 0);
				switch(extras.getInt(GameProperties.GAME_TYPE_KEY)){
				case GameProperties.GAME_TYPE_BLOCK:
					Intent intentGameBlock = new Intent(DomioesGameMenuActivity.this, DominoesGameBlockActivity.class);
					intentGameBlock.putExtras(extras);
					startActivity(intentGameBlock);
					finish();
					break;
				case GameProperties.GAME_TYPE_HOUSE:
					Intent intentGameHouse = new Intent(DomioesGameMenuActivity.this, DominoesGameHouseActivity.class);
					intentGameHouse.putExtras(extras);
					startActivity(intentGameHouse);
					finish();
					break;
				}
				
			}
		});
		
		final Button exitButton = (Button) findViewById(R.id.exitButton);
		
		exitButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
	            System.exit(0);
			}
		});
	}
}
