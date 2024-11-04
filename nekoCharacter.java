/*
 * Packages that are imported for the game to run
 */
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/*
 * The abstract class that all character including enemies extend to have basic functions. 
 */
public abstract class nekoCharacter {
    private int currentHealth;
    private int powerBar = 0;
    private String name = "";
    private int xPosition;
    private int yPosition;

    public nekoCharacter (String characterName, int maxHealth, int xPosition, int yPosition){
        currentHealth = maxHealth;
        name = characterName;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
   } 

   //Visual printed element that is displayed at xPosition and yPostion
   void characterDisplay(){
    

   }

   //Punches nearby enemies and deals 10 points of damage
   void punch(){

   }

   //all characters basic movement
   void characterControls(KeyEvent event){
    if (event.getKeyCode() == KeyEvent.VK_UP){

    }

    if (event.getKeyCode() == KeyEvent.VK_DOWN){

    }

    if (event.getKeyCode() == KeyEvent.VK_RIGHT){

    }

    if (event.getKeyCode() == KeyEvent.VK_LEFT){

    }

   }

   //character can increase current health 
   void heal(int increaseHealth){
    this.currentHealth += increaseHealth;

   }

   //Executes a sound that the character does when attacking
   void attackSound(){

   }



}
