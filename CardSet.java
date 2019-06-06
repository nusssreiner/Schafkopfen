
public class CardSet {

    Card[] cards = new Card[32];


    public CardSet(RoundType roundType) {
        createBasicCardSet();
        editCardSet(roundType);
    }


    private void editCardSet(RoundType roundType) {
        switch (roundType) {
            case SAUSPIEL:
                setTrump(TrumpType.HERZ);
                setTrump(TrumpType.UNTER);
                setTrump(TrumpType.OBER);
                break;
            case RAMSCH:
                setTrump(TrumpType.HERZ);
                setTrump(TrumpType.UNTER);
                setTrump(TrumpType.OBER);
                break;
            case OACHESOLO:
                setTrump(TrumpType.OACHE);
                setTrump(TrumpType.UNTER);
                setTrump(TrumpType.OBER);
                break;
            case GROSSOLO:
                setTrump(TrumpType.GROS);
                setTrump(TrumpType.UNTER);
                setTrump(TrumpType.OBER);
                break;
            case HERZSOLO:
                setTrump(TrumpType.HERZ);
                setTrump(TrumpType.UNTER);
                setTrump(TrumpType.OBER);
                break;
            case SCHOINSOLO:
                setTrump(TrumpType.SCHOIN);
                setTrump(TrumpType.UNTER);
                setTrump(TrumpType.OBER);
                break;
        }
    }

    //sets cards.trump to trump the card matches the input criteria
    private void setTrump(TrumpType trumpType) {
        switch (trumpType) {
            case OACHE:
                for (int i = 0; i < 32; i++) {
                    cards[i].trump = cards[i].color == Color.OACHE ? Trump.TRUMP : cards[i].trump;
                }
                break;
            case GROS:
                for (int i = 0; i < 32; i++) {
                    cards[i].trump = cards[i].color == Color.GROS ? Trump.TRUMP : cards[i].trump;
                }
                break;
            case HERZ:
                for (int i = 0; i < 32; i++) {
                    cards[i].trump = cards[i].color == Color.HERZ ? Trump.TRUMP : cards[i].trump;
                }
                break;
            case SCHOIN:
                for (int i = 0; i < 32; i++) {
                    cards[i].trump = cards[i].color == Color.SCHOIN ? Trump.TRUMP : cards[i].trump;
                }
                break;
            case UNTER:
                for (int i = 0; i < 32; i++) {
                    cards[i].trump = cards[i].number == Number.UNTER ? Trump.TRUMP : cards[i].trump;
                }
                break;
            case OBER:
                for (int i = 0; i < 32; i++) {
                    cards[i].trump = cards[i].number == Number.OBER ? Trump.TRUMP : cards[i].trump;
                }
                break;
        }
    }

    //create a set of cards without trumps
    private void createBasicCardSet() {
        for (int i = 0; i < cards.length; i++) {
            cards[i] = new Card(i + 1);
        }
    }


    public boolean isTrump(int cardId) {
        return (cards[cardId - 1].trump == Trump.TRUMP);
    }

    public String getColor (int cardId) {
        return cards[cardId - 1].color.toString();
    }

    public String getCardInfo(int cardId) {
        return cards[cardId -1].color.toString() + " " + cards[cardId - 1].number.toString() + " " + cards[cardId -1].trump.toString();
    }
}















