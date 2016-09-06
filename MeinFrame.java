import javax.swing.*;
import java.util.Random;

/**
 * 02.09.2016
 * Created by user Schal (Lukas Schalk).
 */

public class MeinFrame extends JFrame {

    public static final String VERSION = "1.5.2";

    JFrame jf = new JFrame();
    public static boolean isBtn1Selected = false, isBtn2Selected = false, isBtn3Selected = false, isBtn4Selected = false, isBtn5Selected = false, gameStarted = false;
    public static boolean isSelectable = false;
    public static boolean coinAnimationWin = false, coinAnimationLoose = false, coinAusgabe = true;
    public static JButton playerBtn1, playerBtn2, playerBtn3, playerBtn4, playerBtn5;
    public static JButton computerBtn1, computerBtn2, computerBtn3, computerBtn4, computerBtn5;
    public static JButton playButton;
    public static JLabel playerSiegeLabel, computerSiegeLabel;
    public static JButton btnErhöhen;
    public static JLabel currentCoinLabel, gettedCoinsLabel;
    JLabel drawLabel;
    JLabel helpLabel1, helpLabel2, helpLabel3, helpLabel4, helpLabel5, helpLabel6, helpLabel7;
    JLabel helpLabelCards1, helpLabelCards2, helpLabelCards3, helpLabelCards4, helpLabelCards5, helpLabelCards6, helpLabelCards7;
    JLabel version;
    Icon normal = new ImageIcon(getClass().getResource("img/spielkarteNORMAL.png"));
    Icon wolke = new ImageIcon(getClass().getResource("img/spielkarteWOLKE.png"));
    Icon pilz = new ImageIcon(getClass().getResource("img/spielkartePILZ.png"));
    Icon blume = new ImageIcon(getClass().getResource("img/spielkarteBLUME.png"));
    Icon luigi = new ImageIcon(getClass().getResource("img/spielkarteLUIGI.png"));
    Icon mario = new ImageIcon(getClass().getResource("img/spielkarteMARIO.png"));
    Icon stern = new ImageIcon(getClass().getResource("img/spielkarteSTERN.png"));

    public static String winner;
    public static int currentCoins = 10;
    public static int gesetzteCoins = 0;
    public static int playerScore = 0, computerScore = 0;
    public static int playerSiege = 0, computerSiege = 0;
    public static int[] playerCards = new int[5];
    public static int[] computerCards = new int[5];

    //Temporäre Variablen
    int setCurrentCards = 0;
    int paare = 0;
    int score = 0, wolken = 0, pilze = 0, blumen = 0, luigis = 0, marios = 0, sterne = 0;
    boolean change1 = true, change2 = true, change3 = true, change4 = true, change5 = true;

