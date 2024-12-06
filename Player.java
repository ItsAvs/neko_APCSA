import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class Player extends Enemy {

    private JFrame frame; 
    private ArrayList<Ability> abilities;
    private int keyCode;

    public Player(String name, int health) {
        super(name, health);
        this.abilities = new ArrayList<>();
        addAbility("Scratch", 15, 25, 2, 0.2);
        addAbility("Bite", 10, 15, 1, 0.1);
        addAbility("Pounce", 0, 10, 0, 0.05);
        setupKeyListener();
    }

    private void setupKeyListener() {
        frame = new JFrame("Player Input");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setFocusable(true);

        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                keyCode = e.getKeyCode();
            }
        });

        frame.setVisible(true);
        frame.requestFocus();
    }


    public String makeMove(Enemy enemy, Engine game) {
        Ability chosenAbility = null;

        switch (keyCode) {
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
                
        }

        if (chosenAbility != null) {
            int damage = chosenAbility.use();
            System.out.println(("Nemo uses " + chosenAbility.getName() + "!"));

            if (damage == -1) {
                System.out.println("Nemo skips the turn because of cooldown.");
            } else {
                enemy.takeDamage(damage);
                System.out.println((enemy.getName() + " takes " + damage + " damage!"));
            }

            
        }

        keyCode = 0; // Reset keyCode after processing

        return chosenAbility.getName();
        
        
    }
}
