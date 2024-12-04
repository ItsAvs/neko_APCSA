

public class NekoGame {

    public NekoGame(){

    }

    private static void levelOne(){
        System.out.println("hiiii");
    }

    private void levelTwo(){}

    private void levelThree(){}

     public static void main(String[] args) {
        Engine game = new Engine();
        Player nemo =  new Player("Nemo",100);
        //enemy one 
        Enemy rosie = new Enemy("Rosie", 100);
        rosie.addAbility("Scratch", 5, 15, 1, 0.1);
        rosie.addAbility("Pounce", 10, 20, 2, 0.15);
        rosie.addAbility("Growl", 0, 10, 0, 0.05);

        //enemy 2
    

        game.playMusic("./audios/start_music.wav", 120, true, 1);
        game.displayScreen("./imgs/start_screen.png");
        game.startKeyCheckLoop(); //check if enter pressed
        game.stopMusicWithFadeOut("./audios/start_music.wav", 500);

        //First cutscene: introduction to cafe
        game.playMusic("./audios/cut_scenes.wav", 120, false,1);
        

        game.displayScreen("./imgs/1.gif");
        
        game.startKeyCheckLoop();
        game.displayScreen("./imgs/2.gif");

        game.startKeyCheckLoop();
        game.displayScreen("./imgs/3.gif");

        game.startKeyCheckLoop();
        game.displayScreen("./imgs/4.gif");

        game.startKeyCheckLoop();
        game.displayScreen("./imgs/5.gif");

        game.startKeyCheckLoop();
        game.displayScreen("./imgs/6.gif");

        game.startKeyCheckLoop();
        game.displayScreen("./imgs/7.gif");

        game.startKeyCheckLoop();
        game.displayScreen("./imgs/8.gif");

        //Fight Scene Starts
        game.startKeyCheckLoop();
        game.stopMusicWithFadeOut("./audios/cut_scenes.wav", 0);
        game.playMusic("./audios/fight.wav", 120, true, 1);
        game.displayScreen("./imgs/9.gif");

        game.displayText("Player Health: " + nemo.getHealth());
        
        System.out.println("Enemy one is Rosie");

        while (!nemo.isDefeated()){
            nemo.makeMove(rosie);
            rosie.makeMove(nemo);
            game.displayText("Player Health: " + nemo.getHealth());

            
        }





        
        
        
        


        
        //display level 

        



       

    }

}