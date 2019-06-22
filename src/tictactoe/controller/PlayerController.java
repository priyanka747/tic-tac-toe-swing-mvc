package tictactoe.controller;


import tictactoe.model.Point;

import java.util.Random;

import tictactoe.model.IGameModel;
import tictactoe.view.IPlayerView;
/**
 * 
 * @author pthakker
 *
 */
public class PlayerController implements IPlayerController {
	private IGameModel model;
	private IPlayerView view;
	private Point point;
//	private int 
	public PlayerController(IGameModel model, IPlayerView view) {
		this.model=model;
		this.view=view;
		view.setHScore(model.getHighscore());
	}

	@Override
	public void action(int i, int j) {
		
			
				if(model.getBordPosition(i, j)==null) {
					model.setBoardPosition(i, j, model.getActivePlayer().getPlayerSign());
					view.setButtonText(i, j, model.getActivePlayer().getPlayerSign());
					model.countMoves();
					chkGameEnd();
					if(model.getPlayer2().isAuto() && model.getPlayer2()==model.getActivePlayer()) {
						view.disableBoard();
						
						String sign=model.getPlayer1().getPlayerSign();
						point=makeMove();
						
						model.setBoardPosition(i, j, model.getActivePlayer().getPlayerSign());
						view.setButtonText(i, j, model.getActivePlayer().getPlayerSign());
						view.enableBoard();
					}
					
					
					model.changePlayer();
					UpdateScreen(model.getActivePlayer().getName()+"'s turn");
				}
			
	}
	/**
	 * @author rohini lawrence
	 * @return
	 */
	public Point makeMove() {
		Point point=new Point(0,0);
		int moves=model.countMoves();
		System.out.println(moves+"");
		System.out.println(point.getX()+", "+point.getY());
		while(true) {
			
			if(moves>=8) {
				Random randnum=new Random(123456789);
				int x=(randnum.nextInt(((3 - 0) + 1)) + 0);
				Random randnumyRandom=new Random(123456789);
				int y= (randnumyRandom.nextInt(((3 - 0) + 1)) + 0);
				System.out.println(point.getX()+", "+point.getY());
				point=new Point(x,y);
			}
			else if(moves<8) {
				point=chkWinPosibility(); // chk is computer is winning or not if yes then return by which move else return null
				if(point!=null) {
					return point;
				}
				point=chkOppWin();// chk is opponent is winning or not if yes then return by which move else return null
				if(point!=null) {
					return point;
				}
				
			}
			
			if(model.getBordPosition((int)point.getX(),(int)point.getY())==null) //if the point is empty than return the point else find other point
			{
				break;
			}
		}
					
			
			return point;
	}
	@Override
	public void UpdateScreen(String msg) {
		view.setInfoLabel(msg);//message or notify task performed
		view.setNameValueLabel(model.getPlayer1().getName(),model.getPlayer2().getName());
		view.setPlayerOnesSign(model.getPlayer1().getPlayerSign());//set sign label
		view.setPlayerTwosSign(model.getPlayer2().getPlayerSign());
		view.setScore(model.getPlayer1().getScore(),model.getPlayer2().getScore());//set score
	}

	@Override
	public void resetGame() {
		model.resetBoard();
		//		model.resetGame();
		//		model.startGame();
		UpdateScreen(model.getActivePlayer().getName()+"'s  turn");

	}

	@Override
	public void startGame(String name1,String name2) {

		model.startGame(name1, name2);
		UpdateScreen(model.getActivePlayer().getName()+"'s  turn");
	}

	@Override
	public boolean checkWin() {
		
		if((model.getBordPosition(0,0)=="X" && model.getBordPosition(1,1)=="X" &&model.getBordPosition(2,2)=="X") ||(model.getBordPosition(0,0)=="O" && model.getBordPosition(1,1)=="O" && model.getBordPosition(2,2)=="O") ) 
			return true;
		else if((model.getBordPosition(0,2)=="X" && model.getBordPosition(1,1)=="X" && model.getBordPosition(2,0)=="X") ||(model.getBordPosition(0,2)=="O" && model.getBordPosition(1,1)=="O" && model.getBordPosition(2,0)=="O") ) 
			return true;
		else if((model.getBordPosition(0,2)=="X" && model.getBordPosition(1,2)=="X" && model.getBordPosition(2,2)=="X") ||(model.getBordPosition(0,2)=="O" && model.getBordPosition(1,2)=="O" && model.getBordPosition(2,2)=="O") ) 
			return true;
		else if((model.getBordPosition(0,1)=="X" && model.getBordPosition(1,1)=="X" && model.getBordPosition(2,1)=="X") ||(model.getBordPosition(0,1)=="O" && model.getBordPosition(1,1)=="O" && model.getBordPosition(2,1)=="O") )
			return true;
		else if((model.getBordPosition(2,0)=="X" && model.getBordPosition(2,1)=="X" && model.getBordPosition(2,2)=="X") ||(model.getBordPosition(2,0)=="O" && model.getBordPosition(2,1)=="O" && model.getBordPosition(2,2)=="O") ) 
			return true;
		else if((model.getBordPosition(1,0)=="X" && model.getBordPosition(1,1)=="X" && model.getBordPosition(1,2)=="X") ||(model.getBordPosition(1,0)=="O" && model.getBordPosition(1,1)=="O" && model.getBordPosition(1,2)=="O") ) 
			return true;
		else if((model.getBordPosition(0,0)=="X" && model.getBordPosition(1,0)=="X" && model.getBordPosition(2,0)=="X") ||(model.getBordPosition(0,0)=="O" && model.getBordPosition(1,0)=="O" && model.getBordPosition(2,0)=="O") ) 
			return true;
		else if((model.getBordPosition(0,0)=="X" && model.getBordPosition(0,1)=="X" &&  model.getBordPosition(0,2)=="X") ||(model.getBordPosition(0,0)=="O" && model.getBordPosition(0,1)=="O" && model.getBordPosition(0,2)=="O") ) 
			return true;
		else
			return false;
	}
	/**
	 * @author pthakker
	 */
	@Override
	public void chkGameEnd() {
		if(model.gameOver()) {
			if(!checkWin()) {
				view.matchDraw();
				model.getActivePlayer().setScore(1);
				model.getInActivePlayer().setScore(1);
				if(model.setHighscore(model.getActivePlayer().getScore())) {
					view.setHScore(model.getHighscore());
					
				}
			}
			else {
				model.getActivePlayer().setScore(2);
				view.win(model.getActivePlayer().getName());
				model.resetGame();
				model.startGame(model.getInActivePlayer());
			}
			model.resetGame();
			model.startGame(model.getInActivePlayer());

		}else if(checkWin()) {
			model.getActivePlayer().setScore(2);
			view.win(model.getActivePlayer().getName());
			if(model.setHighscore(model.getActivePlayer().getScore())) {
				view.setHScore(model.getHighscore());
				
			}
			model.resetGame();
			model.startGame(model.getInActivePlayer());
		}
//		if(model.setHighscore(model.getActivePlayer().getScore())) {
//			view.setHScore(model.getHighscore());
//			
//		}
		
	}

	@Override
	public boolean isAuto() {
		// TODO Auto-generated method stub
		return model.getPlayer2().isAuto();
	}
	@Override
	public Point chkWinPosibility() {
		return point;
		
	}
	@Override
	public Point chkOppWin(){
		return point;
		
	}


}
