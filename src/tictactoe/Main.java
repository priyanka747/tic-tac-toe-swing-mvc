package tictactoe;

import javax.swing.SwingUtilities;

import tictactoe.controller.IPlayerController;
import tictactoe.controller.PlayerController;
import tictactoe.model.*;
import tictactoe.view.IPlayerView;
import tictactoe.view.PlayerView;

public class Main {
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
			
				IPlayerModel player1=new PlayerModel();
				IPlayerModel player2=new PlayerModel();	
				IGameModel model=new GameModel(player1,player2);
				IPlayerView view=new PlayerView();
				IPlayerController controller=new PlayerController(model,view);
				view.setController(controller);
				
			}
		});
		
	}
	
}
