package psModel;

public enum PokerCombo {

    NONE(0), PAIR(1), TWO_PAIR(3), THREE_OF_KIND(6), FLUSH(5), FOUR_OF_KIND(16);
    public int getValue() {
        return value;
    }

    private final int value;

    private PokerCombo(int value) {
        this.value = value;
    }
}
