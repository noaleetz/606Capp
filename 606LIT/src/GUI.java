import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class GUI {
    /**
     * @param args the command line arguments
     */
    
    static JButton [] buttons;
    public static void main(String[] args) {
        int buttonNum = 8;
        int row = 4;
        int col = buttonNum/row;
        
        //Create a window
        //Test comment
        JFrame jf = new JFrame("Press a button to cause every OTHER button to change background color");
        jf.setSize(800,800);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(row, col));
        jf.add(panel);
        
        //Add buttons to the window
        buttons = new JButton [buttonNum];
        for (int i = 0; i < buttonNum; i++) {
            JButton button = new JButton("Button "+(i+1));
            button.addActionListener(new ButtonListener());
            randomBackground(button);
            buttons[i] = button;
            panel.add(button);
        }
        
        jf.setVisible(true);
    }
    
    static void randomBackground(JButton btn){
        //Randomize colors
        Random rand = new Random();
        btn.setBackground(new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256)));
    }
    
    static int findButton(JButton [] buttons, JButton btn) {
        //Find the button
        for (int i = 0; i < buttons.length; i++) {
            if (btn == buttons[i]) return i;
        }
        return -1; //Not found - will never happen
    }
    
    static class ButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton action = (JButton)e.getSource();
            
            int index = findButton(buttons, action);
            if (index == -1) return; //Error checking
            
            for (int i = 0; i < buttons.length; i++) {
                //Change background color for every other button
                if (i != index) randomBackground(buttons[i]);
            }
        }
    }
    
}
