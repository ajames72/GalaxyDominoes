package andrew.james.games.dominoes.game;

import java.util.ArrayList;
import andrew.james.games.dominoes.game.deck.Tile;
import andrew.james.games.dominoes.game.player.Player;
import android.util.Log;

public class GameAI {
	
	/**
	 * 
	 * @param board
	 * @param hand
	 * @return
	 */
	public static byte[] simpleMove(Board board, ArrayList<Tile> hand){
		byte[] index = {0, -1};
		
		Tile t = new Tile(hand.get(0));
		
		while((index[1] == -1) && (index[0] < hand.size())){
			t = new Tile(hand.get(index[0]));
			index[1] = board.matchTileToPosition(t);
			index[0]++;
		}
		//decrement to compensate for last increment
		index[0]--;
		
		return index;
	}
	/**
	 * 
	 * @param board the dominoes game board
	 * @param hand the tiles in the player hand
	 * @return byte[] the tileIndex in position 0 and the positionIndex in position 1 
	 */
	public static byte[] scoringMove(Board board, ArrayList<Tile> hand){
		
		int score = 0;
		byte[] index = {-1, -1};
		byte tileIndex = 0;
		byte positionIndex = 0;
		int scoreTest = 0;

		for(Tile t : hand){
			for(Position p : board.position){
				if(p != null){
					if((t.topValue == t.bottomValue) && (t.topValue == p.currentSuit)){
						scoreTest = getValue(board.position, positionIndex, (t.topValue + t.bottomValue));
					} else if(t.topValue == p.currentSuit){
						scoreTest = getValue(board.position, positionIndex, t.bottomValue);
					} else if(t.bottomValue == p.currentSuit){
						scoreTest = getValue(board.position, positionIndex, t.bottomValue);
					}
					
					if((scoreTest > score) && ((scoreTest % 5) == 0) && (scoreTest > 0)){
						score = scoreTest;
						index[0] = tileIndex;
						index[1] = positionIndex;
					}
				}
				positionIndex++;
			}
			positionIndex = 0;
			tileIndex++;
		}
		
		return index;
	}
	
	/**
	 * Get value of board positions plus value of placed tile
	 * @param position Position array available on the Board
	 * @param index the index of the position where the tile should be placed
	 * @param value the value that will be counted to make the score
	 * @return rtnValue return the value of the positions plus the new tile
	 */
	private static int getValue(Position[] position, byte index, int value){
		
		int rtnValue = value;
		
		for(byte x = 0; x < position.length; x++){
			if(position[x] != null){
				if((x != index) && (position[x].initialised)){
					rtnValue += position[x].currentSuit;
				}
			}
		}
		
		return rtnValue;
	}
	
