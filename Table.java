import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

class Table {
	private int nextPlayer, card1, card2, card3;
	private Round round;
	private CardSet cardSet;
	
	Table (Round round) {
		this.round = round;
		nextPlayer = round.startingPlayer;
		cardSet = new CardSet(round.type);
	}


	//send request to 4 players to play card
	void requestOneTrick() throws IOException {
		int numberOfCards;
		for (numberOfCards = 0; numberOfCards < 4; numberOfCards++) {
			int cardJustPlayed;
			ServerSocket serverSocket = new ServerSocket(round.game.getPort(nextPlayer));
			Socket socket = serverSocket.accept();
			PrintStream printStream = new PrintStream(socket.getOutputStream());
			printStream.println(card1);
			if (card1 == 0) {
				printStream.println("No cards have been played!");
			} else if (card2 == 0) {
				printStream.println(cardSet.getCardInfo(card1) + " has been played.");
			} else if (card3 == 0) {
				printStream.println("The cards \'" + cardSet.getCardInfo(card1) + "\' and \'" + cardSet.getCardInfo(card2) + "\' have been played.");
			} else {
				printStream.println("The cards \'" + cardSet.getCardInfo(card1) + "\', \'" + cardSet.getCardInfo(card2) + "\' and \'" + cardSet.getCardInfo(card3) + "\' have been played.");
			}
			printStream.println("It's your turn.");
			printStream.println("Play a card!");
			Scanner scanner = new Scanner(socket.getInputStream());
			cardJustPlayed = scanner.nextInt();
			switch (numberOfCards) {
				case 0:
					card1 = cardJustPlayed;
					break;
				case 1:
					card2 = cardJustPlayed;
					break;
				case 2:
					card3 = cardJustPlayed;
					break;
				case 3:
					break;
			}
			System.out.println("The following card was played by Player " + nextPlayer + ": " + cardSet.getCardInfo(cardJustPlayed));
			serverSocket.close();
			nextPlayer++;
			nextPlayer = nextPlayer == 5 ? 4 : nextPlayer;
		}
	}
}
