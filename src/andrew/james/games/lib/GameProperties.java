package andrew.james.games.lib;

import android.util.Log;

public final class GameProperties {
	public static final String GAME_TYPE_KEY = "GAME";
	public static final int GAME_TYPE_BLOCK = 0;
	public static final int GAME_TYPE_HOUSE = 1;
	
	public static final String CHARACTER_KEY = "CHARACTER";
	public static final int CHARACTER_1 = 0;
	public static final int CHARACTER_2 = 1;
	public static final int CHARACTER_3 = 2;
	public static final int CHARACTER_4 = 3;
	public static final String CHAR_1_SCORE_KEY = "CHR1S";
	public static final String CHAR_2_SCORE_KEY = "CHR2S";
	public static final String CHAR_3_SCORE_KEY = "CHR3S";
	public static final String CHAR_4_SCORE_KEY = "CHR4S";
	
	public static final int NO_OF_PLAYERS = 4;
	
	public static final String LEVEL_KEY = "LEVEL";
	public static final int LEVEL_EASY = 1;
	public static final int LEVEL_MEDIUM = 2;
	public static final int LEVEL_HARD = 3;
	
	public static final String ROUNDS_KEY = "ROUNDS";
	public static final int ROUNDS_ONE = 1;
	public static final int ROUNDS_THREE = 3;
	public static final int ROUNDS_FIVE = 5;
	
	public static int gameState = -1;
	public static final int GAME_INITIALISE = 1;
	public static final int GAME_INITIALISE_USER = 6;
	public static final int GAME_RUNNING = 0;
	public static final int ROUND_FINISHED = 2; //no user has yet won and no game yet completed
	public static final int GAME_WON = 4; //All rounds completed
	//public static final int ROUND_WON = 5; //single round won but game not complete
	public static final int GAME_STATE_NONE = -1;

	public static int playState = -1;
	public static final int PLAY_STATE_SCORE = 1;
	//public static final int PLAY_STATE_NORMAL = 0;
	//public static final int PLAY_STATE_PAUSE = 2;
	public static final int PLAY_STATE_PLAY = 3;
	public static final int PLAY_STATE_USER = 4;
	public static final int PLAY_STATE_NONE = -1;
	public static final int PLAY_STATE_WAIT_USER_INPUT = 5;
	
	public static int startTop = -1;
	public static int startLeft = -1;
	
	public static byte roundsCounter = -1;
	
	public static final String WINNER_KEY = "WINNER";
	public static final String NUMBER_OF_WINNERS = "NoOfWnr";
	
	public static void debugProperties(String tag){
		switch(GameProperties.gameState){
			case GameProperties.GAME_INITIALISE:
				Log.d(tag, "GameProperties.GAME_INITIALISE");
				break;
			case GameProperties.GAME_RUNNING:
				Log.d(tag, "GameProperties.GAME_RUNNING");
				break;
			case GameProperties.GAME_STATE_NONE:
				Log.d(tag, "GameProperties.GAME_STATE_NONE");
				break;
			case GameProperties.ROUND_FINISHED:
				Log.d(tag, "GameProperties.ROUND_FINISHED");
				break;
			default:
				Log.d(tag, "GameProperties.gameState " + GameProperties.gameState);
				break;
		}
		
		switch(GameProperties.playState){
			case GameProperties.PLAY_STATE_NONE:
				Log.d(tag, "GameProperties.PLAY_STATE_NONE:");
				break;
			case GameProperties.PLAY_STATE_PLAY:
				Log.d(tag, "GameProperties.PLAY_STATE_PLAY");
				break;
			case GameProperties.PLAY_STATE_SCORE:
				Log.d(tag, "GameProperties.PLAY_STATE_SCORE");
				break;
			case GameProperties.PLAY_STATE_WAIT_USER_INPUT:
				Log.d(tag, "GameProperties.PLAY_STATE_WAIT_USER_INPUT");
				break;
				default:
				Log.d(tag, "GameProperties.playState " + GameProperties.playState);
				break;
		}
	}
		
}
