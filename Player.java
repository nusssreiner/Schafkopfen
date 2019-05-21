import java.io.IOException;
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
	
	//receiveCard
	public void receiveCards () throws  IOException, InterruptedException {
		//keep checking for cards as long as Player does not have any
		while (card1 == 0) {
			int inputCard1, inputCard2, inputCard3, inputCard4, inputCard5, inputCard6, inputCard7, inputCard8;
			int port = playerPort; 
			try {
				Socket socket = new Socket("192.168.2.10", port);
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
	
	public static void main (String[] args) throws IOException, InterruptedException {
		//Player chooses name and port
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your name!");
		String name = scanner.next();
		System.out.println("You chose \'" + name + "\' as your name.");
		System.out.println("Now choose an ID! Enter a number from 1-4");
		System.out.println("Make sure noone else in your game choses the same number as you!");
		int port = 0;
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
		Player player = new Player(name, port);
		System.out.println("\'" + player.playerPort + "\' has been set as your port.");
		scanner.close();
		
		//Player receives cards
		player.receiveCards();
	
		
		
	}
	
}
