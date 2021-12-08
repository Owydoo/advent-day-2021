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

    public int xMax() {
        int xMax = 0;
        for (VentLine ventLine :
                this.ventLines) {
            int maxInVentLine = ventLine.xMax();
            if (maxInVentLine > xMax) {
                xMax = maxInVentLine;
            }
        }
        return xMax;
    }

    public int yMax() {
        int yMax = 0;
        for (VentLine ventLine :
                this.ventLines) {
            int maxInVentLine = ventLine.yMax();
            if (maxInVentLine > yMax) {
                yMax = maxInVentLine;
            }
        }
        return yMax;
    }

    @Override
    public String toString() {
        if (yMax() > 30 | xMax() > 30) {
            return "VentBoard too big to be printed";
        }
        String res = "";
        for (int line = 0; line <= yMax(); line++) {
            for (int column = 0; column <= xMax(); column++) {
                int nbVentAtThisPlace = getNbVentAtCoordinates(line, column);
                res += String.valueOf(nbVentAtThisPlace);
            }
            res += "\n";
        }
        return "VentBoard{\n" +
                res + "}\n";
    }

    private int getNbVentAtCoordinates(int line, int column) {
        int res = 0;
        for (VentLine ventLine :
                this.ventLines) {
            if (ventLine.hasAVentAt(line, column)) {
                res += 1;
            }
        }
        return res;
    }


    public int findNbPointsWhereAtLeastTwoVentsOverlap() {
        int res = 0;
        int maxHeight = yMax();
        int maxWidth = xMax();
        for (int line = 0; line <= maxHeight; line++) {
            System.out.println("find nb loading : " + ((line * 100) / maxHeight) + " %");
            for (int column = 0; column <= maxWidth; column++) {
                int nbVentAtThisPlace = getNbVentAtCoordinates(line, column);
                if (nbVentAtThisPlace >= 2) {
                    res += 1;
                }
            }
        }
        return res;
    }
}
