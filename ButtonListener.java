import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 02.09.2016
 * Created by user Schal (Lukas Schalk).
 */

//Klasse zur Überwachung von gedrückten Karten/Buttons

public class ButtonListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {

        //Hier wird geregelt, ob man eine Karte tauschen oder behalten will, also das nach oben und unten verschieben der Karte

        if (GUI.isSelectable) {
            if (e.getSource() == GUI.playerBtn[0] && !Var.selectedBtn[0]) {
                GUI.playerBtn[0].setBounds(100, 330, 125, 181);
                Var.selectedBtn[0] = true;
            } else if (e.getSource() == GUI.playerBtn[0] && Var.selectedBtn[0]) {
                GUI.playerBtn[0].setBounds(100, 350, 125, 181);
                Var.selectedBtn[0] = false;
            }

            if (e.getSource() == GUI.playerBtn[1] && !Var.selectedBtn[1]) {
                GUI.playerBtn[1].setBounds(250, 330, 125, 181);
                Var.selectedBtn[1] = true;
            } else if (e.getSource() == GUI.playerBtn[1] && Var.selectedBtn[1]) {
                GUI.playerBtn[1].setBounds(250, 350, 125, 181);
                Var.selectedBtn[1] = false;
            }

            if (e.getSource() == GUI.playerBtn[2] && !Var.selectedBtn[2]) {
                GUI.playerBtn[2].setBounds(400, 330, 125, 181);
                Var.selectedBtn[2] = true;
            } else if (e.getSource() == GUI.playerBtn[2] && Var.selectedBtn[2]) {
                GUI.playerBtn[2].setBounds(400, 350, 125, 181);
                Var.selectedBtn[2] = false;
            }

            if (e.getSource() == GUI.playerBtn[3] && !Var.selectedBtn[3]) {
                GUI.playerBtn[3].setBounds(550, 330, 125, 181);
                Var.selectedBtn[3] = true;
            } else if (e.getSource() == GUI.playerBtn[3] && Var.selectedBtn[3]) {
                GUI.playerBtn[3].setBounds(550, 350, 125, 181);
                Var.selectedBtn[3] = false;
            }

            if (e.getSource() == GUI.playerBtn[4] && !Var.selectedBtn[4]) {
                GUI.playerBtn[4].setBounds(700, 330, 125, 181);
                Var.selectedBtn[4] = true;
            } else if (e.getSource() == GUI.playerBtn[4] && Var.selectedBtn[4]) {
                GUI.playerBtn[4].setBounds(700, 350, 125, 181);
                Var.selectedBtn[4] = false;
            }
        }

        /*Hier wird abgefragt ob das Spiel gerade am Start ist oder am Ende wenn man den Hauptbutton drückt, und dann
        * entweder das Spiel gestartet oder der Gewinner festgestellt und die Karten des Computers aufgelöst
        */

