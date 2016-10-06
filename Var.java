/**
 * 06.10.2016
 * Created by user Schal (Lukas Schalk).
 */

public class Var {
    public static final String VERSION = "1.6";

    //static enum GameStates{Start, KartenAusgabe,KartenAuswahl, KartenTausch, KartenBehalten, GegnerAuswahl, Auflösung, Ende};
    //static GameStates gameState = GameStates.Start;

    static String winner;
    static int playerScore = 0, computerScore = 0;
    static int playerSiege = 0, computerSiege = 0;
    static boolean selectedBtn[] = new boolean[5];
}
