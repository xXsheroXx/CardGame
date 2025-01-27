package psModel;

import cardutils.Pile;
import cardutils.Rank;
import cardutils.Suit;

public class PokerHands {
    private  PokerHands() {

    }

    static public PokerCombo getPokerCombo(Pile hand) {
        if(fourOfKind(hand)) return PokerCombo.FOUR_OF_KIND;
        if(threeOfKind(hand)) return PokerCombo.THREE_OF_KIND;
        if (flush(hand)) return PokerCombo.FLUSH;
        if(onePairOrTwoPair(hand) == 2) return PokerCombo.TWO_PAIR;
        if(onePairOrTwoPair(hand) == 1) return PokerCombo.PAIR;
        return PokerCombo.NONE;
    }

    static private int onePairOrTwoPair(Pile hand) {
        int counter = 0;
        for (Rank r : Rank.values()) {
            if(hand.noOfRank(r) == 2) {
                counter++;
            }
        }
        return counter;
    }

    static private boolean threeOfKind(Pile hand) {
        for (Rank r : Rank.values()) {
            if(hand.noOfRank(r) == 3) {
                return true;
            }
        }
        return false;
    }

    static private boolean fourOfKind(Pile hand) {
        for (Rank r : Rank.values()) {
            if(hand.noOfRank(r) == 4) {
                return true;
            }
        }
        return false;
    }

    static private boolean flush(Pile hand) {
        for (Suit s : Suit.values()) {
            if (hand.noOfSuit(s) == 5) {
                return true;
            }
        }
        return false;
    }
}
