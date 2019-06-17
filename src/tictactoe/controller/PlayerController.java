package tictactoe.controller;

import tictactoe.model.IGameModel;
import tictactoe.view.IPlayerView;

public class PlayerController implements IPlayerController {
	IGameModel model;
	IPlayerView view;
	public PlayerController(IGameModel model, IPlayerView view) {
		this.model=model;
		this.view=view;
	}

	@Override
	public void action(int i, int j) {
		if(model.getBordPosition(i, j)==null) {
			model.setBoardPosition(i, j, model.getActivePlayer().getPlayerSign());
			view.setButtonText(i, j, model.getActivePlayer().getPlayerSign());
			model.countMoves();
			if(model.gameOver()) {
				if(!checkWin()) {
					view.matchDraw();
					model.getActivePlayer().setScore(1);
					model.getInActivePlayer().setScore(1);
				}
				model.resetGame();
				model.startGame(model.getInActivePlayer());

			}else if(checkWin()) {
					model.getActivePlayer().setScore(2);
					view.win(model.getActivePlayer().getName());
					model.resetGame();
					model.startGame(model.getInActivePlayer());
			}
			model.changePlayer();
			UpdateScreen(model.getActivePlayer().getName()+"'s turn");
		}
	}
	

	@Override
	public void UpdateScreen(String msg) {
		view.setInfoLabel(msg);//message or notify task performed
		view.setNameValueLabel(model.getActivePlayer().getName(),model.getInActivePlayer().getName());
		view.setPlayerOnesSign(model.getActivePlayer().getPlayerSign());//set sign label
		view.setPlayerTwosSign(model.getInActivePlayer().getPlayerSign());
		view.setScore(model.getActivePlayer().getScore(),model.getInActivePlayer().getScore());//set score
	}

	@Override
	public void resetGame() {
		//		model.resetGame();
		//		model.startGame();
		//		UpdateScreen("game Reset");

	}

	@Override
	public void startGame(String name1,String name2) {

		model.startGame(name1, name2);
		UpdateScreen("game started");
	}

	@Override
	public boolean checkWin() {
		if((model.getBordPosition(0,0)=="X" && model.getBordPosition(1,1)=="X" &&model.getBordPosition(2,2)=="X") ||(model.getBordPosition(0,0)=="O" && model.getBordPosition(1,1)=="O" && model.getBordPosition(2,2)=="O") ) 
			return true;
		else if((model.getBordPosition(0,2)=="X" && model.getBordPosition(1,1)=="X" &&model.getBordPosition(2,0)=="X") ||(model.getBordPosition(0,2)=="O" && model.getBordPosition(1,1)=="O" && model.getBordPosition(2,0)=="O") ) 
			return true;
		else if((model.getBordPosition(0,2)=="X" && model.getBordPosition(1,2)=="X" &&model.getBordPosition(2,2)=="X") ||(model.getBordPosition(0,2)=="O" && model.getBordPosition(1,2)=="O" && model.getBordPosition(2,2)=="O") ) 
			return true;
		else if((model.getBordPosition(0,1)=="X" && model.getBordPosition(1,1)=="X" &&model.getBordPosition(2,1)=="X") ||(model.getBordPosition(0,1)=="O" && model.getBordPosition(1,1)=="O" && model.getBordPosition(2,1)=="O") )
			return true;
		else if((model.getBordPosition(2,0)=="X" && model.getBordPosition(2,1)=="X" &&model.getBordPosition(2,2)=="X") ||(model.getBordPosition(2,0)=="O" && model.getBordPosition(2,1)=="O" && model.getBordPosition(2,2)=="O") ) 
			return true;
		else if((model.getBordPosition(1,0)=="X" && model.getBordPosition(1,1)=="X" &&model.getBordPosition(1,2)=="X") ||(model.getBordPosition(1,0)=="O" && model.getBordPosition(1,1)=="O" && model.getBordPosition(1,2)=="O") ) 
			return true;
		else if((model.getBordPosition(0,0)=="X" && model.getBordPosition(1,0)=="X" &&model.getBordPosition(2,0)=="X") ||(model.getBordPosition(0,0)=="O" && model.getBordPosition(1,0)=="O" && model.getBordPosition(2,0)=="O") ) 
			return true;
		else if((model.getBordPosition(0,0)=="X" && model.getBordPosition(0,1)=="X" &&model.getBordPosition(0,2)=="X") ||(model.getBordPosition(0,0)=="O" && model.getBordPosition(0,1)=="O" && model.getBordPosition(0,2)=="O") ) 
			return true;
		else
			return false;
	}



}
