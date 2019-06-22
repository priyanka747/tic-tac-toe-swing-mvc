package tictactoe.view;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import javax.swing.SwingConstants;
/**
 * 
 * @author pthakker
 *
 */
public class Splashscreen extends JWindow {

	private JProgressBar progressBar=new JProgressBar(0,100);
	private int val= 0;
	public Splashscreen() {
		Font smallFont=new Font("Arial Bold",Font.ITALIC,15);
		Font bigFont=new Font("Arial Bold",Font.ITALIC,25);
		JLabel welcomeLabel=new JLabel("welcome to");
		welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel gameLabel=new JLabel("TIC-TAC-TOE");
		gameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		gameLabel.setFont(bigFont);
		
		JLabel copyLabel=new JLabel("version 1.0   copyright 2019    Friends and Co.");
		copyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		copyLabel.setFont(smallFont);
		
		JLabel loadinLabel=new JLabel("loading.....");
		loadinLabel.setHorizontalAlignment(SwingConstants.CENTER);
		loadinLabel.setFont(smallFont);
		
		JLabel perLabel=new JLabel("0");
		perLabel.setHorizontalAlignment(SwingConstants.CENTER);
		perLabel.setFont(new Font("Arial",Font.ITALIC,30));
		
		progressBar.setBounds(0, 150, 300, 2);
		
		Container c=getContentPane();
		c.setLayout(new GridLayout(7,1,10,10));
		c.add(welcomeLabel);
		c.add(gameLabel);
		c.add(copyLabel);
		c.add(loadinLabel);
		c.add(perLabel);
		c.add(progressBar);
		setBounds(500, 285, 550, 300);
		setLocationRelativeTo(null);
		setVisible(true);
		
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				try {
					while(!(val==100)) {
						
						Thread.sleep(50);
						val++;
						perLabel.setText(val+"%");
						progressBar.setValue(val);
				}
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				finally{
					dispose();
					new SetupWindow();
				}
				
			}
		});
		t.start();
	}
	
	
}
