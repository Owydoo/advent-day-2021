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

    public int xMax(){
        int xMax = 0;
        for (VentLine ventLine:
             this.ventLines) {
            int maxInVentLine = ventLine.xMax();
            if (maxInVentLine > xMax){
                xMax = maxInVentLine;
            }
        }
        return xMax;
    }

    @Override
    public String toString() {
        for (int i = 0; i < xMax(); i++) {
            
        }
        return "VentBoard{" +
                "ventLines=" + ventLines +
                '}';
    }
}
