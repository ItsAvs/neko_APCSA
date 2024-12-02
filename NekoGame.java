

public class NekoGame {

    public NekoGame(){

    }

    private void levelOne(){}

    private void levelTwo(){}

    private void levelThree(){}

     public static void main(String[] args) {
        Engine game = new Engine();
        game.playMusic("./audios/start_music.wav", 120, true);
        game.displayScreen("./imgs/start_screen.png");
        game.startKeyCheckLoop(); //check if enter pressed
        game.stopMusicWithFadeOut("./audios/konekonoosanpo.wav", 500);

        //First cutscene: introduction to cafe
        game.displayScreen("./imgs/screen1.gif");
        game.playMusic("./audios/cut_scenes.wav", 120, true);

        
        //display level 

        



       

    }

}