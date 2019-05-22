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
		switch (nextPlayer) {
			case 1: 
				ServerSocket serverSocket1 = new ServerSocket(port1);
				Socket socket1 = serverSocket1.accept();
				PrintStream printStream1 = new PrintStream(socket1.getOutputStream());
				printStream1.println(0);
				printStream1.println("No cards have been played!");
				printStream1.println("It's your turn.");
				printStream1.println("Play a card!");
				Scanner scanner1 = new Scanner (socket1.getInputStream());
				card1 = scanner1.nextInt();
				System.out.println("The folling card was played by Player 1: " + Card.getCardInfo(card1));
				serverSocket1.close();
				
				ServerSocket serverSocket2 = new ServerSocket(port2); //change port later to port2
				Socket socket2 = serverSocket2.accept();
				PrintStream printStream2 = new PrintStream(socket2.getOutputStream());
				printStream2.println(card1);
				printStream2.println(Card.getCardInfo(card1) + " has been played by Player 2"); 
				printStream2.println("It's your turn now.");
				printStream2.println("Play a valid card!");
				Scanner scanner2 = new Scanner (socket2.getInputStream());
				card2 = scanner2.nextInt();
				System.out.println("The folling card was played by Player 2: " + Card.getCardInfo(card2));
				serverSocket2.close();
				
				ServerSocket serverSocket3 = new ServerSocket(port3); //change port later to port3
				Socket socket3 = serverSocket3.accept();
				PrintStream printStream3 = new PrintStream(socket3.getOutputStream());
				printStream3.println(card1);
				printStream3.println("The cards \'" + Card.getCardInfo(card1) + "\' and \'" + Card.getCardInfo(card2)  + "\' have been played by Player 1 and 2."); 
				printStream3.println("It's your turn now.");
				printStream3.println("Play a valid card!");
				Scanner scanner3 = new Scanner (socket3.getInputStream());
				card3 = scanner3.nextInt();
				System.out.println("The folling card was played by Player 3: " + Card.getCardInfo(card3));
				serverSocket3.close();
				
				ServerSocket serverSocket4 = new ServerSocket(port4); //change port later to port4
				Socket socket4 = serverSocket4.accept();
				PrintStream printStream4 = new PrintStream(socket4.getOutputStream());
				printStream4.println(card1);
				printStream4.println("The cards \'" + Card.getCardInfo(card1) + "\', \'" + Card.getCardInfo(card2)  + "\' and \'" + Card.getCardInfo(card3) + "\' have been played by Player 1, 2 and 3."); 
				printStream4.println("It's your turn now.");
				printStream4.println("Play a valid card!");
				Scanner scanner4 = new Scanner (socket4.getInputStream());
				card4 = scanner4.nextInt();
				System.out.println("The folling card was played by Player 4: " + Card.getCardInfo(card4));
				serverSocket4.close();
		}
		
	}
	
}
