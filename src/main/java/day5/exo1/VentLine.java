package day5.exo1;

import java.util.ArrayList;
import java.util.List;

public class VentLine {
    public Vent startVent, endVent;
    public List<Vent> vents = new ArrayList<>();

    public VentLine(Vent startVent, Vent endVent) {
        this.startVent = startVent;
        this.endVent = endVent;
        this.vents = buildVents(startVent, endVent);
    }

    @Override
    public String toString() {
        return "VentLine{" +
                "startVent=" + startVent +
                ", endVent=" + endVent +
                ", vents=" + vents +
                "}\n";
    }

    public Vent getStartVent() {
        return startVent;
    }

    public void setStartVent(Vent startVent) {
        this.startVent = startVent;
    }

    public Vent getEndVent() {
        return endVent;
    }

    public void setEndVent(Vent endVent) {
        this.endVent = endVent;
    }

    public List<Vent> getVents() {
        return vents;
    }

    public void setVents(List<Vent> vents) {
        this.vents = vents;
    }

    private List<Vent> buildVents(Vent start, Vent end) {
        List<Vent> resVents = new ArrayList<>();
        if (start.getX() == end.getX()){
            resVents.add(start);
            for (int i = 1; i < end.getY()-start.getY(); i++) {
                resVents.add(new Vent(start.getX(), start.getY()+i));
            }
            resVents.add(end);
        }
        else if (start.getY() == end.getY()){
            resVents.add(start);
            for (int i = 1 ; i < end.getX() - start.getX() ; i++) {
                resVents.add(new Vent(start.getX()+i, start.getY()));
            }
            resVents.add(end);
        }
        return resVents;
    }
}
