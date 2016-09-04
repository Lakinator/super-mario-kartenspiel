import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 02.09.2016
 * Created by user Schal (Lukas Schalk).
 */

//Klasse zur Überwachung von gedrückten Karten/Buttons

public class MeinButtonListener implements ActionListener {
    Icon normal = new ImageIcon(getClass().getResource("img/spielkarteNORMAL.png"));
    Icon wolke = new ImageIcon(getClass().getResource("img/spielkarteWOLKE.png"));
    Icon pilz = new ImageIcon(getClass().getResource("img/spielkartePILZ.png"));
    Icon blume = new ImageIcon(getClass().getResource("img/spielkarteBLUME.png"));
    Icon luigi = new ImageIcon(getClass().getResource("img/spielkarteLUIGI.png"));
    Icon mario = new ImageIcon(getClass().getResource("img/spielkarteMARIO.png"));
    Icon stern = new ImageIcon(getClass().getResource("img/spielkarteSTERN.png"));

    @Override
    public void actionPerformed(ActionEvent e) {

        //Hier wird geregelt, ob man eine Karte tauschen oder behalten will, also das nach oben und unten verschieben der Karte

        if (MeinFrame.isSelectable) {
            if (e.getSource() == MeinFrame.playerBtn1 && !MeinFrame.isBtn1Selected) {
                MeinFrame.playerBtn1.setBounds(100, 330, 125, 181);
                MeinFrame.isBtn1Selected = true;
            } else if (e.getSource() == MeinFrame.playerBtn1 && MeinFrame.isBtn1Selected) {
                MeinFrame.playerBtn1.setBounds(100, 350, 125, 181);
                MeinFrame.isBtn1Selected = false;
            }

            if (e.getSource() == MeinFrame.playerBtn2 && !MeinFrame.isBtn2Selected) {
                MeinFrame.playerBtn2.setBounds(250, 330, 125, 181);
                MeinFrame.isBtn2Selected = true;
            } else if (e.getSource() == MeinFrame.playerBtn2 && MeinFrame.isBtn2Selected) {
                MeinFrame.playerBtn2.setBounds(250, 350, 125, 181);
                MeinFrame.isBtn2Selected = false;
            }

            if (e.getSource() == MeinFrame.playerBtn3 && !MeinFrame.isBtn3Selected) {
                MeinFrame.playerBtn3.setBounds(400, 330, 125, 181);
                MeinFrame.isBtn3Selected = true;
            } else if (e.getSource() == MeinFrame.playerBtn3 && MeinFrame.isBtn3Selected) {
                MeinFrame.playerBtn3.setBounds(400, 350, 125, 181);
                MeinFrame.isBtn3Selected = false;
            }

            if (e.getSource() == MeinFrame.playerBtn4 && !MeinFrame.isBtn4Selected) {
                MeinFrame.playerBtn4.setBounds(550, 330, 125, 181);
                MeinFrame.isBtn4Selected = true;
            } else if (e.getSource() == MeinFrame.playerBtn4 && MeinFrame.isBtn4Selected) {
                MeinFrame.playerBtn4.setBounds(550, 350, 125, 181);
                MeinFrame.isBtn4Selected = false;
            }

            if (e.getSource() == MeinFrame.playerBtn5 && !MeinFrame.isBtn5Selected) {
                MeinFrame.playerBtn5.setBounds(700, 330, 125, 181);
                MeinFrame.isBtn5Selected = true;
            } else if (e.getSource() == MeinFrame.playerBtn5 && MeinFrame.isBtn5Selected) {
                MeinFrame.playerBtn5.setBounds(700, 350, 125, 181);
                MeinFrame.isBtn5Selected = false;
            }
        }

        /*Hier wird abgefragt ob das Spiel gerade am Start ist oder am Ende wenn man den Hauptbutton drückt, und dann
        * entweder das Spiel gestartet oder der Gewinner festgestellt und die Karten des Computers aufgelöst
        */

        if (e.getSource() == MeinFrame.playButton && !MeinFrame.gameStarted && MeinFrame.playButton.getText().equals("Los!")) {
            MeinFrame.playButton.setText("Karten werden ausgegeben");
            MeinFrame.gameStarted = true;
        } else if (e.getSource() == MeinFrame.playButton && MeinFrame.playButton.getText().equals("Auflösen")) {
            String winner = "";

            //Sieger wird ermittelt und ausgegeben

            if (MeinFrame.computerScore > MeinFrame.playerScore) {
                winner = " > Computer gewinnt! <";
                MeinFrame.computerSiege++;
            } else if (MeinFrame.playerScore > MeinFrame.computerScore) {
                winner = " > Du gewinnst! <";
                MeinFrame.playerSiege++;
            } else if (MeinFrame.playerScore == MeinFrame.computerScore) {
                winner = " > Unentschieden! <";
            }

            MeinFrame.playerSiegeLabel.setText("Deine Siege: " + MeinFrame.playerSiege);
            MeinFrame.computerSiegeLabel.setText("Computersiege: " + MeinFrame.computerSiege);
            MeinFrame.playButton.setText(winner + "  [Klicken für ein neues Spiel!]");

            //Die Karten des Computers werden aufgedeckt

            if (MeinFrame.computerCards[0] == 1) {
                MeinFrame.computerBtn1.setIcon(wolke);
            } else if (MeinFrame.computerCards[0] == 2) {
                MeinFrame.computerBtn1.setIcon(pilz);
            } else if (MeinFrame.computerCards[0] == 3) {
                MeinFrame.computerBtn1.setIcon(blume);
            } else if (MeinFrame.computerCards[0] == 4) {
                MeinFrame.computerBtn1.setIcon(luigi);
            } else if (MeinFrame.computerCards[0] == 5) {
                MeinFrame.computerBtn1.setIcon(mario);
            } else if (MeinFrame.computerCards[0] == 6) {
                MeinFrame.computerBtn1.setIcon(stern);
            }


            if (MeinFrame.computerCards[1] == 1) {
                MeinFrame.computerBtn2.setIcon(wolke);
            } else if (MeinFrame.computerCards[1] == 2) {
                MeinFrame.computerBtn2.setIcon(pilz);
            } else if (MeinFrame.computerCards[1] == 3) {
                MeinFrame.computerBtn2.setIcon(blume);
            } else if (MeinFrame.computerCards[1] == 4) {
                MeinFrame.computerBtn2.setIcon(luigi);
            } else if (MeinFrame.computerCards[1] == 5) {
                MeinFrame.computerBtn2.setIcon(mario);
            } else if (MeinFrame.computerCards[1] == 6) {
                MeinFrame.computerBtn2.setIcon(stern);
            }


            if (MeinFrame.computerCards[2] == 1) {
                MeinFrame.computerBtn3.setIcon(wolke);
            } else if (MeinFrame.computerCards[2] == 2) {
                MeinFrame.computerBtn3.setIcon(pilz);
            } else if (MeinFrame.computerCards[2] == 3) {
                MeinFrame.computerBtn3.setIcon(blume);
            } else if (MeinFrame.computerCards[2] == 4) {
                MeinFrame.computerBtn3.setIcon(luigi);
            } else if (MeinFrame.computerCards[2] == 5) {
                MeinFrame.computerBtn3.setIcon(mario);
            } else if (MeinFrame.computerCards[2] == 6) {
                MeinFrame.computerBtn3.setIcon(stern);
            }


            if (MeinFrame.computerCards[3] == 1) {
                MeinFrame.computerBtn4.setIcon(wolke);
            } else if (MeinFrame.computerCards[3] == 2) {
                MeinFrame.computerBtn4.setIcon(pilz);
            } else if (MeinFrame.computerCards[3] == 3) {
                MeinFrame.computerBtn4.setIcon(blume);
            } else if (MeinFrame.computerCards[3] == 4) {
                MeinFrame.computerBtn4.setIcon(luigi);
            } else if (MeinFrame.computerCards[3] == 5) {
                MeinFrame.computerBtn4.setIcon(mario);
            } else if (MeinFrame.computerCards[3] == 6) {
                MeinFrame.computerBtn4.setIcon(stern);
            }


            if (MeinFrame.computerCards[4] == 1) {
                MeinFrame.computerBtn5.setIcon(wolke);
            } else if (MeinFrame.computerCards[4] == 2) {
                MeinFrame.computerBtn5.setIcon(pilz);
            } else if (MeinFrame.computerCards[4] == 3) {
                MeinFrame.computerBtn5.setIcon(blume);
            } else if (MeinFrame.computerCards[4] == 4) {
                MeinFrame.computerBtn5.setIcon(luigi);
            } else if (MeinFrame.computerCards[4] == 5) {
                MeinFrame.computerBtn5.setIcon(mario);
            } else if (MeinFrame.computerCards[4] == 6) {
                MeinFrame.computerBtn5.setIcon(stern);
            }

            /*Hier wird geschaut, ob Karten zum Austausch gewählt sind und werden dann ausgetauscht. Dann wird das Spiel in
            * die Auflösen- (quasi End-) Phase gebracht
            */

        } else if (e.getSource() == MeinFrame.playButton && MeinFrame.playButton.getText().equals("Karten tauschen")) {
            MeinFrame.playButton.setEnabled(false);
            MeinFrame.playButton.setText("Der Computer wählt...");
            if (MeinFrame.isBtn1Selected) {
                MeinFrame.playerCards = MeinFrame.tauscheKarteAnStelle(MeinFrame.playerCards, 0, MeinFrame.randomCard());

                MeinFrame.playerBtn1.setBounds(100, 350, 125, 181);
                MeinFrame.isBtn1Selected = false;

                if (MeinFrame.playerCards[0] == 1) {
                    MeinFrame.playerBtn1.setIcon(wolke);
                } else if (MeinFrame.playerCards[0] == 2) {
                    MeinFrame.playerBtn1.setIcon(pilz);
                } else if (MeinFrame.playerCards[0] == 3) {
                    MeinFrame.playerBtn1.setIcon(blume);
                } else if (MeinFrame.playerCards[0] == 4) {
                    MeinFrame.playerBtn1.setIcon(luigi);
                } else if (MeinFrame.playerCards[0] == 5) {
                    MeinFrame.playerBtn1.setIcon(mario);
                } else if (MeinFrame.playerCards[0] == 6) {
                    MeinFrame.playerBtn1.setIcon(stern);
                }
            }

            if (MeinFrame.isBtn2Selected) {
                MeinFrame.playerCards = MeinFrame.tauscheKarteAnStelle(MeinFrame.playerCards, 1, MeinFrame.randomCard());

                MeinFrame.playerBtn2.setBounds(250, 350, 125, 181);
                MeinFrame.isBtn2Selected = false;

                if (MeinFrame.playerCards[1] == 1) {
                    MeinFrame.playerBtn2.setIcon(wolke);
                } else if (MeinFrame.playerCards[1] == 2) {
                    MeinFrame.playerBtn2.setIcon(pilz);
                } else if (MeinFrame.playerCards[1] == 3) {
                    MeinFrame.playerBtn2.setIcon(blume);
                } else if (MeinFrame.playerCards[1] == 4) {
                    MeinFrame.playerBtn2.setIcon(luigi);
                } else if (MeinFrame.playerCards[1] == 5) {
                    MeinFrame.playerBtn2.setIcon(mario);
                } else if (MeinFrame.playerCards[1] == 6) {
                    MeinFrame.playerBtn2.setIcon(stern);
                }
            }

            if (MeinFrame.isBtn3Selected) {
                MeinFrame.playerCards = MeinFrame.tauscheKarteAnStelle(MeinFrame.playerCards, 2, MeinFrame.randomCard());

                MeinFrame.playerBtn3.setBounds(400, 350, 125, 181);
                MeinFrame.isBtn3Selected = false;

                if (MeinFrame.playerCards[2] == 1) {
                    MeinFrame.playerBtn3.setIcon(wolke);
                } else if (MeinFrame.playerCards[2] == 2) {
                    MeinFrame.playerBtn3.setIcon(pilz);
                } else if (MeinFrame.playerCards[2] == 3) {
                    MeinFrame.playerBtn3.setIcon(blume);
                } else if (MeinFrame.playerCards[2] == 4) {
                    MeinFrame.playerBtn3.setIcon(luigi);
                } else if (MeinFrame.playerCards[2] == 5) {
                    MeinFrame.playerBtn3.setIcon(mario);
                } else if (MeinFrame.playerCards[2] == 6) {
                    MeinFrame.playerBtn3.setIcon(stern);
                }
            }

            if (MeinFrame.isBtn4Selected) {
                MeinFrame.playerCards = MeinFrame.tauscheKarteAnStelle(MeinFrame.playerCards, 3, MeinFrame.randomCard());

                MeinFrame.playerBtn4.setBounds(550, 350, 125, 181);
                MeinFrame.isBtn4Selected = false;

                if (MeinFrame.playerCards[3] == 1) {
                    MeinFrame.playerBtn4.setIcon(wolke);
                } else if (MeinFrame.playerCards[3] == 2) {
                    MeinFrame.playerBtn4.setIcon(pilz);
                } else if (MeinFrame.playerCards[3] == 3) {
                    MeinFrame.playerBtn4.setIcon(blume);
                } else if (MeinFrame.playerCards[3] == 4) {
                    MeinFrame.playerBtn4.setIcon(luigi);
                } else if (MeinFrame.playerCards[3] == 5) {
                    MeinFrame.playerBtn4.setIcon(mario);
                } else if (MeinFrame.playerCards[3] == 6) {
                    MeinFrame.playerBtn4.setIcon(stern);
                }
            }

            if (MeinFrame.isBtn5Selected) {
                MeinFrame.playerCards = MeinFrame.tauscheKarteAnStelle(MeinFrame.playerCards, 4, MeinFrame.randomCard());

                MeinFrame.playerBtn5.setBounds(700, 350, 125, 181);
                MeinFrame.isBtn5Selected = false;

                if (MeinFrame.playerCards[4] == 1) {
                    MeinFrame.playerBtn5.setIcon(wolke);
                } else if (MeinFrame.playerCards[4] == 2) {
                    MeinFrame.playerBtn5.setIcon(pilz);
                } else if (MeinFrame.playerCards[4] == 3) {
                    MeinFrame.playerBtn5.setIcon(blume);
                } else if (MeinFrame.playerCards[4] == 4) {
                    MeinFrame.playerBtn5.setIcon(luigi);
                } else if (MeinFrame.playerCards[4] == 5) {
                    MeinFrame.playerBtn5.setIcon(mario);
                } else if (MeinFrame.playerCards[4] == 6) {
                    MeinFrame.playerBtn5.setIcon(stern);
                }
            }

        } else if (e.getSource() == MeinFrame.playButton && MeinFrame.playButton.getText().equals("Karten behalten")) {

            MeinFrame.playButton.setEnabled(false);
            MeinFrame.playButton.setText("Der Computer wählt...");


            /*Hier wird geschaut, ob alles aufgelöst wurde und dann wird das Spielfeld zurückgesetzt und kann wieder
            * mit dem Los! Button von neuem gestartet werden
            */

        } else if (e.getSource() == MeinFrame.playButton && !MeinFrame.playButton.getText().equals("Karten tauschen") && !MeinFrame.playButton.getText().equals("Los!") && !MeinFrame.playButton.getText().equals("Karten behalten") && !MeinFrame.playButton.getText().equals("Auflösen")) {
            MeinFrame.playButton.setText("Los!");

            MeinFrame.computerBtn1.setIcon(normal);
            MeinFrame.computerBtn2.setIcon(normal);
            MeinFrame.computerBtn3.setIcon(normal);
            MeinFrame.computerBtn4.setIcon(normal);
            MeinFrame.computerBtn5.setIcon(normal);

            MeinFrame.playerBtn1.setIcon(normal);
            MeinFrame.playerBtn2.setIcon(normal);
            MeinFrame.playerBtn3.setIcon(normal);
            MeinFrame.playerBtn4.setIcon(normal);
            MeinFrame.playerBtn5.setIcon(normal);
        }
    }
}
