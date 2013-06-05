package andrew.james.games.dominoes.game;

import andrew.james.games.dominoes.game.deck.Tile;

public class BoardStatistics {
	
	public byte[] suitsPlayed = {0, 0, 0, 0, 0, 0, 0};
	public byte[] playableSuits = new byte[4];
	public byte numberOfSameSuitOnArms = 0;
	public byte strongSuit = -1;
	
	public BoardStatistics(){
		
	}
	
	public void runStats(Tile tile){
		this.countSuitsPlayed(tile);
	}
	
	/**
	 * Each tile tile placed on board, the suit count is incremented
	 * @param tile
	 */
	public void countSuitsPlayed(Tile tile){
		this.suitsPlayed[tile.topValue]++;
		this.suitsPlayed[tile.bottomValue]++;
	}
	
	public void setPlayableSuits(Position[] position){
		numberOfSameSuitOnArms = 0;
		for(int i = 0; i < position.length; i++){
			playableSuits[i] = (byte) position[i].currentSuit;
		}
		
		for(int i = 0; i < position.length; i++){
			setNumberOfSameSuitOnArms((byte) position[i].currentSuit);
		}
		
	}
	
	public void setNumberOfSameSuitOnArms(byte suit){
		for(byte i = 0; i < playableSuits.length; i++){
			if(playableSuits[i] == suit){
				if((this.numberOfSameSuitOnArms + 1) > this.numberOfSameSuitOnArms)
					this.numberOfSameSuitOnArms++;
				
				if(this.numberOfSameSuitOnArms > 1)
					this.strongSuit = suit;
			}
		}
		//No suit is strong
		if(this.numberOfSameSuitOnArms <= 1)
			this.strongSuit = -1;
	}

}
