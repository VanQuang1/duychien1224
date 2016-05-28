/**
 * Created by admin on 5/28/2016.
 */
public class Main {
    public static void main(String []args){
        GameWindow gameWindow=new GameWindow();
        Thread thread = new Thread(gameWindow);
        thread.start();
    }
}
