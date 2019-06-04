

public class Card {
	
	Color color;
	Number number;
	Type type;
	int cardId;
	
	//constructor
	public Card (int Id) {
		cardId = Id;
		switch (Id) {
		case 1:
			color = Color.OACHE;
			number = Number.SIEBEN;
			type = Type.NOTTRUMP;
			break;
		case 2:
			color = Color.OACHE;
			number = Number.ACHT;
			type = Type.NOTTRUMP;
			break;
		case 3:
			color = Color.OACHE;
			number = Number.NEUN;
			type = Type.NOTTRUMP;
			break;
		case 4:
			color = Color.OACHE;
			number = Number.ZEHN;
			type = Type.NOTTRUMP;
			break;
		case 5:
			color = Color.OACHE;
			number = Number.UNTER;
			type = Type.TRUMP;
			break;
		case 6:
			color = Color.OACHE;
			number = Number.OBER;
			type = Type.TRUMP;
			break;
		case 7:
			color = Color.OACHE;
			number = Number.KOENIG;
			type = Type.NOTTRUMP;
			break;
		case 8:
			color = Color.OACHE;
			number = Number.SAU;
			type = Type.NOTTRUMP;
			break;	
		case 9:
			color = Color.GROS;
			number = Number.SIEBEN;
			type = Type.NOTTRUMP;
			break;
		case 10:
			color = Color.GROS;
			number = Number.ACHT;
			type = Type.NOTTRUMP;
			break;
		case 11:
			color = Color.GROS;
			number = Number.NEUN;
			type = Type.NOTTRUMP;
			break;
		case 12:
			color = Color.GROS;
			number = Number.ZEHN;
			type = Type.NOTTRUMP;
			break;
		case 13:
			color = Color.GROS;
			number = Number.UNTER;
			type = Type.TRUMP;
			break;
		case 14:
			color = Color.GROS;
			number = Number.OBER;
			type = Type.TRUMP;
			break;
		case 15:
			color = Color.GROS;
			number = Number.KOENIG;
			type = Type.NOTTRUMP;
			break;
		case 16:
			color = Color.GROS;
			number = Number.SAU;
			type = Type.NOTTRUMP;
			break;	
		case 17:
			color = Color.HERZ;
			number = Number.SIEBEN;
			type = Type.TRUMP;
			break;
		case 18:
			color = Color.HERZ;
			number = Number.ACHT;
			type = Type.TRUMP;
			break;
		case 19:
			color = Color.HERZ;
			number = Number.NEUN;
			type = Type.TRUMP;
			break;
		case 20:
			color = Color.HERZ;
			number = Number.ZEHN;
			type = Type.TRUMP;
			break;
		case 21:
			color = Color.HERZ;
			number = Number.UNTER;
			type = Type.TRUMP;
			break;
		case 22:
			color = Color.HERZ;
			number = Number.OBER;
			type = Type.TRUMP;
			break;
		case 23:
			color = Color.HERZ;
			number = Number.KOENIG;
			type = Type.TRUMP;
			break;
		case 24:
			color = Color.HERZ;
			number = Number.SAU;
			type = Type.TRUMP;
			break;
		case 25:
			color = Color.SCHOIN;
			number = Number.SIEBEN;
			type = Type.NOTTRUMP;
			break;
		case 26:
			color = Color.SCHOIN;
			number = Number.ACHT;
			type = Type.NOTTRUMP;
			break;
		case 27:
			color = Color.SCHOIN;
			number = Number.NEUN;
			type = Type.NOTTRUMP;
			break;
		case 28:
			color = Color.SCHOIN;
			number = Number.ZEHN;
			type = Type.NOTTRUMP;
			break;
		case 29:
			color = Color.SCHOIN;
			number = Number.UNTER;
			type = Type.TRUMP;
			break;
		case 30:
			color = Color.SCHOIN;
			number = Number.OBER;
			type = Type.TRUMP;
			break;
		case 31:
			color = Color.SCHOIN;
			number = Number.KOENIG;
			type = Type.NOTTRUMP;
			break;
		case 32:
			color = Color.SCHOIN;
			number = Number.SAU;
			type = Type.NOTTRUMP;
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
	
	public static String getType(int Id) {
		Card card = new Card(Id);
		return card.type.toString();
	}
}

