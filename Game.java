import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    int port1, port2, port3, port4, startingPlayer;
    LocalPlayer player1, player2, player3, player4;
    Round round;

    private Game (int p1, int p2, int p3, int p4) {
        port1 = p1;
        port2 = p2;
        port3 = p3;
        port4 = p4;
    }

    private void startGame () throws IOException {
        chooseStartingPlayer();
        player1 = new LocalPlayer (port1, 1, this);
        player2 = new LocalPlayer (port2, 2, this);
        player3 = new LocalPlayer (port3, 3, this);
        player4 = new LocalPlayer (port4, 4, this);
    }

    private void startRound () throws IOException {
        round = new Round(this);
        round.startRound();
    }



    private void chooseStartingPlayer() {
        System.out.println("Enter the ID of the player who gets to start! (1-4)");
        Scanner sc = new Scanner(System.in);
        int whoStarts = 0;
        while (whoStarts <= 0 || whoStarts >= 5) {
            try {
                whoStarts = sc.nextInt();
                if (whoStarts <= 0 || whoStarts >= 5) {
                    System.out.println("Invalid entry, try again");
                }
                else {
                    System.out.println("Player " + whoStarts + " is going to start.");
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Invalid entry, try again");
                sc.next();
            }
        }
        startingPlayer = whoStarts;
    }




    public static void main(String[] args) throws IOException {
        Game game = new Game(3001, 3002, 3003, 3004);
        game.startGame();
        game.startRound();
        game.startingPlayer++;
        game.startingPlayer = game.startingPlayer % 4;
        game.startingPlayer = game.startingPlayer == 0 ? 4 : game.startingPlayer;

    }

    public int getPort (int playerId) {
        switch (playerId) {
            case 1:
                return port1;
            case 2:
                return port2;
            case 3:
                return port3;
            default:
                return port4;
        }
    }
}
