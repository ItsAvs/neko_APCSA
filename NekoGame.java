

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
        //main player
        Player nemo =  new Player("Nemo",100);
        nemo.addAbility("Scratch", 15, 25, 2, 0.2);
        nemo.addAbility("Bite", 10, 15, 1, 0.1);
        nemo.addAbility("Pounce", 0, 10, 0, 0.05);


        //enemy one 
        Enemy winston = new Enemy("winston", 100);
     winston.addAbility("Scratch", 5, 15, 1, 0.1);
     winston.addAbility("Pounce", 10, 20, 2, 0.15);
     winston.addAbility("Growl", 0, 10, 0, 0.05);
     winston.addAbility("Sword", 10, 15, 3, 0.2);
     winston.addAbility("Avada", 5, 8, 1, 0.15);
     winston.addAbility("TNT", 10, 30, 4, 0.3);

        //enemy 2
        Enemy rosie = new Enemy("rosie", 120);
    

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

        //Fight Scene Starts level One
        game.startKeyCheckLoop();
        game.stopMusicWithFadeOut("./audios/cut_scenes.wav", 0);
        game.playMusic("./audios/fight.wav", 120, true, 1);
        game.displayScreen("./imgs/9.gif");

        game.displayText("Player Health: " + nemo.getHealth());
        game.startKeyCheckLoop();
        game.displayScreen("./imgs/10.gif");
        
        System.out.println("Enemy one is winston");

        String enemyMove = "";
        String playerMove = "";

        while (!(nemo.isDefeated() || winston.isDefeated())){
            game.displayText("Player Turn");;
            playerMove = nemo.makeMove(winston, game);

            if (playerMove.equals("Scratch")){
                game.displayScreen(null);
            }

            else if (playerMove.equals("Bite")){
                game.displayScreen(null);
            }

            else if (playerMove.equals("Pounce")){
                game.displayScreen(null);
            }


            game.displayText("Enemy Turn");
            enemyMove = winston.makeMove(nemo, game);
            if (enemyMove.equals("Scratch")){
                game.displayScreen(null);
            }

            else if (enemyMove.equals("Pounce")){
                game.displayScreen(null);
            }

            else if (enemyMove.equals("Growl")){
                game.displayScreen(null);
            }

            else if (enemyMove.equals("Sword")){
                game.displayScreen(null);
            }

            else if (enemyMove.equals("Avada")){
                game.displayScreen(null);
            }
            else if (enemyMove.equals("TNT")){
                game.displayScreen(null);
            }

            if  (winston.bossStage() == 1){
                game.displayVideo("");
            }

           

            
            game.displayEnemyHealth(winston.getHealth());
            game.displayPlayerHealth(nemo.getHealth());;


        }

        //handle who wins or loses

        //cut-scene 2
        game.stopMusicWithFadeOut("./audios/fight.wav", 0);
        game.playMusic("./audios/cut_scenes.wav", 120, true, 1.0);
        game.displayScreen("");

        if (winston.isDefeated()){
            //win cut-scene
        }

        else{

        }

        //cut-scene before level 2


        //level two fight
        game.playMusic("./audios/fight.wav",120, true, 1.0);




        


       

    }

}