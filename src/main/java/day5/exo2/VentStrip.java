package day5.exo2;

import day5.exo1.Vent;
import day5.exo1.VentLine;

import java.util.ArrayList;
import java.util.List;

public class VentStrip extends VentLine {

    public VentStrip(Vent startVent, Vent endVent) {
        super();
        int g;
        if ((startVent.getX() == endVent.getX()) && (startVent.getY() > endVent.getY())) {
            this.startVent = endVent;
            this.endVent = startVent;
            this.vents = super.buildVents(this.startVent, this.endVent);
        } else if ((startVent.getY() == endVent.getY()) && (startVent.getX() > endVent.getX())) {
            this.startVent = endVent;
            this.endVent = startVent;
            this.vents = super.buildVents(this.startVent, this.endVent);
        } else if ((g = gradient(startVent, endVent)) == 1 || ((g = gradient(startVent, endVent)) == -1)) {
            if (startVent.getX() > endVent.getX()) {
                this.startVent = endVent;
                this.endVent = startVent;
            } else {
                this.startVent = startVent;
                this.endVent = endVent;
            }
            this.vents = buildDiagonalVents(this.startVent, this.endVent, g);
        } else {
            this.startVent = startVent;
            this.endVent = endVent;
            this.vents = super.buildVents(this.startVent, this.endVent);
        }
    }

    private List<Vent> buildDiagonalVents(Vent startVent, Vent endVent, int gradient) {
        List<Vent> resVents = new ArrayList<>();
        resVents.add(startVent);
        if (gradient == 1) {
            for (int i = 1; i < endVent.getX() - startVent.getX(); i++) {
                resVents.add(new Vent(startVent.getX() + i, startVent.getY() + i));
            }
        } else if (gradient == -1) {
            for (int i = 1; i < endVent.getX() - startVent.getX(); i++) {
                resVents.add(new Vent(startVent.getX() + i, startVent.getY() - i));
            }
        }
        resVents.add(endVent);
        return resVents;
    }

    private int gradient(Vent start, Vent end) {
        if (end.getX() - start.getX() == 0){
            return Integer.MAX_VALUE;
        }
        return (end.getY() - start.getY()) / (end.getX() - start.getX());
    }


}
