import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 05.09.2016
 * Created by user Schal (Lukas Schalk).
 */

public class DrawCoinLabel extends JLabel {
    BufferedImage coinImg;
    int coin1Y = 280, coin2Y = 210, coin3Y = 140, coin4Y = 70, coin5Y = 0;

    public DrawCoinLabel() {
        try {
            coinImg = ImageIO.read(getClass().getClassLoader().getResourceAsStream("img/coinSMALL.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        //Coinanimationen

        if (MeinFrame.coinAnimationWin) {
            coin1Y += 3;
            coin2Y += 5;
            coin3Y += 7;
            coin4Y += 9;
            coin5Y += 11;
        } else if (MeinFrame.coinAnimationLoose) {
            coin1Y -= 11;
            coin2Y -= 9;
            coin3Y -= 7;
            coin4Y -= 5;
            coin5Y -= 3;
        } else if (!MeinFrame.coinAnimationWin || !MeinFrame.coinAnimationLoose) {
            coin1Y = 280;
            coin2Y = 210;
            coin3Y = 140;
            coin4Y = 70;
            coin5Y = 0;
        }

        //Coins darstellen

        if (MeinFrame.gesetzteCoins >= 1) {
            g.drawImage(coinImg, 30, coin1Y, null);
        }

        if (MeinFrame.gesetzteCoins >= 2) {
            g.drawImage(coinImg, 30, coin2Y, null);
        }

        if (MeinFrame.gesetzteCoins >= 3) {
            g.drawImage(coinImg, 30, coin3Y, null);
        }

        if (MeinFrame.gesetzteCoins >= 4) {
            g.drawImage(coinImg, 30, coin4Y, null);
        }

        if (MeinFrame.gesetzteCoins >= 5) {
            g.drawImage(coinImg, 30, coin5Y, null);
        }

        try {
            Thread.sleep(15);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        repaint();

    }
}
