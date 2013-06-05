package andrew.james.games.dominoes.game.deck;

import java.io.Serializable;
import java.util.UUID;

public class Tile implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1442131684913014971L;
	public int tileIndex;
	public int topValue;
	public int bottomValue;
	public int ID;
	public UUID UniqueID;
	public int[] boardLayoutID = new int[4];

	public Tile(Tile t){
		this.tileIndex = t.tileIndex;
		this.topValue = t.topValue;
		this.bottomValue = t.bottomValue;
		this.ID = t.ID;
		this.UniqueID = t.UniqueID;
		this.boardLayoutID = t.boardLayoutID;
	}

	public Tile(int index, int top, int bottom, int ID, int[] boardLayoutArrayID) {
		this.tileIndex = index;
		this.topValue = top;
		this.bottomValue = bottom;
		this.ID = ID;
		this.UniqueID = UUID.randomUUID();
		this.boardLayoutID = boardLayoutArrayID;
	}
	
	public boolean isTilePair(){
		if(this.topValue == this.bottomValue)
			return true;
		else
			return false;
	}
	
	public int getPairTileScore(){
		return this.topValue * 2;
	}
}
