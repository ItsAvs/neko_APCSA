import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;


Public class Player extends Enemy{

    public Player(String name, int health, ArrayList<Ability> abilities) {
        super(name, health);
        addAbility("Scratch", 15, 25, 2, 0.2);
        addAbility("Bite", 10, 15, 1, 0.1);
        addAbility("Pounce", 0, 10, 0, 0.05);
    }

    public void addKeyListener() {
        // Assuming a GUI component is available to add the listener
        Engine.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    enterPressed = true;
                }
            }
        });
    }

    public boolean isEnterPressed() {
        return enterPressed;
    }

    public void resetEnterPressed() {
        enterPressed = false;
    }

    @Override
    public void makeMove(Player enemy) {
        while (true) {
            if (isEnterPressed()) {
                System.out.println("Q to Attack");
                System.out.println("1 to Scratch");
                System.out.println("2 to Bite");
                System.out.println("3 to Pounce");

                // Simulating key press for demonstration
                int keyCode = getSimulatedKeyPress(); // Placeholder for actual key press capture
                Ability chosenAbility = null;

                if (keyCode == KeyEvent.VK_Q) {
                    enemy.takeDamage(3);
                } else if (keyCode == KeyEvent.VK_1) {
                    chosenAbility = abilities.get(0);
                } else if (keyCode == KeyEvent.VK_2) {
                    chosenAbility = abilities.get(1);
                } else if (keyCode == KeyEvent.VK_3) {
                    chosenAbility = abilities.get(2);
                }

                if (chosenAbility != null) {
                    int damage = chosenAbility.use();
                    System.out.println("Nemo " + " uses " + chosenAbility.getName() + "!");

                    if (damage == -1) {
                        System.out.println("Nemo " + " skips the turn because of cooldown.");
                    }
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

    private int getSimulatedKeyPress() {
        // This method simulates key press for demonstration purposes
        return KeyEvent.VK_1; // Simulating "Scratch" ability
    }
}
