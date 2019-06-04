

public class Card {
	
	Color color;
	Number number;
	Trump trump;
	int cardId;
	
	//constructor
	public Card (int Id) {
		cardId = Id;
		switch (Id) {
		case 1:
			color = Color.OACHE;
			number = Number.SIEBEN;
			trump = Trump.NOTTRUMP;
			break;
		case 2:
			color = Color.OACHE;
			number = Number.ACHT;
			trump = Trump.NOTTRUMP;
			break;
		case 3:
			color = Color.OACHE;
			number = Number.NEUN;
			trump = Trump.NOTTRUMP;
			break;
		case 4:
			color = Color.OACHE;
			number = Number.ZEHN;
			trump = Trump.NOTTRUMP;
			break;
		case 5:
			color = Color.OACHE;
			number = Number.UNTER;
			trump = Trump.TRUMP;
			break;
		case 6:
			color = Color.OACHE;
			number = Number.OBER;
			trump = Trump.TRUMP;
			break;
		case 7:
			color = Color.OACHE;
			number = Number.KOENIG;
			trump = Trump.NOTTRUMP;
			break;
		case 8:
			color = Color.OACHE;
			number = Number.SAU;
			trump = Trump.NOTTRUMP;
			break;	
		case 9:
			color = Color.GROS;
			number = Number.SIEBEN;
			trump = Trump.NOTTRUMP;
			break;
		case 10:
			color = Color.GROS;
			number = Number.ACHT;
			trump = Trump.NOTTRUMP;
			break;
		case 11:
			color = Color.GROS;
			number = Number.NEUN;
			trump = Trump.NOTTRUMP;
			break;
		case 12:
			color = Color.GROS;
			number = Number.ZEHN;
			trump = Trump.NOTTRUMP;
			break;
		case 13:
			color = Color.GROS;
			number = Number.UNTER;
			trump = Trump.TRUMP;
			break;
		case 14:
			color = Color.GROS;
			number = Number.OBER;
			trump = Trump.TRUMP;
			break;
		case 15:
			color = Color.GROS;
			number = Number.KOENIG;
			trump = Trump.NOTTRUMP;
			break;
		case 16:
			color = Color.GROS;
			number = Number.SAU;
			trump = Trump.NOTTRUMP;
			break;	
		case 17:
			color = Color.HERZ;
			number = Number.SIEBEN;
			trump = Trump.TRUMP;
			break;
		case 18:
			color = Color.HERZ;
			number = Number.ACHT;
			trump = Trump.TRUMP;
			break;
		case 19:
			color = Color.HERZ;
			number = Number.NEUN;
			trump = Trump.TRUMP;
			break;
		case 20:
			color = Color.HERZ;
			number = Number.ZEHN;
			trump = Trump.TRUMP;
			break;
		case 21:
			color = Color.HERZ;
			number = Number.UNTER;
			trump = Trump.TRUMP;
			break;
		case 22:
			color = Color.HERZ;
			number = Number.OBER;
			trump = Trump.TRUMP;
			break;
		case 23:
			color = Color.HERZ;
			number = Number.KOENIG;
			trump = Trump.TRUMP;
			break;
		case 24:
			color = Color.HERZ;
			number = Number.SAU;
			trump = Trump.TRUMP;
			break;
		case 25:
			color = Color.SCHOIN;
			number = Number.SIEBEN;
			trump = Trump.NOTTRUMP;
			break;
		case 26:
			color = Color.SCHOIN;
			number = Number.ACHT;
			trump = Trump.NOTTRUMP;
			break;
		case 27:
			color = Color.SCHOIN;
			number = Number.NEUN;
			trump = Trump.NOTTRUMP;
			break;
		case 28:
			color = Color.SCHOIN;
			number = Number.ZEHN;
			trump = Trump.NOTTRUMP;
			break;
		case 29:
			color = Color.SCHOIN;
			number = Number.UNTER;
			trump = Trump.TRUMP;
			break;
		case 30:
			color = Color.SCHOIN;
			number = Number.OBER;
			trump = Trump.TRUMP;
			break;
		case 31:
			color = Color.SCHOIN;
			number = Number.KOENIG;
			trump = Trump.NOTTRUMP;
			break;
		case 32:
			color = Color.SCHOIN;
			number = Number.SAU;
			trump = Trump.NOTTRUMP;
			break;
		}
	}

	public int getCardId() {
		return cardId;
	}

	public static String getCardInfo(int Id) {
		Card card = new Card(Id);
		return card.color.toString() + " " + card.number.toString();
	}
	
	public static String getColor(int Id) {
		Card card = new Card(Id);
		return card.color.toString();
	}

	public static String getNumber(int Id) {
		Card card = new Card(Id);
		return card.number.toString();
	}
	
	public static boolean isTrump(int Id) {
		Card card = new Card(Id);
		return (card.trump.toString().equals(Trump.TRUMP.toString()));
	}
}

