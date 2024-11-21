import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Engine implements KeyListener{

    private JFrame frame;
    private int length = 1024;
    private int width = 768;
    public Engine (){
        initializeFrame();
    }


    // Initialize the main frame
    private void initializeFrame() {
        frame = new JFrame("Neko Cat");
        frame.addKeyListener(this);
        frame.setSize(length, width);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Center the window
        frame.setLayout(new BorderLayout());
    }

    //display images for backgrounds
    public void displayScreen(String file){
        frame.setSize(length, width);  
        ImageIcon image = new ImageIcon(file);
        frame.add(new JLabel(image));
        frame.pack();
        frame.setVisible(true);  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  

    }

    //Displays text for power, health and more
    public void displayText(String text){
        JLabel label=new JLabel();
		label.setBounds(0,0,500,50);
		frame.add(label);
		label.setText(text);
		frame.setVisible(true);
    }


    public void keyTyped(KeyEvent e) { }

      /** Handle the key-pressed event from the text field. */
      public void keyPressed(KeyEvent e) { }

    /** Handle the key-released event from the text field. */
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER){
            System.out.println("event enter pressed");
        }
    }
}