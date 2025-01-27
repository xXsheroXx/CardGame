package cardutils;

import java.util.ArrayList;

public class Pile {
    private ArrayList<Card> theCards;

    public Pile() {
        this.theCards = new ArrayList<>();
    }

    public Pile(ArrayList<Card> initialCards) {
        // initialCards might be manipulated outside this class - make a copy
        ArrayList<Card> copy = new ArrayList<>(initialCards); // alt. copy = theCards.clone();
        this.theCards = copy;
    }

    public int getSize() {
        return theCards.size();
    }

    public void clear() {
        theCards.clear();
    }

    public void add(Card c) {
        theCards.add(c);
    }

    public void add(ArrayList<Card> cards) {
        theCards.addAll(cards);
    }

    public Card get(int index) {
        return theCards.get(index);
    }

    public ArrayList<Card> getTheCards() {
        ArrayList<Card> copy = (ArrayList<Card>) theCards.clone();
        return copy;
    }

    public Card remove(int index) {
        Card c = theCards.remove(index);
        return c;
    }

    public boolean remove(Card c) {
        return theCards.remove(c);
    }

    public boolean contains(Card c) {
        return theCards.contains(c);
    }

    public boolean remove(ArrayList<Card> cards) {
        return theCards.removeAll(cards);
    }

    public int noOfSuit (Suit suit) {
        int counter = 0;
        for (Card c : theCards) {
            if (c.getSuit() == suit) {
                counter ++;
            }
        }
        return counter;
    }

    public int noOfRank(Rank rank) {
        int counter = 0;
        for (Card c : theCards) {
            if (c.getRank() == rank) {
                counter ++;
            }
        }
        return counter;
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