import java.io.IOException;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.stream.Collectors;

public class Round {
	int startingPlayer;
	Game game;
	RoundType type;

	public Round(Game game) {
		this.game = game;
		startingPlayer = game.startingPlayer;
		RoundType type;
	}

	//Asks the starting player to define the type of this round
	private void setNextRoundType () throws IOException {

		Scanner input = new Scanner(System.in);
		System.out.println("Choose RoundType by typing 'typex'");
		System.out.println("for now only 'type1' SAUSPIEL and 'type2' OACHESOLO are available");
		type = null;
		while (type == null) {
			String choice = input.nextLine();
			switch (choice) {
				case "type1":
					type = RoundType.SAUSPIEL;
					break;
				case "type2":
					type = RoundType.OACHESOLO;
					break;

				default:
					System.out.println("Invalid entry, try again");
					type = null;
					break;
			}
		}
	}

	//start a game (mix cards, pass to players)
	public void startRound() throws IOException {

		setNextRoundType();


		shuffleCards();

		game.player1.handOutCards();
		game.player2.handOutCards();
		game.player3.handOutCards();
		game.player4.handOutCards();

		System.out.println("Opening Table and asking Player " + startingPlayer + " to start.");
		Table table = new Table(this);
		table.requestOneRound();
	}

	private void shuffleCards() {
		List<LocalPlayer> availablePlayers = Arrays.asList(game.player1, game.player2, game.player3, game.player4);

		for (int i = 1; i <= 32; i++) {
			availablePlayers = availablePlayers.stream()
					.filter(player -> player.getNumberOfCards() < 8)
					.collect(Collectors.toList());

			int random = new Random().nextInt(availablePlayers.size());
			availablePlayers.get(random).assignCard(new Card(i));
		}
	}
}