        if (e.getSource() == GUI.playButton && !GUI.gameStarted && GUI.playButton.getText().equals("Los!")) {
            GUI.playButton.setText("Karten werden ausgegeben");
            GUI.gesetzteCoins = 1;
            if (GUI.currentCoins != 0) {
                GUI.currentCoins -= 1;
            }
            GUI.currentCoinLabel.setText("Coins: " + GUI.currentCoins);
            GUI.gameStarted = true;
        } else if (e.getSource() == GUI.playButton && GUI.playButton.getText().equals("Auflösen")) {
            Var.winner = "";

            //Sieger wird ermittelt und ausgegeben

            if (Var.computerScore > Var.playerScore) {
                Var.winner = " > Computer gewinnt! <";
                Var.computerSiege++;
            } else if (Var.playerScore > Var.computerScore) {
                Var.winner = " > Du gewinnst! <";
                Var.playerSiege++;
            } else if (Var.playerScore == Var.computerScore) {
                Var.winner = " > Unentschieden! <";
            }

            GUI.playerSiegeLabel.setText("Deine Siege: " + Var.playerSiege);
            GUI.computerSiegeLabel.setText("Computersiege: " + Var.computerSiege);
            GUI.playButton.setText(Var.winner + "  [Klicken für ein neues Spiel!]");

            //Die Karten des Computers werden aufgedeckt

            for(int i = 0; i < 5; i++) {
                if (GUI.computerCards[i] == 1) {
                    GUI.computerBtn[i].setIcon(Resource.wolke);
                } else if (GUI.computerCards[i] == 2) {
                    GUI.computerBtn[i].setIcon(Resource.pilz);
                } else if (GUI.computerCards[i] == 3) {
                    GUI.computerBtn[i].setIcon(Resource.blume);
                } else if (GUI.computerCards[i] == 4) {
                    GUI.computerBtn[i].setIcon(Resource.luigi);
                } else if (GUI.computerCards[i] == 5) {
                    GUI.computerBtn[i].setIcon(Resource.mario);
                } else if (GUI.computerCards[i] == 6) {
                    GUI.computerBtn[i].setIcon(Resource.stern);
                }
            }

            /*Hier wird geschaut, ob Karten zum Austausch gewählt sind und werden dann ausgetauscht. Dann wird das Spiel in
            * die Auflösen- (quasi End-) Phase gebracht
            */

        } else if (e.getSource() == GUI.playButton && GUI.playButton.getText().equals("Karten tauschen")) {
            GUI.playButton.setEnabled(false);
            GUI.playButton.setText("Der Computer wählt...");
            if (Var.selectedBtn[0]) {
                GUI.playerCards = GUI.tauscheKarteAnStelle(GUI.playerCards, 0, GUI.randomCard());

                GUI.playerBtn[0].setBounds(100, 350, 125, 181);
                Var.selectedBtn[0] = false;

                if (GUI.playerCards[0] == 1) {
                    GUI.playerBtn[0].setIcon(Resource.wolke);
                } else if (GUI.playerCards[0] == 2) {
                    GUI.playerBtn[0].setIcon(Resource.pilz);
                } else if (GUI.playerCards[0] == 3) {
                    GUI.playerBtn[0].setIcon(Resource.blume);
                } else if (GUI.playerCards[0] == 4) {
                    GUI.playerBtn[0].setIcon(Resource.luigi);
                } else if (GUI.playerCards[0] == 5) {
                    GUI.playerBtn[0].setIcon(Resource.mario);
                } else if (GUI.playerCards[0] == 6) {
                    GUI.playerBtn[0].setIcon(Resource.stern);
                }
            }

            if (Var.selectedBtn[1]) {
                GUI.playerCards = GUI.tauscheKarteAnStelle(GUI.playerCards, 1, GUI.randomCard());

                GUI.playerBtn[1].setBounds(250, 350, 125, 181);
                Var.selectedBtn[1] = false;

                if (GUI.playerCards[1] == 1) {
                    GUI.playerBtn[1].setIcon(Resource.wolke);
                } else if (GUI.playerCards[1] == 2) {
                    GUI.playerBtn[1].setIcon(Resource.pilz);
                } else if (GUI.playerCards[1] == 3) {
                    GUI.playerBtn[1].setIcon(Resource.blume);
                } else if (GUI.playerCards[1] == 4) {
                    GUI.playerBtn[1].setIcon(Resource.luigi);
                } else if (GUI.playerCards[1] == 5) {
                    GUI.playerBtn[1].setIcon(Resource.mario);
                } else if (GUI.playerCards[1] == 6) {
                    GUI.playerBtn[1].setIcon(Resource.stern);
                }
            }

            if (Var.selectedBtn[2]) {
                GUI.playerCards = GUI.tauscheKarteAnStelle(GUI.playerCards, 2, GUI.randomCard());

                GUI.playerBtn[2].setBounds(400, 350, 125, 181);
                Var.selectedBtn[2] = false;

                if (GUI.playerCards[2] == 1) {
                    GUI.playerBtn[2].setIcon(Resource.wolke);
                } else if (GUI.playerCards[2] == 2) {
                    GUI.playerBtn[2].setIcon(Resource.pilz);
                } else if (GUI.playerCards[2] == 3) {
                    GUI.playerBtn[2].setIcon(Resource.blume);
                } else if (GUI.playerCards[2] == 4) {
                    GUI.playerBtn[2].setIcon(Resource.luigi);
                } else if (GUI.playerCards[2] == 5) {
                    GUI.playerBtn[2].setIcon(Resource.mario);
                } else if (GUI.playerCards[2] == 6) {
                    GUI.playerBtn[2].setIcon(Resource.stern);
                }
            }

            if (Var.selectedBtn[3]) {
                GUI.playerCards = GUI.tauscheKarteAnStelle(GUI.playerCards, 3, GUI.randomCard());

                GUI.playerBtn[3].setBounds(550, 350, 125, 181);
                Var.selectedBtn[3] = false;

                if (GUI.playerCards[3] == 1) {
                    GUI.playerBtn[3].setIcon(Resource.wolke);
                } else if (GUI.playerCards[3] == 2) {
                    GUI.playerBtn[3].setIcon(Resource.pilz);
                } else if (GUI.playerCards[3] == 3) {
                    GUI.playerBtn[3].setIcon(Resource.blume);
                } else if (GUI.playerCards[3] == 4) {
                    GUI.playerBtn[3].setIcon(Resource.luigi);
                } else if (GUI.playerCards[3] == 5) {
                    GUI.playerBtn[3].setIcon(Resource.mario);
                } else if (GUI.playerCards[3] == 6) {
                    GUI.playerBtn[3].setIcon(Resource.stern);
                }
            }

            if (Var.selectedBtn[4]) {
                GUI.playerCards = GUI.tauscheKarteAnStelle(GUI.playerCards, 4, GUI.randomCard());

                GUI.playerBtn[4].setBounds(700, 350, 125, 181);
                Var.selectedBtn[4] = false;

                if (GUI.playerCards[4] == 1) {
                    GUI.playerBtn[4].setIcon(Resource.wolke);
                } else if (GUI.playerCards[4] == 2) {
                    GUI.playerBtn[4].setIcon(Resource.pilz);
                } else if (GUI.playerCards[4] == 3) {
                    GUI.playerBtn[4].setIcon(Resource.blume);
                } else if (GUI.playerCards[4] == 4) {
                    GUI.playerBtn[4].setIcon(Resource.luigi);
                } else if (GUI.playerCards[4] == 5) {
                    GUI.playerBtn[4].setIcon(Resource.mario);
                } else if (GUI.playerCards[4] == 6) {
                    GUI.playerBtn[4].setIcon(Resource.stern);
                }
            }

        } else if (e.getSource() == GUI.playButton && GUI.playButton.getText().equals("Karten behalten")) {

            GUI.playButton.setEnabled(false);
            GUI.playButton.setText("Der Computer wählt...");


            /*Hier wird geschaut, ob alles aufgelöst wurde und dann wird das Spielfeld zurückgesetzt und kann wieder
            * mit dem Los! Button von neuem gestartet werden
            */

        } else if (e.getSource() == GUI.playButton && !GUI.playButton.getText().equals("Karten tauschen") && !GUI.playButton.getText().equals("Los!") && !GUI.playButton.getText().equals("Karten behalten") && !GUI.playButton.getText().equals("Auflösen")) {
            Funktion.reset();
        }

        //Erhöhen button (Coinsystem)

        if (e.getSource() == GUI.btnErhöhen && GUI.btnErhöhen.isEnabled()) {
            GUI.gesetzteCoins++;
            GUI.currentCoins -= 1;
            GUI.currentCoinLabel.setText("Coins: " + GUI.currentCoins);
        }

    }
}
