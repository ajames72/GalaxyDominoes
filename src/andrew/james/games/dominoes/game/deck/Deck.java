package andrew.james.games.dominoes.game.deck;

import andrew.james.games.R;

public class Deck {
	
	public Tile deck[];
	
	public Deck(){
		this.deck = new Tile[28];
		
		this.deck[0] = new Tile(0, 0, 1, R.drawable.tile0_1, new int[]{R.drawable.tile0_1_0, R.drawable.tile0_1_90, R.drawable.tile0_1_180, R.drawable.tile0_1_270});
		this.deck[1] = new Tile(1, 0, 2, R.drawable.tile0_2, new int[]{R.drawable.tile0_2_0, R.drawable.tile0_2_90, R.drawable.tile0_2_180, R.drawable.tile0_2_270});
		this.deck[2] = new Tile(2, 0, 3, R.drawable.tile0_3, new int[]{R.drawable.tile0_3_0, R.drawable.tile0_3_90, R.drawable.tile0_3_180, R.drawable.tile0_3_270});
		this.deck[3] = new Tile(3, 0, 4, R.drawable.tile0_4, new int[]{R.drawable.tile0_4_0, R.drawable.tile0_4_90, R.drawable.tile0_4_180, R.drawable.tile0_4_270});
		this.deck[4] = new Tile(4, 0, 5, R.drawable.tile0_5, new int[]{R.drawable.tile0_5_0, R.drawable.tile0_5_90, R.drawable.tile0_5_180, R.drawable.tile0_5_270});
		this.deck[5] = new Tile(5, 0, 6, R.drawable.tile0_6, new int[]{R.drawable.tile0_6_0, R.drawable.tile0_6_90, R.drawable.tile0_6_180, R.drawable.tile0_6_270});
		this.deck[6] = new Tile(6, 1, 2, R.drawable.tile1_2, new int[]{R.drawable.tile1_2_0, R.drawable.tile1_2_90, R.drawable.tile1_2_180, R.drawable.tile1_2_270});
		this.deck[7] = new Tile(7, 1, 3, R.drawable.tile1_3, new int[]{R.drawable.tile1_3_0, R.drawable.tile1_3_90, R.drawable.tile1_3_180, R.drawable.tile1_3_270});
		this.deck[8] = new Tile(8, 1, 4, R.drawable.tile1_4, new int[]{R.drawable.tile1_4_0, R.drawable.tile1_4_90, R.drawable.tile1_4_180, R.drawable.tile1_4_270});
		this.deck[9] = new Tile(9, 1, 5, R.drawable.tile1_5, new int[]{R.drawable.tile1_5_0, R.drawable.tile1_5_90, R.drawable.tile1_5_180, R.drawable.tile1_5_270});
		this.deck[10] = new Tile(10, 1, 6, R.drawable.tile1_6, new int[]{R.drawable.tile1_6_0, R.drawable.tile1_6_90, R.drawable.tile1_6_180, R.drawable.tile1_6_270});
		this.deck[11] = new Tile(11, 2, 3, R.drawable.tile2_3, new int[]{R.drawable.tile2_3_0, R.drawable.tile2_3_90, R.drawable.tile2_3_180, R.drawable.tile2_3_270});
		this.deck[12] = new Tile(12, 2, 4, R.drawable.tile2_4, new int[]{R.drawable.tile2_4_0, R.drawable.tile2_4_90, R.drawable.tile2_4_180, R.drawable.tile2_4_270});
		this.deck[13] = new Tile(13, 2, 5, R.drawable.tile2_5, new int[]{R.drawable.tile2_5_0, R.drawable.tile2_5_90, R.drawable.tile2_5_180, R.drawable.tile2_5_270});
		this.deck[14] = new Tile(14, 2, 6, R.drawable.tile2_6, new int[]{R.drawable.tile2_6_0, R.drawable.tile2_6_90, R.drawable.tile2_6_180, R.drawable.tile2_6_270});
		this.deck[15] = new Tile(15, 3, 4, R.drawable.tile3_4, new int[]{R.drawable.tile3_4_0, R.drawable.tile3_4_90, R.drawable.tile3_4_180, R.drawable.tile3_4_270});
		this.deck[16] = new Tile(16, 3, 5, R.drawable.tile3_5, new int[]{R.drawable.tile3_5_0, R.drawable.tile3_5_90, R.drawable.tile3_5_180, R.drawable.tile3_5_270});
		this.deck[17] = new Tile(17, 3, 6, R.drawable.tile3_6, new int[]{R.drawable.tile3_6_0, R.drawable.tile3_6_90, R.drawable.tile3_6_180, R.drawable.tile3_6_270});
		this.deck[18] = new Tile(18, 4, 5, R.drawable.tile4_5, new int[]{R.drawable.tile4_5_0, R.drawable.tile4_5_90, R.drawable.tile4_5_180, R.drawable.tile4_5_270});
		this.deck[19] = new Tile(19, 4, 6, R.drawable.tile4_6, new int[]{R.drawable.tile4_6_0, R.drawable.tile4_6_90, R.drawable.tile4_6_180, R.drawable.tile4_6_270});
		this.deck[20] = new Tile(20, 5, 6, R.drawable.tile5_6, new int[]{R.drawable.tile5_6_0, R.drawable.tile5_6_90, R.drawable.tile5_6_180, R.drawable.tile5_6_270});
		this.deck[21] = new Tile(21, 0, 0, R.drawable.tile0_0, new int[]{R.drawable.tile0_0_0, R.drawable.tile0_0_90, R.drawable.tile0_0_180, R.drawable.tile0_0_270});
		this.deck[22] = new Tile(22, 1, 1, R.drawable.tile1_1, new int[]{R.drawable.tile1_1_0, R.drawable.tile1_1_90, R.drawable.tile1_1_180, R.drawable.tile1_1_270});
		this.deck[23] = new Tile(23, 2, 2, R.drawable.tile2_2, new int[]{R.drawable.tile2_2_0, R.drawable.tile2_2_90, R.drawable.tile2_2_180, R.drawable.tile2_2_270});
		this.deck[24] = new Tile(24, 3, 3, R.drawable.tile3_3, new int[]{R.drawable.tile3_3_0, R.drawable.tile3_3_90, R.drawable.tile3_3_180, R.drawable.tile3_3_270});
		this.deck[25] = new Tile(25, 4, 4, R.drawable.tile4_4, new int[]{R.drawable.tile4_4_0, R.drawable.tile4_4_90, R.drawable.tile4_4_180, R.drawable.tile4_4_270});
		this.deck[26] = new Tile(26, 5, 5, R.drawable.tile5_5, new int[]{R.drawable.tile5_5_0, R.drawable.tile5_5_90, R.drawable.tile5_5_180, R.drawable.tile5_5_270});
		this.deck[27] = new Tile(27, 6, 6, R.drawable.tile6_6, new int[]{R.drawable.tile6_6_0, R.drawable.tile6_6_90, R.drawable.tile6_6_180, R.drawable.tile6_6_270});
		
		this.shuffleDeck();
	}
	
	public static boolean matchTile(Tile t1, Tile t2){
		
		if((t1.topValue == t2.topValue) || (t1.topValue == t2.bottomValue) ){
			return true;
		}
		if((t1.bottomValue == t2.topValue) || (t1.bottomValue == t2.bottomValue) ){
			return true;
		}
		
		return false;
	}
	
	private void shuffleDeck(){
		for(int i = 1; i < 28; i++){
			Tile B = this.deck[i];
			int j = i;
			
			while((j > 0) && (this.deck[j - 1].UniqueID.compareTo(B.UniqueID) == 1)){
				this.deck[j] = this.deck[j - 1];
				j--;
			}
			this.deck[j] = B;
		}
	}
}
