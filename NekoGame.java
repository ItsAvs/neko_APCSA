

public class NekoGame {

    public NekoGame(){

    }

    public static boolean levelOne(Engine game, Player nemo, Enemy winston){
        game.startKeyCheckLoop();
        game.stopMusicWithFadeOut("./audios/cut_scenes.wav", 0);
        game.playMusic("./audios/fight.wav", 120, true, 1);
        game.displayScreen("./imgs/9.gif");

        
        game.startKeyCheckLoop();
        game.displayScreen("./imgs/15.gif");
        game.displayText("Player Health: " + nemo.getHealth());
        
        System.out.println("Enemy one is winston");

        String enemyMove = "";
        String playerMove = "";

        while (!(nemo.isDefeated() || winston.isDefeated())){
            game.displayText("Player Turn");
            playerMove = nemo.makeMove(winston, game);

            if (playerMove.equals("Scratch")){
                game.displayScreen("./imgs/1nemo_scratch.gif");
                game.delay(3000);
                game.displayScreen("./imgs/15.gif");
                
            }

            else if (playerMove.equals("Bite")){
                game.displayScreen("./imgs/1nemo_bite.gif");
                game.delay(3000);
                game.displayScreen("./imgs/15.gif");
            }

            else if (playerMove.equals("Pounce")){
                game.displayScreen("./imgs/1nemo_pounce.gif");
                game.delay(3000);
                game.displayScreen("./imgs/15.gif");
            }


            game.displayText("Enemy Turn");
            enemyMove = winston.makeMove(nemo, game);
            if (enemyMove.equals("Scratch")){
                game.displayScreen("./imgs/imgs/winston_scratch.gif");
                game.delay(3000);
                game.displayScreen("./imgs/15.gif");
            }

            else if (enemyMove.equals("Pounce")){
                game.displayScreen("./imgs/1winston_pounce.gif");
                game.delay(3000);
                game.displayScreen("./imgs/15.gif");
            }

            else if (enemyMove.equals("Growl")){
                game.displayScreen("./imgs/winston_growl.gif");
                game.delay(3000);
                game.displayScreen("./imgs/15.gif");
            }

            else if (enemyMove.equals("Sword")){
                game.displayScreen("./imgs/winston_sword");
                game.delay(3000);
                game.displayScreen("./imgs/15.gif");
            }

            else if (enemyMove.equals("Avada")){
                game.displayScreen("./imgs/winston_avada.gif");
                game.delay(3000);
                game.displayScreen("./imgs/15.gif");
            }
            else if (enemyMove.equals("TNT")){
                game.displayScreen("./imgs/winston_TNT.gif");
                game.delay(3000);
                game.displayScreen("./imgs/15.gif");
            }

            if  (winston.bossStage() == 1){
                game.displayText("OH NO! Winston leveled up to boss stage 2!");
                game.delay(3000);
                game.displayScreen("./imgs/15.gif");
            }

           

            
            game.displayEnemyHealth(winston.getHealth());
            game.displayPlayerHealth(nemo.getHealth());
            nemo.reduceCooldowns();
            winston.reduceCooldowns();


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
            game.displayText("Player Turn");
            playerMove = nemo.makeMove(rosie, game);

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
            enemyMove = rosie.makeMove(nemo, game);
            if (enemyMove.equals("Claw Swipe")){
                game.displayScreen("");
            }

            else if (enemyMove.equals("Furious Charge")){
                game.displayScreen(null);
            }

            else if (enemyMove.equals("Intimidate")){
                game.displayScreen(null);
            }

            else if (enemyMove.equals("Box Punch")){
                game.displayScreen(null);
            }

            else if (enemyMove.equals("Fireball")){
                game.displayScreen(null);
            }
            else if (enemyMove.equals("Attack")){
                game.displayScreen(null);
            }

            if  (rosie.bossStage() == 1){
                game.displayVideo("");
            }

        

        
        game.displayEnemyHealth(rosie.getHealth());
        game.displayPlayerHealth(nemo.getHealth());

        }

        return rosie.isDefeated();
    }

