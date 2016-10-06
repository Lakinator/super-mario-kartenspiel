import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * 02.09.2016
 * Created by user Schal (Lukas Schalk).
 */

public class GUI extends JFrame {

    static boolean gameStarted = false;
    static boolean isSelectable = false;
    static boolean coinAnimationWin = false, coinAnimationLoose = false, coinAusgabe = true;
    static JButton playerBtn[] = new JButton[5];
    static JButton computerBtn[] = new JButton[5];
    static JButton playButton;
    static JLabel playerSiegeLabel, computerSiegeLabel;
    static JButton btnErhöhen;
    static JLabel currentCoinLabel, gettedCoinsLabel;
    JLabel drawLabel;
    static JLabel helpLabel1, helpLabel2, helpLabel3, helpLabel4, helpLabel5, helpLabel6, helpLabel7;
    JLabel helpLabelCards1, helpLabelCards2, helpLabelCards3, helpLabelCards4, helpLabelCards5, helpLabelCards6, helpLabelCards7;
    JLabel version;

    static int[] playerCards = new int[5];
    static int[] computerCards = new int[5];
    static int currentCoins = 10;
    static int gesetzteCoins = 0;

    //Temporäre Variablen
    int setCurrentCards = 0;
    int paare = 0;
    int score = 0, wolken = 0, pilze = 0, blumen = 0, luigis = 0, marios = 0, sterne = 0;
    boolean change1 = true, change2 = true, change3 = true, change4 = true, change5 = true;

