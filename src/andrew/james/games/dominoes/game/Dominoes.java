package andrew.james.games.dominoes.game;

import java.util.ArrayList;
import java.util.Iterator;

import andrew.james.games.R;
import andrew.james.games.dominoes.game.deck.*;
import andrew.james.games.dominoes.game.player.*;
import andrew.james.games.lib.*;

public class Dominoes {
	
	public Player player[] = new Player[4];
	public User user;
	public int gameType;
	public int userCharacter;
	public int rounds;
	public int level;
	public Board gameBoard;
	
	
	private static int playerIndex;
	public static Position currentTile;
	public static byte missedRounds = 0;
	
	public Dominoes(){
		
	}
	
	public Dominoes(int gameType, int user, int level, int rounds){
		
		this.gameType = gameType;
		this.userCharacter = user;
		this.level = level;
		this.rounds = rounds;
		this.player[0] = new Player(R.drawable.ch1_game_on, R.drawable.ch1_game_off, R.drawable.ch1_on, R.drawable.ch1_off, (short)0);
		this.player[1] = new Player(R.drawable.ch2_game_on, R.drawable.ch2_game_off, R.drawable.ch2_on, R.drawable.ch2_off, (short)1);
		this.player[2] = new Player(R.drawable.ch3_game_on, R.drawable.ch3_game_off, R.drawable.ch3_on, R.drawable.ch3_off, (short)2);
		this.player[3] = new Player(R.drawable.ch4_game_on, R.drawable.ch4_game_off, R.drawable.ch4_on, R.drawable.ch4_off, (short)3);
		
	}
	
