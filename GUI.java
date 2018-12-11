import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Button;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;

import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class GUI extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textField;
	private GridButtonPanel grid =  new GridButtonPanel();
	private Battleship bs = new Battleship();
	private Player userPlayer = new Player();
	private Player computer = new Player();
	static GUI frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		setTitle("Battleship\r\n");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 789, 574);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		bs.setupComputer(userPlayer);//random ship placement
        
        bs.setupComputer(computer);//random ship placement
      
		
	
		ImageIcon hitIcon = new ImageIcon("___");
		ImageIcon missIcon = new ImageIcon("___");

		Image hit = hitIcon.getImage().getScaledInstance(5,5, java.awt.Image.SCALE_SMOOTH);
		Image miss = missIcon.getImage().getScaledInstance(5,5, java.awt.Image.SCALE_SMOOTH);
		
		
		
		JPanel panel = grid.createGridPanel();
		panel.setBounds(0, 0, 620, 455);
		contentPane.add(panel);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(10, 432, 309, 92);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Points: ");
		lblNewLabel.setBounds(344, 432, 120, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblComputerPoints = new JLabel("Computer Points:");
		lblComputerPoints.setBounds(488, 436, 120, 14);
		contentPane.add(lblComputerPoints);
		
		JLabel lblToWin = new JLabel("17 to win");
		lblToWin.setBounds(418, 418, 46, 14);
		contentPane.add(lblToWin);
		 for (int i = 0; i < 10 * 10; i++) {
	            int row = i / 10;
	            int col = i % 10;
	            JToggleButton gb = grid.getGridButton(row, col);
	            gb.addActionListener(this);
		 }
	}
	
	@Override
	public void actionPerformed(ActionEvent e) { 
		System.out.println("yes");
		Object source = e.getSource(); // source is button pressed
		//Image hit = ;
		//Image miss = ;
		
        JToggleButton btn = grid.getGridButton(grid.getRow(source),grid.getCol(source));
        btn.setEnabled(false);
        String result = "";
        String compResult = "";
      
          
         
            result = bs.askForGuess(userPlayer, computer,grid.getRow(source),grid.getCol(source));
            System.out.println(result); // add to textField 
		
	    if(result = "HIT") 
	   	 btn.setImage(hit);
	    else
		 btn.setImagae(miss);
         
		
            if (computer.playerGrid.hasLost())
            {
                System.out.println("HIT!...COMPUTER LOSES"); //add to textField
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                
            }
            
            System.out.println("\nCOMPUTER IS MAKING GUESS..."); //add to textField
              
              
            compResult = bs.compMakeGuess(computer, userPlayer);
            //add time delay
            System.out.println(compResult); //add to textField
            
	    if(compResult = "HIT") 
	        btn.setImage(hit);
	    else
	    	btn.setImagae(miss);
		
		
            if (userPlayer.playerGrid.hasLost())
            {
                System.out.println("COMPUTER HITS!...USER LOSES"); //add to textField
                //add time delay
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                
            }
            
        }
        
	}

