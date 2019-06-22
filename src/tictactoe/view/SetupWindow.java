package tictactoe.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import tictactoe.controller.IPlayerController;
import tictactoe.controller.PlayerController;
import tictactoe.model.GameModel;
import tictactoe.model.IGameModel;
import tictactoe.model.IPlayerModel;
import tictactoe.model.PlayerModel;
/**
 * 
 * @author pthakker
 *
 */
public class SetupWindow extends JFrame {
	IPlayerModel player1,player2;
	public SetupWindow(){

		Container c=getContentPane();
		JPanel buttonPanel=new JPanel(new GridLayout(1,2,30,20));
		JLabel whoLabel =new JLabel("Choose your Partner....");
		whoLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		whoLabel.setFont(new Font("Arial",Font.BOLD,20));
		JButton computer=new JButton("AI");
		Border border=BorderFactory.createLineBorder(Color.GREEN,2,true);
		
		computer.setBorder(border);
		
		buttonPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

		JButton friend=new JButton("FRIEND");
		friend.setBorder(null);

		JButton startButton=new JButton("START ");
//		friend.setBorder(border);
		
		c.setBackground(Color.BLACK);
		whoLabel.setForeground(Color.WHITE);
		computer.setForeground(Color.BLUE);
		friend.setForeground(Color.BLUE);
		startButton.setBackground(Color.BLACK);
		startButton.setForeground(Color.WHITE);
		buttonPanel.setBackground(Color.BLACK);
		computer.setBackground(Color.BLACK);
		friend.setBackground(Color.BLACK);
		startButton.setBorder(border);
		ActionListener listener=new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource()==computer) {
					friend.setBorder(null);
					computer.setBorder(border);
				}
				else if (e.getSource()==friend) {
					computer.setBorder(null);
					friend.setBorder(border);
				}
				else if(e.getSource()==startButton) {

					if(computer.getBorder()!=null) {
						player1=new PlayerModel(false);
						player2=new PlayerModel(true);	
					}else if (friend.getBorder() != null) {

						player1=new PlayerModel(false);
						player2=new PlayerModel(false);	

					}
					IGameModel model=new GameModel(player1,player2);
					dispose();
					IPlayerView view=new PlayerView();
					IPlayerController controller=new PlayerController(model,view);
					view.setController(controller);
				}

			}
		};
		computer.addActionListener(listener);
		friend.addActionListener(listener);
		startButton.addActionListener(listener);
		((JComponent) c).setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		c.setLayout(new GridLayout(3, 1,20,30));
		c.add(whoLabel);

		buttonPanel.add(computer);
		buttonPanel.add(friend);
		c.add(buttonPanel);
		c.add(startButton);

//		revalidate();
//		repaint();
		setBounds(500, 285, 500, 250);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);
	}
}
