

public class NekoGame {

    public NekoGame(){

    }

    private void levelOne(){}

    private void levelTwo(){}

    private void levelThree(){}

     public static void main(String[] args) {
        Engine game = new Engine();
        game.playMusic("./audios/start_music.wav", 120, true, 1);
        game.displayScreen("./imgs/start_screen.png");
        game.startKeyCheckLoop(); //check if enter pressed
        game.stopMusicWithFadeOut("./audios/konekonoosanpo.wav", 500);

        //First cutscene: introduction to cafe
        game.playMusic("./audios/typing.wav", 3, false, 0.01);
        game.displayScreen("./imgs/1.gif");
        game.playMusic("./audios/cut_scenes.wav", 120, true,1);
        game.displayScreen(null);


        
        //display level 

        



       

    }

}