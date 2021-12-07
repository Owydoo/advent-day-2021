package day5.exo1;

public class Vent {
    private int x, y;

    public Vent(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "{" +
                "x=" + x +
                ", y=" + y +
                "}\n";
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    /**
     * We take only vertical or horizontal lines so one coordinate has to be equal
     *
     * @param vent
     * @return
     */
    public boolean match(Vent vent) {
        return (this.getX() == vent.getX()) || (this.getY() == vent.getY());
    }
}