    private boolean levelThree(Engine game, Player nemo, Enemy luna){

        return luna.isDefeated();

    }

     public static void main(String[] args) {
        Engine game = new Engine();
        //main player
        Player nemo =  new Player("Nemo",100, game);
        nemo.addAbility("Scratch", 15, 25, 2, 0.2);
        nemo.addAbility("Bite", 10, 15, 1, 0.1);
        nemo.addAbility("Pounce", 0, 10, 0, 0.05);


        //enemy one 
        Enemy winston = new Enemy("winston", 100, game);
        winston.addAbility("Scratch", 5, 15, 1, 0.1);
        winston.addAbility("Pounce", 10, 20, 2, 0.15);
        winston.addAbility("Growl", 0, 10, 0, 0.05);
        //stage 2 abilities
        winston.addAbility("Sword", 10, 15, 3, 0.2);
        winston.addAbility("Avada", 5, 8, 1, 0.15);
        winston.addAbility("TNT", 10, 30, 4, 0.3);

        //enemy 2
        Enemy rosie = new Enemy("rosie", 120, game);
        rosie.addAbility("Claw Swipe", 15, 25, 3, 0.2);
        rosie.addAbility("Furious Charge", 20, 30, 4, 0.25);
        rosie.addAbility("Intimidate", 0, 5, 1, 0.1);
        //stage 2 abilities
        rosie.addAbility("Fireball", 23, 35, 3, 0.3);
        rosie.addAbility("Box Punch", 30, 35, 3, 0.2);
        rosie.addAbility("Attack", 10, 15, 2, 0.1);

        //enemy 3
        Enemy luna = new Enemy("Luna", 150, game);
    
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

        if (fightWon){
            game.displayScreen("./imgs/28.gif");

            game.startKeyCheckLoop();
            game.displayScreen("./imgs/29.gif");

            game.startKeyCheckLoop();
            game.displayScreen("./imgs/30.gif");

            game.startKeyCheckLoop();
            game.displayScreen("./imgs/31.gif");

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
        game.displayScreen("./imgs/41.gif");

        game.startKeyCheckLoop();
        game.displayScreen("./imgs/42.gif");

        game.startKeyCheckLoop();
        game.displayScreen("./imgs/43.gif");

        game.startKeyCheckLoop();
        game.displayScreen("./imgs/44.gif");

        game.startKeyCheckLoop();
        game.displayScreen("./imgs/45.gif");

        game.startKeyCheckLoop();
        game.displayScreen("./imgs/46.gif");

        game.startKeyCheckLoop();
        game.displayScreen("./imgs/47.gif");

        game.startKeyCheckLoop();
        game.displayScreen("./imgs/48.gif");

        game.startKeyCheckLoop();
        game.displayScreen("./imgs/49.gif");

        game.startKeyCheckLoop();
        game.displayScreen("./imgs/50.gif");

        game.startKeyCheckLoop();
        game.displayScreen("./imgs/51.gif");

        game.startKeyCheckLoop();
        game.displayScreen("./imgs/52.gif");

        game.startKeyCheckLoop();
        game.displayScreen("./imgs/53.gif");


        
        //level two fight
        game.stopMusicWithFadeOut("./audios/cut_scenes.wav", 0);
        game.playMusic("./audios/fight.wav",120, true, 1.0);
        game.displayScreen("./imgs/54.gif");
        game.startKeyCheckLoop();
        game.displayScreen("./imgs/54.gif");

        fightWon = levelTwo(game, nemo, rosie);

        if (fightWon){

        }

        else {

        }

        //level 3 cut-scene

        //level 3 fight
        game.playMusic("./audios/fight.wav",120, true, 1.0);
        game.displayScreen("");
        //fightWon = levelThree(game, nemo, luna);




        


       

    }

}
