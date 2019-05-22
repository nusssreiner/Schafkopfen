import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Player {
	
	int playerPort, card1, card2, card3, card4, card5, card6, card7, card8, port;
	String playerName;
	
	
	
	//constructor
	public Player (String playerName, int playerPort) {
		this.playerName = playerName;
		this.playerPort = playerPort;
		
	}
	
	//creating player (p gets to chose name and port)
	private void setUpPlayer() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your name!");
		playerName = scanner.next();
		System.out.println("You chose \'" + playerName + "\' as your name.");
		System.out.println("Now choose an ID! Enter a number from 1-4");
		System.out.println("Make sure noone else in your game choses the same number as you!");
		port = 0;
		while (port == 0) {
			int id = scanner.nextInt();
			switch(id) {
			case 1:
				port = 3001;
				break;
			case 2:
				port = 3002;
				break;
			case 3:
				port = 3003;
				break;
			case 4:
				port = 3004;
				break;
			default:
				System.out.println("Invalid entry");
			}
		}
		playerPort = port;

	}
	
	//receiveCard
	public void receiveCards () throws  IOException, InterruptedException {
		//keep checking for cards as long as Player does not have any
		while (card1 == 0) {
			int inputCard1, inputCard2, inputCard3, inputCard4, inputCard5, inputCard6, inputCard7, inputCard8;
			int port = playerPort; 
			try {
				Socket socket = new Socket("127.0.0.1", port);
				Thread.sleep(200);
				Scanner scanner = new Scanner (socket.getInputStream());
				inputCard1 = scanner.nextInt();
				inputCard2 = scanner.nextInt();
				inputCard3 = scanner.nextInt();
				inputCard4 = scanner.nextInt();
				inputCard5 = scanner.nextInt();
				inputCard6 = scanner.nextInt();
				inputCard7 = scanner.nextInt();
				inputCard8 = scanner.nextInt();
				scanner.close();
				socket.close();
				card1 = inputCard1;
				card2 = inputCard2;
				card3 = inputCard3;
				card4 = inputCard4;
				card5 = inputCard5;
				card6 = inputCard6;
				card7 = inputCard7;
				card8 = inputCard8;
				System.out.println("De kartn hosd griagd: " + card1 + ", " + card2 + ", " + card3 + ", " + card4 + ", " + card5 + ", " + card6 + ", " + card7 + " und " + card8 + ".");
			}	
			catch ( IOException e ){
			}
		}	
	}
	
	//play card
	public void playCard() throws InterruptedException {
		while (true) {
			try {
				Socket socket = new Socket("127.0.0.1", port);
				Thread.sleep(200);
				Scanner scanner = new Scanner (socket.getInputStream());
				Scanner input = new Scanner (System.in);
	//			System.out.println(scanner.next());
				PrintStream printStream = new PrintStream(socket.getOutputStream());
				System.out.println("Enter your choice by typing cardx");
				System.out.println("You have the following cards available:");
				System.out.println("card1 = " + card1); //planning on adding class card with return method
				System.out.println("card2 = " + card2);
				System.out.println("card3 = " + card3);
				System.out.println("card4 = " + card4);
				System.out.println("card5 = " + card5);
				System.out.println("card6 = " + card6);
				System.out.println("card7 = " + card7);
				System.out.println("card8 = " + card8);
				int cardId = 0;
				String choice;
				choice = input.next();
				while (cardId == 0) {
					switch (choice) {
						case "card1":
							cardId = card1;
							break;
						case "card2":
							cardId = card2;
							break;
						case "card3":
							cardId = card3;
							break;
						case "card4":
							cardId = card4;
							break;
						case "card5":
							cardId = card5;
							break;
						case "card6":
							cardId = card6;
							break;
						case "card7":
							cardId = card7;
							break;
						case "card8":
							cardId = card8;
							break;
					}
					if (cardId == 0) {
						System.out.println("Invalid entry, try again");
						choice = input.next();
					}
				}
				printStream.println(cardId);
				System.out.println("You played your card: " + cardId);
				scanner.close();
				socket.close();
			}	
			catch ( IOException e ){
			}
		}
	}
	
	public static void main (String[] args) throws IOException, InterruptedException {
		
		Player player = new Player("0", 0);
		player.setUpPlayer();
		System.out.println("\'" + player.playerPort + "\' has been set as your port.");
		
		player.receiveCards();
		
		player.playCard();
		
		
	}
	
}
