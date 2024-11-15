public class Winston extends NekoCharacter{
    public Winston(String characterName, int maxHealth, int xPosition, int yPosition){
        super(characterName, maxHealth, xPosition, yPosition);
    }
   
    public void something(){
        System.out.println("hello world");
    }

    public static void main(String[] args) {
        Winston cat = new Winston("Winston", 10, 0, 0);
        cat.something();
    }

}

