package day3.exo2;

public class Answer {
    private Integer oxygenGenerator, co2ScrubberRating, lifeSupportRating;

    public Answer(Integer oxygenGenerator, Integer co2ScrubberRating, Integer lifeSupportRating) {
        this.oxygenGenerator = oxygenGenerator;
        this.co2ScrubberRating = co2ScrubberRating;
        this.lifeSupportRating = lifeSupportRating;
    }

    public Answer() {
        this.oxygenGenerator = 0;
        this.co2ScrubberRating = 0;
        this.lifeSupportRating = 0;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "oxygenGenerator=" + oxygenGenerator +
                ", co2ScrubberRating=" + co2ScrubberRating +
                ", lifeSupportRating=" + lifeSupportRating +
                '}';
    }

    public Integer getOxygenGenerator() {
        return oxygenGenerator;
    }

    public void setOxygenGenerator(Integer oxygenGenerator) {
        this.oxygenGenerator = oxygenGenerator;
    }

    public Integer getCo2ScrubberRating() {
        return co2ScrubberRating;
    }

    public void setCo2ScrubberRating(Integer co2ScrubberRating) {
        this.co2ScrubberRating = co2ScrubberRating;
    }

    public Integer getLifeSupportRating() {
        return lifeSupportRating;
    }

    public void setLifeSupportRating(Integer lifeSupportRating) {
        this.lifeSupportRating = lifeSupportRating;
    }
}
