package tictactoe.view;

import tictactoe.controller.IPlayerController;
/**
 * 
 * @author mit patel
 *
 */
public interface IPlayerView {
	public void setController(IPlayerController controller);
	public void  setButtonText(int i,int j,String sign);
	public void setScore(int scorepone,int scoreptwo);
	public void setHScore(int hs);
	public void setPlayerOnesSign(String sign);
	public void setPlayerTwosSign(String sign);
	public void setInfoLabel(String msg);
	public void setNameValueLabel(String player1,String player2);
	public void resetBoard();
	void exit();
	public void win(String name);
	public void matchDraw();	
	public void disableBoard();
	public void enableBoard();
}
