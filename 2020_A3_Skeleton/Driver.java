public class Driver {
    public static void main(String[] args){
        try{
            new GameCharGen().run();
        }catch(NoGameCharacterFoundException ex){
            System.out.println(ex.getMessage());
        }
    }
}