	public void initialise(short[] args){
		
		setPlayerIndex(0);
		Dominoes.missedRounds = 0;
		
		Deck deck = new Deck();
		this.gameBoard = new Board();
		GameProperties.gameState = GameProperties.GAME_INITIALISE;
		GameProperties.playState = GameProperties.PLAY_STATE_NONE;
		
		short i = 0;
		
		switch(this.gameType){
		case GameProperties.GAME_TYPE_BLOCK:
			
			//Players get dealt 7
			for(Player p : player){
				p.hand.removeAll(p.hand);
				p.hand.add(deck.deck[i]);
				p.hand.add(deck.deck[i + 1]);
				p.hand.add(deck.deck[i + 2]);
				p.hand.add(deck.deck[i + 3]);
				p.hand.add(deck.deck[i + 4]);
				p.hand.add(deck.deck[i + 5]);
				p.hand.add(deck.deck[i + 6]);
				i += 7;
			}
			
			
			break;
		case GameProperties.GAME_TYPE_HOUSE:
			//Players get dealt 5
			i = 0;
			for(Player p : player){
				p.hand.removeAll(p.hand);
				p.hand.add(deck.deck[i]);
				p.hand.add(deck.deck[i + 1]);
				p.hand.add(deck.deck[i + 2]);
				p.hand.add(deck.deck[i + 3]);
				p.hand.add(deck.deck[i + 4]);
				i += 5;
			}
			
			this.gameBoard.tileBank = new ArrayList<Tile>();
			this.gameBoard.tileBank.add(deck.deck[i]);
			this.gameBoard.tileBank.add(deck.deck[i + 1]);
			this.gameBoard.tileBank.add(deck.deck[i + 2]);
			this.gameBoard.tileBank.add(deck.deck[i + 3]);
			this.gameBoard.tileBank.add(deck.deck[i + 4]);
			this.gameBoard.tileBank.add(deck.deck[i + 5]);
			this.gameBoard.tileBank.add(deck.deck[i + 6]);
			this.gameBoard.tileBank.add(deck.deck[i + 7]);
			
			break;
		}
		
		
		for(int x = 0; x < this.player.length; x++){
			this.player[x].score = args[x];
		}
		
		//Test data
		/*
		for(Player p : this.player){
			p.hand.removeAll(p.hand);
		}
		*/
		/*
		this.player[0].hand.add(deck.deck[27]);
		this.player[0].hand.add(deck.deck[24]);
		this.player[0].hand.add(deck.deck[24]);
		this.player[0].hand.add(deck.deck[24]);
		this.player[0].hand.add(deck.deck[24]);

		this.player[1].hand.add(deck.deck[5]);
		this.player[1].hand.add(deck.deck[2]);
		this.player[1].hand.add(deck.deck[2]);
		this.player[1].hand.add(deck.deck[2]);
		this.player[1].hand.add(deck.deck[2]);

		this.player[2].hand.add(deck.deck[5]);
		this.player[2].hand.add(deck.deck[3]);
		this.player[2].hand.add(deck.deck[3]);
		this.player[2].hand.add(deck.deck[3]);
		this.player[2].hand.add(deck.deck[3]);

		this.player[3].hand.add(deck.deck[5]);
		this.player[3].hand.add(deck.deck[4]);
		this.player[3].hand.add(deck.deck[4]);
		this.player[3].hand.add(deck.deck[4]);
		this.player[3].hand.add(deck.deck[4]);
		*/
		
		
		/*
		this.player[0].hand.add(deck.deck[27]);
		this.player[0].hand.add(deck.deck[27]);
		this.player[0].hand.add(deck.deck[27]);
		this.player[0].hand.add(deck.deck[27]);
		this.player[0].hand.add(deck.deck[27]);
		this.player[0].hand.add(deck.deck[27]);
		this.player[0].hand.add(deck.deck[27]);
		this.player[1].hand.add(deck.deck[2]);
		this.player[1].hand.add(deck.deck[2]);
		this.player[1].hand.add(deck.deck[2]);
		this.player[1].hand.add(deck.deck[2]);
		this.player[1].hand.add(deck.deck[2]);
		this.player[1].hand.add(deck.deck[2]);
		this.player[1].hand.add(deck.deck[2]);
		this.player[2].hand.add(deck.deck[3]);
		this.player[2].hand.add(deck.deck[3]);
		this.player[2].hand.add(deck.deck[3]);
		this.player[2].hand.add(deck.deck[3]);
		this.player[2].hand.add(deck.deck[3]);
		this.player[2].hand.add(deck.deck[3]);
		this.player[2].hand.add(deck.deck[3]);
		this.player[3].hand.add(deck.deck[4]);
		this.player[3].hand.add(deck.deck[4]);
		this.player[3].hand.add(deck.deck[4]);
		this.player[3].hand.add(deck.deck[4]);
		this.player[3].hand.add(deck.deck[4]);
		this.player[3].hand.add(deck.deck[4]);
		this.player[3].hand.add(deck.deck[4]);
		*/
		/*
		this.player[0].hand.add(deck.deck[26]);
		this.player[0].hand.add(deck.deck[26]);
		this.player[0].hand.add(deck.deck[26]);
		this.player[0].hand.add(deck.deck[26]);
		this.player[0].hand.add(deck.deck[26]);
		this.player[0].hand.add(deck.deck[26]);
		this.player[0].hand.add(deck.deck[26]);
		this.player[1].hand.add(deck.deck[2]);
		this.player[1].hand.add(deck.deck[2]);
		this.player[1].hand.add(deck.deck[2]);
		this.player[1].hand.add(deck.deck[2]);
		this.player[1].hand.add(deck.deck[2]);
		this.player[1].hand.add(deck.deck[2]);
		this.player[1].hand.add(deck.deck[2]);
		this.player[2].hand.add(deck.deck[3]);
		this.player[2].hand.add(deck.deck[3]);
		this.player[2].hand.add(deck.deck[3]);
		this.player[2].hand.add(deck.deck[3]);
		this.player[2].hand.add(deck.deck[3]);
		this.player[2].hand.add(deck.deck[3]);
		this.player[2].hand.add(deck.deck[3]);
		this.player[3].hand.add(deck.deck[0]);
		this.player[3].hand.add(deck.deck[0]);
		this.player[3].hand.add(deck.deck[0]);
		this.player[3].hand.add(deck.deck[0]);
		this.player[3].hand.add(deck.deck[0]);
		this.player[3].hand.add(deck.deck[0]);
		this.player[3].hand.add(deck.deck[0]);

		*/
		//End Test Data
		
		this.user = new User(this.player[this.userCharacter]);
		
		Dominoes.setPlayerIndex(this.getFirstPlayer());

	}
	
