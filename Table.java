import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Table {
	int nextPlayer, port1, port2, port3, port4, card1, card2, card3, card4;
	
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
		ServerSocket serverSocket = new ServerSocket(port1);
		Socket socket = serverSocket.accept();
		PrintStream printStream = new PrintStream(socket.getOutputStream());
		printStream.println("Play a card!");
		Scanner scanner = new Scanner (socket.getInputStream());
		System.out.println("The folling card was played: " + scanner.nextInt());
		serverSocket.close();
	}
	
}
