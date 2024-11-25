import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Engine implements KeyListener {

    private JFrame frame;
    private JLabel textLabel;
    private boolean enterPressed = false; // Track if Enter was pressed
    private BackgroundPanel backgroundPanel;
    private final int initialLength = 1024;
    private final int initialWidth = 768;

    public Engine() {
        initializeFrame();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // You can handle other key releases here if needed
    }

    // Custom panel to handle scaling the background image
    private class BackgroundPanel extends JPanel {
        private Image backgroundImage;

        public void setBackgroundImage(ImageIcon imageIcon) {
            this.backgroundImage = imageIcon.getImage();
            repaint(); // Redraw the panel when the image changes
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (backgroundImage != null) {
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this); // Scale image
            }
        }
    }

    // Initialize the main frame
    private void initializeFrame() {
        frame = new JFrame("Neko Cat");
        frame.addKeyListener(this);
        frame.setSize(initialLength, initialWidth);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Center the window
        frame.setLayout(null); // Use absolute positioning

        // Create and add the background panel
        backgroundPanel = new BackgroundPanel();
        backgroundPanel.setBounds(0, 0, initialLength, initialWidth);
        backgroundPanel.setLayout(null); // Allow components to be added with absolute positioning
        frame.add(backgroundPanel);

        // Add the text label
        textLabel = new JLabel();
        textLabel.setBounds(10, 10, 300, 30); // Top-left corner
        textLabel.setForeground(Color.RED);
        textLabel.setFont(new Font("Arial", Font.BOLD, 16));
        backgroundPanel.add(textLabel);

        // Add a ComponentListener to resize components when the frame is resized
        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                // Resize the background and adjust text position if necessary
                backgroundPanel.setBounds(0, 0, frame.getWidth(), frame.getHeight());
                textLabel.setBounds(10, 10, 300, 30); // Optional: Adjust if you need relative positioning
                backgroundPanel.repaint();
            }
        });

        frame.setVisible(true);
    }

    // Display images for backgrounds
    public void displayScreen(String file) {
        ImageIcon imageIcon = new ImageIcon(file);
        backgroundPanel.setBackgroundImage(imageIcon); // Set the background image dynamically
    }

    // Displays text for power, health, and more
    public void displayText(String text) {
        textLabel.setText(text); // Update the existing text label
        frame.repaint(); // Ensure updates are visible
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        // When Enter is pressed, set the flag to true
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            enterPressed = true;
        }
    }

    // Method to check if Enter was pressed
    public boolean isEnterPressed() {
        return enterPressed;
    }

    // Reset the Enter pressed flag
    public void resetEnterPressed() {
        enterPressed = false;
    }

    // Main game loop or logic for checking Enter press
    public void startKeyCheckLoop() {
        while (true) {
            if (isEnterPressed()) {
                System.out.println("Enter pressed");
                resetEnterPressed(); // Reset after checking
                return;
            }

            try {
                Thread.sleep(100); // Delay to avoid busy-waiting (100ms)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void turnOccurs(){
        //Player's turn 
    }

    //player does their turn
    private void playerTurn(){
        /*
         * certain keypresses trigger certain attacks
         */
    }

    private void enemyTurn(){

    }

    
}

