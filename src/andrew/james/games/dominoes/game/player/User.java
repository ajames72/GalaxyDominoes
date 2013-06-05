package andrew.james.games.dominoes.game.player;

import andrew.james.games.R;
import andrew.james.games.dominoes.game.deck.Tile;

public class User extends Player {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -471623384633792946L;
	public Tile[] gameBoardUserSelectableTile;
	public static Tile selectedTile;
	public boolean canMove;
	public byte chosenPosition;

	public User(Player p){
		super(p.playerIconOnID, p.playerIconOffID, p.playerIconLrgOnID, p.playerIconLrgOffID, p.playerNum);
		this.playerNum = p.playerNum;
		this.gameBoardUserSelectableTile = new Tile[13];

		for(int i = 0; i < p.hand.size(); i++){
			this.gameBoardUserSelectableTile[i] = new Tile(p.hand.get(i));
		}
		this.canMove = false;
		this.chosenPosition = -1;
	}
	
	public int getUserTileResourceID(Tile t){
		if((this.gameBoardUserSelectableTile[0] != null) && (this.gameBoardUserSelectableTile[0].UniqueID == t.UniqueID)){
			return R.id.tile1;
		} else if((this.gameBoardUserSelectableTile[1] != null) && (this.gameBoardUserSelectableTile[1].UniqueID == t.UniqueID)){
			return R.id.tile2;
		} else if((this.gameBoardUserSelectableTile[2] != null) && (this.gameBoardUserSelectableTile[2].UniqueID == t.UniqueID)){
			return R.id.tile3;
		} else if((this.gameBoardUserSelectableTile[3] != null) && (this.gameBoardUserSelectableTile[3].UniqueID == t.UniqueID)){
			return R.id.tile4;
		} else if((this.gameBoardUserSelectableTile[4] != null) && (this.gameBoardUserSelectableTile[4].UniqueID == t.UniqueID)){
			return R.id.tile5;
		} else if((this.gameBoardUserSelectableTile[5] != null) && (this.gameBoardUserSelectableTile[5].UniqueID == t.UniqueID)){
			return R.id.tile6;
		} else if((this.gameBoardUserSelectableTile[6] != null) && (this.gameBoardUserSelectableTile[6].UniqueID == t.UniqueID)){
			return R.id.tile7;
		} else if((this.gameBoardUserSelectableTile[7] != null) && (this.gameBoardUserSelectableTile[7].UniqueID == t.UniqueID)){
			return R.id.tile8;
		} else if((this.gameBoardUserSelectableTile[8] != null) && (this.gameBoardUserSelectableTile[8].UniqueID == t.UniqueID)){
			return R.id.tile9;
		} else if((this.gameBoardUserSelectableTile[9] != null) && (this.gameBoardUserSelectableTile[9].UniqueID == t.UniqueID)){
			return R.id.tile10;
		} else if((this.gameBoardUserSelectableTile[10] != null) && (this.gameBoardUserSelectableTile[10].UniqueID == t.UniqueID)){
			return R.id.tile11;
		} else if((this.gameBoardUserSelectableTile[11] != null) && (this.gameBoardUserSelectableTile[11].UniqueID == t.UniqueID)){
			return R.id.tile12;
		} else if((this.gameBoardUserSelectableTile[12] != null) && (this.gameBoardUserSelectableTile[12].UniqueID == t.UniqueID)){
			return R.id.tile13;
		}
		
		return -1;
	}
	
	public void removeUserTileResourceID(Tile t){
		if((this.gameBoardUserSelectableTile[0] != null) && (this.gameBoardUserSelectableTile[0].UniqueID == t.UniqueID)){
			this.gameBoardUserSelectableTile[0] = null;
		} else if((this.gameBoardUserSelectableTile[1] != null) && (this.gameBoardUserSelectableTile[1].UniqueID == t.UniqueID)){
			this.gameBoardUserSelectableTile[1] = null;
		} else if((this.gameBoardUserSelectableTile[2] != null) && (this.gameBoardUserSelectableTile[2].UniqueID == t.UniqueID)){
			this.gameBoardUserSelectableTile[2] = null;
		} else if((this.gameBoardUserSelectableTile[3] != null) && (this.gameBoardUserSelectableTile[3].UniqueID == t.UniqueID)){
			this.gameBoardUserSelectableTile[3] = null;
		} else if((this.gameBoardUserSelectableTile[4] != null) && (this.gameBoardUserSelectableTile[4].UniqueID == t.UniqueID)){
			this.gameBoardUserSelectableTile[4] = null;
		} else if((this.gameBoardUserSelectableTile[5] != null) && (this.gameBoardUserSelectableTile[5].UniqueID == t.UniqueID)){
			this.gameBoardUserSelectableTile[5] = null;
		} else if((this.gameBoardUserSelectableTile[6] != null) && (this.gameBoardUserSelectableTile[6].UniqueID == t.UniqueID)){
			this.gameBoardUserSelectableTile[6] = null;
		} else if((this.gameBoardUserSelectableTile[7] != null) && (this.gameBoardUserSelectableTile[7].UniqueID == t.UniqueID)){
			this.gameBoardUserSelectableTile[7] = null;
		} else if((this.gameBoardUserSelectableTile[8] != null) && (this.gameBoardUserSelectableTile[8].UniqueID == t.UniqueID)){
			this.gameBoardUserSelectableTile[8] = null;
		} else if((this.gameBoardUserSelectableTile[9] != null) && (this.gameBoardUserSelectableTile[9].UniqueID == t.UniqueID)){
			this.gameBoardUserSelectableTile[9] = null;
		} else if((this.gameBoardUserSelectableTile[10] != null) && (this.gameBoardUserSelectableTile[10].UniqueID == t.UniqueID)){
			this.gameBoardUserSelectableTile[10] = null;
		} else if((this.gameBoardUserSelectableTile[11] != null) && (this.gameBoardUserSelectableTile[11].UniqueID == t.UniqueID)){
			this.gameBoardUserSelectableTile[11] = null;
		} else if((this.gameBoardUserSelectableTile[12] != null) && (this.gameBoardUserSelectableTile[12].UniqueID == t.UniqueID)){
			this.gameBoardUserSelectableTile[12] = null;
		}
	}
}
