import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.Random;

public class LocalPlayer {
	//cards of a player
	private int port, id, numberOfCards;
	private Card[] cards;
	private String name, ip;
	
	//the player, each card belongs to
	// static int p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18, p19, p20, p21, p22, p23, p24, p25, p26, p27, p28, p29, p30, p31, p32;
//	int numberOfCardsPlayer1, numberOfCardsPlayer2, numberOfCardsPlayer3, numberOfCardsPlayer4;

	//constructor
	LocalPlayer (int port, int id) {
		this.port = port;
		this.id = id;
		cards = new Card[8];
	}
	
	//for 'shuffleCards' create random number
	private static int getRandom(int max) {
		Random r = new Random();
		return r.nextInt(max) + 1;
	}

	public int getNumberOfCards() {
		return numberOfCards;
	}
	
	//for 'assignCards' assign any card if it belongs to player
	void assignCard (Card card) {
		if (numberOfCards < 8) {
			cards[numberOfCards] = card;
		}
		numberOfCards++;
	}
	

	
	//hand out 8 cards to player
	void handOutCards() throws IOException {
		ServerSocket serverSocket = new ServerSocket(port);
		Socket socket = serverSocket.accept();
		PrintStream printStream = new PrintStream(socket.getOutputStream());

		for (Card card : cards) {
			printStream.println(card.getCardId());
		}

		socket.close();
		serverSocket.close();
	}

}
