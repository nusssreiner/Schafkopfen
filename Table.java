import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Table {
	int nextPlayer, port1, port2, port3, port4, card1, card2, card3, card4, numberOfCards;
	Round round;
	
	public Table (Round round) {
		this.round = round;
		nextPlayer = round.startingPlayer;
		port1 = round.game.getPort(1);
		port2 = round.game.getPort(2);
		port3 = round.game.getPort(3);
		port4 = round.game.getPort(4);
	}

	//send request to one player to play a card

	//send request to player to play card
	public void requestOneRound() throws IOException {
		for (numberOfCards = 0; numberOfCards < 4; numberOfCards++) {
			int cardJustPlayed;
			ServerSocket serverSocket = new ServerSocket(round.game.getPort(nextPlayer));
			Socket socket = serverSocket.accept();
			PrintStream printStream = new PrintStream(socket.getOutputStream());
			printStream.println(card1);
			if (card1 == 0) {
				printStream.println("No cards have been played!");
			} else if (card2 == 0) {
				printStream.println(Card.getCardInfo(card1) + " has been played.");
			} else if (card3 == 0) {
				printStream.println("The cards \'" + Card.getCardInfo(card1) + "\' and \'" + Card.getCardInfo(card2) + "\' have been played.");
			} else {
				printStream.println("The cards \'" + Card.getCardInfo(card1) + "\', \'" + Card.getCardInfo(card2) + "\' and \'" + Card.getCardInfo(card3) + "\' have been played.");
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
					card4 = cardJustPlayed;
					break;
			}
			System.out.println("The following card was played by Player " + nextPlayer + ": " + Card.getCardInfo(cardJustPlayed));
			serverSocket.close();
			nextPlayer++;
			nextPlayer = nextPlayer % 4;
			nextPlayer = nextPlayer == 0 ? 4 : nextPlayer;
		}
	}
}
