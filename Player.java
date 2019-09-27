import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Player {

	private int playerPort, card1, card2, card3, card4, card5, card6, card7, card8, firstCard;
	private CardSet cardSet;
	private RoundType roundType;
	private String playerName;


	//constructor
	private Player(String playerName, int playerPort) {
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
		int port = 0;
		while (port == 0) {
			int id = input.nextInt();
			switch (id) {
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

	//receiveCards
	private void receiveCards() throws InterruptedException {
		//keep checking for cards as long as Player does not have any
		while (card1 == 0) {
			int inputCard1, inputCard2, inputCard3, inputCard4, inputCard5, inputCard6, inputCard7, inputCard8;
			int port = playerPort;
			try {
				Socket socket = new Socket("127.0.0.1", port);
				Thread.sleep(500);
				Scanner scanner = new Scanner(socket.getInputStream());
				roundType = RoundType.valueOf(scanner.nextLine());
				cardSet = new CardSet(roundType);
				inputCard1 = scanner.nextInt();
				inputCard2 = scanner.nextInt();
				inputCard3 = scanner.nextInt();
				inputCard4 = scanner.nextInt();
				inputCard5 = scanner.nextInt();
				inputCard6 = scanner.nextInt();
				inputCard7 = scanner.nextInt();
				inputCard8 = scanner.nextInt();
				PrintStream printStream = new PrintStream(socket.getOutputStream());
				printStream.println(playerName);
				scanner.close();
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
				System.out.println(cardSet.getCardInfo(card1));
				System.out.println(cardSet.getCardInfo(card2));
				System.out.println(cardSet.getCardInfo(card3));
				System.out.println(cardSet.getCardInfo(card4));
				System.out.println(cardSet.getCardInfo(card5));
				System.out.println(cardSet.getCardInfo(card6));
				System.out.println(cardSet.getCardInfo(card7));
				System.out.println(cardSet.getCardInfo(card8));
			} catch (IOException e) {
			}
		}
	}

	//receiveRoundInfo
	private void receiveRoundInfo() throws InterruptedException {

	}


	//setRoundType
	private void setRoundType() throws InterruptedException {
		boolean wereAsked = false;
		while (!wereAsked) {
			try {
				Socket socket = new Socket("127.0.0.1", playerPort);
				System.out.println("Do you want to play?");
				Scanner scanner = new Scanner(socket.getInputStream());
				Thread.sleep(100);
				int whichPlayer = scanner.nextInt();
				switch (whichPlayer) {
					case 1:
						System.out.println("You're the first one to decide!");
						break;
					case 2:
						System.out.println("You're the second one to decide!");
						System.out.println(scanner.nextLine());
						break;
					case 3:
						System.out.println("You're the third one to decide!");
						System.out.println(scanner.nextLine());
						break;
					case 4:
						System.out.println("You're the last one to decide!");
						System.out.println(scanner.nextLine());
						break;
				}
				wereAsked = true;
			}
			catch (IOException ignored){}
			Thread.sleep(200);
		}

	}

	//compare color of 2 cards
	private boolean compareColor(int id1, int id2) {
		return cardSet.getColor(id1).equals(cardSet.getColor(id2));
	}

	//check whether one of the cards is a trump
	private boolean checkForTrump() {
		return cardSet.isTrump(card1) || cardSet.isTrump(card2) || cardSet.isTrump(card3) || cardSet.isTrump(card4) ||
				cardSet.isTrump(card5) || cardSet.isTrump(card6) || cardSet.isTrump(card7) || cardSet.isTrump(card8);
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
		else if (cardSet.isTrump(firstCard)) {
			if (!checkForTrump()) {
				return true;
			} else if (cardSet.isTrump(id)) {
				return true;
			} else {
				return false;
			}
		} else if (checkForColor()) {
			return compareColor(id, firstCard);
		} else {
			return true;
		}
	}

	//play card
	private void playCard() throws InterruptedException {
		int cardId = 0;
		while (cardId == 0) {
			try {
				Socket socket = new Socket("127.0.0.1", playerPort);
				Thread.sleep(500);
				Scanner scanner = new Scanner(socket.getInputStream());
				Scanner input = new Scanner(System.in);
				System.out.println();
				firstCard = scanner.nextInt();
				System.out.println("Table states: \'" + scanner.nextLine() + "\'");
				System.out.println("Table states: \'" + scanner.nextLine() + "\'");
				System.out.println("Table requests: \'" + scanner.nextLine() + "\'");
				PrintStream printStream = new PrintStream(socket.getOutputStream());
				System.out.println("You have the following cards available:");
				System.out.println("card1 = " + cardSet.getCardInfo(card1));
				System.out.println("card2 = " + cardSet.getCardInfo(card2));
				System.out.println("card3 = " + cardSet.getCardInfo(card3));
				System.out.println("card4 = " + cardSet.getCardInfo(card4));
				System.out.println("card5 = " + cardSet.getCardInfo(card5));
				System.out.println("card6 = " + cardSet.getCardInfo(card6));
				System.out.println("card7 = " + cardSet.getCardInfo(card7));
				System.out.println("card8 = " + cardSet.getCardInfo(card8));
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
				System.out.println("You played your card: " + cardSet.getCardInfo(cardId));
				scanner.close();
				socket.close();
			} catch (IOException ignored) {
			}
			Thread.sleep(200);
		}
		System.out.println("just exited the loop!");
	}

	public static void main(String[] args) throws IOException, InterruptedException {

		Player player = new Player("0", 0);
		player.setUpPlayer();
		System.out.println("\'" + player.playerPort + "\' has been set as your port.");
		player.receiveCards();
		player.setRoundType();
		player.playCard();

	}
}