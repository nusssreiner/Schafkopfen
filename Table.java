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
				ServerSocket serverSocket11 = new ServerSocket(port1);
				Socket socket11 = serverSocket11.accept();
				PrintStream printStream11 = new PrintStream(socket11.getOutputStream());
				printStream11.println(0);
				printStream11.println("No cards have been played!");
				printStream11.println("It's your turn.");
				printStream11.println("Play a card!");
				Scanner scanner11 = new Scanner (socket11.getInputStream());
				card1 = scanner11.nextInt();
				System.out.println("The folling card was played by Player 1: " + Card.getCardInfo(card1));
				serverSocket11.close();
				
				ServerSocket serverSocket12 = new ServerSocket(port2); //change port later to port2
				Socket socket12 = serverSocket12.accept();
				PrintStream printStream12 = new PrintStream(socket12.getOutputStream());
				printStream12.println(card1);
				printStream12.println(Card.getCardInfo(card1) + " has been played by Player 2"); 
				printStream12.println("It's your turn now.");
				printStream12.println("Play a valid card!");
				Scanner scanner12 = new Scanner (socket12.getInputStream());
				card2 = scanner12.nextInt();
				System.out.println("The folling card was played by Player 2: " + Card.getCardInfo(card2));
				serverSocket12.close();
				
				ServerSocket serverSocket13 = new ServerSocket(port3); //change port later to port3
				Socket socket13 = serverSocket13.accept();
				PrintStream printStream13 = new PrintStream(socket13.getOutputStream());
				printStream13.println(card1);
				printStream13.println("The cards \'" + Card.getCardInfo(card1) + "\' and \'" + Card.getCardInfo(card2)  + "\' have been played by Player 1 and 2."); 
				printStream13.println("It's your turn now.");
				printStream13.println("Play a valid card!");
				Scanner scanner13 = new Scanner (socket13.getInputStream());
				card3 = scanner13.nextInt();
				System.out.println("The folling card was played by Player 3: " + Card.getCardInfo(card3));
				serverSocket13.close();
				
				ServerSocket serverSocket14 = new ServerSocket(port4); //change port later to port4
				Socket socket14 = serverSocket14.accept();
				PrintStream printStream14 = new PrintStream(socket14.getOutputStream());
				printStream14.println(card1);
				printStream14.println("The cards \'" + Card.getCardInfo(card1) + "\', \'" + Card.getCardInfo(card2)  + "\' and \'" + Card.getCardInfo(card3) + "\' have been played by Player 1, 2 and 3."); 
				printStream14.println("It's your turn now.");
				printStream14.println("Play a valid card!");
				Scanner scanner14 = new Scanner (socket14.getInputStream());
				card4 = scanner14.nextInt();
				System.out.println("The folling card was played by Player 4: " + Card.getCardInfo(card4));
				serverSocket14.close();
				break;
			case 2:
				ServerSocket serverSocket21 = new ServerSocket(port2);
				Socket socket21 = serverSocket21.accept();
				PrintStream printStream21 = new PrintStream(socket21.getOutputStream());
				printStream21.println(0);
				printStream21.println("No cards have been played!");
				printStream21.println("It's your turn.");
				printStream21.println("Play a card!");
				Scanner scanner21 = new Scanner (socket21.getInputStream());
				card1 = scanner21.nextInt();
				System.out.println("The folling card was played by Player 2: " + Card.getCardInfo(card1));
				serverSocket21.close();
				
				ServerSocket serverSocket22 = new ServerSocket(port3); //change port later to port2
				Socket socket22 = serverSocket22.accept();
				PrintStream printStream22 = new PrintStream(socket22.getOutputStream());
				printStream22.println(card1);
				printStream22.println(Card.getCardInfo(card1) + " has been played by Player 2"); 
				printStream22.println("It's your turn now.");
				printStream22.println("Play a valid card!");
				Scanner scanner22 = new Scanner (socket22.getInputStream());
				card2 = scanner22.nextInt();
				System.out.println("The folling card was played by Player 3: " + Card.getCardInfo(card2));
				serverSocket22.close();
				
				ServerSocket serverSocket23 = new ServerSocket(port4); //change port later to port3
				Socket socket23 = serverSocket23.accept();
				PrintStream printStream23 = new PrintStream(socket23.getOutputStream());
				printStream23.println(card1);
				printStream23.println("The cards \'" + Card.getCardInfo(card1) + "\' and \'" + Card.getCardInfo(card2)  + "\' have been played by Player 2 and 3."); 
				printStream23.println("It's your turn now.");
				printStream23.println("Play a valid card!");
				Scanner scanner23 = new Scanner (socket23.getInputStream());
				card3 = scanner23.nextInt();
				System.out.println("The folling card was played by Player 4: " + Card.getCardInfo(card3));
				serverSocket23.close();
				
				ServerSocket serverSocket24 = new ServerSocket(port1); //change port later to port4
				Socket socket24 = serverSocket24.accept();
				PrintStream printStream24 = new PrintStream(socket24.getOutputStream());
				printStream24.println(card1);
				printStream24.println("The cards \'" + Card.getCardInfo(card1) + "\', \'" + Card.getCardInfo(card2)  + "\' and \'" + Card.getCardInfo(card3) + "\' have been played by Player 2, 3 and 4."); 
				printStream24.println("It's your turn now.");
				printStream24.println("Play a valid card!");
				Scanner scanner24 = new Scanner (socket24.getInputStream());
				card4 = scanner24.nextInt();
				System.out.println("The folling card was played by Player 1: " + Card.getCardInfo(card4));
				serverSocket24.close();
				break;
			case 3:
				ServerSocket serverSocket31 = new ServerSocket(port3);
				Socket socket31 = serverSocket31.accept();
				PrintStream printStream31 = new PrintStream(socket31.getOutputStream());
				printStream31.println(0);
				printStream31.println("No cards have been played!");
				printStream31.println("It's your turn.");
				printStream31.println("Play a card!");
				Scanner scanner31 = new Scanner (socket31.getInputStream());
				card1 = scanner31.nextInt();
				System.out.println("The folling card was played by Player 3: " + Card.getCardInfo(card1));
				serverSocket31.close();
				
				ServerSocket serverSocket32 = new ServerSocket(port4); //change port later to port2
				Socket socket32 = serverSocket32.accept();
				PrintStream printStream32 = new PrintStream(socket32.getOutputStream());
				printStream32.println(card1);
				printStream32.println(Card.getCardInfo(card1) + " has been played by Player 3"); 
				printStream32.println("It's your turn now.");
				printStream32.println("Play a valid card!");
				Scanner scanner32 = new Scanner (socket32.getInputStream());
				card2 = scanner32.nextInt();
				System.out.println("The folling card was played by Player 4: " + Card.getCardInfo(card2));
				serverSocket32.close();
				
				ServerSocket serverSocket33 = new ServerSocket(port1); //change port later to port3
				Socket socket33 = serverSocket33.accept();
				PrintStream printStream33 = new PrintStream(socket33.getOutputStream());
				printStream33.println(card1);
				printStream33.println("The cards \'" + Card.getCardInfo(card1) + "\' and \'" + Card.getCardInfo(card2)  + "\' have been played by Player 3 and 4."); 
				printStream33.println("It's your turn now.");
				printStream33.println("Play a valid card!");
				Scanner scanner33 = new Scanner (socket33.getInputStream());
				card3 = scanner33.nextInt();
				System.out.println("The folling card was played by Player 1: " + Card.getCardInfo(card3));
				serverSocket33.close();
				
				ServerSocket serverSocket34 = new ServerSocket(port2); //change port later to port4
				Socket socket34 = serverSocket34.accept();
				PrintStream printStream34 = new PrintStream(socket34.getOutputStream());
				printStream34.println(card1);
				printStream34.println("The cards \'" + Card.getCardInfo(card1) + "\', \'" + Card.getCardInfo(card2)  + "\' and \'" + Card.getCardInfo(card3) + "\' have been played by Player 3, 4 and 1."); 
				printStream34.println("It's your turn now.");
				printStream34.println("Play a valid card!");
				Scanner scanner34 = new Scanner (socket34.getInputStream());
				card4 = scanner34.nextInt();
				System.out.println("The folling card was played by Player 2: " + Card.getCardInfo(card4));
				serverSocket34.close();
				break;
			case 4:
				ServerSocket serverSocket41 = new ServerSocket(port4);
				Socket socket41 = serverSocket41.accept();
				PrintStream printStream41 = new PrintStream(socket41.getOutputStream());
				printStream41.println(0);
				printStream41.println("No cards have been played!");
				printStream41.println("It's your turn.");
				printStream41.println("Play a card!");
				Scanner scanner41 = new Scanner (socket41.getInputStream());
				card1 = scanner41.nextInt();
				System.out.println("The folling card was played by Player 4: " + Card.getCardInfo(card1));
				serverSocket41.close();
				
				ServerSocket serverSocket42 = new ServerSocket(port1); //change port later to port2
				Socket socket42 = serverSocket42.accept();
				PrintStream printStream42 = new PrintStream(socket42.getOutputStream());
				printStream42.println(card1);
				printStream42.println(Card.getCardInfo(card1) + " has been played by Player 2"); 
				printStream42.println("It's your turn now.");
				printStream42.println("Play a valid card!");
				Scanner scanner42 = new Scanner (socket42.getInputStream());
				card2 = scanner42.nextInt();
				System.out.println("The folling card was played by Player 1: " + Card.getCardInfo(card2));
				serverSocket42.close();
				
				ServerSocket serverSocket43 = new ServerSocket(port2); //change port later to port3
				Socket socket43 = serverSocket43.accept();
				PrintStream printStream43 = new PrintStream(socket43.getOutputStream());
				printStream43.println(card1);
				printStream43.println("The cards \'" + Card.getCardInfo(card1) + "\' and \'" + Card.getCardInfo(card2)  + "\' have been played by Player 1 and 2."); 
				printStream43.println("It's your turn now.");
				printStream43.println("Play a valid card!");
				Scanner scanner43 = new Scanner (socket43.getInputStream());
				card3 = scanner43.nextInt();
				System.out.println("The folling card was played by Player 2: " + Card.getCardInfo(card3));
				serverSocket43.close();
				
				ServerSocket serverSocket44 = new ServerSocket(port3); //change port later to port4
				Socket socket44 = serverSocket44.accept();
				PrintStream printStream44 = new PrintStream(socket44.getOutputStream());
				printStream44.println(card1);
				printStream44.println("The cards \'" + Card.getCardInfo(card1) + "\', \'" + Card.getCardInfo(card2)  + "\' and \'" + Card.getCardInfo(card3) + "\' have been played by Player 4, 1 and 2."); 
				printStream44.println("It's your turn now.");
				printStream44.println("Play a valid card!");
				Scanner scanner44 = new Scanner (socket44.getInputStream());
				card4 = scanner44.nextInt();
				System.out.println("The folling card was played by Player 3: " + Card.getCardInfo(card4));
				serverSocket44.close();
				break;
		}
		
	}
	
}
