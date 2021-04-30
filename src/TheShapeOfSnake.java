import javax.swing.JFrame;
import java.awt.Graphics;

public class TheShapeOfSnake extends JFrame {
    public TheShapeOfSnake(){
        setSize(400,400);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        TheShapeOfSnake obj = new TheShapeOfSnake();
        obj.paint(null);
    }

    public void paint(Graphics g) {
        g.fillRect(0, 0, 25, 50);
    }

}