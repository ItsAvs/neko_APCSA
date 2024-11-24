import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Engine implements KeyListener {

    private JFrame frame;
    private JLabel textLabel;
    private int lastPressedKey = -1; 
    private BackgroundPanel backgroundPanel;
    private final int initialLength = 1024;
    private final int initialWidth = 768;

    public Engine() {
        initializeFrame();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
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
        lastPressedKey = e.getKeyCode(); // Store the last pressed key
    }

    // Method to get the last pressed key
     public int getLastPressedKey() {
        return lastPressedKey;
    }

    public void isEnterPressed(){
        int key;
        while (true) {
            key = getLastPressedKey(); 
            if (key != -1 && KeyEvent.getKeyText(key).equals(KeyEvent.VK_ENTER)) { 
                System.out.println("Enter pressed");
            }

            try {
                Thread.sleep(100); // Add a small delay to avoid busy-waiting (100ms)
            } catch (InterruptedException e) {
            }
        }
    }
    

}
