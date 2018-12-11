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
import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class GUI extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textField;
	private GridButtonPanel grid =  new GridButtonPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
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
		
		
	
		
		JPanel panel = grid.createGridPanel();
		panel.setBounds(0, 0, 620, 455);
		contentPane.add(panel);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(10, 432, 309, 92);
		contentPane.add(textField);
		textField.setColumns(10);
		
	   

		

		
		
	}
	public void actionPerformed(ActionEvent e) { 
		Object source = e.getSource(); // source is button pressed
		//Image hit = ;
		//Image miss = ;
		Battleship bs = new Battleship();
		Player userPlayer = new Player();
		bs.setupComputer(userPlayer);//random ship placement
        
        Player computer = new Player();
        bs.setupComputer(computer);//random ship placement
      
        JToggleButton btn = grid.getGridButton(grid.getRow(source),grid.getCol(source));
        String result = "";
        while(true)
        {
            System.out.println(result);
            System.out.println("\nUSER MAKE GUESS:");
            result = bs.askForGuess(userPlayer, computer,grid.getRow(source),grid.getCol(source));
        
            if (computer.playerGrid.hasLost())
            {
                System.out.println("HIT!...COMPUTER LOSES"); // S
                break;
            }
            
            System.out.println("\nCOMPUTER IS MAKING GUESS...");
              
              
            bs.compMakeGuess(computer, userPlayer);
            
            if (userPlayer.playerGrid.hasLost())
            {
                System.out.println("COMPUTER HITS!...USER LOSES");
                break;
            }
        }
	}
}
