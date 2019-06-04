import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Player {
	
	int playerPort, card1, card2, card3, card4, card5, card6, card7, card8, port, firstCard;
	String playerName;
	
	
	
	//constructor
	public Player (String playerName, int playerPort) {
		this.playerName = playerName;
		this.playerPort = playerPort;
		
	}
	
	//creating player (p gets to chose name and port)
	private void setUpPlayer() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter your name!");
		playerName = input.next();
		System.out.println("You chose \'" + playerName + "\' as your name.");
		System.out.println("Now choose an ID! Enter a number from 1-4");
		System.out.println("Make sure noone else in your game choses the same number as you!");
		port = 0;
		while (port == 0) {
			int id = input.nextInt();
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
				Thread.sleep(500);
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
				System.out.println();
				System.out.println("You received the following cards: ");
				System.out.println(Card.getCardInfo(card1));
				System.out.println(Card.getCardInfo(card2));
				System.out.println(Card.getCardInfo(card3));
				System.out.println(Card.getCardInfo(card4));
				System.out.println(Card.getCardInfo(card5));
				System.out.println(Card.getCardInfo(card6));
				System.out.println(Card.getCardInfo(card7));
				System.out.println(Card.getCardInfo(card8));
			}	
			catch ( IOException e ){
			}
		}	
	}
	
	//compare color of 2 cards
	private boolean compareColor(int id1, int id2) {
		return Card.getColor(id1).equals(Card.getColor(id2));
	}
	
	//check whether there is a card of the trump of the first card
	private boolean checkForTrump() {
		return Card.isTrump(card1) || Card.isTrump(card2) || Card.isTrump(card3) || Card.isTrump(card4) ||
			   Card.isTrump(card5) || Card.isTrump(card6) || Card.isTrump(card7) || Card.isTrump(card8);
	}
	private boolean checkForColor() {
		return compareColor(card1, firstCard) || compareColor(card2, firstCard) || compareColor(card3, firstCard) || compareColor(card4, firstCard) ||
				compareColor(card5, firstCard) || compareColor(card6, firstCard) || compareColor(card7, firstCard) || compareColor(card8, firstCard);
	}
	
	//check validity of a card, that is about to be played
	private boolean checkValidity(int id) {
		//there was no card assigned, the entry was not valid
		if (id == 0) {
			return false;
		}
		//a card is always valid, if it is the first one
		else if (firstCard == 0) {
			return true;
		}
		// if the first card was a trump, then a trump has to be played if available
		else if (Card.isTrump(firstCard)) {
			if (!checkForTrump()) {
				return true;
			}
			else if (Card.isTrump(id)) {
				return true;
			}
			else {
				return false;
			}
		}
		else if (checkForColor()) {
			return compareColor(id, firstCard);
		}
		else {
			return true;
		}
	}
	
	//play card
	private void playCard() throws InterruptedException {
		int cardId = 0;
		while (cardId == 0) {
			try {
				Socket socket = new Socket("127.0.0.1", port);
				Thread.sleep(500);
				Scanner scanner = new Scanner (socket.getInputStream());
				Scanner input = new Scanner (System.in);
				System.out.println();
				firstCard = scanner.nextInt();
				System.out.println("Table states: \'" + scanner.nextLine() + "\'");
				System.out.println("Table states: \'" + scanner.nextLine() + "\'");
				System.out.println("Table requests: \'" + scanner.nextLine() + "\'");
				PrintStream printStream = new PrintStream(socket.getOutputStream());
				System.out.println("You have the following cards available:");
				System.out.println("card1 = " + Card.getCardInfo(card1)); //planning on adding class card with return method
				System.out.println("card2 = " + Card.getCardInfo(card2));
				System.out.println("card3 = " + Card.getCardInfo(card3));
				System.out.println("card4 = " + Card.getCardInfo(card4));
				System.out.println("card5 = " + Card.getCardInfo(card5));
				System.out.println("card6 = " + Card.getCardInfo(card6));
				System.out.println("card7 = " + Card.getCardInfo(card7));
				System.out.println("card8 = " + Card.getCardInfo(card8));
				System.out.println("Choose a valid one! (pay attention to the color of the first card played!)");
				System.out.println("Enter your choice by typing cardx");
				
				String choice;
				choice = input.nextLine();
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
					if (!checkValidity(cardId)) {
						System.out.println("Invalid entry, try again");
						cardId = 0;
						choice = input.nextLine();
					}
				
				}
				printStream.println(cardId);
				System.out.println("You played your card: " + Card.getCardInfo(cardId));
				scanner.close();
				socket.close();
			}	
			catch ( IOException e ){
			}
			Thread.sleep(200);
		}
		System.out.println("just exited loop!");
	}
	
	public static void main (String[] args) throws IOException, InterruptedException {

		Player player = new Player("0", 0);
		player.setUpPlayer();
		System.out.println("\'" + player.playerPort + "\' has been set as your port.");
		player.receiveCards();
		player.playCard();
		
	}


} 
