

public class NekoGame {

    public NekoGame(){

    }

    private void levelOne(){}

    private void levelTwo(){}

    private void levelThree(){}

     public static void main(String[] args) {
        Engine game = new Engine();
        game.playMusic("./audios/konekonoosanpo.wav", 120, true);
        game.displayScreen("./imgs/neko.png");
        game.startKeyCheckLoop(); //check if enter pressed
        game.displayText("hiiiii");
        game.stopMusicWithFadeOut("./audios/konekonoosanpo.wav", 500);
        
        //display level 

        



       

    }

}