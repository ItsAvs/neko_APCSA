import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class nekoGame {

    private JFrame frame;

    // Constructor to initialize the game
    public nekoGame() {
        initializeFrame();
        showStartScreen();
    }

    // Initialize the main frame
    private void initializeFrame() {
        frame = new JFrame("Game");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Center the window
        frame.setLayout(new BorderLayout());
    }

    // Method to display the start screen
    private void showStartScreen() {
        // Clear the frame and prepare it for the start screen
        frame.getContentPane().removeAll();

        // Panel for the start screen with background color
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(232, 211, 172));

        // Title label with a fancy font and color
        JLabel label = new JLabel("Welcome to Neko!", SwingConstants.CENTER);
        label.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 24));
        label.setForeground(new Color(33, 23, 16)); // Indigo color
        label.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        panel.add(label, BorderLayout.CENTER);

        // Start button with a custom color and font
        JButton startButton = new JButton("Start Game");
        startButton.setFont(new Font("SansSerif", Font.PLAIN, 18));
        startButton.setBackground(new Color(250, 166, 102));
        startButton.setForeground(Color.BLACK);
        startButton.setFocusPainted(false);
        startButton.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
        startButton.setPreferredSize(new Dimension(150, 40));

        // Add padding around the start button
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(232, 211, 172));
        buttonPanel.add(startButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        // Add an action listener for the start button to proceed to the main game
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGame(); // Proceed to the main game
            }
        });

        frame.add(panel);
        frame.revalidate(); // Refresh frame
        frame.repaint();    // Repaint frame to apply changes
        frame.setVisible(true); // Display the frame
        }

        // Method to start the main game
        private void startGame() {
        System.out.println("Game has started!");

        // Clear the start screen and set up the game environment
        frame.getContentPane().removeAll();

        // Game screen label with updated message
        JLabel gameLabel = new JLabel("Game is now running...", SwingConstants.CENTER);
        gameLabel.setFont(new Font("Serif", Font.BOLD, 18));
        gameLabel.setForeground(new Color(34, 139, 34));
        frame.add(gameLabel, BorderLayout.CENTER);

        frame.revalidate();
        frame.repaint();

        gameLoop();
        }

        // Placeholder for the main game loop
        private void gameLoop() {
        System.out.println("Game loop is running...");
        }

        // Main method to run the game
        public static void main(String[] args) {
        new nekoGame();
        }
        }
