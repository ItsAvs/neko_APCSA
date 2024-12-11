

public class NekoGame {

    public NekoGame(){

    }

    public static void levelOne(Engine game, Player nemo, Enemy winston){
        boolean fightWon = false;
        
            while (!fightWon){
            nemo.setHealth(100);
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
                    game.displayScreen("./imgs/nemo1.gif");
                    game.delay(3000);
                    game.displayScreen("./imgs/15.gif");
                    
                }

                else if (playerMove.equals("Bite")){
                    game.displayScreen("./imgs/nemo4.gif");
                    game.delay(3000);
                    game.displayScreen("./imgs/15.gif");
                }

                else if (playerMove.equals("Pounce")){
                    game.displayScreen("./imgs/nemo7.gif");
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
                    game.stopMusicWithFadeOut("./audios/fight.wav",0);
                    game.playMusic("./audios/boss1.wav", 25, false, 1.0);
                    game.displayScreen("./imgs/boss1.gif");
                    game.delay(25000);
                    game.playMusic("./audios/fight.wav", 25, false, 1.0);
                }

            

                
                game.displayEnemyHealth(winston.getHealth());
                game.displayPlayerHealth(nemo.getHealth());
                nemo.reduceCooldowns();
                winston.reduceCooldowns();


            }

            fightWon = winston.isDefeated();
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
                game.displayScreen("./imgs/33.gif");

                game.startKeyCheckLoop();
                game.displayScreen("./imgs/34.gif");

                game.startKeyCheckLoop();
                game.displayScreen("./imgs/35.gif");

                game.startKeyCheckLoop();
                game.displayScreen("./imgs/36.gif");

                game.startKeyCheckLoop();
                game.displayScreen("./imgs/37.gif");

                game.startKeyCheckLoop();
                game.displayScreen("./imgs/38.gif");

