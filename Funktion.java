import java.awt.*;

/**
 * 06.10.2016
 * Created by user Schal (Lukas Schalk).
 */

public class Funktion {
    static void reset() {
        GUI.playButton.setText("Los!");
        GUI.gettedCoinsLabel.setText("");
        GUI.btnErhöhen.setEnabled(false);
        GUI.coinAnimationWin = false;
        GUI.coinAnimationLoose = false;
        GUI.coinAusgabe = true;
        GUI.gesetzteCoins = 0;
        GUI.currentCoinLabel.setText("Coins: " + GUI.currentCoins);

        for(int i = 0; i < 5; i++) {
            GUI.computerBtn[i].setIcon(Resource.normal);
            GUI.playerBtn[i].setIcon(Resource.normal);
        }

        GUI.helpLabel2.setForeground(Color.DARK_GRAY);
        GUI.helpLabel3.setForeground(Color.DARK_GRAY);
        GUI.helpLabel4.setForeground(Color.DARK_GRAY);
        GUI.helpLabel5.setForeground(Color.DARK_GRAY);
        GUI.helpLabel6.setForeground(Color.DARK_GRAY);
        GUI.helpLabel7.setForeground(Color.DARK_GRAY);
    }

    static void waitMillis(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
