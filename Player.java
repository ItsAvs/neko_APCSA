import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class Player extends Enemy {

    private JFrame frame; 
    private ArrayList<Ability> abilities;
    private int keyCode;
    private String name;

    public Player(String name, int health) {
        super(name, health);
        this.abilities = new ArrayList<>();
        this.name = name;
        setupKeyListener();
    }

    public void addAbility(String name, int minDamage, int maxDamage, int cooldown, double failureChance) {
        abilities.add(new Ability(name, minDamage, maxDamage, cooldown, failureChance));
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

        while (chosenAbility == null){

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
