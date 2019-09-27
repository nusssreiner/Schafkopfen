import java.beans.IntrospectionException;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.stream.Collectors;

class Round {
	int startingPlayer;
	int secondPlayer;
	int thirdPlayer;
	int lastPlayer;
	private Boolean[] haveBeenAsked = new Boolean[3];
	private Boolean[] wantsToPlay = new Boolean[3];
	Game game;
	RoundType type;

	Round(Game game) {
		this.game = game;
		startingPlayer = game.startingPlayer;
		secondPlayer = (startingPlayer + 1) == 5 ? 1 : (startingPlayer + 1);
		thirdPlayer = (secondPlayer + 1) == 5 ? 1 : (secondPlayer + 1);
		lastPlayer = (thirdPlayer + 1) == 5 ? 1 : (thirdPlayer + 1);
		type = null;
	}

	//get information which Players chose to play,
	private String getWhoWantsToPlay () {
		if (!haveBeenAsked[0]) {
			return "Feel free to choose!";
		}
		else if (!haveBeenAsked[1]) {
			if (!wantsToPlay[0]) {
				return "The starting player " + game.player1.name + " chose not to play";
			}
			else {
				return "The starting player " + game.player1.name + " wants to play";
			}
		}
		else if (!haveBeenAsked[2]) {
			if (!(wantsToPlay[0] && wantsToPlay[1]))
				return game.player1.name
		}
		else if (!haveBeenAsked[3]) {

		}

	}

	//Asks the starting player to define the type of this round
	private void askPlayerToDefineRoundType (int playerId) throws IOException {
		ServerSocket serverSocket = new ServerSocket(game.getPort(playerId));
		Socket socket = serverSocket.accept();
		PrintStream printStream = new PrintStream(socket.getOutputStream());
		if (playerId == startingPlayer) {
			printStream.println(1);
			haveBeenAsked[0] = true;
		}
		else if (playerId == secondPlayer) {
			printStream.println(2);
			printStream.println(getWhoWantsToPlay());
			haveBeenAsked[1] = true;
		}
		else if (playerId == thirdPlayer) {
			printStream.println(3);
			haveBeenAsked[2] = true;
		}
		else if (playerId == lastPlayer) {
			printStream.println(4);
			haveBeenAsked[3] = true;
		}
		serverSocket.close();
	}

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

	private void handOutCards() throws IOException, InterruptedException {
		game.player1.handOutCards();
		game.player2.handOutCards();
		game.player3.handOutCards();
		game.player4.handOutCards();
		System.out.println("These are the player's names:");
		System.out.println(game.player1.name);
		System.out.println(game.player2.name);
		System.out.println(game.player3.name);
		System.out.println(game.player4.name);
	}

	//start a game (mix cards, pass to players)
	void startRound() throws IOException, InterruptedException {
		setNextRoundType();
		shuffleCards();

		handOutCards();
		System.out.println(startingPlayer + "" + secondPlayer + "" + thirdPlayer + "" + lastPlayer);
		askPlayerToDefineRoundType(startingPlayer);
		askPlayerToDefineRoundType(secondPlayer);
		askPlayerToDefineRoundType(thirdPlayer);
		askPlayerToDefineRoundType(lastPlayer);

		System.out.println("Opening Table and asking Player " + startingPlayer + " to define the roundType.");
		Table table = new Table(this); 
		table.requestOneTrick();
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
