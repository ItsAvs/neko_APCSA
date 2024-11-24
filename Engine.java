import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class Engine implements KeyListener{

    private JFrame frame;
    private JLabel textLabel;
    private JLabel backgroundLabel;
    private final int length = 1024;
    private final int width = 768;


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

        // Add the background label
        backgroundLabel = new JLabel();
        backgroundLabel.setBounds(0, 0, length, width);
        frame.add(backgroundLabel);

        // Add the text label
        textLabel = new JLabel();
        textLabel.setBounds(50, 10, 240, 30);
        textLabel.setForeground(Color.BLUE);
        textLabel.setFont(new Font("Arial", Font.BOLD, 16));
        frame.add(textLabel);

        frame.setVisible(true); 
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
        textLabel.setText(text); // Update the existing text label
        frame.repaint(); // Ensure updates are visible
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