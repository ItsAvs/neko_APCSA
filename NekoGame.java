

public class NekoGame {

    public NekoGame(){

    }

    public static boolean levelOne(Engine game, Player nemo, Enemy winston){
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
                game.displayScreen("./imgs/imgs/rosie_attack.gif");
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

        return winston.isDefeated();
    }

    public static boolean levelTwo(Engine game, Player nemo, Enemy rosie){
            game.startKeyCheckLoop();
            game.stopMusicWithFadeOut("./audios/cut_scenes.wav", 0);
            game.playMusic("./audios/fight.wav", 120, true, 1);
            game.displayScreen("./imgs/.gif");
    
            game.displayText("Player Health: " + nemo.getHealth());
            game.startKeyCheckLoop();
            game.displayScreen("./imgs/10.gif");
            
            System.out.println("Enemy one is winston");
    
            String enemyMove = "";
            String playerMove = "";
    
            while (!(nemo.isDefeated() || rosie.isDefeated())){

            }

        return rosie.isDefeated();
    }

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
        rosie.addAbility("Claw Swipe", 15, 25, 3, 0.2);
        rosie.addAbility("Furious Charge", 20, 30, 4, 0.25);
        rosie.addAbility("Intimidate", 0, 5, 1, 0.1);
    
        //start game
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
        boolean fightWon = levelOne(game, nemo, winston);
        
        //cut-scene 2
        game.stopMusicWithFadeOut("./audios/fight.wav", 0);
        game.playMusic("./audios/cut_scenes.wav", 120, true, 1.0);
        game.displayScreen("");

        if (fightWon){
            //win cut-scene
        }

        else{
            //lose cut scene
            game.displayScreen("./imgs/30.gif");

            game.startKeyCheckLoop();
            game.displayScreen("./imgs/31.gif");

            game.startKeyCheckLoop();
            game.displayScreen("./imgs/32.gif");

            game.startKeyCheckLoop();
            game.displayScreen("./imgs/33.gif");

            game.startKeyCheckLoop();
            game.displayScreen("./imgs/34.gif");

            game.startKeyCheckLoop();
            game.displayScreen("./imgs/36.gif");
        }

        //cut-scene before level 2
        fightWon = levelTwo(game, nemo, rosie);


        //level two fight
        game.playMusic("./audios/fight.wav",120, true, 1.0);
        game.displayScreen("");




        


       

    }

}
