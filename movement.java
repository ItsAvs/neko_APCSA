import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class OptimizedEngineWithDiagonalMovement implements KeyListener {

    private JFrame frame;
    private int length = 1024;
    private int width = 768;
    private int xPosition = 100; // Initial x position
    private int yPosition = 100; // Initial y position
    private JLabel characterLabel;
    private boolean upPressed, downPressed, leftPressed, rightPressed;

    public OptimizedEngineWithDiagonalMovement() {
        initializeFrame();
        initializeCharacter();
    }

    // Initialize the main frame
    private void initializeFrame() {
        frame = new JFrame("Neko Cat Optimized");
        frame.setSize(length, width);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Center the window
        frame.setLayout(null);
        frame.addKeyListener(this);
    }

    // Initialize character representation
    private void initializeCharacter() {
        characterLabel = new JLabel(new ImageIcon("C:\\Users\\800025088\\Downloads\\character.png")); // Predetermined file path
        characterLabel.setBounds(xPosition, yPosition, 50, 50); // Set initial position and size
        frame.add(characterLabel);
        frame.setVisible(true);
    }

    // Handle key events for movement with boundary checks
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP: upPressed = true; break;
            case KeyEvent.VK_DOWN: downPressed = true; break;
            case KeyEvent.VK_LEFT: leftPressed = true; break;
            case KeyEvent.VK_RIGHT: rightPressed = true; break;
        }
        updatePosition();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP: upPressed = false; break;
            case KeyEvent.VK_DOWN: downPressed = false; break;
            case KeyEvent.VK_LEFT: leftPressed = false; break;
            case KeyEvent.VK_RIGHT: rightPressed = false; break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    private void updatePosition() {
        int moveAmount = 5; // Movement increment
        if (upPressed && yPosition > 0) yPosition -= moveAmount; // Move up
        if (downPressed && yPosition < width - 50) yPosition += moveAmount; // Move down
        if (leftPressed && xPosition > 0) xPosition -= moveAmount; // Move left
        if (rightPressed && xPosition < length - 50) xPosition += moveAmount; // Move right

        // Diagonal movement
        if (upPressed && leftPressed && xPosition > 0 && yPosition > 0) {
            xPosition -= moveAmount;
            yPosition -= moveAmount; // Move diagonally up-left
        }
        if (upPressed && rightPressed && xPosition < length - 50 && yPosition > 0) {
            xPosition += moveAmount;
            yPosition -= moveAmount; // Move diagonally up-right
        }
        if (downPressed && leftPressed && xPosition > 0 && yPosition < width - 50) {
            xPosition -= moveAmount;
            yPosition += moveAmount; // Move diagonally down-left
        }
        if (downPressed && rightPressed && xPosition < length - 50 && yPosition < width - 50) {
            xPosition += moveAmount;
            yPosition += moveAmount; // Move diagonally down-right
        }

        characterLabel.setBounds(xPosition, yPosition, 50, 50); // Update character position
    }

    public static void main(String[] args) {
        new OptimizedEngineWithDiagonalMovement();
    }
}
