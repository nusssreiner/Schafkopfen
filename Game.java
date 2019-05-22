import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
	static int port1, port2, port3, port4, startingPlayer;
	
	private static void createGame (int p1, int p2, int p3, int p4, int whoStarts) {
		port1 = p1;
		port2 = p2;
		port3 = p3;
		port4 = p4;
		startingPlayer = whoStarts;
	}
	
	public static void main (String[] args) throws IOException {
		System.out.println("Enter the ID of the player who gets to start! (1-4)");
		Scanner sc = new Scanner(System.in);
		int whoStarts = 0;
		while (whoStarts == 0 || whoStarts > 4) {
			try {
				whoStarts = sc.nextInt();
				if (whoStarts == 0 || whoStarts > 4) {
					System.out.println("Invalid entry, try again");
				}
				else {
					System.out.println("Player " + whoStarts + " is going to start.");
				}
			}
			catch ( InputMismatchException e) {
				System.out.println("Invalid entry, try again");
			};
			
		}
		
		Game.createGame(3001, 3002, 3003, 3004, whoStarts);
		System.out.println("Connecting to players and handing out cards.");
		LocalPlayer.startGame(port1, port2, port3, port4);
		System.out.println("Opening Table and asking Player " + startingPlayer + " to start.");
		Table table = new Table (2);
		table.requestOneRound();
	}
	
	public static int getPort1 () {
		return port1;
	}
	
	public static int getPort2 () {
		return port2;
	}
	
	public static int getPort3 () {
		return port3;
	}
	
	public static int getPort4 () {
		return port4;
	}
}
