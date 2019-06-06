

	public class Card {

		Color color;
		Number number;
		Trump trump;
		int cardId;

		//constructor
		public Card(int Id) {
			cardId = Id;
			switch (Id) {
				case 1:
					color = Color.OACHE;
					number = Number.SIEBEN;
					break;
				case 2:
					color = Color.OACHE;
					number = Number.ACHT;
					break;
				case 3:
					color = Color.OACHE;
					number = Number.NEUN;
					break;
				case 4:
					color = Color.OACHE;
					number = Number.ZEHN;
					break;
				case 5:
					color = Color.OACHE;
					number = Number.UNTER;
					break;
				case 6:
					color = Color.OACHE;
					number = Number.OBER;
					break;
				case 7:
					color = Color.OACHE;
					number = Number.KOENIG;
					break;
				case 8:
					color = Color.OACHE;
					number = Number.SAU;
					break;
				case 9:
					color = Color.GROS;
					number = Number.SIEBEN;
					break;
				case 10:
					color = Color.GROS;
					number = Number.ACHT;
					break;
				case 11:
					color = Color.GROS;
					number = Number.NEUN;
					break;
				case 12:
					color = Color.GROS;
					number = Number.ZEHN;
					break;
				case 13:
					color = Color.GROS;
					number = Number.UNTER;
					break;
				case 14:
					color = Color.GROS;
					number = Number.OBER;
					break;
				case 15:
					color = Color.GROS;
					number = Number.KOENIG;
					break;
				case 16:
					color = Color.GROS;
					number = Number.SAU;
					break;
				case 17:
					color = Color.HERZ;
					number = Number.SIEBEN;
					break;
				case 18:
					color = Color.HERZ;
					number = Number.ACHT;
					break;
				case 19:
					color = Color.HERZ;
					number = Number.NEUN;
					break;
				case 20:
					color = Color.HERZ;
					number = Number.ZEHN;
					break;
				case 21:
					color = Color.HERZ;
					number = Number.UNTER;
					break;
				case 22:
					color = Color.HERZ;
					number = Number.OBER;
					break;
				case 23:
					color = Color.HERZ;
					number = Number.KOENIG;
					break;
				case 24:
					color = Color.HERZ;
					number = Number.SAU;
					break;
				case 25:
					color = Color.SCHOIN;
					number = Number.SIEBEN;
					break;
				case 26:
					color = Color.SCHOIN;
					number = Number.ACHT;
					break;
				case 27:
					color = Color.SCHOIN;
					number = Number.NEUN;
					break;
				case 28:
					color = Color.SCHOIN;
					number = Number.ZEHN;
					break;
				case 29:
					color = Color.SCHOIN;
					number = Number.UNTER;
					break;
				case 30:
					color = Color.SCHOIN;
					number = Number.OBER;
					break;
				case 31:
					color = Color.SCHOIN;
					number = Number.KOENIG;
					break;
				case 32:
					color = Color.SCHOIN;
					number = Number.SAU;
					break;
			}
			trump = Trump.NOTTRUMP;
		}

		public int getCardId() {
			return cardId;
		}
	}
