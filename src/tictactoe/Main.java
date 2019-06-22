package tictactoe;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import tictactoe.view.Splashscreen;
/**
 * 
 * @author priyanka thakker
 * programme starts from here
 */
public class Main {
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
//				try 
//				{
//					UIManager.setLookAndFeel(
//							UIManager.getSystemLookAndFeelClassName());
//				}
//				catch (UnsupportedLookAndFeelException | ClassNotFoundException |
//						InstantiationException | IllegalAccessException e) {}
				new Splashscreen();
//				IPlayerModel player1=new PlayerModel();
//				IPlayerModel player2=new PlayerModel();	
//				IGameModel model=new GameModel(player1,player2);
//				IPlayerView view=new PlayerView();
//				IPlayerController controller=new PlayerController(model,view);
//				view.setController(controller);
				
			}
		});
		
	}
	
}
