package tictactoe.view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import tictactoe.controller.IPlayerController;


public class PlayerView extends JFrame implements IPlayerView {

	private IPlayerController playerController;
	String p1,p2,sign;
	JLabel scorevalueJLabel=new JLabel("0");
	JLabel scorevalueJLabel2=new JLabel("0");
	JLabel hsvalueJLabel=new JLabel("0");
	JLabel namevaluJLabel=new JLabel("");
	JLabel namevaluJLabel2=new JLabel("");
	JLabel signvalueJLabel=new JLabel("'X'");
	JLabel signvalueJLabel2=new JLabel("'O'");
	JLabel infoJLabel=new JLabel("enjoy !!");
	JLabel gameLabel=new JLabel("TIC TAC TOE");
	JButton[][] buttons=new JButton[3][3];
	JButton resetButton=new JButton("Reset");
	JButton exitButton=new JButton("Exit");
	JPanel nJPanel=new JPanel();
	JPanel statsJPanel=new JPanel(new GridLayout(8,2,0,0));
	JPanel mainContainer=(JPanel)getContentPane();
	public PlayerView() {
		super("TIC TAC TOE");
		
		Font labelFont=new Font("Arial Bold",Font.ITALIC , 30);
		Font buttonFont=new Font("Arial Bold",Font.BOLD , 35);
		mainContainer.setBackground(Color.BLACK);
		mainContainer.setForeground(Color.WHITE);
		
		statsJPanel.setBackground(Color.BLACK);
		
		gameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		infoJLabel.setHorizontalAlignment(SwingConstants.CENTER);
		gameLabel.setFont(labelFont);
		/*** game board*/
		nJPanel.setLayout(new GridLayout(3,3));
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				buttons[i][j]=new JButton();
				buttons[i][j].setBackground(Color.BLACK);
				buttons[i][j].setForeground(Color.WHITE);
				buttons[i][j].setFont(buttonFont);
				
				final int x = i;
				final int y = j;
				buttons[i][j].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						playerController.action(x,y);
					}
				});
				nJPanel.add(buttons[i][j]);
			}
		}
		
		/** stats board*/
		JLabel nameJLabel=new JLabel("Player1: ");	
		JLabel nameJLabel2=new JLabel("Player2: ");	
		JLabel signJLabel=new JLabel("Player1's Sign: ");
		JLabel signJLabel2=new JLabel("Player2's Sign: ");
		JLabel scoreJLabel=new JLabel("Score: ");
		JLabel scoreJLabel2=new JLabel("Score: ");
		JLabel highscorescoreJLabel=new JLabel("Highscore: ");
		
		// player 1
		statsJPanel.add(nameJLabel);
		statsJPanel.add(namevaluJLabel);
		statsJPanel.add(signJLabel);
		statsJPanel.add(signvalueJLabel);
		statsJPanel.add(scoreJLabel);
		statsJPanel.add(scorevalueJLabel);
		
		//player 2
		statsJPanel.add(nameJLabel2);
		statsJPanel.add(namevaluJLabel2);
		statsJPanel.add(signJLabel2);
		statsJPanel.add(signvalueJLabel2);
		statsJPanel.add(scoreJLabel2);
		statsJPanel.add(scorevalueJLabel2);
		
		// game stats
		statsJPanel.add(highscorescoreJLabel);
		statsJPanel.add(hsvalueJLabel);
	
		//buttons
		
		statsJPanel.add(resetButton);
		statsJPanel.add(exitButton);
		resetButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				resetBoard();
				playerController.resetGame();
				
			}
		});
		exitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				exit();
			}
		});
		mainContainer.add(gameLabel,BorderLayout.NORTH);
		mainContainer.add(nJPanel,BorderLayout.CENTER);
		mainContainer.add(statsJPanel,BorderLayout.EAST);
		mainContainer.add(infoJLabel,BorderLayout.SOUTH);
		setSize(700,450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	
	@Override
	public void setController(IPlayerController playerController) {
		this.playerController=playerController;
		p1=JOptionPane.showInputDialog("enter name for player1");
				p2=JOptionPane.showInputDialog("enter name for player2");
		playerController.startGame(p1,p2);
				
	}

	@Override
	public void setButtonText(int i,int j,String sign) {
		buttons[i][j].setText(sign);
	}

	@Override
	public void setScore(int scorepone,int scoreptwo) {
		scorevalueJLabel.setText(""+scorepone);
		scorevalueJLabel2.setText(""+scoreptwo);
	}

	@Override
	public void setPlayerOnesSign(String sign) {
		signvalueJLabel.setText(sign);
	}

	@Override
	public void setInfoLabel(String msg) {
		infoJLabel.setText(msg);
	}

	@Override
	public void setPlayerTwosSign(String sign) {
		signvalueJLabel2.setText(sign);
	}
	@Override
	public void exit() {
		int a=JOptionPane.showConfirmDialog(mainContainer,"Are you sure?");  
		if(a==JOptionPane.YES_OPTION){  
		    System.exit(0);  
		}  
	}

	@Override
	public void setNameValueLabel(String player1,String player2) {
		// TODO Auto-generated method stub
		namevaluJLabel.setText(player1);
		namevaluJLabel2.setText(player2);
	}

	@Override
	public void win(String name) {
		JOptionPane.showMessageDialog(this, name + " you win!!");
		resetBoard();
		playerController.resetGame();
	}


	@Override
	public void matchDraw() {
		JOptionPane.showMessageDialog(this, "Hard one.. match tie");
		resetBoard();
		playerController.resetGame();
	}


	@Override
	public void resetBoard() {
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				buttons[i][j].setText("");
			}
		}
	}
}
