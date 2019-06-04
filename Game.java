import java.io.IOException;
import java.io.PrintStream;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.stream.Collectors;

public class Game {
	int port1, port2, port3, port4, startingPlayer;
	LocalPlayer player1, player2, player3, player4;

	private Game(int p1, int p2, int p3, int p4) {
		port1 = p1;
		port2 = p2;
		port3 = p3;
		port4 = p4;
		chooseStartingPlayer();
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

	public static void main (String[] args) throws IOException {
		Game game = new Game(3001, 3002, 3003, 3004);
		System.out.println("Connecting to players and handing out cards.");
		game.startGame();
	}

	//start a game (mix cards, pass to players)
	public void startGame () throws IOException {
		player1 = new LocalPlayer (port1, 1);
		player2 = new LocalPlayer (port2, 2);
		player3 = new LocalPlayer (port3, 3);
		player4 = new LocalPlayer (port4, 4);

		shuffleCards();

		player1.handOutCards();
		player2.handOutCards();
		player3.handOutCards();
		player4.handOutCards();

		System.out.println("Opening Table and asking Player " + startingPlayer + " to start.");
		Table table = new Table(this);
		table.requestOneRound();
	}

	private void shuffleCards() {
		List<LocalPlayer> availablePlayers = Arrays.asList(player1, player2, player3, player4);

		for (int i = 1; i <= 32; i++) {
			availablePlayers = availablePlayers.stream()
					.filter(player -> player.getNumberOfCards() < 8)
					.collect(Collectors.toList());

			int random = new Random().nextInt(availablePlayers.size());
			availablePlayers.get(random).assignCard(new Card(i));
		}
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
