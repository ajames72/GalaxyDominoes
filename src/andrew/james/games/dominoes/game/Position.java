package andrew.james.games.dominoes.game;

import andrew.james.games.dominoes.game.deck.Tile;
import andrew.james.games.lib.GameProperties;
import android.graphics.Rect;
import android.util.Log;

public class Position {
	public Tile tileResource;
	public int currentSuit;
	public char dir;
	public int top;
	public int left;
	public boolean initialised = false;
	
	public Position(){
		
	}
	
	public Position(Tile t){
		this.tileResource = new Tile(t);
		this.left = GameProperties.startLeft;
		this.top = GameProperties.startTop;
	}
	
	public boolean validateTile(Tile t){
		if(t.topValue == this.currentSuit){
			return true;
		} else if(t.bottomValue == this.currentSuit){
			return true;
		} else {
			return false;
		}
	}
	
	public boolean validateTileTopValue(Tile t){
		if(t.topValue == this.currentSuit){
			return true;
		} else {
			return false;
		}
	}
	
	public boolean validateTileBottomValue(Tile t){
		if(t.bottomValue == this.currentSuit){
			return true;
		} else {
			return false;
		}
	}
	
	public boolean matchTileToPosition(int x, int y){
		return true;
	}
	
	public boolean checkDropArea(Rect r, int offsetX, int offsetY){
		
		Log.d("motion", "this.left " + (this.left + offsetX) + ", this.top " + (this.top + offsetY));
		Log.d("motion", "r.left " + r.left + ", r.top " + r.top + " r.right " + r.right + " r.bottom " + r.bottom);
		
		
		return r.contains((this.left + offsetX), (this.top + offsetY));
	}
}
