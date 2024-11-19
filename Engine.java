import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Engine {

    private JFrame frame;
    private int length = 1024;
    private int width = 768;
    public Engine (){
        initializeFrame();
    }


    // Initialize the main frame
    private void initializeFrame() {
        frame = new JFrame("Game");
        frame.setSize(length, width);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Center the window
        frame.setLayout(new BorderLayout());
    }

    //display images for backgrounds

    private void displayScreen(String file){
        frame.setSize(length, width);  
        ImageIcon image = new ImageIcon(file);
        frame.add(new JLabel(image));
        frame.pack();
        frame.setVisible(true);  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  

    }

    private boolean isActionDone(ActionListener e){
        return e.actionPerformed(null) == KeyEvent.VK_ENTER;
        
    }
}