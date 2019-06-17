package tictactoe.model;

public class PlayerModel implements IPlayerModel {
	private String name;
	private String PlayerSign;
	private int score;
	private boolean isActive;
	
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

}
