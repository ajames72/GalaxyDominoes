package andrew.james.games.dominoes.game;

import java.util.ArrayList;

import andrew.james.games.dominoes.game.deck.Tile;
import android.graphics.Rect;


public class Board {
	
	public Position position[];
	public Rect boardArea;
	public static int tileWidth;
	public static int tileHeight;
	public static int boardPositionLeft;
	public static int boardPositionTop;
	public static int boardPositionRight;
	public static int boardPositionBottom;
	public BoardStatistics boardStatistics;
	public Tile startTile;
	public ArrayList<Tile> tileBank;
	
	public Board(){
		this.position = new Position[4];
		this.boardStatistics = new BoardStatistics();
	}
	
	public void initialize(Tile t){
		this.startTile = new Tile(t);

		this.position[0] = new Position(this.startTile);
		this.position[0].currentSuit = t.topValue;
		this.position[0].dir = 'e';
		this.position[0].left -= tileWidth;
		this.position[0].top +=  (tileWidth / 2);

		this.position[1] = new Position(this.startTile);
		this.position[1].currentSuit = t.topValue;
		this.position[1].dir = 'w';
		this.position[1].top +=  (tileWidth / 2);
	}

	public byte matchTileToPosition(Tile t){
		for(int index = 0; index < 4; index++){
			if(this.position[index] != null){
				if(this.position[index].validateTile(t)){
					return (byte) index;
				}
			}
		}
		
		return -1;
	}
	
	public byte matchTileToPosition(byte index, Tile t){
		if((this.position[index] != null) && (this.position[index].validateTile(t))){
			return index;
		} else {
			return -1;
		}
	}
	
	public Position placeTileOnBoard(int index, Tile placedTile){
		
		if(this.position[index] == null)
			return null;
		
		if(!this.position[index].initialised)
			this.position[index].initialised = true;
		
		if((this.position[0].initialised) && (this.position[1].initialised) && (this.position[2] == null) && (this.position[3] == null)){
			this.position[2] = new Position(this.startTile);
			this.position[2].dir = 'n';
			this.position[2].currentSuit = this.startTile.topValue;
			this.position[3] = new Position(this.startTile);
			this.position[3].dir = 's';
			this.position[3].currentSuit = this.startTile.topValue;
		}
		
		if(placedTile.topValue == placedTile.bottomValue){
			this.position[index].currentSuit = placedTile.topValue;
		} else if(this.position[index].currentSuit == placedTile.topValue){
			this.position[index].currentSuit = placedTile.bottomValue;
		} else if(this.position[index].currentSuit == placedTile.bottomValue){
			this.position[index].currentSuit = placedTile.topValue;
		}
		
		boolean flip = false;
		
		if(placedTile.bottomValue != this.position[index].currentSuit){
			//flip tile
			flip = true;
		}
		
		this.position[index].tileResource = placedTile;
		
		this.updateCoOrds(index, flip);
		
		return this.position[index];
	}
	
	
	private void updateCoOrds(int index, boolean flip){
		
		if(this.position[index] != null){
		
			switch(this.position[index].dir){
			case 'e':
				
				this.position[index].tileResource.ID = flip ? this.position[index].tileResource.boardLayoutID[1] : this.position[index].tileResource.boardLayoutID[3];
				
				if(this.position[index].left < boardPositionRight){
					this.position[index].left  += tileHeight;
				} else {
					this.position[index].dir = 's';
					this.position[index].tileResource.ID = flip ? this.position[index].tileResource.boardLayoutID[2] : this.position[index].tileResource.boardLayoutID[0];
					this.position[index].top += tileWidth;
					this.position[index].left  += tileWidth;
				}
				break;
			case 'w':
				
				this.position[index].tileResource.ID = flip ? this.position[index].tileResource.boardLayoutID[3] : this.position[index].tileResource.boardLayoutID[1];
				
				if(this.position[index].left > boardPositionLeft){
					this.position[index].left  -= tileHeight;
				} else {
					this.position[index].dir = 'n';
					this.position[index].tileResource.ID = flip ? this.position[index].tileResource.boardLayoutID[0] : this.position[index].tileResource.boardLayoutID[2];
					this.position[index].top -= tileHeight;
				}
				break;
			case 'n':
				
				this.position[index].tileResource.ID = flip ? this.position[index].tileResource.boardLayoutID[0] : this.position[index].tileResource.boardLayoutID[2];
				
				if(this.position[index].top > boardPositionTop){
					this.position[index].top -= tileHeight;
				} else {
					this.position[index].dir = 'e';
					this.position[index].tileResource.ID = flip ? this.position[index].tileResource.boardLayoutID[1] : this.position[index].tileResource.boardLayoutID[3];
					this.position[index].left  += tileWidth;
				}
				break;
			case 's':
				
				this.position[index].tileResource.ID = flip ? this.position[index].tileResource.boardLayoutID[2] : this.position[index].tileResource.boardLayoutID[0];
				
				if(this.position[index].top < boardPositionBottom){
					this.position[index].top += tileHeight;
				} else {
					this.position[index].dir = 'w';
					this.position[index].tileResource.ID = flip ? this.position[index].tileResource.boardLayoutID[3] : this.position[index].tileResource.boardLayoutID[1];
					this.position[index].left -= tileHeight;
					this.position[index].top += tileWidth;
				}
				break;
			}
		}
	}
	
	public int getBoardResult() {
		int score = 0;

		if((!this.position[0].initialised) || (!this.position[1].initialised)){
			if(!this.position[0].initialised){
				if(!this.position[0].tileResource.isTilePair()){
					score += this.position[0].currentSuit;
				} else {
					score += (this.position[0].currentSuit * 2);
				}
			} else if(!this.position[1].initialised){
				if(!this.position[1].tileResource.isTilePair()){
					score += this.position[1].currentSuit;
				} else {
					score += (this.position[1].currentSuit * 2);
				}
			}
		}
		
		for(Position p : this.position){
			if(p != null){
				if(p.initialised){
					if(!p.tileResource.isTilePair()){
						score += p.currentSuit;
					} else {
						score += (p.currentSuit * 2);
					}
				}
			}
		}
		
		return score;
	}
}
