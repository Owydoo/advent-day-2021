package day4.exo1;

public class BingoBox {
    private int value;
    private boolean isDrawn;

    public BingoBox(int value, boolean isDrawn) {
        this.value = value;
        this.isDrawn = isDrawn;
    }

    @Override
    public String toString() {
        return "BingoBox{" +
                "value=" + value +
                ", isDrawn=" + isDrawn +
                '}';
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isDrawn() {
        return isDrawn;
    }

    public void setDrawn(boolean drawn) {
        isDrawn = drawn;
    }
}
