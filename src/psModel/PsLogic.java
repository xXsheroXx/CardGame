package psModel;

import cardutils.Card;
import cardutils.Deck;
import cardutils.Pile;

import java.util.ArrayList;
import java.util.List;

public class PsLogic implements IPsLogic{
    private Card nextCard;
    private List<Pile> myPiles;
    private Deck deck;

    public PsLogic() {
        myPiles = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            myPiles.add(new Pile());
        }
        deck = new Deck();
        initNewGame();
    }


    @Override
    public void initNewGame() {
        deck.fill();
        deck.shuffleCards();
        for (Pile p : myPiles) {
            p.clear();
            p.add(deck.dealCard());
        }
    }

    @Override
    public Card pickNextCard() throws IllegalStateException {
        if (nextCard != null) throw new IllegalStateException("Can not pick Card");
        nextCard = deck.dealCard();
        return nextCard;
    }

    @Override
    public void addCardToPile(int n) throws IllegalStateException {
        if (nextCard == null) throw new IllegalStateException("You have not picked a card");
        if(myPiles.get(n).getSize()<5) {
            myPiles.get(n).add(nextCard);
            nextCard = null;
        }
    }

    @Override
    public boolean isGameOver() {
        return (getCardCount()==25);
    }

    @Override
    public int getCardCount() {
        return 52 - deck.getSize();
    }

    @Override
    public List<Pile> getPiles() {
        List<Pile> clonedList = new ArrayList<>();
        clonedList.addAll(myPiles);
        return clonedList;
    }

    @Override
    public int getPoints() {
        int point = 0;
        for (Pile p : myPiles) {
            point += PokerHands.getPokerCombo(p).getValue();
        }
        return point;
    }

    @Override
    public String toString() {
        StringBuilder s= new StringBuilder();
        for (Pile p: myPiles) {
            s.append(p.toString()).append("\n");
        }
        return s.toString();
    }
}