    public GUI() {
        setLayout(null);
        setSize(950, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Super Mario Kartenspiel");
        setLocationRelativeTo(null);
        setResizable(false);

        playButton = new JButton("Los!");
        playButton.setBounds(270, 270, 380, 40);
        playButton.addActionListener(new ButtonListener());
        add(playButton);

        playerSiegeLabel = new JLabel("Deine Siege: " + Var.playerSiege);
        playerSiegeLabel.setBounds(720, 310, 200, 20);
        add(playerSiegeLabel);

        computerSiegeLabel = new JLabel("Computersiege: " + Var.computerSiege);
        computerSiegeLabel.setBounds(110, 250, 200, 20);
        add(computerSiegeLabel);

        btnErhöhen = new JButton("Erhöhen!");
        btnErhöhen.setBounds(5, 350, 90, 50);
        btnErhöhen.addActionListener(new ButtonListener());
        add(btnErhöhen);

        currentCoinLabel = new JLabel("Coins: " + currentCoins);
        currentCoinLabel.setBounds(22, 400, 90, 20);
        add(currentCoinLabel);

        gettedCoinsLabel = new JLabel("");
        gettedCoinsLabel.setBounds(22, 425, 90, 20);
        add(gettedCoinsLabel);

        drawLabel = new DrawCoinLabel();
        drawLabel.setBounds(0, 0, 100, 350);
        add(drawLabel);

        helpLabelCards1 = new JLabel("Karten System:");
        helpLabelCards1.setBounds(850, 50, 90, 20);
        helpLabelCards2 = new JLabel("1: Wolke");
        helpLabelCards2.setBounds(850, 75, 90, 20);
        helpLabelCards3 = new JLabel("2: Pilz");
        helpLabelCards3.setBounds(850, 100, 90, 20);
        helpLabelCards4 = new JLabel("3: Blume");
        helpLabelCards4.setBounds(850, 125, 90, 20);
        helpLabelCards5 = new JLabel("4: Luigi");
        helpLabelCards5.setBounds(850, 150, 90, 20);
        helpLabelCards6 = new JLabel("5: Mario");
        helpLabelCards6.setBounds(850, 175, 90, 20);
        helpLabelCards7 = new JLabel("6: Stern");
        helpLabelCards7.setBounds(850, 200, 90, 20);
        add(helpLabelCards1);
        add(helpLabelCards2);
        add(helpLabelCards3);
        add(helpLabelCards4);
        add(helpLabelCards5);
        add(helpLabelCards6);
        add(helpLabelCards7);

        helpLabel1 = new JLabel("Coin System:");
        helpLabel1.setBounds(850, 350, 90, 20);
        helpLabel2 = new JLabel("1 Paar: x2");
        helpLabel2.setBounds(850, 375, 90, 20);
        helpLabel3 = new JLabel("2 Paar: x3");
        helpLabel3.setBounds(850, 400, 90, 20);
        helpLabel4 = new JLabel("3 Gleiche: x4");
        helpLabel4.setBounds(850, 425, 90, 20);
        helpLabel5 = new JLabel("Full House: x5");
        helpLabel5.setBounds(850, 450, 90, 20);
        helpLabel6 = new JLabel("4 Gleiche: x6");
        helpLabel6.setBounds(850, 475, 90, 20);
        helpLabel7 = new JLabel("5 Gleiche: x12");
        helpLabel7.setBounds(850, 500, 90, 20);
        add(helpLabel1);
        add(helpLabel2);
        add(helpLabel3);
        add(helpLabel4);
        add(helpLabel5);
        add(helpLabel6);
        add(helpLabel7);

        version = new JLabel("Version " + Var.VERSION + " | Created by Lukas S. | lakinator.bplaced.net");
        version.setBounds(10, 550, 500, 20);
        add(version);

        //PlayerButtons
        for(int i = 0; i < 5; i++){
            playerBtn[i] = new JButton();
            playerBtn[i].setIcon(Resource.normal);
            playerBtn[i].addActionListener(new ButtonListener());
            playerBtn[i].setBorder(null);
            playerBtn[i].setFocusPainted(false);
            playerBtn[i].setContentAreaFilled(false);
            add(playerBtn[i]);
        }

        playerBtn[0].setBounds(100, 350, 125, 181);
        playerBtn[1].setBounds(250, 350, 125, 181);
        playerBtn[2].setBounds(400, 350, 125, 181);
        playerBtn[3].setBounds(550, 350, 125, 181);
        playerBtn[4].setBounds(700, 350, 125, 181);

        //ComputerButtons

        for(int i = 0; i < 5; i++){
            computerBtn[i] = new JButton();
            computerBtn[i].setIcon(Resource.normal);
            computerBtn[i].setBorder(null);
            computerBtn[i].setFocusPainted(false);
            computerBtn[i].setContentAreaFilled(false);
            add(computerBtn[i]);
        }

        computerBtn[0].setBounds(100, 50, 125, 181);
        computerBtn[1].setBounds(250, 50, 125, 181);
        computerBtn[2].setBounds(400, 50, 125, 181);
        computerBtn[3].setBounds(550, 50, 125, 181);
        computerBtn[4].setBounds(700, 50, 125, 181);

        setVisible(true);

        //Hauptschleife des Spiels

        while (true) {
            Funktion.waitMillis(15);

            if (playButton.getText().equals("Karten behalten") || playButton.getText().equals("Karten tauschen")) {
                isSelectable = true;
            } else {
                isSelectable = false;
            }

            if (Var.selectedBtn[0] || Var.selectedBtn[1] || Var.selectedBtn[2] || Var.selectedBtn[3] || Var.selectedBtn[4] && playButton.getText().equals("Karten behalten")) {
                playButton.setText("Karten tauschen");
            } else if (!Var.selectedBtn[0] && !Var.selectedBtn[1] && !Var.selectedBtn[2] && !Var.selectedBtn[3] && !Var.selectedBtn[4] && playButton.getText().equals("Karten tauschen")) {
                playButton.setText("Karten behalten");
            }

            //Coinsystem

            if (playButton.getText().equals("Karten behalten") || playButton.getText().equals("Karten tauschen")) {
                if (gesetzteCoins == 5 || currentCoins == 0) {
                    btnErhöhen.setEnabled(false);
                } else {
                    btnErhöhen.setEnabled(true);
                }
            } else {
                btnErhöhen.setEnabled(false);
            }

            //Auswertung der gesetzten Coins

            if (!playButton.getText().equals("Karten behalten") && !playButton.getText().equals("Karten tauschen") && !playButton.getText().equals("Los!") && !playButton.getText().equals("Auflösen") && !playButton.getText().equals("Der Computer wählt...") && !playButton.getText().equals("Karten werden ausgegeben")) {
                if (coinAusgabe) {
                    if (Var.winner.equals(" > Computer gewinnt! <")) {
                        coinAnimationLoose = true;
                        gettedCoinsLabel.setText("-" + gesetzteCoins);
                    } else if (Var.winner.equals(" > Du gewinnst! <")) {
                        coinAnimationWin = true;

                        if (Var.playerScore <= 120 && Var.playerScore >= 2) {  //1 Paar
                            currentCoins += gesetzteCoins*2;
                            gettedCoinsLabel.setText("+" + gesetzteCoins*2);
                        } else if (Var.playerScore > 300 && Var.playerScore <= 400) { //2 Paar
                            currentCoins += gesetzteCoins*3;
                            gettedCoinsLabel.setText("+" + gesetzteCoins*3);
                        } else if (Var.playerScore > 794 && Var.playerScore <= 800) { //3 Gleiche
                            currentCoins += gesetzteCoins*4;
                            gettedCoinsLabel.setText("+" + gesetzteCoins*4);
                        } else if (Var.playerScore > 1000 && Var.playerScore <= 6500) { //Full House
                            currentCoins += gesetzteCoins*5;
                            gettedCoinsLabel.setText("+" + gesetzteCoins*5);
                        } else if (Var.playerScore > 18999 && Var.playerScore <= 19010) { //4 Gleiche
                            currentCoins += gesetzteCoins*6;
                            gettedCoinsLabel.setText("+" + gesetzteCoins*6);
                        } else if (Var.playerScore > 19999) { //5 Gleiche
                            currentCoins += gesetzteCoins*12;
                            gettedCoinsLabel.setText("+" + gesetzteCoins*12);
                        }

                    } else if (Var.winner.equals(" > Unentschieden! <")) {
                        coinAnimationWin = true;
                        currentCoins += gesetzteCoins;
                        gettedCoinsLabel.setText("+" + gesetzteCoins);
                    }

                    //Farben des Systems links an der Seite
                    if (Var.winner.equals(" > Unentschieden! <")) {
                        if (Var.playerScore <= 120 && Var.playerScore >= 2) {  //1 Paar
                            helpLabel2.setForeground(Color.BLUE);
                        } else if (Var.playerScore > 300 && Var.playerScore <= 400) { //2 Paar
                            helpLabel3.setForeground(Color.BLUE);
                        } else if (Var.playerScore > 794 && Var.playerScore <= 800) { //3 Gleiche
                            helpLabel4.setForeground(Color.BLUE);
                        } else if (Var.playerScore > 1000 && Var.playerScore <= 6500) { //Full House
                            helpLabel5.setForeground(Color.BLUE);
                        } else if (Var.playerScore > 18999 && Var.playerScore <= 19010) { //4 Gleiche
                            helpLabel6.setForeground(Color.BLUE);
                        } else if (Var.playerScore > 19999) { //5 Gleiche
                            helpLabel7.setForeground(Color.BLUE);
                        }
                    } else {
                        if (Var.playerScore > Var.computerScore) {
                            if (Var.playerScore <= 120 && Var.playerScore >= 2) {  //1 Paar
                                helpLabel2.setForeground(Color.GREEN);
                            } else if (Var.playerScore > 300 && Var.playerScore <= 400) { //2 Paar
                                helpLabel3.setForeground(Color.GREEN);
                            } else if (Var.playerScore > 794 && Var.playerScore <= 800) { //3 Gleiche
                                helpLabel4.setForeground(Color.GREEN);
                            } else if (Var.playerScore > 1000 && Var.playerScore <= 6500) { //Full House
                                helpLabel5.setForeground(Color.GREEN);
                            } else if (Var.playerScore > 18999 && Var.playerScore <= 19010) { //4 Gleiche
                                helpLabel6.setForeground(Color.GREEN);
                            } else if (Var.playerScore > 19999) { //5 Gleiche
                                helpLabel7.setForeground(Color.GREEN);
                            }

                            if (Var.computerScore <= 120 && Var.computerScore >= 2) {  //1 Paar
                                helpLabel2.setForeground(Color.RED);
                            } else if (Var.computerScore > 300 && Var.computerScore <= 400) { //2 Paar
                                helpLabel3.setForeground(Color.RED);
                            } else if (Var.computerScore > 794 && Var.computerScore <= 800) { //3 Gleiche
                                helpLabel4.setForeground(Color.RED);
                            } else if (Var.computerScore > 1000 && Var.computerScore <= 6500) { //Full House
                                helpLabel5.setForeground(Color.RED);
                            } else if (Var.computerScore > 18999 && Var.computerScore <= 19010) { //4 Gleiche
                                helpLabel6.setForeground(Color.RED);
                            } else if (Var.computerScore > 19999) { //5 Gleiche
                                helpLabel7.setForeground(Color.RED);
                            }
                        } else if (Var.playerScore < Var.computerScore) {

                            if (Var.playerScore <= 120 && Var.playerScore >= 2) {  //1 Paar
                                helpLabel2.setForeground(Color.RED);
                            } else if (Var.playerScore > 300 && Var.playerScore <= 400) { //2 Paar
                                helpLabel3.setForeground(Color.RED);
                            } else if (Var.playerScore > 794 && Var.playerScore <= 800) { //3 Gleiche
                                helpLabel4.setForeground(Color.RED);
                            } else if (Var.playerScore > 1000 && Var.playerScore <= 6500) { //Full House
                                helpLabel5.setForeground(Color.RED);
                            } else if (Var.playerScore > 18999 && Var.playerScore <= 19010) { //4 Gleiche
                                helpLabel6.setForeground(Color.RED);
                            } else if (Var.playerScore > 19999) { //5 Gleiche
                                helpLabel7.setForeground(Color.RED);
                            }

                            if (Var.computerScore <= 120 && Var.computerScore >= 2) {  //1 Paar
                                helpLabel2.setForeground(Color.GREEN);
                            } else if (Var.computerScore > 300 && Var.computerScore <= 400) { //2 Paar
                                helpLabel3.setForeground(Color.GREEN);
                            } else if (Var.computerScore > 794 && Var.computerScore <= 800) { //3 Gleiche
                                helpLabel4.setForeground(Color.GREEN);
                            } else if (Var.computerScore > 1000 && Var.computerScore <= 6500) { //Full House
                                helpLabel5.setForeground(Color.GREEN);
                            } else if (Var.computerScore > 18999 && Var.computerScore <= 19010) { //4 Gleiche
                                helpLabel6.setForeground(Color.GREEN);
                            } else if (Var.computerScore > 19999) { //5 Gleiche
                                helpLabel7.setForeground(Color.GREEN);
                            }
                        }

                    }

                    System.out.println("Player Score: " + Var.playerScore); //Debug
                    System.out.println("Computer Score: " + Var.computerScore); //Debug

                    currentCoinLabel.setText("Coins: " + currentCoins);
                    coinAusgabe = false;
                }
            }

            //Computer KI

            if (playButton.getText().equals("Der Computer wählt...")) {
                setCurrentCards = currentScore(computerCards);
                change1 = true;
                change2 = true;
                change3 = true;
                change4 = true;
                change5 = true;

                System.out.println("ComputerScore vor Kartenwechsel: " + currentScore(computerCards)); //Debug

                if (wolken >= 2) {
                    for (int i = 0; i < 5; i++) {
                        if (computerCards[i] == 1) {
                            System.out.println("An Stelle " + i + " ist eine Wolke"); //Debug
                            switch (i) {
                                case 0:
                                    change1 = false;
                                    break;
                                case 1:
                                    change2 = false;
                                    break;
                                case 2:
                                    change3 = false;
                                    break;
                                case 3:
                                    change4 = false;
                                    break;
                                case 4:
                                    change5 = false;
                                    break;
                            }
                        }
                    }
                }

                if (pilze >= 2) {
                    for (int i = 0; i < 5; i++) {
                        if (computerCards[i] == 2) {
                            System.out.println("An Stelle " + i + " ist ein Pilz"); //Debug
                            switch (i) {
                                case 0:
                                    change1 = false;
                                    break;
                                case 1:
                                    change2 = false;
                                    break;
                                case 2:
                                    change3 = false;
                                    break;
                                case 3:
                                    change4 = false;
                                    break;
                                case 4:
                                    change5 = false;
                                    break;
                            }
                        }
                    }
                }

                if (blumen >= 2) {
                    for (int i = 0; i < 5; i++) {
                        if (computerCards[i] == 3) {
                            System.out.println("An Stelle " + i + " ist eine Blume"); //Debug
                            switch (i) {
                                case 0:
                                    change1 = false;
                                    break;
                                case 1:
                                    change2 = false;
                                    break;
                                case 2:
                                    change3 = false;
                                    break;
                                case 3:
                                    change4 = false;
                                    break;
                                case 4:
                                    change5 = false;
                                    break;
                            }
                        }
                    }
                }

                if (luigis >= 2) {
                    for (int i = 0; i < 5; i++) {
                        if (computerCards[i] == 4) {
                            System.out.println("An Stelle " + i + " ist ein Luigi"); //Debug
                            switch (i) {
                                case 0:
                                    change1 = false;
                                    break;
                                case 1:
                                    change2 = false;
                                    break;
                                case 2:
                                    change3 = false;
                                    break;
                                case 3:
                                    change4 = false;
                                    break;
                                case 4:
                                    change5 = false;
                                    break;
                            }
                        }
                    }
                }

                if (marios >= 2) {
                    for (int i = 0; i < 5; i++) {
                        if (computerCards[i] == 5) {
                            System.out.println("An Stelle " + i + " ist ein Mario"); //Debug
                            switch (i) {
                                case 0:
                                    change1 = false;
                                    break;
                                case 1:
                                    change2 = false;
                                    break;
                                case 2:
                                    change3 = false;
                                    break;
                                case 3:
                                    change4 = false;
                                    break;
                                case 4:
                                    change5 = false;
                                    break;
                            }
                        }
                    }
                }

                if (sterne >= 2) {
                    for (int i = 0; i < 5; i++) {
                        if (computerCards[i] == 6) {
                            System.out.println("An Stelle " + i + " ist ein Stern"); //Debug
                            switch (i) {
                                case 0:
                                    change1 = false;
                                    break;
                                case 1:
                                    change2 = false;
                                    break;
                                case 2:
                                    change3 = false;
                                    break;
                                case 3:
                                    change4 = false;
                                    break;
                                case 4:
                                    change5 = false;
                                    break;
                            }
                        }
                    }
                }

                Funktion.waitMillis(1000);

                if (change1) {
                    computerCards[0] = randomCard();
                    System.out.println("Slot 1 getauscht"); //Debug

                    computerBtn[0].setBounds(100, 25, 125, 181);

                    Funktion.waitMillis(500);

                    computerBtn[0].setBounds(100, 50, 125, 181);

                }
                if (change2) {
                    computerCards[1] = randomCard();
                    System.out.println("Slot 2 getauscht"); //Debug

                    computerBtn[1].setBounds(250, 25, 125, 181);

                    Funktion.waitMillis(500);

                    computerBtn[1].setBounds(250, 50, 125, 181);

                }
                if (change3) {
                    computerCards[2] = randomCard();
                    System.out.println("Slot 3 getauscht"); //Debug

                    computerBtn[2].setBounds(400, 25, 125, 181);

                    Funktion.waitMillis(500);

                    computerBtn[2].setBounds(400, 50, 125, 181);

                }
                if (change4) {
                    computerCards[3] = randomCard();
                    System.out.println("Slot 4 getauscht"); //Debug

                    computerBtn[3].setBounds(550, 25, 125, 181);

                    Funktion.waitMillis(500);

                    computerBtn[3].setBounds(550, 50, 125, 181);

                }
                if (change5) {
                    computerCards[4] = randomCard();
                    System.out.println("Slot 5 getauscht"); //Debug

                    computerBtn[4].setBounds(700, 25, 125, 181);

                    Funktion.waitMillis(500);

                    computerBtn[4].setBounds(700, 50, 125, 181);

                }

                System.out.println("ComputerScore nach Kartenwechsel: " + currentScore(computerCards)); //Debug

                playButton.setEnabled(true);
                playButton.setText("Auflösen");
            }

            //Der Score wird gesetzt

            if (playButton.getText().equals("Auflösen")) {
                //System.out.println("PlayerCards Score: " + currentScore(playerCards)); //Debug
                Var.playerScore = currentScore(playerCards);
                //System.out.println("ComputerCards Score: " + currentScore(computerCards)); //Debug
                Var.computerScore = currentScore(computerCards);
            }

            startGame(playerCards);
        }
    }

    public static int randomCard() {
        Random rn = new Random();
        int randCard = rn.nextInt(6) + 1;

        return randCard;
    }

    public static int[] tauscheKarteAnStelle(int [] karten, int stelle, int welcheKarte) {

        karten[stelle] = welcheKarte;

        return karten;
    }

    public static int[] berechneKartenset(int[] newCards) {
        Random rn = new Random();

        for(int i = 0; i < 5; i++)
        {
            newCards[i] = rn.nextInt(6) + 1;
            //System.out.println(newCards[i]);
        }

        return newCards;

    }

    public void startGame(int[] cardsPlayer) {
        if (gameStarted) {

            //Berechnungen

            playerCards = berechneKartenset(playerCards);
            computerCards = berechneKartenset(computerCards);

            playButton.setEnabled(false);

            Funktion.waitMillis(500);

            for(int i = 0; i < 5; i++) {
                if (cardsPlayer[i] == 1) {
                    playerBtn[i].setIcon(Resource.wolke);
                } else if (cardsPlayer[i] == 2) {
                    playerBtn[i].setIcon(Resource.pilz);
                } else if (cardsPlayer[i] == 3) {
                    playerBtn[i].setIcon(Resource.blume);
                } else if (cardsPlayer[i] == 4) {
                    playerBtn[i].setIcon(Resource.luigi);
                } else if (cardsPlayer[i] == 5) {
                    playerBtn[i].setIcon(Resource.mario);
                } else if (cardsPlayer[i] == 6) {
                    playerBtn[i].setIcon(Resource.stern);
                }

                Funktion.waitMillis(500);
            }

            gameStarted = false;
            playButton.setEnabled(true);
            playButton.setText("Karten behalten");

        }
    }

    public int currentScore(int[] cards) {
        paare = 0;
        score = 0;
        wolken = 0;
        pilze = 0;
        blumen = 0;
        luigis = 0;
        marios = 0;
        sterne = 0;

        for (int i = 0; i < 5; i++) {
            switch (cards[i]) {
                case 1:
                    wolken++;
                    break;
                case 2:
                    pilze++;
                    break;
                case 3:
                    blumen++;
                    break;
                case 4:
                    luigis++;
                    break;
                case 5:
                    marios++;
                    break;
                case 6:
                    sterne++;
                    break;
            }
        }

        if (wolken == 2) {
            score += 2;
            paare++;
        }
        if (pilze == 2) {
            score += 20;
            paare++;
        }
        if (blumen == 2) {
            score += 45;
            paare++;
        }
        if (luigis == 2) {
            score += 80;
            paare++;
        }
        if (marios == 2) {
            score += 100;
            paare++;
        }
        if (sterne == 2) {
            score += 120;
            paare++;
        }


        if (wolken == 3) {
            score += 795;
        }
        if (pilze == 3) {
            score += 796;
        }
        if (blumen == 3) {
            score += 797;
        }
        if (luigis == 3) {
            score += 798;
        }
        if (marios == 3) {
            score += 799;
        }
        if (sterne == 3) {
            score += 800;
        }

        //2 Paare --> Das höhere Paar der beiden zählt und das kleiner Paar wird hinzugerechnet, falls die ersten beiden gleich sind
        if (paare == 2) {
            if (wolken == 2) {
                score = 300;
                if (pilze == 2) {
                    score += 2;
                }
                if (blumen == 2) {
                    score += 3;
                }
                if (luigis == 2) {
                    score += 4;
                }
                if (marios == 2) {
                    score += 5;
                }
                if (sterne == 2) {
                    score += 6;
                }
            }
            if (pilze == 2) {
                score = 310;
                if (wolken == 2) {
                    score += 1;
                }
                if (blumen == 2) {
                    score += 3;
                }
                if (luigis == 2) {
                    score += 4;
                }
                if (marios == 2) {
                    score += 5;
                }
                if (sterne == 2) {
                    score += 6;
                }
            }
            if (blumen == 2) {
                score = 320;
                if (wolken == 2) {
                    score += 1;
                }
                if (pilze == 2) {
                    score += 2;
                }
                if (luigis == 2) {
                    score += 4;
                }
                if (marios == 2) {
                    score += 5;
                }
                if (sterne == 2) {
                    score += 6;
                }
            }
            if (luigis == 2) {
                score = 330;
                if (wolken == 2) {
                    score += 1;
                }
                if (pilze == 2) {
                    score += 2;
                }
                if (blumen == 2) {
                    score += 3;
                }
                if (marios == 2) {
                    score += 5;
                }
                if (sterne == 2) {
                    score += 6;
                }
            }
            if (marios == 2) {
                score = 340;
                if (wolken == 2) {
                    score += 1;
                }
                if (pilze == 2) {
                    score += 2;
                }
                if (blumen == 2) {
                    score += 3;
                }
                if (luigis == 2) {
                    score += 4;
                }
                if (sterne == 2) {
                    score += 6;
                }
            }
            if (sterne == 2) {
                score = 350;
                if (wolken == 2) {
                    score += 1;
                }
                if (pilze == 2) {
                    score += 2;
                }
                if (blumen == 2) {
                    score += 3;
                }
                if (luigis == 2) {
                    score += 4;
                }
                if (marios == 2) {
                    score += 5;
                }
            }
        }

        //Full House
        if (wolken == 3 || pilze == 3 || blumen == 3 || luigis == 3 || marios == 3 || sterne == 3) {
            if (paare == 1) {
                if (wolken == 3) {
                    score = 1000;
                } else if (pilze == 3) {
                    score = 2000;
                } else if (blumen == 3) {
                    score = 3000;
                } else if (luigis == 3) {
                    score = 4000;
                } else if (marios == 3) {
                    score = 5000;
                } else if (sterne == 3) {
                    score = 6000;
                }

                if (wolken == 2) {
                    score += 2;
                }
                if (pilze == 2) {
                    score += 20;
                }
                if (blumen == 2) {
                    score += 45;
                }
                if (luigis == 2) {
                    score += 80;
                }
                if (marios == 2) {
                    score += 100;
                }
                if (sterne == 2) {
                    score += 120;
                }
            }
        }


        if (wolken == 4) {
            score += 19000;
        }
        if (pilze == 4) {
            score += 19001;
        }
        if (blumen == 4) {
            score += 19002;
        }
        if (luigis == 4) {
            score += 19003;
        }
        if (marios == 4) {
            score += 19004;
        }
        if (sterne == 4) {
            score += 19005;
        }

        if (wolken == 5) {
            score += 20000;
        }
        if (pilze == 5) {
            score += 20001;
        }
        if (blumen == 5) {
            score += 20002;
        }
        if (luigis == 5) {
            score += 20003;
        }
        if (marios == 5) {
            score += 20004;
        }
        if (sterne == 5) {
            score += 20005;
        }

        return score;
    }
}
