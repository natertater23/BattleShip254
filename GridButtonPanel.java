import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JToggleButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class GridButtonPanel {

    private static final int N = 10;
    private final List<JToggleButton> list = new ArrayList<JToggleButton>();

    private JToggleButton getGridButton(int r, int c) {
        int index = r * N + c;
        return list.get(index);
    }

    private JToggleButton createGridButton(final int row, final int col) {
        final JToggleButton b = new JToggleButton( row + "," + col);
        b.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JToggleButton gb = GridButtonPanel.this.getGridButton(row, col);
                System.out.println( row + "," + col);
            }
        });
        return b;
    }

    JPanel createGridPanel() {
        JPanel p = new JPanel(new GridLayout(N, N));
        for (int i = 0; i < N * N; i++) {
            int row = i / N;
            int col = i % N;
            JToggleButton gb = createGridButton(row, col);
            list.add(gb);
            p.add(gb);
        }
        return p;
    }

    void display() {
        JFrame f = new JFrame("Battleship");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(createGridPanel());
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setBounds(100, 100, 789, 574);
    }

  
}