	public static byte[] blockingMove(Board board, Player player){
		
		byte[] index = {-1, -1};
		
		
		/**
		 * Blocking move
		 * check tiles already played
		 * Search for arms that do not have blocking suit
		 * Decide if blocking move appropriate:
		 * Do any of the arms have chosen blocking suit?
		 * Is player hand strong in the blocking suit?
		 * 
		 */
		
		Log.d("hard", "player.handStatistics.strongSuitStrength " + player.handStatistics.strongSuitStrength + ", player.handStatistics.strengthThreshold " + player.handStatistics.strengthThreshold );
		
		byte strongSuitIndex = -1;
		if(player.handStatistics.strongSuitStrength > player.handStatistics.strengthThreshold){
			//Player has control over a particular suit so get best tile from hand
			for(byte x = 0; x < player.hand.size(); x++){
				Tile t = (Tile)player.hand.get(x);
				
				if((t.topValue == strongSuitIndex) || (t.bottomValue == strongSuitIndex)){
					int scoreTest = 0;
					//Test if tile can be played
					for(byte i = 0; i < 4; i++){
						if(board.matchTileToPosition(i, t) > -1){
							Log.d("hard", "Z: board.matchTileToPosition(" + i + ", t)" + board.matchTileToPosition(i, t));
							//check if arm position currentSuit == strong suit, skip to next arm.
							Log.d("hard", "Z: board.position[" + i + "].currentSuit " + board.position[i].currentSuit + "  != strongSuitIndex " + strongSuitIndex);
							if(board.position[i].currentSuit != strongSuitIndex){
								// Test if can score by placing on arm
								int currentScoreTest = 0;
								
								if((t.topValue == t.bottomValue) && (t.topValue == board.position[i].currentSuit)){
									currentScoreTest = getValue(board.position, i, (t.topValue + t.bottomValue));
								} else if(t.topValue == board.position[i].currentSuit){
									currentScoreTest = getValue(board.position, i, t.bottomValue);
								} else if(t.bottomValue == board.position[i].currentSuit){
									currentScoreTest = getValue(board.position, i, t.bottomValue);
								}
								Log.d("hard", "scoreTest " + scoreTest);
								if(((currentScoreTest % 5) == 0) && (currentScoreTest > 0)){
									scoreTest = currentScoreTest;
									index[0] = x;	//chosen tile
									index[1] = i;	//chosen position
								} else if(scoreTest == 0) {
									index[0] = x;	//chosen tile
									index[1] = i;	//chosen position
								}
							}
						}
					}
				}
			}
			
			
		} else {
			// next criteria
			
			
			//count suits on board and suits in hand
			//find out if any suit in player control is strong
			
			byte[] suitStrength = new byte[7];
			
			for(byte i = 0; i < suitStrength.length; i++){
				suitStrength[i] = (byte) ((byte) player.handStatistics.suit[i] + board.boardStatistics.suitsPlayed[i]);
			}
			//find out strongest suit
			//N.B. doesn't take into consideration if there are more than 1 strongest suit. This is important because the best strongest suit could be used to score points
			
			byte strongSuitCount = -1;
			
			for(byte i = 0; i < suitStrength.length; i++){
				Log.d("hard", "suitStrength[" + i + "] " + suitStrength[i]);
				if(suitStrength[i] > strongSuitCount){
					strongSuitCount = suitStrength[i];
					strongSuitIndex = i;
				}
			}
			Log.d("hard", "strongSuitCount " + strongSuitCount + " strongSuitIndex " + strongSuitIndex);
			//Now we have chosen the suit, choose the best tile
			for(byte x = 0; x < player.hand.size(); x++){
				Tile t = (Tile)player.hand.get(x);
				
				if((t.topValue == strongSuitIndex) || (t.bottomValue == strongSuitIndex)){
					int scoreTest = 0;
					//Test if tile can be played
					for(byte i = 0; i < 4; i++){
						if(board.matchTileToPosition(i, t) > -1){
							Log.d("hard", "Z: board.matchTileToPosition(" + i + ", t)" + board.matchTileToPosition(i, t));
							//check if arm position currentSuit == strong suit, skip to next arm.
							Log.d("hard", "Z: board.position[" + i + "].currentSuit " + board.position[i].currentSuit + "  != strongSuitIndex " + strongSuitIndex);
							if(board.position[i].currentSuit != strongSuitIndex){
								// Test if can score by placing on arm
								int currentScoreTest = 0;
								
								if((t.topValue == t.bottomValue) && (t.topValue == board.position[i].currentSuit)){
									currentScoreTest = getValue(board.position, i, (t.topValue + t.bottomValue));
								} else if(t.topValue == board.position[i].currentSuit){
									currentScoreTest = getValue(board.position, i, t.bottomValue);
								} else if(t.bottomValue == board.position[i].currentSuit){
									currentScoreTest = getValue(board.position, i, t.bottomValue);
								}
								Log.d("hard", "scoreTest " + scoreTest);
								if(((currentScoreTest % 5) == 0) && (currentScoreTest > 0)){
									scoreTest = currentScoreTest;
									index[0] = x;	//chosen tile
									index[1] = i;	//chosen position
								} else if(scoreTest == 0) {
									index[0] = x;	//chosen tile
									index[1] = i;	//chosen position
								}
							}
						}
					}
				}
			}
			
		}
		
		Log.d("hard", "index[0] " + index[0] + " index[1] " + index[1]);
		return index;
	}
}
