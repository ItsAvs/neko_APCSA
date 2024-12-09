import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;
import javax.swing.*;


public class Engine implements KeyListener {

    private JFrame frame;
    private JLabel textLabel;
    private boolean enterPressed = false; // Track if Enter was pressed
    private boolean one = false;
    private boolean two = false;
    private boolean three = false;
    private BackgroundPanel backgroundPanel;
    private final int initialLength = 1024;
    private final int initialWidth = 768;
    private Clip audioClip;

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
        textLabel.setForeground(Color.BLUE);
        textLabel.setFont(new Font("Arial", Font.BOLD, 20));
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

    public void displayPlayerHealth(int health){

    }

    public void displayEnemyHealth(int health){

    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        // When Enter is pressed, set the flag to true
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            enterPressed = true;
        }

        else if (e.getKeyCode() == KeyEvent.VK_1) {
            one = true;
        }

        else if (e.getKeyCode() == KeyEvent.VK_2) {
            two = true;
        }

        else if (e.getKeyCode() == KeyEvent.VK_3) {
            three = true;
        }
    }


    // Reset the Enter pressed flag
    public void resetEnterPressed() {
        enterPressed = false;
    }

    // Main game loop or logic for checking Enter press
    public int startKeyCheckLoop() {
        while (true) {
            if (enterPressed) {
                System.out.println("Enter pressed");
                resetEnterPressed(); // Reset after checking
                return -1;
            }

            else if (one){
                System.out.println("1");
                one = false;
                return 1;

            }

            else if (two){
                System.out.println("2");
                two = false;
                return 2;
            }

            else if (three){
                System.out.println("3");
                three = false;
                return 3;
            }

            try {
                Thread.sleep(100); // Delay to avoid busy-waiting (100ms)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }



    public void playMusic(String filePath, int durationInSeconds, boolean loop, double volumePercent) {
        try {
            // Load the audio file
            File audioFile = new File(filePath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);

    
            // Get a Clip to play the audio
            audioClip = AudioSystem.getClip();
            audioClip.open(audioStream);
            FloatControl volumeControl = (FloatControl) audioClip.getControl(FloatControl.Type.MASTER_GAIN);

    
            if (loop) {
                // Loop continuously
                audioClip.loop(Clip.LOOP_CONTINUOUSLY);
            } else {
                // Play once
                audioClip.loop(0);
            }
    
            // Start playing the audio
            audioClip.start();
            volumeControl.setValue((int) (volumeControl.getMaximum() * volumePercent));
            
    
            // Create a separate thread to stop the audio after the specified duration
            new Thread(() -> {
                try {
                    Thread.sleep(durationInSeconds * 1000); // Convert seconds to milliseconds
                    audioClip.stop();
                    audioClip.close(); // Release resources
                } catch (InterruptedException e) {
                    System.out.println("Error while stopping the audio.");
                }
            }).start();
    
        } catch (UnsupportedAudioFileException e) {
            System.out.println("The specified audio file is not supported.");
        } catch (IOException e) {
            System.out.println("Error occurred while playing the audio.");
        } catch (LineUnavailableException e) {
            System.out.println("Audio line is unavailable.");
        }
    }

    public void stopMusicWithFadeOut(String filePath, int fadeDurationMs) {
        if (audioClip != null && audioClip.isRunning()) {
            try {
                // Get the volume control
                FloatControl volumeControl = (FloatControl) audioClip.getControl(FloatControl.Type.MASTER_GAIN);
    
                // Determine the number of steps and volume decrement per step
                int steps = 50; // Number of fade steps
                float volumeDecrement = volumeControl.getMaximum() / steps;
    
                for (int i = 0; i < steps; i++) {
                    float newVolume = volumeControl.getValue() - volumeDecrement;
                    if (newVolume < volumeControl.getMinimum()) {
                        newVolume = volumeControl.getMinimum(); // Ensure volume doesn't go below the minimum
                    }
                    volumeControl.setValue(newVolume);
    
                    // Pause between steps to create the fade effect
                    Thread.sleep(fadeDurationMs / steps);
                }
    
                // Stop and close the clip after the fade-out
                audioClip.stop();
                audioClip.close();
            } catch (Exception e) {
                System.out.println("Error during fade-out: " + e.getMessage());
            }
        }
    }

    public static void delay(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            System.out.println("Sleep interrupted: " + e.getMessage());
            Thread.currentThread().interrupt(); // Preserve the interrupted status
        }

    }

    public void displayVideo(String file){

    }


}
    
    

    


