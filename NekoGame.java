import java.util.ArrayList;


public class NekoGame {
    private ArrayList<String> moveLogs = new ArrayList<String>();

    public NekoGame(){

    }

    private void levelOne(){}

    private void levelTwo(){}

    private void levelThree(){}

     public static void main(String[] args) {
        Engine game = new Engine();
        game.displayScreen("./imgs/neko.png");
        game.startKeyCheckLoop(); //check if enter pressed
        game.displayText("damage: 0"); 

       

    }

}