	public void playGame(){
		
		switch(GameProperties.gameState) {

			case GameProperties.GAME_RUNNING:
				
				switch(GameProperties.playState) {
					case GameProperties.PLAY_STATE_USER:

						if(this.user.canMove){
							
							if((this.user.chosenPosition >= 0) && (this.user.chosenPosition <= 3)){
								currentTile = this.gameBoard.placeTileOnBoard(this.user.chosenPosition, this.player[this.userCharacter].getTile(User.selectedTile));
								this.gameBoard.boardStatistics.runStats(currentTile.tileResource);
								//User has placed tile on board, prevent placing further tiles on board
								Dominoes.missedRounds = 0;
								user.canMove = false;

							} else {
								currentTile = null;
							}
						}
						break;
					case GameProperties.PLAY_STATE_PLAY:
						
						if(Dominoes.getPlayerIndex() != this.userCharacter){
							byte chosenPos = -1;
							boolean missedGo = false;
							
							Tile pt = new Tile(this.player[Dominoes.getPlayerIndex()].hand.get(0));
							
							switch(this.level){
								case GameProperties.LEVEL_EASY:
									//don't care, just place a tile
									byte i = 0;
									
									chosenPos = this.gameBoard.matchTileToPosition(pt);
									
									while((chosenPos == -1) && (i < this.player[Dominoes.getPlayerIndex()].hand.size())){
										pt = new Tile(this.player[Dominoes.getPlayerIndex()].hand.get(i));
										chosenPos = this.gameBoard.matchTileToPosition(pt);
										i++;
									}
									
									break;
								case GameProperties.LEVEL_MEDIUM:
									//Use some logic to score most points
									byte[] indexMedium = GameAI.scoringMove(this.gameBoard, this.player[Dominoes.getPlayerIndex()].hand);

									if((indexMedium[0] == -1) && (indexMedium[1] == -1)){
										indexMedium = GameAI.simpleMove(this.gameBoard, this.player[Dominoes.getPlayerIndex()].hand);
									}

									chosenPos = indexMedium[1];
									if((chosenPos > -1) && (indexMedium[0] > -1) && (indexMedium[0] < this.player[Dominoes.getPlayerIndex()].hand.size()))
										pt = new Tile(this.player[Dominoes.getPlayerIndex()].hand.get(indexMedium[0]));

									break;
								case GameProperties.LEVEL_HARD:
									//Use some tactics
									
									this.player[Dominoes.getPlayerIndex()].handStatistics.runStats(this.player[Dominoes.getPlayerIndex()].hand);
																		
									byte[] indexHard = GameAI.blockingMove(gameBoard, this.player[Dominoes.getPlayerIndex()]);
									
									if((indexHard[0] == -1) && (indexHard[1] == -1)){
										indexHard = GameAI.scoringMove(this.gameBoard, this.player[Dominoes.getPlayerIndex()].hand);
										
										if((indexHard[0] == -1) && (indexHard[1] == -1)){
											indexHard = GameAI.simpleMove(this.gameBoard, this.player[Dominoes.getPlayerIndex()].hand);
										}
									}
									
									chosenPos = indexHard[1];

									if((chosenPos > -1) && (indexHard[0] > -1) && (indexHard[0] < this.player[Dominoes.getPlayerIndex()].hand.size()))
										pt = new Tile(this.player[Dominoes.getPlayerIndex()].hand.get(indexHard[0]));

									break;
							}
							
							if((chosenPos >= 0) && (chosenPos <= 3)){
								currentTile = this.gameBoard.placeTileOnBoard(chosenPos, this.player[Dominoes.getPlayerIndex()].getTile(pt));
								this.gameBoard.boardStatistics.runStats(currentTile.tileResource);
								Dominoes.missedRounds = 0;
							} else {
								currentTile = null;
								switch(this.gameType){
								case GameProperties.GAME_TYPE_BLOCK:
									Dominoes.missedRounds++;
									break;
								case GameProperties.GAME_TYPE_HOUSE:
									
									if(this.gameBoard.tileBank.size() > 0){
										this.player[Dominoes.getPlayerIndex()].hand.add(this.gameBoard.tileBank.get(0));
									} else {
										Dominoes.missedRounds++;
									}
									
									break;
								}
								missedGo = true;
							}
							
							
							if(( this.player[Dominoes.getPlayerIndex()].hand.size() > 0) && (Dominoes.missedRounds < GameProperties.NO_OF_PLAYERS)){
								if(!missedGo){
									if(this.player[Dominoes.getPlayerIndex()].score(this.gameBoard.getBoardResult())){
										GameProperties.playState = GameProperties.PLAY_STATE_SCORE;
									}
								}
							} else if((Dominoes.missedRounds == GameProperties.NO_OF_PLAYERS) || ( this.player[Dominoes.getPlayerIndex()].hand.size() == 0)) {
								
								if(this.player[Dominoes.getPlayerIndex()].score(this.gameBoard.getBoardResult())){
									//score popup
									GameProperties.playState = GameProperties.PLAY_STATE_SCORE;
								} else {
									GameProperties.playState = GameProperties.GAME_STATE_NONE;
								}
								GameProperties.gameState = GameProperties.ROUND_FINISHED;
								this.getBonusPoints();
							}
							
						} else {
							//USER GO ****
							//Do nothing until user has placed tile on board
							GameProperties.playState = GameProperties.PLAY_STATE_WAIT_USER_INPUT;
							
							//Test user can make move
							byte testUserPos = -1;
							
							for(Iterator<Tile> t = this.player[this.userCharacter].hand.iterator(); t.hasNext(); ){
								testUserPos = this.gameBoard.matchTileToPosition(t.next());
								if((testUserPos >= 0) && (testUserPos <= 3))
									this.user.canMove = true;
							}
							
							//If not, progress game
							if(!this.user.canMove){
								currentTile = null;
								Dominoes.missedRounds++;
							}
						}
						
						break;
					case GameProperties.PLAY_STATE_WAIT_USER_INPUT:
						
						if(this.gameType == GameProperties.GAME_TYPE_HOUSE){
							//Test user can make move
							byte testUserPos = -1;
							
							for(Iterator<Tile> t = this.player[this.userCharacter].hand.iterator(); t.hasNext(); ){
								testUserPos = this.gameBoard.matchTileToPosition(t.next());
								if((testUserPos >= 0) && (testUserPos <= 3))
									this.user.canMove = true;
							}
							
							//If not, progress game
							if(!this.user.canMove){
								currentTile = null;
							}
						}
						break;
				}
				
				break;
			case GameProperties.GAME_INITIALISE:
				
				currentTile = new Position(this.player[Dominoes.getPlayerIndex()].getHighValueTile());
				
				this.gameBoard.initialize(currentTile.tileResource);
				
				//start game
				if(Dominoes.getPlayerIndex() == this.userCharacter){
					GameProperties.gameState = GameProperties.GAME_INITIALISE_USER; 
				}
				
				break;
			case GameProperties.GAME_INITIALISE_USER:
				
				//start game
				GameProperties.gameState = GameProperties.GAME_RUNNING; 
				GameProperties.playState = GameProperties.PLAY_STATE_PLAY;
				Dominoes.incrementPlayerCounter();
				
				break;
			case GameProperties.ROUND_FINISHED:

				break;
		}
	}
	
