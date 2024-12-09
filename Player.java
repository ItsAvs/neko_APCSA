import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class Player extends Enemy {

    private JFrame frame; 
    private ArrayList<Ability> abilities;
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
        frame.addComponentListener(new ComponentAdapter() {
        });

        frame.setVisible(true);
        frame.requestFocus();
    }


    public String makeMove(Enemy enemy, Engine game) {
        Ability chosenAbility = null;
        int buttonPressed = game.startKeyCheckLoop();
        int damage = -1;

        while (chosenAbility == null || buttonPressed == -1 || damage == -1){
            buttonPressed = game.startKeyCheckLoop();

            if (buttonPressed == 1){
                chosenAbility = abilities.get(0);
                System.out.println("1");
            }

            else if (buttonPressed == 2){
                chosenAbility = abilities.get(1);
                System.out.println("2");
            }

            else if (buttonPressed == 3){
                chosenAbility = abilities.get(2);
                System.out.println("3");
            }

            if (chosenAbility != null){
                damage = chosenAbility.use();
            }


        }

        System.out.println(("Nemo uses " + chosenAbility.getName() + "!"));
        enemy.takeDamage(damage);
        System.out.println((enemy.getName() + " takes " + damage + " damage!"));
    

            


        return chosenAbility.getName();
        
        
    }
}
