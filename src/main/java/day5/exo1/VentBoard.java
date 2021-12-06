package day5.exo1;

import java.util.ArrayList;
import java.util.List;

public class VentBoard {
    public List<VentLine> ventLines;

    public VentBoard(List<VentLine> ventLines) {
        this.ventLines = ventLines;
    }

    public VentBoard() {
        this.ventLines = new ArrayList<>();
    }

    public List<VentLine> getVentLines() {
        return ventLines;
    }

    public void setVentLines(List<VentLine> ventLines) {
        this.ventLines = ventLines;
    }

    @Override
    public String toString() {
        return "VentBoard{" +
                "ventLines=" + ventLines +
                '}';
    }
}
