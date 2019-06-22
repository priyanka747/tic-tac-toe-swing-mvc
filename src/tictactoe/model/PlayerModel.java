package tictactoe.model;
/**
 * 
 * @author pthakker
 *
 */
public class PlayerModel implements IPlayerModel {
	private String name;
	private boolean isAuto=false;
	private String PlayerSign;
	private int score;
	private boolean isActive;
	
	public PlayerModel(boolean isComputer) {
		if(isComputer) {
			isAuto=true;
		}
	}
	@Override
	public int getScore() {
		return score;
	}

	@Override
	public void setScore(int score) {
		this.score+=score;
	}

	@Override
	public void setName(String name) {
		this.name=name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public boolean isActive() {
		return isActive;
	}

	@Override
	public void setIsActive(boolean isActive) {
		this.isActive=isActive;
	}

	@Override
	public void setPlayerSign(String PlayerSign) {
		this.PlayerSign=PlayerSign;
	}

	@Override
	public String getPlayerSign() {
		return PlayerSign;
	}

	@Override
	public void reset() {
		score=0;
	}
	/**
	 * @return the isAuto
	 */
	public boolean isAuto() {
		return isAuto;
	}
	/**
	 * @param isAuto the isAuto to set
	 */
	

}
