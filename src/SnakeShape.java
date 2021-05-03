import javax.swing.*;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SnakeShape extends JPanel implements ActionListener, KeyListener {
    Timer timer = new Timer(50, this);
    int x = 0, y = 0, velX = 0, velY = 0;
    int snakeWidth = 10, snakeHeight = 10;
    int n = (int) (Math.random() * 390);
    int m = (int) (Math.random() * 390);

    public SnakeShape() {
        timer.start();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.green);
        g.fillRect(x, y, snakeWidth, snakeHeight);
        g.setColor(Color.red);
        g.fillRect(n, m, 10, 10);
    }


    public void actionPerformed(ActionEvent e) {
        if (x + 10 < 0) {
            x = 375;
        }
        if (x > 385) {

            x = 0;
        }
        if (y < 0) {
            velY = 0;
            y = 0;
        }
        if (y > 352) {
            velY = 0;
            y = 352;
        }

        x = x + velX;
        y = y + velY;
        repaint();
    }

    public void keyPressed(KeyEvent e) {
        int c = e.getKeyCode();
        if (c == KeyEvent.VK_LEFT) {
            velX = -10;
            velY = 0;
            if (c == KeyEvent.VK_RIGHT) {
                velX = -10;
                velY = 0;
            }
            if (x == n) {
                x = x + 10;
                snakeWidth = snakeWidth + 10;
                repaint();
            }
        }
        if (c == KeyEvent.VK_UP) {
            velX = 0;
            velY = -10;
            if (c == KeyEvent.VK_DOWN) {
                velX = 0;
                velY = -10;
            }
            if (y == m) {
                y = y + 10;
                snakeHeight = snakeHeight + 10;
            }
        }
        if (c == KeyEvent.VK_RIGHT) {
            velX = 10;
            velY = 0;
            if (c == KeyEvent.VK_LEFT) {
                velX = 10;
                velY = 0;
            }
            if (x + 10 == n) {
                x = x - 10;
                snakeWidth = snakeWidth + 10;
            }
        }
        if (c == KeyEvent.VK_DOWN) {
            velX = 0;
            velY = 10;
            if (c == KeyEvent.VK_UP) {
                velX = 0;
                velY = 10;
            }
            if (y + 10 == m) {
                y = y - 10;
                snakeHeight = snakeHeight + 10;
            }
        }
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }

    public static void main(String[] args) {
        SnakeShape obj = new SnakeShape();
        obj.paint(null);
        JFrame jf = new JFrame();
        jf.setSize(400, 400);
        jf.setVisible(true);
        jf.setResizable(false);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.add(obj);


    }


}