package tictactoe.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
/**
 * 
 * @author pthakker
 *
 */
public class GameModel implements IGameModel {
	private int highScore;
	private boolean gameOver=false;
	private String board[][]=new String[3][3];
	IPlayerModel player1,player2;

	private final static String path="highscore.txt";

	public GameModel(IPlayerModel player1, IPlayerModel player2) {
		this.player1=player1;
		this.player2=player2;
		getHighscore();
	}

	@Override
	public int getHighScore() {
		return highScore;
	}
	@Override
	public void startGame(String player1,String player2) {
		this.player1.setName(player1);
		this.player2.setName(player2);
		this.player1.setScore(0);
		this.player2.setScore(0);
		this.player1.setPlayerSign("X");
		this.player2.setPlayerSign("O");
		this.player1.setIsActive(true);
	}
	@Override
	public void startGame(IPlayerModel player) {
		this.player1.setPlayerSign("X");
		this.player2.setPlayerSign("O");
		player.setIsActive(true);
	}

	@Override
	public boolean gameOver() {
		
		return gameOver;
	}

	@Override
	public void resetGame() {
		gameOver=false;
		resetBoard();
	}

	@Override
	public void setHighScore(int highScore) {
		this.highScore=highScore;
	}

	@Override
	public IPlayerModel getActivePlayer() {
		if(player1.isActive()) {
			return player1;
		}else {
			return player2;
		}
	}

	@Override
	public String getBordPosition(int row,int col) {
		return board[row][col];
	} 

	@Override
	public void setBoardPosition(int i, int j, String sign) {
		board[i][j]=sign;
	}

	@Override
	public String getPlayerSign(IPlayerModel player) {
		return player.getPlayerSign();
	}
	@Override
	public int getPlayerScore(IPlayerModel player) {
		return player.getScore();
	}
	@Override
	public String getPlayerName(IPlayerModel player) {
		return player.getName();
	}

	@Override
	public void changePlayer() {
		// TODO Auto-generated method stub
		if(player1.isActive()) {
			player1.setIsActive(false);
			player2.setIsActive(true);
		}
		else {
			player1.setIsActive(true);
			player2.setIsActive(false);
		}

	}
	@Override
	public int countMoves() {
		int cnt=0;
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(getBordPosition(i, j)==null) {
					cnt++;
				}
			}
		}
		if(cnt<=0)
			gameOver=true;
		return cnt;
	}

	@Override
	public IPlayerModel getInActivePlayer() {
		if(player1.isActive()) {
			return player2;
		}else {
			return player1;
		}
	}

	@Override
	public void resetBoard() {
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				board[i][j]=null;
			}
		}
	}

	@Override
	public IPlayerModel getPlayer1() {
		// TODO Auto-generated method stub
		return player1;
	}

	@Override
	public IPlayerModel getPlayer2() {
		// TODO Auto-generated method stub
		return player2;
	}

	@Override
	public boolean isAuto() {
		return(player2.isAuto()?true:false);
	}

	@Override
	public boolean setHighscore(int hs) {
		if(highScore<hs) {
		try(PrintWriter out=new PrintWriter(path)){
			
				out.println(hs);
				return true;
				
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		}
		return false;
	}

	@Override
	public int getHighscore() {

		try (BufferedReader br =new BufferedReader(new FileReader(path))){
//			FileReader fr =new FileReader(path);
//		BufferedReader br =new BufferedReader(fr);
			String line="";
			
			while((line=br.readLine())!=null) {
				highScore=Integer.parseInt(line);
				System.out.println(line);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return highScore;
	}
	
}
