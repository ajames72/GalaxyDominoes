package andrew.james.games.dominoes.game.player;

import java.io.Serializable;
import java.util.ArrayList;

import andrew.james.games.dominoes.game.deck.Tile;
import android.util.Log;

public class HandStatistics implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8130209849591287319L;
	public byte strongSuit = 0;
	public byte strongSuitStrength = 0;
	public byte strengthThreshold = 0;	//Play this if threshold reached
	public boolean zeroFiveTile = false;
	public byte[] suit = {0, 0, 0, 0, 0, 0 , 0};
	public boolean[] doubleTile = {false, false, false, false, false, false, false};
	
	public HandStatistics(){
		
	}
	
	public void runStats(ArrayList<Tile> hand){
		this.countSuits(hand);
		this.setStrongSuitStrength();
		this.setStrengthThreshold(hand.size());
	}
	
	public void countSuits(ArrayList<Tile> hand){
		
		for(byte x = 0; (x < doubleTile.length) && (x < this.suit.length); x++){
			doubleTile[x] = false;
			this.suit[x] = 0;
		}
		
		zeroFiveTile = false;
		
		//count suits in hand
		for(Tile t : hand){
			
			this.suit[t.topValue]++;
			this.suit[t.bottomValue]++;
			
			switch(t.tileIndex){
			case 4:
				zeroFiveTile = true;
				break;
			case 21:
				doubleTile[0] = true;
				break;
			case 22:
				doubleTile[1] = true;
				break;
			case 23:
				doubleTile[2] = true;
				break;
			case 24:
				doubleTile[3] = true;
				break;
			case 25:
				doubleTile[4] = true;
				break;
			case 26:
				doubleTile[5] = true;
				break;
			case 27:
				doubleTile[6] = true;
				break;
				
			}
		}
	}
	
	/**
	 * Log the strongest suit
	 */
	public void setStrongSuitStrength(){
		
		this.strongSuitStrength = 0;
		this.strongSuit = -1;
		
		for(byte i = 0; i < this.suit.length; i++){
			if(this.suit[i] > this.strongSuitStrength){
				this.strongSuitStrength = this.suit[i];
				this.strongSuit = i;
				Log.d("hard", "this.suit[" + i + "] " + this.suit[i]);
				Log.d("hard", "this.strongSuitStrength " + this.strongSuitStrength + " this.strongSuit " + this.strongSuit + " i " + i);
			}
		}
	}
	
	/**
	 * If strength threshold is reached, then user has strong suit. This would trigger option to play blocking move.
	 * The strength threshold is reached when that number of suits is contained in a hand.
	 * @param hand Tiles in player hand
	 */
	public void setStrengthThreshold(int size){
		
		switch(size){
		case 7:
			this.strengthThreshold = 5;
			break;
		case 6:
			this.strengthThreshold = 4;
			break;
		case 5:
			this.strengthThreshold = 3;
			break;
		case 4:
			this.strengthThreshold = 2;
			break;
		case 3:
			this.strengthThreshold = 1;
			break;
		case 2:
		case 1:
			this.strengthThreshold = 0;
			break;
		}
		
	}

}