                game.startKeyCheckLoop();
                game.displayScreen("./imgs/39.gif");
                game.startKeyCheckLoop();
                nemo.setHealth(100);

            }
        }

    }

    public static void levelTwo(Engine game, Player nemo, Enemy rosie){
        boolean fightWon = false;
            while (!fightWon){
            nemo.setHealth(100);
            game.startKeyCheckLoop();
            game.stopMusicWithFadeOut("./audios/cut_scenes.wav", 0);
            game.playMusic("./audios/fight.wav", 120, true, 1);
            game.displayScreen("./imgs/53.gif");

            game.startKeyCheckLoop();
            game.displayScreen("./imgs/54.gif");
            
            System.out.println("Enemy two is rosie");

            String enemyMove = "";
            String playerMove = "";

            while (!(nemo.isDefeated() || rosie.isDefeated())){
                game.displayText("Player Turn");
                playerMove = nemo.makeMove(rosie, game);

                if (playerMove.equals("Scratch")){
                    game.displayScreen("./imgs/nemo2.gif");
                    game.delay(3000);
                    game.displayScreen("./imgs/54.gif");
                }

                else if (playerMove.equals("Bite")){
                    game.displayScreen("./imgs/nemo5.gif");
                    game.delay(3000);
                    game.displayScreen("./imgs/54.gif");
                }

                else if (playerMove.equals("Pounce")){
                    game.displayScreen("./imgs/nemo6.gif");
                    game.delay(3000);
                    game.displayScreen("./imgs/54.gif");
                }


                game.displayText("Enemy Turn");
                enemyMove = rosie.makeMove(nemo, game);
                if (enemyMove.equals("Claw Swipe")){
                    game.displayScreen("./imgs/rosie_claw.gif");
                    game.delay(3000);
                    game.displayScreen("./imgs/54.gif");
                }

                else if (enemyMove.equals("Furious Charge")){
                    game.displayScreen("./imgs/rosie_charge.gif");
                    game.delay(3000);
                    game.displayScreen("./imgs/54.gif");
                }

                else if (enemyMove.equals("Intimidate")){
                    game.displayScreen("./imgs/rosie_intimidate.gif");
                    game.delay(3000);
                    game.displayScreen("./imgs/54.gif");
                }

                else if (enemyMove.equals("Box Punch")){
                    game.displayScreen("./imgs/rosie_punch.gif");
                    game.delay(3000);
                    game.displayScreen("./imgs/54.gif");
                }

                else if (enemyMove.equals("Fireball")){
                    game.displayScreen("./imgs/rosie_fireball.gif");
                    game.delay(3000);
                    game.displayScreen("./imgs/54.gif");
                }
                else if (enemyMove.equals("Attack")){
                    game.displayScreen("./imgs/rosie_attack.gif");
                    game.delay(3000);
                    game.displayScreen("./imgs/54.gif");
                }

                if  (rosie.bossStage() == 1){
                    game.displayText("OH NO! Rosie leveled up to boss stage 2!");
                    game.delay(3000);
                    game.stopMusicWithFadeOut("./audios/fight.wav",0);
                    game.playMusic("./audios/boss2.wav", 25, false, 1.0);
                    game.displayScreen("./imgs/boss2.gif");
                    game.delay(25000);
                    game.playMusic("./audios/fight.wav", 25, false, 1.0);

                }

            

            
            game.displayEnemyHealth(rosie.getHealth());
            game.displayPlayerHealth(nemo.getHealth());

            }

            fightWon = rosie.isDefeated();
            
            if (fightWon){
                game.displayScreen("./imgs/63.gif");

                game.startKeyCheckLoop();
                game.displayScreen("./imgs/64.gif");

                game.startKeyCheckLoop();
                game.displayScreen("./imgs/65.gif");

                game.startKeyCheckLoop();
                game.displayScreen("./imgs/66.gif");

                game.startKeyCheckLoop();
                game.displayScreen("./imgs/67.gif");

                game.startKeyCheckLoop();
                game.displayScreen("./imgs/68.gif");


            }

            else {
                game.displayScreen("./imgs/69.gif");

                game.startKeyCheckLoop();
                game.displayScreen("./imgs/70.gif");

                game.startKeyCheckLoop();
                game.displayScreen("./imgs/71.gif");

                game.startKeyCheckLoop();
                game.displayScreen("./imgs/72.gif");

                game.startKeyCheckLoop();
                game.displayScreen("./imgs/73.gif");

                game.startKeyCheckLoop();
                game.displayScreen("./imgs/74.gif");
                nemo.setHealth(100);


            }

        }
    }

    private static void levelThree(Engine game, Player nemo, Enemy luna){
        boolean fightWon = false;
        while (!fightWon){
            nemo.setHealth(100);
            game.startKeyCheckLoop();
            game.stopMusicWithFadeOut("./audios/cut_scenes.wav", 0);
            game.playMusic("./audios/fight.wav", 120, true, 1);
            game.displayScreen("./imgs/88.gif");

            game.startKeyCheckLoop();
            game.displayScreen("./imgs/89.gif");
            
            System.out.println("Enemy three is luna");

            String enemyMove = "";
            String playerMove = "";

            while (!(nemo.isDefeated() || luna.isDefeated())){
                game.displayText("Player Turn");
                playerMove = nemo.makeMove(luna, game);

                if (playerMove.equals("Scratch")){
                    game.displayScreen("./imgs/nemo3.gif");
                    game.delay(3000);
                    game.displayScreen("./imgs/89.gif");
                }

                else if (playerMove.equals("Bite")){
                    game.displayScreen("./imgs/nemo6.gif");
                    game.delay(3000);
                    game.displayScreen("./imgs/89.gif");
                }

                else if (playerMove.equals("Pounce")){
                    game.displayScreen("./imgs/nemo9.gif");
                    game.delay(3000);
                    game.displayScreen("./imgs/89.gif");
                }


                game.displayText("Enemy Turn");
                enemyMove = luna.makeMove(nemo, game);
                if (enemyMove.equals("Arrow")){
                    game.displayScreen("./imgs/luna_arrow.gif");
                    game.delay(3000);
                    game.displayScreen("./imgs/89.gif");
                }

                else if (enemyMove.equals("Banana")){
                    game.displayScreen("./imgs/luna_banana.gif");
                    game.delay(3000);
                    game.displayScreen("./imgs/89.gif");
                }

                else if (enemyMove.equals("Eagle")){
                    game.displayScreen("./imgs/luna_eagle.gif");
                    game.delay(3000);
                    game.displayScreen("./imgs/89.gif");
                }

                else if (enemyMove.equals("Hypnotize")){
                    game.displayScreen("./imgs/luna_hypnotize.gif");
                    game.delay(3000);
                    game.displayScreen("./imgs/89.gif");
                }

                else if (enemyMove.equals("Storm")){
                    game.displayScreen("./imgs/luna_storm.gif");
                    game.delay(3000);
                    game.displayScreen("./imgs/89.gif");
                }
                else if (enemyMove.equals("Watergun")){
                    game.displayScreen("./imgs/luna_watergun.gif");
                    game.delay(3000);
                    game.displayScreen("./imgs/89.gif");
                }

                if  (luna.bossStage() == 1){
                    game.displayText("OH NO! Luna leveled up to boss stage 2!");
                    game.delay(3000);
                    game.stopMusicWithFadeOut("./audios/fight.wav",0);
                    game.playMusic("./audios/boss3.wav", 25, false, 1.0);
                    game.displayScreen("./imgs/boss3.gif");
                    game.delay(25000);
                    game.playMusic("./audios/fight.wav", 25, false, 1.0);
                
                }

            

            
            game.displayEnemyHealth(luna.getHealth());
            game.displayPlayerHealth(nemo.getHealth());

            }

            fightWon = luna.isDefeated();
            
            if (fightWon){
                game.displayScreen("./imgs/98.gif");

                game.startKeyCheckLoop();
                game.displayScreen("./imgs/99.gif");

                game.startKeyCheckLoop();
                game.displayScreen("./imgs/100.gif");

                game.startKeyCheckLoop();
                game.displayScreen("./imgs/101.gif");

                game.startKeyCheckLoop();
                game.displayScreen("./imgs/102.gif");

                game.startKeyCheckLoop();
                game.displayScreen("./imgs/103.gif");

                game.startKeyCheckLoop();
                game.displayScreen("./imgs/104.gif");

                game.startKeyCheckLoop();
                game.displayScreen("./imgs/105.gif");

                game.startKeyCheckLoop();
                game.displayScreen("./imgs/106.gif");

                game.startKeyCheckLoop();
                game.displayScreen("./imgs/107.gif");

                game.startKeyCheckLoop();
                game.displayScreen("./imgs/108.gif");

                game.startKeyCheckLoop();
                
                game.playMusic("./audios/start_music.wav", 120, true, 1.0);
                game.displayScreen("./imgs/109.gif");
                game.stopMusicWithFadeOut("./audios/start_music.wav", 0);

                game.startKeyCheckLoop();
                return;

            }

            else {
                game.displayScreen("./imgs/111.gif");

                game.startKeyCheckLoop();
                game.displayScreen("./imgs/112.gif");

                game.startKeyCheckLoop();
                game.displayScreen("./imgs/113.gif");

                game.startKeyCheckLoop();
                game.displayScreen("./imgs/114.gif");

                game.startKeyCheckLoop();
                game.displayScreen("./imgs/115.gif");

                game.startKeyCheckLoop();
                game.displayScreen("./imgs/116.gif");

                game.startKeyCheckLoop();
                game.displayScreen("./imgs/117.gif");

                game.startKeyCheckLoop();
                game.displayScreen("./imgs/118.gif");

                game.startKeyCheckLoop();
                game.displayScreen("./imgs/119.gif");

                game.startKeyCheckLoop();
                game.displayScreen("./imgs/120.gif");

                game.startKeyCheckLoop();
                game.displayScreen("./imgs/121.gif");

                game.startKeyCheckLoop();
                game.displayScreen("./imgs/122.gif");

                game.startKeyCheckLoop();
                game.displayScreen("./imgs/123.gif");

                game.startKeyCheckLoop();
                game.displayScreen("./imgs/124.gif");

                game.startKeyCheckLoop();
                game.displayScreen("./imgs/125.gif");

                game.startKeyCheckLoop();
                game.displayScreen("./imgs/126.gif");

                game.startKeyCheckLoop();
                game.displayScreen("./imgs/127.gif");

                nemo.setHealth(100);


            }

        }

        

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
        luna.addAbility("Water Gun", 10, 20, 1, 0.1);
        luna.addAbility("Eagle", 20, 30, 3, 0.25);
        luna.addAbility("Arrow", 15, 25, 2, 0.2);
        luna.addAbility("Hypnotize", 50, 70, 4, 0.3);
        luna.addAbility("Banana", 50, 60, 3, 0.25);
        luna.addAbility("Storm", 45, 58, 2, 0.1);
    
        //start game
        game.playMusic("./audios/start_music.wav", 120, true, 1);
        game.displayScreen("./imgs/start_screen.png");
        game.startKeyCheckLoop(); //check if enter pressed
        game.stopMusicWithFadeOut("./audios/start_music.wav", 500);

        //First cutscene: introduction to cafe
        game.playMusic("./audios/cut_scenes.wav", 120, false,1);
        game.displayScreen("./imgs/t1.gif");
        
        game.startKeyCheckLoop();
        game.displayScreen("./imgs/t2.gif");

        game.startKeyCheckLoop();
        game.displayScreen("./imgs/t3.gif");

        game.startKeyCheckLoop();
        game.displayScreen("./imgs/t4.gif");

        game.startKeyCheckLoop();
        game.displayScreen("./imgs/t5.gif");

        game.startKeyCheckLoop();
        game.displayScreen("./imgs/t6.gif");
        
        game.startKeyCheckLoop();
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
        levelOne(game, nemo, winston);


        //cut-scene before level 2
        game.stopMusicWithFadeOut("./audios/fight.wav", 500);
        game.playMusic("./audios/cut_scenes.wav", 120, false,1);
        
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


        levelTwo(game, nemo, rosie);


        //level 3 cut-scene
        game.stopMusicWithFadeOut("/audios/fight.wav;", 0);
        game.playMusic("./audios/cut_scenes.wav", 120, true, 1.0);

        game.displayScreen("./imgs/76.gif");

        game.startKeyCheckLoop();
        game.displayScreen("./imgs/77.gif");

        game.startKeyCheckLoop();
        game.displayScreen("./imgs/78.gif");

        game.startKeyCheckLoop();
        game.displayScreen("./imgs/79.gif");


        game.startKeyCheckLoop();
        game.displayScreen("./imgs/80.gif");


        game.startKeyCheckLoop();
        game.displayScreen("./imgs/81.gif");

        game.startKeyCheckLoop();
        game.displayScreen("./imgs/82.gif");

        game.startKeyCheckLoop();
        game.displayScreen("./imgs/83.gif");

        game.startKeyCheckLoop();
        game.displayScreen("./imgs/85.gif");

        game.startKeyCheckLoop();
        game.displayScreen("./imgs/86.gif");

        game.startKeyCheckLoop();
        game.displayScreen("./imgs/87.gif");


        //level 3 fight
        game.playMusic("./audios/fight.wav",120, true, 1.0);
        levelThree(game, nemo, luna);

        return;




        


       

    }

}
