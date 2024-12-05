import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;


public class Player extends Enemy {

    private boolean enterPressed = false;
    private JFrame frame; // Frame to handle key events
    private ArrayList<Ability> abilities;

    public Player(String name, int health) {
        super(name, health);
        addAbility("Scratch", 15, 25, 2, 0.2);
        addAbility("Bite", 10, 15, 1, 0.1);
        addAbility("Pounce", 0, 10, 0, 0.05);

        setupKeyListener(); // Initialize key listener
    }

    private void setupKeyListener() {
        frame = new JFrame("Player Input");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setFocusable(true);

        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    enterPressed = true;
                }
            }
        });

        frame.setVisible(true);
        frame.requestFocus();
    }

    public boolean isEnterPressed() {
        return enterPressed;
    }

    public void resetEnterPressed() {
        enterPressed = false;
    }

    public void makeMove(Enemy enemy, Engine game) {
        while (true) {
                System.out.println("Q to Attack");
                System.out.println("1 to Scratch");
                System.out.println("2 to Bite");
                System.out.println("3 to Pounce");

                int keyCode = getSimulatedKeyPress(); // Placeholder for actual key press
                Ability chosenAbility = null;

                switch (keyCode) {
                    case KeyEvent.VK_Q:
                        enemy.takeDamage(3);
                        game.displayText("Nemo attacks directly for 3 damage!");
                        break;
                    case KeyEvent.VK_1:
                        chosenAbility = abilities.get(0);
                        break;
                    case KeyEvent.VK_2:
                        chosenAbility = abilities.get(1);
                        break;
                    case KeyEvent.VK_3:
                        chosenAbility = abilities.get(2);
                        break;
                    default:
                        System.out.println("Invalid input!");
                        break;
                }

                if (chosenAbility != null) {
                    int damage = chosenAbility.use();
                    game.displayText("Nemo " + " uses " + chosenAbility.getName() + "!");

                    if (damage == -1) {
                        System.out.println("Nemo skips the turn because of cooldown.");
                    } 
                        else {
                        enemy.takeDamage(damage);
                        game.displayText(enemy.getName() + " takes " + damage + " damage!");
                    }

                    return;
                }

                resetEnterPressed();
                

            try {
                Thread.sleep(100); // Delay to avoid busy-waiting (100ms)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



    private int getSimulatedKeyPress() {
        // Simulating "Scratch" ability
        return KeyEvent.VK_1;
    }
}
