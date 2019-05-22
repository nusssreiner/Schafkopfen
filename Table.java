import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Table {
	int nextPlayer, port1, port2, port3, port4, card1, card2, card3, card4, numberOfCards;
	
	public Table (int beginningPlayer) {
		nextPlayer = beginningPlayer;
		port1 = Game.getPort1();
		port2 = Game.getPort2();
		port3 = Game.getPort3();
		port4 = Game.getPort4();
	}
	
	//send request to player to play card
	public void requestOneRound() throws IOException {
		Table table = new Table (1);
		switch (nextPlayer) {
			case 1: 
				ServerSocket serverSocket1 = new ServerSocket(port1);
				Socket socket1 = serverSocket1.accept();
				PrintStream printStream = new PrintStream(socket1.getOutputStream());
				printStream.println("No cards have been played!");
				printStream.println("It's your turn.");
				printStream.println("Play a card!");
				Scanner scanner = new Scanner (socket1.getInputStream());
				System.out.println("The folling card was played: " + scanner.nextInt());
				serverSocket1.close();
				
				ServerSocket serverSocket2 = new ServerSocket(port2);
				Socket socket2 = serverSocket2.accept();
				
		}
		
	}
	
}
