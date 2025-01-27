package cardutils;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private final ArrayList<Card> theCards;
    private static final ArrayList<Card >protoDeck = new ArrayList<>();

    static {
        for (Suit s : Suit.values()) {
            for (Rank r : Rank.values()) {
                protoDeck.add(new Card(r,s));
            }
        }
    }
    /**
     * Create a new deck with 52 distinct cards.
     */
    public Deck() {
        theCards = new ArrayList<>();
        fill();
    }

    /**
     * Fill the deck with 52 distinct cards.
     */
    public void fill() {
        theCards.clear(); // remove possibly remaining cards
        theCards.addAll(protoDeck);
    }

    public int getSize() {
        return theCards.size();
    }

    /**
     * Return, and remove, the card at the top of the deck.
     */
    public Card dealCard() {
        return theCards.remove(theCards.size() - 1);
    }


    /**
     * Shuffle (mix) the cards in the deck.
     */
    public void shuffleCards() {
        Collections.shuffle(theCards);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        if (theCards.size() > 0) {
            builder.append(theCards.get(0).toString());
            for (int i = 1; i < theCards.size(); i++) {
                builder.append(", ").append(theCards.get(i).toString());
            }
        }
        builder.append("]");

        return builder.toString();
    }
}
