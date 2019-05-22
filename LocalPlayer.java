import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class LocalPlayer {
	//cards of a player
	int port, id, card1, card2, card3, card4, card5, card6, card7, card8, numberOfAssignedCards;
	String name, ip;
	
	//the player, each card belongs to
	static int p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18, p19, p20, p21, p22, p23, p24, p25, p26, p27, p28, p29, p30, p31, p32;
	static int numberOfCardsPlayer1, numberOfCardsPlayer2, numberOfCardsPlayer3, numberOfCardsPlayer4;
	
	//constructor
	private LocalPlayer (int port, int id) {
		this.port = port;
		this.id = id;
	}
	
	//for 'shuffleCards' create random number
	private static int getRandom(int max) {
		Random r = new Random();
		return r.nextInt(max) + 1;
	}
	
	
	//for 'shuffleCards' increases the number of the player's cards
	private static void increase (int p) {
		switch (p) {
		 case 1:
			 numberOfCardsPlayer1++;
			 break;
		 case 2:
			 numberOfCardsPlayer2++;
			 break;
		 case 3:
			 numberOfCardsPlayer3++;
			 break;
		 default:
			 numberOfCardsPlayer4++;
			 break;
		}
	}
	
	
	//for 'shuffleCards' assign cards 9 and further
	private static int assign () {
		boolean player1Available = numberOfCardsPlayer1 < 8;
		boolean player2Available = numberOfCardsPlayer2 < 8;
		boolean player3Available = numberOfCardsPlayer3 < 8;
		boolean player4Available = numberOfCardsPlayer4 < 8;
		int p = 0;
		switch (player1Available + "-" + player2Available + "-" + player3Available + "-" + player4Available){
			case "true-true-true-true":
				p = LocalPlayer.getRandom(4);
				break;
			case "true-true-true-false":
				p = LocalPlayer.getRandom(3);
				break;
			case "true-true-false-true":
				p = LocalPlayer.getRandom(3);
				p = (p == 3) ? 4 : p;
				break;
			case "true-false-true-true":
				p = LocalPlayer.getRandom(3);
				p = (p == 2) ? 4 : p;
				break;
			case "false-true-true-true":
				p = LocalPlayer.getRandom(3);
				p = (p == 1) ? 4 : p;
				break;
			case "true-true-false-false":
				p = LocalPlayer.getRandom(2);
				break;
			case "true-false-true-false":
				p = LocalPlayer.getRandom(2);
				p = (p == 2) ? 3 : p;
				break;
			case "false-true-true-false":
				p = LocalPlayer.getRandom(2);
				p = (p == 1) ? 2 : 3;
				break;
			case "true-false-false-true":
				p = LocalPlayer.getRandom(2);
				p = (p == 1) ? 1 : 4;
				break;
			case "false-true-false-true":
				p = LocalPlayer.getRandom(2);
				p = (p == 1) ? 2 : 4;
				break;
			case "false-false-true-true":
				p = LocalPlayer.getRandom(2);
				p = (p == 1) ? 3 : 4;
				break;
			case "true-false-false-false":
				p = 1;
				break;
			case "false-true-false-false":
				p = 2;
				break;
			case "false-false-true-false":
				p = 3;
				break;
			case "false-false-false-true":
				p = 4;
				break;
		}
		LocalPlayer.increase(p);
		return p;
	}
	
	
	//shuffle cards
	private static void shuffleCards () {
		 p1 = LocalPlayer.assign();
		 p2 = LocalPlayer.assign();
		 p3 = LocalPlayer.assign();
		 p4 = LocalPlayer.assign();
		 p5 = LocalPlayer.assign();
		 p6 = LocalPlayer.assign();
		 p7 = LocalPlayer.assign();
		 p8 = LocalPlayer.assign();
		 p9 = LocalPlayer.assign();
		 p10 = LocalPlayer.assign();
		 p11 = LocalPlayer.assign();
		 p12 = LocalPlayer.assign();
		 p13 = LocalPlayer.assign();
		 p14 = LocalPlayer.assign();
		 p15 = LocalPlayer.assign();
		 p16 = LocalPlayer.assign();
		 p17 = LocalPlayer.assign();
		 p18 = LocalPlayer.assign();
		 p19 = LocalPlayer.assign();
		 p20 = LocalPlayer.assign();
		 p21 = LocalPlayer.assign();
		 p22 = LocalPlayer.assign();
		 p23 = LocalPlayer.assign();
		 p24 = LocalPlayer.assign();
		 p25 = LocalPlayer.assign();
		 p26 = LocalPlayer.assign();
		 p27 = LocalPlayer.assign();
		 p28 = LocalPlayer.assign();
		 p29 = LocalPlayer.assign();
		 p30 = LocalPlayer.assign();
		 p31 = LocalPlayer.assign();
		 p32 = LocalPlayer.assign();
	}
	
	
	//for 'assignCards' assign any card if it belongs to player
	private void assignCard (int p, int c) {
		if (p == id) {
			switch (numberOfAssignedCards) {
			case 0:
				card1 = c;
				break;
			case 1:
				card2 = c;
				break;
			case 2:
				card3 = c;
				break;
			case 3:
				card4 = c;
				break;
			case 4:
				card5 = c;
				break;
			case 5:
				card6 = c;
				break;
			case 6:
				card7 = c;
				break;
			case 7:
				card8 = c;
				break;
			}
			numberOfAssignedCards++;
		}
	}
	
	
	//assign to player
	private void assignCards () {
		assignCard(p1, 1);
		assignCard(p2, 2);
		assignCard(p3, 3);
		assignCard(p4, 4);
		assignCard(p5, 5);
		assignCard(p6, 6);
		assignCard(p7, 7);
		assignCard(p8, 8);
		assignCard(p9, 9);
		assignCard(p10, 10);
		assignCard(p11, 11);
		assignCard(p12, 12);
		assignCard(p13, 13);
		assignCard(p14, 14);
		assignCard(p15, 15);
		assignCard(p16, 16);
		assignCard(p17, 17);
		assignCard(p18, 18);
		assignCard(p19, 19);
		assignCard(p20, 20);
		assignCard(p21, 21);
		assignCard(p22, 22);
		assignCard(p23, 23);
		assignCard(p24, 24);
		assignCard(p25, 25);
		assignCard(p26, 26);
		assignCard(p27, 27);
		assignCard(p28, 28);
		assignCard(p29, 29);
		assignCard(p30, 30);
		assignCard(p31, 31);
		assignCard(p32, 32);
	}
	
	
	//hand out 8 cards to player
	private void handOutCards() throws IOException {
		ServerSocket serverSocket = new ServerSocket(port);
		Socket socket = serverSocket.accept();
		PrintStream printStream = new PrintStream(socket.getOutputStream());
		printStream.println(card1);
		printStream.println(card2);
		printStream.println(card3);
		printStream.println(card4);
		printStream.println(card5);
		printStream.println(card6);
		printStream.println(card7);
		printStream.println(card8);
		socket.close();
		serverSocket.close();
	}
	
	//start a game (mix cards, pass to players)
	public static void startGame (int port1, int port2, int port3, int port4) throws IOException {
		LocalPlayer player1 = new LocalPlayer (port1, 1);
		LocalPlayer player2 = new LocalPlayer (port2, 2);
		LocalPlayer player3 = new LocalPlayer (port3, 3);
		LocalPlayer player4 = new LocalPlayer (port4, 4);
		
		LocalPlayer.shuffleCards();
		
		player1.assignCards();
		player2.assignCards();
		player3.assignCards();
		player4.assignCards();
		
		player1.handOutCards();
//		player2.handOutCards();
//		player3.handOutCards();
//		player4.handOutCards();
		
	}
}
