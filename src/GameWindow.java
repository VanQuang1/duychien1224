import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by admin on 5/28/2016.
 */
public class GameWindow extends Frame implements Runnable{
    Image background,plane1,bufferedImage;
    int planeX=100,planeY=100,speedX=0,speedY=0;

    public GameWindow() throws HeadlessException {
        this.setTitle("1945");
        this.setSize(480, 600);
        this.setVisible(true);
        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()){
                    case KeyEvent.VK_W:
                        speedY -=3;break;
                    case KeyEvent.VK_A:
                        speedX -=3;break;
                    case KeyEvent.VK_D:
                        speedX+=3;break;
                    case KeyEvent.VK_S:
                        speedY+=3;break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                speedX=0;
                speedY=0;

            }
        });
        try {
            background = ImageIO.read(new File("Resources/Background.png"));
            plane1 = ImageIO.read(new File("Resources/PLANE1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void update(Graphics g) {
        if (bufferedImage==null){
            bufferedImage=new BufferedImage(480,600,1);
        }
        Graphics bufferedGraphics =bufferedImage.getGraphics();
        bufferedGraphics.drawImage(background,0,0,null);
        bufferedGraphics.drawImage(plane1,planeX,planeY,null);
        g.drawImage(bufferedImage,0,0,null);

    }
    @Override
    public void run (){
        long i=0;
        while(true){
            try {
                planeX+=speedX;
                planeY+=speedY;
                Thread.sleep(17);
                repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}