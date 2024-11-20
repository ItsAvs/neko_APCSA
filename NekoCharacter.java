/*
 * Packages that are imported for the game to run
 */
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/*
 * The abstract class that all character including enemies extend to have basic functions. 
 */
public abstract class NekoCharacter {
    private int currentHealth;
    private int powerBar = 0;
    private String name = "";

    public NekoCharacter (String characterName, int maxHealth){
        currentHealth = maxHealth;
        name = characterName;

   } 

   //Visual printed element that is displayed at xPosition and yPostion
   void characterDisplay(){
    

   }

   //Punches nearby enemies and deals 10 points of damage
   void punch(){

   }

   //character can increase current health 
   void heal(int increaseHealth){
    this.currentHealth += increaseHealth;

   }

   //Executes a sound that the character does when attacking
   void attackSound(){

   }



}
