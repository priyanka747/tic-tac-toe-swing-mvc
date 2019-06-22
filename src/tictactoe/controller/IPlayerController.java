package tictactoe.controller;

import tictactoe.model.Point;
/**
 * 
 * @author pthakker
 *
 */
public interface IPlayerController {
	public void UpdateScreen(String msg);
	public void action(int i, int j);
	public void resetGame();
	public void startGame(String name1,String name2);
	public boolean checkWin();
	public void chkGameEnd();
	public boolean isAuto();
	public Point chkWinPosibility();
	public Point chkOppWin();
	
}
