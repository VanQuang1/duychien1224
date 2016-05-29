import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by admin on 5/28/2016.
 */
public class GameWindow extends Frame implements Runnable{
    Image background,plane1,bufferedImage,plane2;
    int planeX1=100,planeY1=500,speedX1=0,speedY1=0;
    int planeX2=300,planeY2=500;
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
                        speedY1 -=3;break;
                    case KeyEvent.VK_A:
                        speedX1 -=3;break;
                    case KeyEvent.VK_D:
                        speedX1+=3;break;
                    case KeyEvent.VK_S:
                        speedY1+=3;break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                speedX1=0;
                speedY1=0;

            }
        });
        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {
                System.out.println("moved at:" + e.getX() +" "+ e.getY());
                planeX2 = e.getX();
                planeY2 = e.getY();
            }
        });
        try {
            background = ImageIO.read(new File("Resources/Background.png"));
            plane1 = ImageIO.read(new File("Resources/PLANE2.png"));
            plane2 = ImageIO.read(new File("Resources/PLANE3.png"));
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
        bufferedGraphics.drawImage(plane1,planeX1,planeY1,null);
        bufferedGraphics.drawImage(plane2,planeX2,planeY2,null);
        g.drawImage(bufferedImage,0,0,null);

    }
    @Override
    public void run (){
        long i=0;
        while(true){
            try {
                planeX1+=speedX1;
                planeY1+=speedY1;
                Thread.sleep(17);
                repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}