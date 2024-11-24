import java.util.ArrayList;


public class NekoGame {
    private ArrayList<String> moveLogs = new ArrayList<String>();

    public NekoGame(){

    }

     public static void main(String[] args) {
        Engine game = new Engine();
        game.displayScreen("./imgs/neko.png");
        game.startKeyCheckLoop();

       

    }

}