    public MeinFrame() {
        jf.setLayout(null);
        jf.setSize(950, 600);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setTitle("Super Mario Kartenspiel");
        jf.setLocationRelativeTo(null);
        jf.setResizable(false);

        playButton = new JButton("Los!");
        playButton.setBounds(270, 270, 380, 40);
        playButton.addActionListener(new MeinButtonListener());
        jf.add(playButton);

        playerSiegeLabel = new JLabel("Deine Siege: " + playerSiege);
        playerSiegeLabel.setBounds(720, 310, 200, 20);
        jf.add(playerSiegeLabel);

        computerSiegeLabel = new JLabel("Computersiege: " + computerSiege);
        computerSiegeLabel.setBounds(110, 250, 200, 20);
        jf.add(computerSiegeLabel);

        btnErhöhen = new JButton("Erhöhen!");
        btnErhöhen.setBounds(5, 350, 90, 50);
        btnErhöhen.addActionListener(new MeinButtonListener());
        jf.add(btnErhöhen);

        currentCoinLabel = new JLabel("Coins: " + currentCoins);
        currentCoinLabel.setBounds(22, 400, 90, 20);
        jf.add(currentCoinLabel);

        gettedCoinsLabel = new JLabel("");
        gettedCoinsLabel.setBounds(22, 425, 90, 20);
        jf.add(gettedCoinsLabel);

        drawLabel = new DrawCoinLabel();
        drawLabel.setBounds(0, 0, 100, 350);
        jf.add(drawLabel);

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
        jf.add(helpLabelCards1);
        jf.add(helpLabelCards2);
        jf.add(helpLabelCards3);
        jf.add(helpLabelCards4);
        jf.add(helpLabelCards5);
        jf.add(helpLabelCards6);
        jf.add(helpLabelCards7);

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
        jf.add(helpLabel1);
        jf.add(helpLabel2);
        jf.add(helpLabel3);
        jf.add(helpLabel4);
        jf.add(helpLabel5);
        jf.add(helpLabel6);
        jf.add(helpLabel7);

        version = new JLabel("Version " + VERSION + " | Created by Lukas S. | lakinator.bplaced.net");
        version.setBounds(10, 550, 500, 20);
        jf.add(version);

        //PlayerButtons

        playerBtn1 = new JButton();
        playerBtn1.setBounds(100, 350, 125, 181);
        playerBtn1.setIcon(normal);
        playerBtn1.addActionListener(new MeinButtonListener());
        jf.add(playerBtn1);

        playerBtn2 = new JButton();
        playerBtn2.setBounds(250, 350, 125, 181);
        playerBtn2.setIcon(normal);
        playerBtn2.addActionListener(new MeinButtonListener());
        jf.add(playerBtn2);

        playerBtn3 = new JButton();
        playerBtn3.setBounds(400, 350, 125, 181);
        playerBtn3.setIcon(normal);
        playerBtn3.addActionListener(new MeinButtonListener());
        jf.add(playerBtn3);

        playerBtn4 = new JButton();
        playerBtn4.setBounds(550, 350, 125, 181);
        playerBtn4.setIcon(normal);
        playerBtn4.addActionListener(new MeinButtonListener());
        jf.add(playerBtn4);

        playerBtn5 = new JButton();
        playerBtn5.setBounds(700, 350, 125, 181);
        playerBtn5.setIcon(normal);
        playerBtn5.addActionListener(new MeinButtonListener());
        jf.add(playerBtn5);

        //ComputerButtons

        computerBtn1 = new JButton();
        computerBtn1.setBounds(100, 50, 125, 181);
        computerBtn1.setIcon(normal);
        jf.add(computerBtn1);

        computerBtn2 = new JButton();
        computerBtn2.setBounds(250, 50, 125, 181);
        computerBtn2.setIcon(normal);
        jf.add(computerBtn2);

        computerBtn3 = new JButton();
        computerBtn3.setBounds(400, 50, 125, 181);
        computerBtn3.setIcon(normal);
        jf.add(computerBtn3);

        computerBtn4 = new JButton();
        computerBtn4.setBounds(550, 50, 125, 181);
        computerBtn4.setIcon(normal);
        jf.add(computerBtn4);

        computerBtn5 = new JButton();
        computerBtn5.setBounds(700, 50, 125, 181);
        computerBtn5.setIcon(normal);
        jf.add(computerBtn5);

        jf.setVisible(true);

        //Hauptschleife des Spiels

        while (true) {
            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (playButton.getText().equals("Karten behalten") || playButton.getText().equals("Karten tauschen")) {
                isSelectable = true;
            } else {
                isSelectable = false;
            }

            if (isBtn1Selected || isBtn2Selected || isBtn3Selected || isBtn4Selected || isBtn5Selected && playButton.getText().equals("Karten behalten")) {
                playButton.setText("Karten tauschen");
            } else if (!isBtn1Selected && !isBtn2Selected && !isBtn3Selected && !isBtn4Selected && !isBtn5Selected && playButton.getText().equals("Karten tauschen")) {
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
                    if (winner.equals(" > Computer gewinnt! <")) {
                        coinAnimationLoose = true;
                        gettedCoinsLabel.setText("-" + gesetzteCoins);
                    } else if (winner.equals(" > Du gewinnst! <")) {
                        coinAnimationWin = true;

                        if (playerScore <= 120 && playerScore >= 2) {  //1 Paar
                            currentCoins += gesetzteCoins*2;
                            gettedCoinsLabel.setText("+" + gesetzteCoins*2);
                        } else if (playerScore > 300 && playerScore <= 400) { //2 Paar
                            currentCoins += gesetzteCoins*3;
                            gettedCoinsLabel.setText("+" + gesetzteCoins*3);
                        } else if (playerScore > 794 && playerScore <= 800) { //3 Gleiche
                            currentCoins += gesetzteCoins*4;
                            gettedCoinsLabel.setText("+" + gesetzteCoins*4);
                        } else if (playerScore > 1000 && playerScore <= 6500) { //Full House
                            currentCoins += gesetzteCoins*5;
                            gettedCoinsLabel.setText("+" + gesetzteCoins*5);
                        } else if (playerScore > 18999 && playerScore <= 19010) { //4 Gleiche
                            currentCoins += gesetzteCoins*6;
                            gettedCoinsLabel.setText("+" + gesetzteCoins*6);
                        } else if (playerScore > 19999) { //5 Gleiche
                            currentCoins += gesetzteCoins*12;
                            gettedCoinsLabel.setText("+" + gesetzteCoins*12);
                        }

                    } else if (winner.equals(" > Unentschieden! <")) {
                        coinAnimationWin = true;
                        currentCoins += gesetzteCoins;
                        gettedCoinsLabel.setText("+" + gesetzteCoins);
                    }
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

                System.out.println(currentScore(computerCards)); //Debug

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

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (change1) {
                    computerCards[0] = randomCard();
                    System.out.println("Slot 1"); //Debug

                    computerBtn1.setBounds(100, 25, 125, 181);

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    computerBtn1.setBounds(100, 50, 125, 181);

                }
                if (change2) {
                    computerCards[1] = randomCard();
                    System.out.println("Slot 2"); //Debug

                    computerBtn2.setBounds(250, 25, 125, 181);

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    computerBtn2.setBounds(250, 50, 125, 181);

                }
                if (change3) {
                    computerCards[2] = randomCard();
                    System.out.println("Slot 3"); //Debug

                    computerBtn3.setBounds(400, 25, 125, 181);

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    computerBtn3.setBounds(400, 50, 125, 181);

                }
                if (change4) {
                    computerCards[3] = randomCard();
                    System.out.println("Slot 4"); //Debug

                    computerBtn4.setBounds(550, 25, 125, 181);

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    computerBtn4.setBounds(550, 50, 125, 181);

                }
                if (change5) {
                    computerCards[4] = randomCard();
                    System.out.println("Slot 5"); //Debug

                    computerBtn5.setBounds(700, 25, 125, 181);

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    computerBtn5.setBounds(700, 50, 125, 181);

                }

                System.out.println(currentScore(computerCards)); //Debug

                playButton.setEnabled(true);
                playButton.setText("Auflösen");
            }

            //Der Score wird gesetzt

            if (playButton.getText().equals("Auflösen")) {
                System.out.println("PlayerCards Score: " + currentScore(playerCards)); //Debug
                playerScore = currentScore(playerCards);
                System.out.println("ComputerCards Score: " + currentScore(computerCards)); //Debug
                computerScore = currentScore(computerCards);
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
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (cardsPlayer[0] == 1) {
                playerBtn1.setIcon(wolke);
            } else if (cardsPlayer[0] == 2) {
                playerBtn1.setIcon(pilz);
            } else if (cardsPlayer[0] == 3) {
                playerBtn1.setIcon(blume);
            } else if (cardsPlayer[0] == 4) {
                playerBtn1.setIcon(luigi);
            } else if (cardsPlayer[0] == 5) {
                playerBtn1.setIcon(mario);
            } else if (cardsPlayer[0] == 6) {
                playerBtn1.setIcon(stern);
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (cardsPlayer[1] == 1) {
                playerBtn2.setIcon(wolke);
            } else if (cardsPlayer[1] == 2) {
                playerBtn2.setIcon(pilz);
            } else if (cardsPlayer[1] == 3) {
                playerBtn2.setIcon(blume);
            } else if (cardsPlayer[1] == 4) {
                playerBtn2.setIcon(luigi);
            } else if (cardsPlayer[1] == 5) {
                playerBtn2.setIcon(mario);
            } else if (cardsPlayer[1] == 6) {
                playerBtn2.setIcon(stern);
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (cardsPlayer[2] == 1) {
                playerBtn3.setIcon(wolke);
            } else if (cardsPlayer[2] == 2) {
                playerBtn3.setIcon(pilz);
            } else if (cardsPlayer[2] == 3) {
                playerBtn3.setIcon(blume);
            } else if (cardsPlayer[2] == 4) {
                playerBtn3.setIcon(luigi);
            } else if (cardsPlayer[2] == 5) {
                playerBtn3.setIcon(mario);
            } else if (cardsPlayer[2] == 6) {
                playerBtn3.setIcon(stern);
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (cardsPlayer[3] == 1) {
                playerBtn4.setIcon(wolke);
            } else if (cardsPlayer[3] == 2) {
                playerBtn4.setIcon(pilz);
            } else if (cardsPlayer[3] == 3) {
                playerBtn4.setIcon(blume);
            } else if (cardsPlayer[3] == 4) {
                playerBtn4.setIcon(luigi);
            } else if (cardsPlayer[3] == 5) {
                playerBtn4.setIcon(mario);
            } else if (cardsPlayer[3] == 6) {
                playerBtn4.setIcon(stern);
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (cardsPlayer[4] == 1) {
                playerBtn5.setIcon(wolke);
            } else if (cardsPlayer[4] == 2) {
                playerBtn5.setIcon(pilz);
            } else if (cardsPlayer[4] == 3) {
                playerBtn5.setIcon(blume);
            } else if (cardsPlayer[4] == 4) {
                playerBtn5.setIcon(luigi);
            } else if (cardsPlayer[4] == 5) {
                playerBtn5.setIcon(mario);
            } else if (cardsPlayer[4] == 6) {
                playerBtn5.setIcon(stern);
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
