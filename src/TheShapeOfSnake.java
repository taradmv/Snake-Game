import javax.swing.*;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TheShapeOfSnake extends JPanel implements ActionListener, KeyListener {
    Timer timer = new Timer(5, this);
    int x = 0, y = 0, velX = 0, velY = 0;
    int snakeWidth = 25 , snakeHeight=25;
    int n, m;

    public TheShapeOfSnake() {
        timer.start();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.green);
        g.fillRect(x, y, 10, 10);
        int n = (int) (Math.random() * 375);
        int m = (int) (Math.random() * 350);
        g.setColor(Color.red);
        g.fillOval(n, m, 10, 10);
    }


    public void actionPerformed(ActionEvent e) {
        if (x < 0) {
            velX = 0;
            x = 0;
        }
        if (x > 375) {
            velX = 0;
            x = 375;
        }
        if (y < 0) {
            velY = 0;
            y = 0;
        }
        if (y > 350) {
            velY = 0;
            y = 350;
        }

        x = x + velX;
        y = y + velY;
        repaint();
    }

    public void keyPressed(KeyEvent e) {
        int c = e.getKeyCode();
        if (c == KeyEvent.VK_LEFT) {
            velX = -1;
            velY = 0;
        }
        if (c == KeyEvent.VK_UP) {
            velX = 0;
            velY = -1;
        }
        if (c == KeyEvent.VK_RIGHT) {
            velX = 1;
            velY = 0;
        }
        if (c == KeyEvent.VK_DOWN) {
            velX = 0;
            velY = 1;
        }
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }

    public static void main(String[] args) {
        TheShapeOfSnake obj = new TheShapeOfSnake();
        obj.paint(null);
        JFrame jf = new JFrame();
        jf.setSize(400, 400);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.add(obj);
    }


}