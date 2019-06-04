import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Round {
	int startingPlayer;
	Game game;
	RoundType type;

	public Round(int startingPlayer, Game game, RoundType type) {
		this.game = game;
		this.startingPlayer = startingPlayer;
		this.type = type;
	}


	//start a game (mix cards, pass to players)
	public void startRound() throws IOException {

		shuffleCards();

		game.player1.handOutCards();
		game.player2.handOutCards();
		game.player3.handOutCards();
		game.player4.handOutCards();

		System.out.println("Opening Table and asking Player " + startingPlayer + " to start.");
		Table table = new Table(this);
		table.requestOneRound();
	}

	private void shuffleCards() {
		List<LocalPlayer> availablePlayers = Arrays.asList(game.player1, game.player2, game.player3, game.player4);

		for (int i = 1; i <= 32; i++) {
			availablePlayers = availablePlayers.stream()
					.filter(player -> player.getNumberOfCards() < 8)
					.collect(Collectors.toList());

			int random = new Random().nextInt(availablePlayers.size());
			availablePlayers.get(random).assignCard(new Card(i));
		}
	}
}
