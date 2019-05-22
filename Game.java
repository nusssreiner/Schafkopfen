import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Game {
	static int port1, port2, port3, port4;
	
	private static void createGame (int p1, int p2, int p3, int p4) {
		port1 = p1;
		port2 = p2;
		port3 = p3;
		port4 = p4;
	}
	
	public static void main (String[] args) throws IOException {
		Game.createGame(3001, 3002, 3003, 3004);
		LocalPlayer.startGame(port1, port2, port3, port4);
		Table table = new Table (1);
		table.request();
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
