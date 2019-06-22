package tictactoe.model;
/**
 * 
 * @author pthakker
 *
 */
public interface IPlayerModel {
	public int getScore();
	public void setScore(int score);
	public void setName(String name);
	public String getName();
	public void setPlayerSign(String sign);/** X or O*/
	public String getPlayerSign();
	public boolean isActive();
	public void setIsActive(boolean isActive);
	public void reset();

	public boolean isAuto();
}
