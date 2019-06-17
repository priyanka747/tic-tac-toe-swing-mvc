package tictactoe.controller;


public interface IPlayerController {
	public void UpdateScreen(String msg);
	public void action(int i, int j);
	public void resetGame();
	public void startGame(String name1,String name2);
	public boolean checkWin();
}
