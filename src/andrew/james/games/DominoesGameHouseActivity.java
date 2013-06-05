package andrew.james.games;

import andrew.james.games.dominoes.game.Board;
import andrew.james.games.dominoes.game.Dominoes;
import andrew.james.games.dominoes.game.Position;
import andrew.james.games.dominoes.game.deck.Tile;
import andrew.james.games.dominoes.game.player.Player;
import andrew.james.games.dominoes.game.player.User;
import andrew.james.games.lib.GameProperties;
import android.animation.LayoutTransition;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;

import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.graphics.Rect;

public class DominoesGameHouseActivity extends Activity {
	
	private Bundle extras;
	public Dominoes dominoes;
	private Handler handler;
	private boolean showFlag = false;
	private Rect[] inputArea = new Rect[8];
	private ImageView[] inputHighlight = new ImageView[8];
	private String scoreString;
	private String endOfRoundHeaderText;
	private String endOfRoundScoreText;
	private ImageView[] userTiles = new ImageView[15];
	private ImageView[] bankTiles = new ImageView[8];
	private short newTileSlot = 5;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.game_board);
		
		GameProperties.playState = GameProperties.GAME_STATE_NONE;
		
		Resources res = getResources();
		
		scoreString = res.getString(R.string.playerScoreText);
		endOfRoundHeaderText = res.getString(R.string.endOfRoundDiallogBoxHeaderText);
		endOfRoundScoreText = res.getString(R.string.endOfRoundScoreText);
		
		Board.tileWidth = res.getInteger(R.integer.tileWidth);
		Board.tileHeight = res.getInteger(R.integer.tileHeight);
		Board.boardPositionLeft = res.getInteger(R.integer.boardLeft);
		Board.boardPositionTop =  res.getInteger(R.integer.boardTop);
		Board.boardPositionRight =  res.getInteger(R.integer.boardRight);
		Board.boardPositionBottom = res.getInteger(R.integer.boardBottom);
		
		//Input area's are areas where user can drop tile to add to domino arms
		inputArea[0] = new Rect(res.getInteger(R.integer.northWestLeft), res.getInteger(R.integer.northWestTop), res.getInteger(R.integer.northWestRight), res.getInteger(R.integer.northWestBottom));
		inputArea[1] = new Rect(res.getInteger(R.integer.northLeft), res.getInteger(R.integer.northTop), res.getInteger(R.integer.northRight), res.getInteger(R.integer.northBottom));
		inputArea[2] = new Rect(res.getInteger(R.integer.northEastLeft), res.getInteger(R.integer.northEastTop), res.getInteger(R.integer.northEastRight), res.getInteger(R.integer.northEastBottom));
		inputArea[3] = new Rect(res.getInteger(R.integer.eastLeft), res.getInteger(R.integer.eastTop), res.getInteger(R.integer.eastRight), res.getInteger(R.integer.eastBottom));
		inputArea[4] = new Rect(res.getInteger(R.integer.southEastLeft), res.getInteger(R.integer.southEastTop), res.getInteger(R.integer.southEastRight), res.getInteger(R.integer.southEastBottom));
		inputArea[5] = new Rect(res.getInteger(R.integer.southLeft), res.getInteger(R.integer.southTop), res.getInteger(R.integer.southRight), res.getInteger(R.integer.southBottom));
		inputArea[6] = new Rect(res.getInteger(R.integer.southWestLeft), res.getInteger(R.integer.southWestTop), res.getInteger(R.integer.southWestRight), res.getInteger(R.integer.southWestBottom));
		inputArea[7] = new Rect(res.getInteger(R.integer.westLeft), res.getInteger(R.integer.westTop), res.getInteger(R.integer.westRight), res.getInteger(R.integer.westBottom));
		
		inputHighlight[0] = (ImageView) findViewById(R.id.nwHighlight);
		inputHighlight[1] = (ImageView) findViewById(R.id.nHighlight);
		inputHighlight[2] = (ImageView) findViewById(R.id.neHighlight);
		inputHighlight[3] = (ImageView) findViewById(R.id.eHighlight);
		inputHighlight[4] = (ImageView) findViewById(R.id.seHighlight);
		inputHighlight[5] = (ImageView) findViewById(R.id.sHighlight);
		inputHighlight[6] = (ImageView) findViewById(R.id.swHighlight);
		inputHighlight[7] = (ImageView) findViewById(R.id.wHighlight);
		
		this.userTiles[0] = (ImageView) findViewById(R.id.tile1);
		this.userTiles[1] = (ImageView) findViewById(R.id.tile2);
		this.userTiles[2] = (ImageView) findViewById(R.id.tile3);
		this.userTiles[3] = (ImageView) findViewById(R.id.tile4);
		this.userTiles[4] = (ImageView) findViewById(R.id.tile5);
		this.userTiles[5] = (ImageView) findViewById(R.id.tile6);
		this.userTiles[6] = (ImageView) findViewById(R.id.tile7);
		this.userTiles[7] = (ImageView) findViewById(R.id.tile8);
		this.userTiles[8] = (ImageView) findViewById(R.id.tile9);
		this.userTiles[9] = (ImageView) findViewById(R.id.tile10);
		this.userTiles[10] = (ImageView) findViewById(R.id.tile11);
		this.userTiles[11] = (ImageView) findViewById(R.id.tile12);
		this.userTiles[12] = (ImageView) findViewById(R.id.tile13);
		
		
		this.bankTiles[0] = (ImageView) findViewById(R.id.bank1);
		this.bankTiles[0].setVisibility(View.VISIBLE);
		this.bankTiles[1] = (ImageView) findViewById(R.id.bank2);
		this.bankTiles[1].setVisibility(View.VISIBLE);
		this.bankTiles[2] = (ImageView) findViewById(R.id.bank3);
		this.bankTiles[2].setVisibility(View.VISIBLE);
		this.bankTiles[3] = (ImageView) findViewById(R.id.bank4);
		this.bankTiles[3].setVisibility(View.VISIBLE);
		this.bankTiles[4] = (ImageView) findViewById(R.id.bank5);
		this.bankTiles[4].setVisibility(View.VISIBLE);
		this.bankTiles[5] = (ImageView) findViewById(R.id.bank6);
		this.bankTiles[5].setVisibility(View.VISIBLE);
		this.bankTiles[6] = (ImageView) findViewById(R.id.bank7);
		this.bankTiles[6].setVisibility(View.VISIBLE);
		this.bankTiles[7] = (ImageView) findViewById(R.id.bank8);
		this.bankTiles[7].setVisibility(View.VISIBLE);

		
		
		
		extras = getIntent().getExtras();
		
		if(extras != null)
		this.dominoes = new Dominoes(extras.getInt(andrew.james.games.lib.GameProperties.GAME_TYPE_KEY),
				extras.getInt(andrew.james.games.lib.GameProperties.CHARACTER_KEY),
				extras.getInt(andrew.james.games.lib.GameProperties.LEVEL_KEY),
				extras.getInt(andrew.james.games.lib.GameProperties.ROUNDS_KEY));
		
		short[] pScore = new short[4];
		
		pScore[0] = (short) extras.getInt(andrew.james.games.lib.GameProperties.CHAR_1_SCORE_KEY);
		pScore[1] = (short) extras.getInt(andrew.james.games.lib.GameProperties.CHAR_2_SCORE_KEY);
		pScore[2] = (short) extras.getInt(andrew.james.games.lib.GameProperties.CHAR_3_SCORE_KEY);
		pScore[3] = (short) extras.getInt(andrew.james.games.lib.GameProperties.CHAR_4_SCORE_KEY);
		
		this.dominoes.initialise(pScore);
		
		ImageView userCharacterImageView = (ImageView) findViewById(R.id.userCharacterIcon);
		userCharacterImageView.setImageResource(this.dominoes.player[this.dominoes.userCharacter].playerIconOffID);
		
		RelativeLayout mainBg = (RelativeLayout) findViewById(R.id.gameBoardParent);
		
		final DrawView dv = new DrawView(this);
		dv.invalidate();
		mainBg.addView(dv);
		
		mainBg.setOnTouchListener(new View.OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent motionEvent) {
				switch(motionEvent.getAction()){
				case MotionEvent.ACTION_MOVE:
					
			        int mx = (int) motionEvent.getX();
			        int my = (int) motionEvent.getY();
			        if(dv.image != null)
			        	dv.image.setBounds(mx, my, (mx + Board.tileWidth), (my + Board.tileHeight));
			        
			        
			        if(inputArea[0].contains((int) motionEvent.getX(), (int) motionEvent.getY())){
			        	if(!inputHighlight[0].isShown())
			        		inputHighlight[0].setVisibility(View.VISIBLE);
					} else {
						if(inputHighlight[0].isShown())
			        		inputHighlight[0].setVisibility(View.INVISIBLE);
					}
			        if(inputArea[1].contains((int) motionEvent.getX(), (int) motionEvent.getY())){
			        	if(!inputHighlight[1].isShown())
			        		inputHighlight[1].setVisibility(View.VISIBLE);
					} else {
						if(inputHighlight[1].isShown())
			        		inputHighlight[1].setVisibility(View.INVISIBLE);
					}
			        if(inputArea[2].contains((int) motionEvent.getX(), (int) motionEvent.getY())){
			        	if(!inputHighlight[2].isShown())
			        		inputHighlight[2].setVisibility(View.VISIBLE);
					} else {
						if(inputHighlight[2].isShown())
			        		inputHighlight[2].setVisibility(View.INVISIBLE);
					}
			        if(inputArea[3].contains((int) motionEvent.getX(), (int) motionEvent.getY())){
			        	if(!inputHighlight[3].isShown())
			        		inputHighlight[3].setVisibility(View.VISIBLE);
					} else {
						if(inputHighlight[3].isShown())
			        		inputHighlight[3].setVisibility(View.INVISIBLE);
					}
			        if(inputArea[4].contains((int) motionEvent.getX(), (int) motionEvent.getY())){
			        	if(!inputHighlight[4].isShown())
			        		inputHighlight[4].setVisibility(View.VISIBLE);
					} else {
						if(inputHighlight[4].isShown())
			        		inputHighlight[4].setVisibility(View.INVISIBLE);
					}
			        if(inputArea[5].contains((int) motionEvent.getX(), (int) motionEvent.getY())){
			        	if(!inputHighlight[5].isShown())
			        		inputHighlight[5].setVisibility(View.VISIBLE);
					} else {
						if(inputHighlight[5].isShown())
			        		inputHighlight[5].setVisibility(View.INVISIBLE);
					}
			        if(inputArea[6].contains((int) motionEvent.getX(), (int) motionEvent.getY())){
			        	if(!inputHighlight[6].isShown())
			        		inputHighlight[6].setVisibility(View.VISIBLE);
					} else {
						if(inputHighlight[6].isShown())
			        		inputHighlight[6].setVisibility(View.INVISIBLE);
					}
			        if(inputArea[7].contains((int) motionEvent.getX(), (int) motionEvent.getY())){
			        	if(!inputHighlight[7].isShown())
			        		inputHighlight[7].setVisibility(View.VISIBLE);
					} else {
						if(inputHighlight[7].isShown())
			        		inputHighlight[7].setVisibility(View.INVISIBLE);
					}

					break;
				case MotionEvent.ACTION_UP:
					dv.image = null;
					//Process user event only if user selects a tile
					if(User.selectedTile != null){
						
						if(inputArea[0].contains((int) motionEvent.getX(), (int) motionEvent.getY())){
							//North West
							//Board.position 1
							if(inputHighlight[0].isShown())
				        		inputHighlight[0].setVisibility(View.INVISIBLE);
							
							if(dominoes.gameBoard.position[1].checkDropArea(inputArea[0], getResources().getInteger(R.integer.northWestLeft), getResources().getInteger(R.integer.northWestTop))){
								dominoes.user.chosenPosition = dominoes.gameBoard.matchTileToPosition((byte) 1, User.selectedTile);
							}
							
						} else if(inputArea[1].contains((int) motionEvent.getX(), (int) motionEvent.getY())){
							//North
							//Board.position 2
							if(inputHighlight[1].isShown())
				        		inputHighlight[1].setVisibility(View.INVISIBLE);
							
							dominoes.user.chosenPosition = dominoes.gameBoard.matchTileToPosition((byte) 2, User.selectedTile);
							
						} else if(inputArea[2].contains((int) motionEvent.getX(), (int) motionEvent.getY())){
							//North East
							//Board.position 2
							if(inputHighlight[2].isShown())
				        		inputHighlight[2].setVisibility(View.INVISIBLE);
							
							if(dominoes.gameBoard.position[2].checkDropArea(inputArea[2], getResources().getInteger(R.integer.northWestLeft), getResources().getInteger(R.integer.northWestTop))){
								dominoes.user.chosenPosition = dominoes.gameBoard.matchTileToPosition((byte) 2, User.selectedTile);
							}
						} else if(inputArea[3].contains((int) motionEvent.getX(), (int) motionEvent.getY())){
							//East
							//Board.position 0
							if(inputHighlight[3].isShown())
				        		inputHighlight[3].setVisibility(View.INVISIBLE);
							
							dominoes.user.chosenPosition = dominoes.gameBoard.matchTileToPosition((byte) 0, User.selectedTile);
							
						} else if(inputArea[4].contains((int) motionEvent.getX(), (int) motionEvent.getY())){
							//South East
							//Board.position 0
							if(inputHighlight[4].isShown())
				        		inputHighlight[4].setVisibility(View.INVISIBLE);
							
							if(dominoes.gameBoard.position[0].checkDropArea(inputArea[4], getResources().getInteger(R.integer.northWestLeft), getResources().getInteger(R.integer.northWestTop))){
								dominoes.user.chosenPosition = dominoes.gameBoard.matchTileToPosition((byte) 0, User.selectedTile);
							}
						} else if(inputArea[5].contains((int) motionEvent.getX(), (int) motionEvent.getY())){
							//South
							//Board.position 3
							if(inputHighlight[5].isShown())
				        		inputHighlight[5].setVisibility(View.INVISIBLE);
							
							dominoes.user.chosenPosition = dominoes.gameBoard.matchTileToPosition((byte) 3, User.selectedTile);
							
						} else if(inputArea[6].contains((int) motionEvent.getX(), (int) motionEvent.getY())){
							//South West
							//Board.position 3
							if(inputHighlight[6].isShown())
				        		inputHighlight[6].setVisibility(View.INVISIBLE);
							
							if(dominoes.gameBoard.position[3].checkDropArea(inputArea[6], getResources().getInteger(R.integer.northWestLeft), getResources().getInteger(R.integer.northWestTop))){
								dominoes.user.chosenPosition = dominoes.gameBoard.matchTileToPosition((byte) 3, User.selectedTile);
							}
							
						} else if(inputArea[7].contains((int) motionEvent.getX(), (int) motionEvent.getY())){
							//West
							//Board.position 1
							if(inputHighlight[7].isShown())
				        		inputHighlight[7].setVisibility(View.INVISIBLE);
							
							dominoes.user.chosenPosition = dominoes.gameBoard.matchTileToPosition((byte) 1, User.selectedTile);
							
						} 
						
						GameProperties.playState = GameProperties.PLAY_STATE_USER;
						
						dominoes.playGame();
						
			 			if(Dominoes.currentTile != null){
				 			RelativeLayout mLayout = (RelativeLayout) findViewById(R.id.playarea);
				 			mLayout.addView(placeTile(getBaseContext(), Dominoes.currentTile));
				 			dominoes.user.removeUserTileResourceID(Dominoes.currentTile.tileResource);
				 			dominoes.user.chosenPosition = -1;
			 			} else {
							// Return selected tile to users hand
		 					((ImageView) findViewById(dominoes.user.getUserTileResourceID(User.selectedTile))).setVisibility(View.VISIBLE);
		 					dominoes.user.chosenPosition = -1;
			 			}
			 			
			 			if(( dominoes.player[dominoes.userCharacter].hand.size() > 0) && (Dominoes.missedRounds <= GameProperties.NO_OF_PLAYERS)){
			 				//do this check because user may have dropped tile in incorrect position. Wait till user selects correct position to place tile
			 				if(!dominoes.user.canMove){
					 			User.selectedTile = null;
					 			
					 			if(dominoes.player[dominoes.userCharacter].score(dominoes.gameBoard.getBoardResult())){
									GameProperties.playState = GameProperties.PLAY_STATE_SCORE;
									
									//show pop up as quickly as possible
									handler.postDelayed(runGameTask, 100);
								} else {
									Dominoes.incrementPlayerCounter();
				 					GameProperties.playState = GameProperties.PLAY_STATE_PLAY;
				 					
				 					handler.postDelayed(runGameTask, 1000);
								}
			 				}
		 				} else if((Dominoes.missedRounds == GameProperties.NO_OF_PLAYERS) || ( dominoes.player[dominoes.userCharacter].hand.size() == 0)) {
		 					
		 					//end of round
	 						GameProperties.roundsCounter++;
	 						
		 					if(dominoes.player[dominoes.userCharacter].score(dominoes.gameBoard.getBoardResult())){
								//score popup
								GameProperties.playState = GameProperties.PLAY_STATE_SCORE;
							} else {
								GameProperties.playState = GameProperties.GAME_STATE_NONE;
							}
							
		 					GameProperties.gameState = GameProperties.ROUND_FINISHED;
		 					dominoes.getBonusPoints();
		 					
		 					handler.postDelayed(runGameTask, 1000);
		 				}
					}
					
					break;
				case MotionEvent.ACTION_DOWN:
					
					break;
			}
			
			dv.invalidate();
			
			return true;

			}
		});

		final ImageView userTile1 = (ImageView) findViewById(R.id.tile1);
		userTile1.setImageResource(this.dominoes.player[this.dominoes.userCharacter].hand.get(0).ID);
		userTile1.setOnTouchListener(new View.OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				switch(event.getAction()){
				case MotionEvent.ACTION_DOWN:
					if(dominoes.user.gameBoardUserSelectableTile[0] != null){
						User.selectedTile = dominoes.user.gameBoardUserSelectableTile[0];
						dv.image = getResources().getDrawable(dominoes.user.gameBoardUserSelectableTile[0].ID);
						userTile1.setVisibility(View.INVISIBLE);
					}
					break;
				}
				return false;
			}
		});
		
		final ImageView userTile2 = (ImageView) findViewById(R.id.tile2);
		userTile2.setImageResource(this.dominoes.player[this.dominoes.userCharacter].hand.get(1).ID);
		userTile2.setOnTouchListener(new View.OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				switch(event.getAction()){
				case MotionEvent.ACTION_DOWN:
					if(dominoes.user.gameBoardUserSelectableTile[1] != null){
						User.selectedTile = dominoes.user.gameBoardUserSelectableTile[1];
						dv.image= getResources().getDrawable(dominoes.user.gameBoardUserSelectableTile[1].ID);
						userTile2.setVisibility(View.INVISIBLE);
					}
					break;
				}
				return false;
			}
		});
		
		final ImageView userTile3 = (ImageView) findViewById(R.id.tile3);
		userTile3.setImageResource(this.dominoes.player[this.dominoes.userCharacter].hand.get(2).ID);
		userTile3.setOnTouchListener(new View.OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				switch(event.getAction()){
				case MotionEvent.ACTION_DOWN:
					if(dominoes.user.gameBoardUserSelectableTile[2] != null){
						User.selectedTile = dominoes.user.gameBoardUserSelectableTile[2];
						dv.image= getResources().getDrawable(dominoes.user.gameBoardUserSelectableTile[2].ID);
						userTile3.setVisibility(View.INVISIBLE);
					}
					break;
				}
				return false;
			}
		});
		
		final ImageView userTile4 = (ImageView) findViewById(R.id.tile4);
		userTile4.setImageResource(this.dominoes.player[this.dominoes.userCharacter].hand.get(3).ID);
		userTile4.setOnTouchListener(new View.OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				switch(event.getAction()){
				case MotionEvent.ACTION_DOWN:
					if(dominoes.user.gameBoardUserSelectableTile[3] != null){
						User.selectedTile = dominoes.user.gameBoardUserSelectableTile[3];
						dv.image= getResources().getDrawable(dominoes.user.gameBoardUserSelectableTile[3].ID);
						userTile4.setVisibility(View.INVISIBLE);
					}
					break;
				}
				return false;
			}
		});
		
		final ImageView userTile5 = (ImageView) findViewById(R.id.tile5);
		userTile5.setImageResource(this.dominoes.player[this.dominoes.userCharacter].hand.get(4).ID);
		userTile5.setOnTouchListener(new View.OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				switch(event.getAction()){
				case MotionEvent.ACTION_DOWN:
					if(dominoes.user.gameBoardUserSelectableTile[4] != null){
						User.selectedTile = dominoes.user.gameBoardUserSelectableTile[4];
						dv.image= getResources().getDrawable(dominoes.user.gameBoardUserSelectableTile[4].ID);
						userTile5.setVisibility(View.INVISIBLE);
					}
					break;
				}
				return false;
			}
		});
		
		final ImageView userTile6 = (ImageView) findViewById(R.id.tile6);
		//userTile6.setImageResource(this.dominoes.player[this.dominoes.userCharacter].hand.get(5).ID);
		userTile6.setOnTouchListener(new View.OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				switch(event.getAction()){
				case MotionEvent.ACTION_DOWN:
					if(dominoes.user.gameBoardUserSelectableTile[5] != null){
						User.selectedTile = dominoes.user.gameBoardUserSelectableTile[5];
						dv.image= getResources().getDrawable(dominoes.user.gameBoardUserSelectableTile[5].ID);
						userTile6.setVisibility(View.INVISIBLE);
					}
					break;
				}
				return false;
			}
		});
		final ImageView userTile7 = (ImageView) findViewById(R.id.tile7);
		//userTile7.setImageResource(this.dominoes.player[this.dominoes.userCharacter].hand.get(6).ID);
		userTile7.setOnTouchListener(new View.OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				switch(event.getAction()){
				case MotionEvent.ACTION_DOWN:
					if(dominoes.user.gameBoardUserSelectableTile[6] != null){
						User.selectedTile = dominoes.user.gameBoardUserSelectableTile[6];
						dv.image= getResources().getDrawable(dominoes.user.gameBoardUserSelectableTile[6].ID);
						userTile7.setVisibility(View.INVISIBLE);
					}
					break;
				}
				return false;
			}
		});
		
		final ImageView userTile8 = (ImageView) findViewById(R.id.tile8);
		
		userTile8.setOnTouchListener(new View.OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				switch(event.getAction()){
				case MotionEvent.ACTION_DOWN:
					if(dominoes.user.gameBoardUserSelectableTile[7] != null){
						User.selectedTile = dominoes.user.gameBoardUserSelectableTile[7];
						dv.image= getResources().getDrawable(dominoes.user.gameBoardUserSelectableTile[7].ID);
						userTile8.setVisibility(View.INVISIBLE);
					}
					break;
				}
				return false;
			}
		});
		
		final ImageView userTile9 = (ImageView) findViewById(R.id.tile9);
		userTile9.setOnTouchListener(new View.OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				switch(event.getAction()){
				case MotionEvent.ACTION_DOWN:
					if(dominoes.user.gameBoardUserSelectableTile[8] != null){
						User.selectedTile = dominoes.user.gameBoardUserSelectableTile[8];
						dv.image= getResources().getDrawable(dominoes.user.gameBoardUserSelectableTile[8].ID);
						userTile9.setVisibility(View.INVISIBLE);
					}
					break;
				}
				return false;
			}
		});
		
		final ImageView userTile10 = (ImageView) findViewById(R.id.tile10);
		userTile10.setOnTouchListener(new View.OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				switch(event.getAction()){
				case MotionEvent.ACTION_DOWN:
					if(dominoes.user.gameBoardUserSelectableTile[9] != null){
						User.selectedTile = dominoes.user.gameBoardUserSelectableTile[9];
						dv.image= getResources().getDrawable(dominoes.user.gameBoardUserSelectableTile[9].ID);
						userTile10.setVisibility(View.INVISIBLE);
					}
					break;
				}
				return false;
			}
		});
		
		final ImageView userTile11 = (ImageView) findViewById(R.id.tile11);
		userTile11.setOnTouchListener(new View.OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				switch(event.getAction()){
				case MotionEvent.ACTION_DOWN:
					if(dominoes.user.gameBoardUserSelectableTile[10] != null){
						User.selectedTile = dominoes.user.gameBoardUserSelectableTile[10];
						dv.image= getResources().getDrawable(dominoes.user.gameBoardUserSelectableTile[10].ID);
						userTile11.setVisibility(View.INVISIBLE);
					}
					break;
				}
				return false;
			}
		});
		
		final ImageView userTile12 = (ImageView) findViewById(R.id.tile12);
		userTile12.setOnTouchListener(new View.OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				switch(event.getAction()){
				case MotionEvent.ACTION_DOWN:
					if(dominoes.user.gameBoardUserSelectableTile[11] != null){
						User.selectedTile = dominoes.user.gameBoardUserSelectableTile[11];
						dv.image= getResources().getDrawable(dominoes.user.gameBoardUserSelectableTile[11].ID);
						userTile12.setVisibility(View.INVISIBLE);
					}
					break;
				}
				return false;
			}
		});
		
		final ImageView userTile13 = (ImageView) findViewById(R.id.tile13);
		userTile13.setOnTouchListener(new View.OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				switch(event.getAction()){
				case MotionEvent.ACTION_DOWN:
					if(dominoes.user.gameBoardUserSelectableTile[12] != null){
						User.selectedTile = dominoes.user.gameBoardUserSelectableTile[12];
						dv.image= getResources().getDrawable(dominoes.user.gameBoardUserSelectableTile[12].ID);
						userTile13.setVisibility(View.INVISIBLE);
					}
					break;
				}
				return false;
			}
		});
		
		final Button menuButton = (Button) findViewById(R.id.menuButtonGame);
		
		menuButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(DominoesGameHouseActivity.this, GalaxyDominoesActivity.class);
				startActivity(i);
				finish();
			}
		});
		
		final Button exitButton = (Button) findViewById(R.id.exitButton);
		
		exitButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
	            System.exit(0);
			}
		});
		
		final Button newRoundOKButton = (Button) findViewById(R.id.newRoundContinuebutton);
		
		newRoundOKButton.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v) {
				
				
				if((GameProperties.playState == GameProperties.PLAY_STATE_NONE) && (GameProperties.gameState == GameProperties.GAME_WON)){
					//Game won, transition to winner activity
					extras.clear();
					extras.putInt(GameProperties.NUMBER_OF_WINNERS, dominoes.getWinner().size());

					byte x = 0;
					for(Player p : dominoes.getWinner()){
						extras.putSerializable(GameProperties.WINNER_KEY + x, p);
						x++;
					}

					Intent i = new Intent(DominoesGameHouseActivity.this, DominoesGameFinishActivity.class);
					i.putExtras(extras);
					startActivity(i);
					finish();
				} else {
					
					extras.putInt(andrew.james.games.lib.GameProperties.CHAR_1_SCORE_KEY, dominoes.player[0].score);
					extras.putInt(andrew.james.games.lib.GameProperties.CHAR_2_SCORE_KEY, dominoes.player[1].score);
					extras.putInt(andrew.james.games.lib.GameProperties.CHAR_3_SCORE_KEY, dominoes.player[2].score);
					extras.putInt(andrew.james.games.lib.GameProperties.CHAR_4_SCORE_KEY, dominoes.player[3].score);

					//Round finished, reload this activity
					finish();
					startActivity(getIntent().putExtras(extras));
				}
			}
		});
		
		//Basic transition animation
		RelativeLayout playArea = (RelativeLayout) findViewById(R.id.playarea);
		LayoutTransition layoutTransition = new LayoutTransition();
		playArea.setLayoutTransition(layoutTransition);
	}
	
	protected void onStart() {
		super.onStart();

		// SLEEP 2 SECONDS HERE ...
	    handler = new Handler(); 
	    handler.postDelayed(runGameTask, 1000); 
	}
	
	private Runnable runGameTask = new Runnable(){

		@Override
		public void run() {
			
 			RelativeLayout mLayout = (RelativeLayout) findViewById(R.id.playarea);
 			ImageView currentPlayerImageView = (ImageView) findViewById(R.id.currentPlayerIcon);
 			currentPlayerImageView.setImageResource(dominoes.player[Dominoes.getPlayerIndex()].playerIconOffID);
 			
 			//For tile positioning
 			if(GameProperties.gameState == GameProperties.GAME_INITIALISE){
 				
	 			ImageView startPosition = (ImageView) findViewById(R.id.startPosition);
	 			GameProperties.startLeft = startPosition.getLeft();
	 			GameProperties.startTop = startPosition.getTop();
 			}

			if(Dominoes.missedRounds >= GameProperties.NO_OF_PLAYERS){
				GameProperties.gameState = GameProperties.ROUND_FINISHED;
			}
 			
 			//Game logic
 			dominoes.playGame();
 			
 			//Display results
 			switch(GameProperties.gameState) {

				case GameProperties.GAME_RUNNING:
					
					switch(GameProperties.playState) {
						case GameProperties.PLAY_STATE_WAIT_USER_INPUT:
							
							if(!dominoes.user.canMove){
								currentPlayerImageView.setImageResource(dominoes.player[Dominoes.getPlayerIndex()].playerIconOnID);
								
								if(dominoes.gameBoard.tileBank.size() == 0){
									Dominoes.incrementPlayerCounter();
									
									GameProperties.playState = GameProperties.PLAY_STATE_PLAY;
								} else {
									//Make added tiles visible
									bankTiles[(dominoes.gameBoard.tileBank.size() -1)].setVisibility(View.INVISIBLE);
									
									dominoes.player[dominoes.userCharacter].hand.add(dominoes.gameBoard.tileBank.get(0));
									
									if(!userTiles[newTileSlot].isShown()){
										dominoes.user.gameBoardUserSelectableTile[DominoesGameHouseActivity.this.newTileSlot] = new Tile(dominoes.gameBoard.tileBank.get(0));
										dominoes.gameBoard.tileBank.remove(0);
										userTiles[newTileSlot].setImageResource(dominoes.player[dominoes.userCharacter].hand.get(dominoes.player[dominoes.userCharacter].hand.size() - 1).ID);
										userTiles[newTileSlot].setVisibility(View.VISIBLE);
									}
									newTileSlot++;

								}
								
					 			handler.postDelayed(runGameTask, 1500);
							}

							break;
						case GameProperties.PLAY_STATE_PLAY:

							if(Dominoes.currentTile != null){
					 			mLayout.addView(placeTile(getBaseContext(), Dominoes.currentTile));
					 			
					 			Dominoes.incrementPlayerCounter();
				 			} else {
				 				currentPlayerImageView.setImageResource(dominoes.player[Dominoes.getPlayerIndex()].playerIconOnID);
				 				
				 				if(dominoes.gameBoard.tileBank.size() == 0){
									Dominoes.incrementPlayerCounter();
								} else {
									DominoesGameHouseActivity.this.bankTiles[(dominoes.gameBoard.tileBank.size() -1)].setVisibility(View.INVISIBLE);
									dominoes.gameBoard.tileBank.remove(0);
								}
				 			}
				 			
				 			handler.postDelayed(runGameTask, 1500);
				 			
							break;
						case GameProperties.PLAY_STATE_SCORE:
							
							TextView scoreDialog = (TextView) findViewById(R.id.gamePlayDialog);
							
							scoreDialog.setText(formatScoreResultString(Dominoes.getPlayerIndex(), dominoes.gameBoard.getBoardResult()));
							
							if(scoreDialog.isShown()){
								
								scoreDialog.setVisibility(View.INVISIBLE);
								
								if(GameProperties.gameState == GameProperties.ROUND_FINISHED)
									GameProperties.playState = GameProperties.GAME_STATE_NONE;
								
								handler.postDelayed(runGameTask, 1000);
							}else{
								
								if(showFlag){
									//Creates a delay after panel has been hidden
									GameProperties.playState = GameProperties.PLAY_STATE_PLAY;
									showFlag = false;

						 			Dominoes.incrementPlayerCounter();
									
									handler.postDelayed(runGameTask, 1000);
								} else {

									if(Dominoes.currentTile != null){
							 			mLayout.addView(placeTile(getBaseContext(), Dominoes.currentTile));
						 			}
						 			showFlag = true;
									scoreDialog.setVisibility(View.VISIBLE);
									scoreDialog.bringToFront();
									handler.postDelayed(runGameTask, 2000);
								}
							}
							
							break;
					}
					
					break;
				case GameProperties.GAME_INITIALISE:
					
					showFlag = false;
					
		 			if(Dominoes.currentTile != null){
						mLayout.addView(placeInitialTile(getBaseContext(), Dominoes.currentTile));
					}
					
					TextView initScoreDialog = (TextView) findViewById(R.id.gamePlayDialog);
					
					if(initScoreDialog.isShown()){
						initScoreDialog.setVisibility(View.INVISIBLE);
					}
					
					Dominoes.incrementPlayerCounter();
					
					GameProperties.gameState = GameProperties.GAME_RUNNING; 
					GameProperties.playState = GameProperties.PLAY_STATE_PLAY;

					handler.postDelayed(runGameTask, 1000);

					break;
				case GameProperties.GAME_INITIALISE_USER:
					
					showFlag = false;

					//start game
					int rId = dominoes.user.getUserTileResourceID(Dominoes.currentTile.tileResource);
					if(rId != -1){
						((ImageView) findViewById(rId)).setVisibility(View.INVISIBLE);
					}
					
		 			mLayout.addView(placeInitialTile(getBaseContext(), Dominoes.currentTile));
					
		 			Dominoes.incrementPlayerCounter();
		 			
					GameProperties.gameState = GameProperties.GAME_RUNNING; 
					GameProperties.playState = GameProperties.PLAY_STATE_PLAY;
		 			
		 			handler.postDelayed(runGameTask, 1000);
		 			
					break;
				case GameProperties.ROUND_FINISHED:
					
					//Still show score board to acknowledge points given
					if(GameProperties.playState == GameProperties.PLAY_STATE_SCORE){
						TextView scoreDialog = (TextView) findViewById(R.id.gamePlayDialog);
						
						scoreDialog.setText(formatScoreResultString(Dominoes.getPlayerIndex(), dominoes.gameBoard.getBoardResult()));
						
						if(scoreDialog.isShown()){

							scoreDialog.setVisibility(View.INVISIBLE);

							GameProperties.playState = GameProperties.GAME_STATE_NONE;
							
							handler.postDelayed(runGameTask, 500);
						}else{
							
							if(Dominoes.currentTile != null){
					 			mLayout.addView(placeTile(getBaseContext(), Dominoes.currentTile));
					 			
					 			Dominoes.currentTile = null;
				 			}

							scoreDialog.setVisibility(View.VISIBLE);
							scoreDialog.bringToFront();
							handler.postDelayed(runGameTask, 2000);
						}

					} else if(GameProperties.playState == GameProperties.PLAY_STATE_NONE){
						//Show the end of round board
						if(Dominoes.currentTile != null){
				 			mLayout.addView(placeTile(getBaseContext(), Dominoes.currentTile));
				 			
				 			Dominoes.currentTile = null;
			 			}
						
						ImageView winnerIconView = (ImageView) findViewById(R.id.winnerIcon);
						winnerIconView.setImageResource(dominoes.player[Dominoes.getPlayerIndex()].playerIconLrgOnID);
						
						TextView endOfRoundDialogHeaderText = (TextView) findViewById(R.id.newRoundDialogHeaderText);
						endOfRoundDialogHeaderText.setText(formatEndOfRoundDialogBoxHeaderText(Dominoes.getPlayerIndex()));
						
						TextView endOfRoundDialogText = (TextView) findViewById(R.id.newRoundDialogText);
						endOfRoundDialogText.setText(formatEndOfRoundDialogBoxText());
						
						RelativeLayout roundFinishedLayout = (RelativeLayout) findViewById(R.id.newRoundDialogLayout);
						
						if(!roundFinishedLayout.isShown())
							roundFinishedLayout.setVisibility(View.VISIBLE);
						
						roundFinishedLayout.bringToFront();
						
						if((GameProperties.roundsCounter >= dominoes.rounds) || (dominoes.rounds == 1)){
							GameProperties.gameState = GameProperties.GAME_WON; 
							GameProperties.playState = GameProperties.PLAY_STATE_NONE;
						} else {
							GameProperties.roundsCounter++;
						}
						
					}

					break;
 			}
		}
	};
    
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
    
    protected ImageView placeInitialTile(Context context, Position p){
    	ImageView newTile = new ImageView(context);
    	
    	newTile.setBackgroundResource(p.tileResource.ID);
    	
    	RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(27, 52);
    	
    	params.addRule(RelativeLayout.CENTER_HORIZONTAL);
    	params.addRule(RelativeLayout.CENTER_VERTICAL);
    	
    	newTile.setLayoutParams(params);
    	
    	return newTile;
    }
    
    protected ImageView placeTile(Context context, Position p){
    	
    	ImageView newTile = new ImageView(context);
    	RelativeLayout.LayoutParams params;

    	switch(p.dir){
		case 'e':
			
			newTile.setBackgroundResource(p.tileResource.ID);
	    	newTile.setAdjustViewBounds(true);

	    	params = new RelativeLayout.LayoutParams(Board.tileHeight, Board.tileWidth);

	    	params.leftMargin = p.left;
	    	params.topMargin = p.top;

	    	newTile.setLayoutParams(params);
			
			break;
		case 'w':
			
			newTile.setBackgroundResource(p.tileResource.ID);
	    	newTile.setAdjustViewBounds(true);

	    	params = new RelativeLayout.LayoutParams(Board.tileHeight, Board.tileWidth);

	    	params.leftMargin = p.left;
	    	params.topMargin = p.top;

	    	newTile.setLayoutParams(params);
			
			break;
		case 'n':
			
			newTile.setBackgroundResource(p.tileResource.ID);
	    	newTile.setAdjustViewBounds(true);

	    	params = new RelativeLayout.LayoutParams(Board.tileWidth, Board.tileHeight);

	    	params.leftMargin = p.left;
	    	params.topMargin = p.top;

	    	newTile.setLayoutParams(params);
			
			break;
		case 's':
			
			newTile.setBackgroundResource(p.tileResource.ID);
	    	newTile.setAdjustViewBounds(true);

	    	params = new RelativeLayout.LayoutParams(Board.tileWidth, Board.tileHeight);

	    	params.leftMargin = p.left;
	    	params.topMargin = p.top;

	    	newTile.setLayoutParams(params);

			break;
		}
    	
    	return newTile;
    }
    
    public String formatScoreResultString(int pNum, int score){
    	String formattedString = scoreString;
    	
    	formattedString = formattedString.replace("{pNum}", Integer.toString(pNum + 1));
    	formattedString = formattedString.replace("{score}", Integer.toString(score));
    	
    	return formattedString;
    }
    
    public String formatEndOfRoundDialogBoxHeaderText(int pNum){
    	
    	String formattedString = endOfRoundHeaderText.replace("{pNum}", Integer.toString(pNum + 1));
    	
    	return formattedString;
    }
    
    public String formatEndOfRoundDialogBoxText(){
    	
    	String formattedString = "";
    	
    	for(byte i = 0; i < dominoes.player.length; i++){
    		formattedString += endOfRoundScoreText.replace("{pNum}", Integer.toString(i + 1));
    		formattedString = formattedString.replace("{score}", Integer.toString(dominoes.player[i].score)) + "\n";
    	}
    	
    	return formattedString;
    }
}


