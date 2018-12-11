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

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Button;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.util.concurrent.TimeUnit;

import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class GUI extends JFrame implements ActionListener {

	private JPanel contentPane;
	private GridButtonPanel grid =  new GridButtonPanel();
	private Battleship bs = new Battleship();
	private Player userPlayer = new Player();
	private Player computer = new Player();
	private JLabel lblNewLabel;
	private JLabel lblComputerPoints;
	Image hit;
	Image miss;
	ImageIcon hitIcon;
	ImageIcon missIcon;
	JTextArea textArea = new JTextArea();
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
		setBounds(100, 100, 636, 564);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		bs.setupComputer(userPlayer);//random ship placement
        
        bs.setupComputer(computer);//random ship placement
      
		

		 hitIcon = new ImageIcon("D:\\Eclipse\\Battleship\\src\\hit.png");
		 missIcon = new ImageIcon(" D:\\Eclipse\\Battleship\\src\\miss.png");

		 	hit = hitIcon.getImage().getScaledInstance(5,5, java.awt.Image.SCALE_SMOOTH);
		 	miss = missIcon.getImage().getScaledInstance(5,5, java.awt.Image.SCALE_SMOOTH);
		
		
		JPanel panel = grid.createGridPanel();
		panel.setBounds(0, 0, 620, 455);
		contentPane.add(panel);
		
		lblNewLabel = new JLabel("Points: " + computer.oppGrid.getPoints());
		lblNewLabel.setBounds(343, 467, 120, 23);
		contentPane.add(lblNewLabel);
		
		lblComputerPoints = new JLabel("Computer Points: " + userPlayer.oppGrid.getPoints());
		lblComputerPoints.setBounds(343, 498, 120, 14);
		contentPane.add(lblComputerPoints);
		
		JLabel lblToWin = new JLabel("17 points to win; 5 ships; Lengths: 2,3,3,4,5");
		lblToWin.setBounds(343, 454, 267, 14);
		contentPane.add(lblToWin);
		
		
		textArea.setEditable(false);
		//textArea.setBounds(10, 459, 323, 66);
		//contentPane.add(textArea);
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(10,459,323,66);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		contentPane.add(scrollPane);
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
            lblNewLabel.setText("Points: " + userPlayer.oppGrid.getPoints());
            textArea.append("\n" +result + " at " + grid.getRow(source) + ", "  + grid.getCol(source)); // add to textField 
        	
    	    if(result == "HIT") 
    	   	 btn.setIcon(hitIcon);
    	    else
    		 btn.setIcon(missIcon);
         
            if (computer.playerGrid.hasLost())
            {
            	   textArea.append( "\n" + "HIT!...COMPUTER LOSES"); //add to textField
                try {
					TimeUnit.SECONDS.sleep(6);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                
            }
            
            textArea.append("\nCOMPUTER IS MAKING GUESS..."); //add to textField
              
              
            compResult = bs.compMakeGuess(computer, userPlayer);
            lblComputerPoints.setText("Computer Points: " + computer.oppGrid.getPoints());
            textArea.append( "\n" + compResult); //add to textField
            
            if (userPlayer.playerGrid.hasLost())
            {
            	   textArea.append( "\nCOMPUTER HITS!...USER LOSES"); //add to textField
                try {
					TimeUnit.SECONDS.sleep(6);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                
            }
            
        }
	}

