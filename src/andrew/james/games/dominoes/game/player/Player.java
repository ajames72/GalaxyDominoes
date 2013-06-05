package andrew.james.games.dominoes.game.player;

import java.io.Serializable;
import java.util.ArrayList;
import andrew.james.games.dominoes.game.deck.Tile;

public class Player implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5124960765006611341L;
	public int playerIconOnID;
	public int playerIconOffID;
	public int playerIconLrgOnID;
	public int playerIconLrgOffID;
	public short playerNum;
	public short score;
	public short roundsWon;
	public ArrayList<Tile> hand;
	public HandStatistics handStatistics;
	
	public Player(int IDOn, int IDOff, int IDLrgOn, int IDLrgOff, short pNum){
		this.playerIconOnID = IDOn;
		this.playerIconOffID = IDOff;
		this.playerIconLrgOnID = IDLrgOn;
		this.playerIconLrgOffID = IDLrgOff;
		this.playerNum = pNum;
		this.score = 0;
		this.roundsWon = 0;
		this.hand = new ArrayList<Tile>();
		this.score = 0;
		this.handStatistics = new HandStatistics();
	}
	
	public Tile getHighValueTile(){

		Tile high = this.hand.get(0);
		
		for(Tile t : this.hand){
			if(t != null){
				if(t.tileIndex > high.tileIndex){
					high = t;
				}
			}
		}
		return this.getTile(high);
	}
	
	public int getHighValueTileIndex(){

		Tile high = this.hand.get(0);
		
		for(Tile t : this.hand){
			if(t != null){
				if(t.tileIndex > high.tileIndex){
					high = t;
				}
			}
		}
		return high.tileIndex;
	}
	
	
	public Tile getTile(Tile t){
		int i = 0;
		for(Tile match : this.hand){
			if(match.tileIndex == t.tileIndex){
				return this.hand.remove(i);
			}
			i++;
		}
		return null;
	}
	
	public Tile viewTile(Tile t){
		int i = 0;
		for(Tile match : this.hand){
			if(match.tileIndex == t.tileIndex){
				return this.hand.get(i);
			}
			i++;
		}
		return null;
	}

	public boolean score(int result) {

		if(((result % 5) == 0) && (result > 0)) {
			this.score += result;
			return true;
		}
		return false;
	}

}