	public short getFirstPlayer(){
		
		short first = 0;
		
		for(Player p : this.player){
			if(p.getHighValueTileIndex() > this.player[first].getHighValueTileIndex()){
				first = p.playerNum;
			}
		}
		
		return first;
	}
	
	public void getBonusPoints(){
		//Add player tiles and add to round winner score
		//If player has used all dominoes in hand
		if((this.player[Dominoes.getPlayerIndex()].hand.size() == 0) && (Dominoes.missedRounds == 0)){
			short bonusScore = 0;
			for(byte i = 0; i < this.player.length; i++){
				if(i != Dominoes.getPlayerIndex()){
					bonusScore += (this.player[i].hand.size() * 5);
				}
			}
			
			this.player[Dominoes.getPlayerIndex()].score += bonusScore;
		}
	}
	
	public static void incrementPlayerCounter(){
		Dominoes.setPlayerIndex(Dominoes.getPlayerIndex() + 1);
		if(Dominoes.getPlayerIndex() > 3)
			Dominoes.setPlayerIndex(0);
	}

	public static int getPlayerIndex() {
		return playerIndex;
	}

	public static void setPlayerIndex(int playerIndex) {
		Dominoes.playerIndex = playerIndex;
	}

	//Return array list incase of draw
	public ArrayList<Player> getWinner(){
		ArrayList<Player> _winner = new ArrayList<Player>();
		
		short _score = 0;
		//find high score first
		for(Player p : this.player){
			if(p.score > _score){
				_score = p.score;
			}
		}
		
		for(Player p : this.player){
			if(p.score >= _score){
				_winner.add(p);
			}
		}
		
		return _winner;
	}
}
