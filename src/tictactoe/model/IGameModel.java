package tictactoe.model;

/**
 * 
 * @author pthakker
 *
 */
public interface IGameModel {
	public int getHighScore();
	public void setHighScore(int highScore);
	public boolean gameOver();
	public void resetGame();
	public void resetBoard();
	public IPlayerModel getActivePlayer();
	public IPlayerModel getInActivePlayer();
	public void setBoardPosition(int i,int j,String sign);
	public String getBordPosition(int row,int col);
	public String getPlayerSign(IPlayerModel player);
	public int getPlayerScore(IPlayerModel player);
	public String getPlayerName(IPlayerModel player);
	void startGame(String player1, String player2);
	void startGame(IPlayerModel player);
	public void changePlayer();
	public  int countMoves();
	public IPlayerModel getPlayer1();
	public IPlayerModel getPlayer2();
	public boolean isAuto();
	public boolean setHighscore(int i);
	public int getHighscore();
}
