import java.io.IOException;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.Random;

public class LocalPlayer {
	//cards of a player
	private int port, id, numberOfCards;
	private Card[] cards;
	private Game game;

	//constructor
	LocalPlayer (int port, int id, Game game) {
		this.game = game;
		this.port = port;
		this.id = id;
		cards = new Card[8];
	}

	public int getNumberOfCards() {
		return numberOfCards;
	}
	
	void assignCard (Card card) {
		if (numberOfCards < 8) {
			cards[numberOfCards] = card;
		}
		numberOfCards++;
	}
	
	//hand out 8 cards to 1 player
	void handOutCards() throws IOException {
		ServerSocket serverSocket = new ServerSocket(port);
		Socket socket = serverSocket.accept();
		PrintStream printStream = new PrintStream(socket.getOutputStream());
		//tell player about round type
		printStream.println(game.round.type.toString());
		//pass him his cards
		for (Card card : cards) {
			printStream.println(card.getCardId());
		}
	}

}
