
public class CardSet {

    Card[] cards = new Card[31];


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
            case RAMSCH:
                setTrump(TrumpType.HERZ);
                setTrump(TrumpType.UNTER);
                setTrump(TrumpType.OBER);
            case OACHESOLO:
                setTrump(TrumpType.OACHE);
                setTrump(TrumpType.UNTER);
                setTrump(TrumpType.OBER);
            case GROSSOLO:
                setTrump(TrumpType.GROS);
                setTrump(TrumpType.UNTER);
                setTrump(TrumpType.OBER);
            case HERZSOLO:
                setTrump(TrumpType.HERZ);
                setTrump(TrumpType.UNTER);
                setTrump(TrumpType.OBER);
            case SCHOINSOLO:
                setTrump(TrumpType.SCHOIN);
                setTrump(TrumpType.UNTER);
                setTrump(TrumpType.OBER);
        }
    }

    //sets cards.trump to trump the card matches the input criteria
    private void setTrump(TrumpType trumpType) {
        switch (trumpType) {
            case OACHE:
                for (int i = 0; i < 32; i++) {
                    cards[i].trump = cards[i].color == Color.OACHE ? Trump.TRUMP : cards[i].trump;
                }
            case GROS:
                for (int i = 0; i < 32; i++) {
                    cards[i].trump = cards[i].color == Color.GROS ? Trump.TRUMP : cards[i].trump;
                }
            case HERZ:
                for (int i = 0; i < 32; i++) {
                    cards[i].trump = cards[i].color == Color.HERZ ? Trump.TRUMP : cards[i].trump;
                }
            case SCHOIN:
                for (int i = 0; i < 32; i++) {
                    cards[i].trump = cards[i].color == Color.SCHOIN ? Trump.TRUMP : cards[i].trump;
                }
            case UNTER:
                for (int i = 0; i < 32; i++) {
                    cards[i].trump = cards[i].number == Number.UNTER ? Trump.TRUMP : cards[i].trump;
                }
            case OBER:
                for (int i = 0; i < 32; i++) {
                    cards[i].trump = cards[i].number == Number.OBER ? Trump.TRUMP : cards[i].trump;
                }
        }
    }

    //create a set of cards without trumps
    private void createBasicCardSet() {
        for (int i = 0; i < cards.length; i++) {
            cards[i] = new Card(i + 1);
        }
    }

    public static void main(String[] args) {
        CardSet cardSet = new CardSet(RoundType.SAUSPIEL);
        System.out.println(cardSet.cards[0]);
    }


    public boolean isTrump(int cardId) {
        return (cards[cardId - 1].trump == Trump.TRUMP);
    }
}