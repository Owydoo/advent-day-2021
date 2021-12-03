package day3.exo1;

public class Answer {
    private Integer gammaRate, epsilonRate, powerConsumption;

    public Answer(Integer gammaRate, Integer epsilonRate, Integer powerConsumption) {
        this.gammaRate = gammaRate;
        this.epsilonRate = epsilonRate;
        this.powerConsumption = powerConsumption;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "gammaRate=" + gammaRate +
                ", epsilonRate=" + epsilonRate +
                ", powerConsumption=" + powerConsumption +
                '}';
    }

    public Integer getGammaRate() {
        return gammaRate;
    }

    public Integer getEpsilonRate() {
        return epsilonRate;
    }

    public Integer getPowerConsumption() {
        return powerConsumption;
    }

    public void setGammaRate(Integer gammaRate) {
        this.gammaRate = gammaRate;
    }

    public void setEpsilonRate(Integer epsilonRate) {
        this.epsilonRate = epsilonRate;
    }

    public void setPowerConsumption(Integer powerConsumption) {
        this.powerConsumption = powerConsumption;
    }
}
