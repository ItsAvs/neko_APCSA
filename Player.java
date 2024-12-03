import java.util.ArrayList;
import java.util.Random;


public class Player extends Enemy{

    public Player(String name, int health, ArrayList<Ability> abilities){
        super("Nemo", 100);
        addAbility("Scratch", 15, 25, 2, 0.2);
        addAbility("Bite", 10, 15, 1, 0.1);
        addAbility("Pounce", 0, 10, 0, 0.05);

    }


    public String keyPressed(KeyEvent e) {
        return e.getKeyCode;

        
    }

    public boolean isEnterPressed() {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            return true;
        return false;
    }

    @Override
    public void makeMove(Player enemy) {
        

        

        while (true) {
            if (isEnterPressed()) {
                System.out.println("Q to Attack");
                System.out.println("1 to Scratch");
                System.out.println("2 to Bite");
                System.out.println("3 to Pounce");

                if (keyPressed() == KeyEvent.VK_Q){
                    enemy.takeDamage(3);
                }
                else if (keyPressed() == KeyEvent.VK_1){
                    Ability chosenAbility = abilities.get(1);
                }
                else if (keyPressed() == KeyEvent.VK_2){
                    Ability chosenAbility = abilities.get(2);
                }
                else if (keyPressed() == KeyEvent.VK_3){
                    Ability chosenAbility = abilities.get(3);
                }

                
                int damage = chosenAbility.use();
                System.out.println(name + " uses " + chosenAbility.getName() + "!");
                
                if (damage == -1) {
                    System.out.println(name + " skips the turn because of cooldown.");
                }



                resetEnterPressed();
                return;
            }

            try {
                Thread.sleep(100); // Delay to avoid busy-waiting (100ms)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}