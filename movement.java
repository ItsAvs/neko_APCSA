import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class AdvancedPlatformerWithBackground extends JPanel implements ActionListener, KeyListener {
    private int playerX = 50;
    private int playerY = 300;
    private int playerWidth = 50;
    private int playerHeight = 50;
    private int velocityY = 0;
    private boolean isJumping = false;
    private Timer timer;
    private int horizontalVelocity = 0;
    private final int ACCELERATION = 3;
    private final int FRICTION = 2;
    private final int MAX_VELOCITY = 25;
    private Image background;

    public AdvancedPlatformerWithBackground() {
        background = new ImageIcon("C:\\Users\\800025088\\Downloads\\character.png").getImage(); // Load background image
        timer = new Timer(20, this);
        timer.start();
        setFocusable(true);
        addKeyListener(this);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, getWidth(), getHeight(), this); // Draw background
        g.setColor(Color.YELLOW);
        g.fillRect(playerX, playerY, playerWidth, playerHeight);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (isJumping) {
            velocityY += 1; // Gravity effect
            playerX += horizontalVelocity;
            playerY += velocityY;
            if (playerY >= 300) { // Ground level
                playerY = 300;
                isJumping = false;
                velocityY = 0;
            }
        }
        playerX += horizontalVelocity;
        applyFriction();
        repaint();
    }

    private void applyFriction() {
        if (horizontalVelocity > 0) {
            horizontalVelocity = Math.max(horizontalVelocity - FRICTION, 0);
        } else if (horizontalVelocity < 0) {
            horizontalVelocity = Math.min(horizontalVelocity + FRICTION, 0);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            horizontalVelocity = Math.max(horizontalVelocity - ACCELERATION, -MAX_VELOCITY);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            horizontalVelocity = Math.min(horizontalVelocity + ACCELERATION, MAX_VELOCITY);
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            if (!isJumping) {
                isJumping = true;
                velocityY = -12; // Increased jump velocity
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT) {
            horizontalVelocity = horizontalVelocity; // Stop horizontal movement
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        JFrame frame = new JFrame("Advanced 2D Platformer with Background");
        AdvancedPlatformerWithBackground game = new AdvancedPlatformerWithBackground();
        frame.add(game);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
