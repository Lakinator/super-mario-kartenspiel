import javax.swing.*;
import java.util.Random;

/**
 * 02.09.2016
 * Created by user Schal (Lukas Schalk).
 */

public class MeinFrame extends JFrame {

    public static final double VERSION = 1.2;

    JFrame jf = new JFrame();
    public static boolean isBtn1Selected = false, isBtn2Selected = false, isBtn3Selected = false, isBtn4Selected = false, isBtn5Selected = false, gameStarted = false;
    public static boolean isSelectable = false;
    public static JButton playerBtn1, playerBtn2, playerBtn3, playerBtn4, playerBtn5;
    public static JButton computerBtn1, computerBtn2, computerBtn3, computerBtn4, computerBtn5;
    public static JButton playButton;
    public static JLabel playerSiegeLabel, computerSiegeLabel;
    JLabel version;
    Icon normal = new ImageIcon(getClass().getResource("img/spielkarteNORMAL.png"));
    Icon wolke = new ImageIcon(getClass().getResource("img/spielkarteWOLKE.png"));
    Icon pilz = new ImageIcon(getClass().getResource("img/spielkartePILZ.png"));
    Icon blume = new ImageIcon(getClass().getResource("img/spielkarteBLUME.png"));
    Icon luigi = new ImageIcon(getClass().getResource("img/spielkarteLUIGI.png"));
    Icon mario = new ImageIcon(getClass().getResource("img/spielkarteMARIO.png"));
    Icon stern = new ImageIcon(getClass().getResource("img/spielkarteSTERN.png"));

    public static int playerScore = 0, computerScore = 0;
    public static int playerSiege = 0, computerSiege = 0;
    public static int[] playerCards = new int[5];
    public static int[] computerCards = new int[5];

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


        while (true) {
            try {
                Thread.sleep(50);
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

            if (playButton.getText().equals("Auflösen") || playButton.getText().equals("Karten behalten")) {
                System.out.println("PlayerCards Score: " + currentScore(playerCards));
                playerScore = currentScore(playerCards);
                System.out.println("ComputerCards Score: " + currentScore(computerCards));
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
        int score = 0;
        int wolken = 0;
        int pilze = 0;
        int blumen = 0;
        int luigis = 0;
        int marios = 0;
        int sterne = 0;

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
        }
        if (pilze == 2) {
            score += 4;
        }
        if (blumen == 2) {
            score += 6;
        }
        if (luigis == 2) {
            score += 8;
        }
        if (marios == 2) {
            score += 10;
        }
        if (sterne == 2) {
            score += 12;
        }


        if (wolken == 3) {
            score += 24;
        }
        if (pilze == 3) {
            score += 26;
        }
        if (blumen == 3) {
            score += 28;
        }
        if (luigis == 3) {
            score += 30;
        }
        if (marios == 3) {
            score += 32;
        }
        if (sterne == 3) {
            score += 34;
        }


        if (wolken == 4) {
            score += 46;
        }
        if (pilze == 4) {
            score += 48;
        }
        if (blumen == 4) {
            score += 50;
        }
        if (luigis == 4) {
            score += 52;
        }
        if (marios == 4) {
            score += 54;
        }
        if (sterne == 4) {
            score += 56;
        }

        if (wolken == 5) {
            score += 100;
        }
        if (pilze == 5) {
            score += 102;
        }
        if (blumen == 5) {
            score += 104;
        }
        if (luigis == 5) {
            score += 106;
        }
        if (marios == 5) {
            score += 108;
        }
        if (sterne == 5) {
            score += 110;
        }

        return score;
    }
}
