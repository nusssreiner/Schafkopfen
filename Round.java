import java.beans.IntrospectionException;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.stream.Collectors;

class Round {
	int[] players = new int[4]; //the first object is the id of the starting player, the second object the id of the second player in row and so on
	private Boolean[] haveBeenAsked = new Boolean[4];
	private Boolean[] wantsToPlay = new Boolean[4];
	Game game;
	RoundType type;

	Round(Game game) {
		this.game = game;
		type = null;

	}

	private void setPlayersIds () {
		players[0] = game.startingPlayer;
		players[1] = (players[0] + 1) == 5 ? 1 : (players[0] + 1);
		players[2] = (players[1] + 1) == 5 ? 1 : (players[1] + 1);
		players[3] = (players[2] + 1) == 5 ? 1 : (players[2] + 1);
	}

	private void setBooleanArraysToZero () {
		for (int i = 0; i < haveBeenAsked.length; i++) {
			haveBeenAsked[i] = false;
		}
		for (int i = 0; i < wantsToPlay.length; i++) {
			wantsToPlay[i] = false;
		}
	}

	//get information which Players chose to play,
	private String getWhoWantsToPlay() {
		if (!haveBeenAsked[0]) {
			return "Feel free to choose!";
		} else if (!haveBeenAsked[1]) {
			if (!wantsToPlay[0]) {
				return "The starting player " + game.getPlayerName(players[0]) + " chose not to play.";
			} else {
				return "The starting player " + game.getPlayerName(players[0]) + " wants to play.";
			}
		} else if (!haveBeenAsked[2]) {
			if (wantsToPlay[0] && wantsToPlay[1]) {
				return game.getPlayerName(players[0]) + " and " + game.getPlayerName(players[1]) + " both want to play";
			} else if (!(!wantsToPlay[0] && wantsToPlay[1])) {
				return game.getPlayerName(players[0]) + " wants to play, " + game.getPlayerName(players[1]) + " does not.";
			} else if (!(wantsToPlay[0] && !wantsToPlay[1])) {
				return game.getPlayerName(players[0]) + " does not want to play, " + game.getPlayerName(players[1]) + " does.";
			} else if (!wantsToPlay[0] && !wantsToPlay[1]) {
				return game.getPlayerName(players[0]) + " and " + game.getPlayerName(players[1]) + " both want to play";
			}
		} else if (!haveBeenAsked[3]) {
			if (!wantsToPlay[0] && !wantsToPlay[1] && !wantsToPlay[2]) {
				return "No one wants to play yet";
			} else {
				return "sb wants to play already";
			}
		}
		return "No one wants to play";
	}

	private int getCorrespondingObjectNumberOfArray (int playerId) {
		if (playerId == players[0]) {
			return 0;
		} else if (playerId == players[1]) {
			return 1;
		} else if (playerId == players[2]) {
			return 2;
		} else if (playerId == players[3]) {
			return 3;
		} else {
			return 4;
		}
	}

	//Asks the starting player to define the type of this round
	private void askPlayerToDefineRoundType (int playerId) throws IOException, InterruptedException{
		ServerSocket serverSocket = new ServerSocket(game.getPort(playerId));
		Socket socket = serverSocket.accept();
		PrintStream printStream = new PrintStream(socket.getOutputStream());
		Scanner scanner = new Scanner(socket.getInputStream());
		while (!haveBeenAsked[getCorrespondingObjectNumberOfArray(playerId)]) {
			if (playerId == players[0]) {
				printStream.println(1);
				printStream.println(getWhoWantsToPlay());
				wantsToPlay[0] = Boolean.valueOf(scanner.nextLine());
				haveBeenAsked[0] = true;
			} else if (playerId == players[1]) {
				printStream.println(2);
				printStream.println(getWhoWantsToPlay());
				wantsToPlay[1] = Boolean.valueOf(scanner.nextLine());
				haveBeenAsked[1] = true;
			} else if (playerId == players[2]) {
				printStream.println(3);
				printStream.println(getWhoWantsToPlay());
				wantsToPlay[2] = Boolean.valueOf(scanner.nextLine());
				haveBeenAsked[2] = true;
			} else if (playerId == players[3]) {
				printStream.println(4);
				printStream.println(getWhoWantsToPlay());
				wantsToPlay[3] = Boolean.valueOf(scanner.nextLine());
				haveBeenAsked[3] = true;
			}
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

	private void handOutCards () throws IOException, InterruptedException {
		game.player1.handOutCards();
		game.player2.handOutCards();
		game.player3.handOutCards();
		game.player4.handOutCards();
	}

	//start a game (mix cards, pass to players)
	void startRound () throws IOException, InterruptedException {
		setBooleanArraysToZero();
		setPlayersIds();

		setNextRoundType();
		shuffleCards();

		handOutCards();
		askPlayerToDefineRoundType(players[0]);
		askPlayerToDefineRoundType(players[1]);
		askPlayerToDefineRoundType(players[2]);
		askPlayerToDefineRoundType(players[3]);
		System.out.println("The 1. Player " + players[0] + " wants to play: " + wantsToPlay[0]);
		System.out.println("The 2. Player " + players[1] + " wants to play: " + wantsToPlay[1]);
		System.out.println("The 3. Player " + players[2] + " wants to play: " + wantsToPlay[2]);
		System.out.println("The 4. Player " + players[3] + " wants to play: " + wantsToPlay[3]);


		//System.out.println("Opening Table and asking Player " + startingPlayer + " to define the roundType.");
		Table table = new Table(this);
		table.requestOneTrick();
	}

	private void shuffleCards () {
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