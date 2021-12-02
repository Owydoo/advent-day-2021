package day1.exo2;

public class Window {
    private Integer el1,el2,el3;

    public Window(Integer el1, Integer el2, Integer el3) {
        this.el1 = el1;
        this.el2 = el2;
        this.el3 = el3;
    }

    @Override
    public String toString() {
        return "Window{" +
                "el1=" + el1 +
                ", el2=" + el2 +
                ", el3=" + el3 +
                '}';
    }

    public Integer getEl1() {
        return el1;
    }

    public void setEl1(Integer el1) {
        this.el1 = el1;
    }

    public Integer getEl2() {
        return el2;
    }

    public void setEl2(Integer el2) {
        this.el2 = el2;
    }

    public Integer getEl3() {
        return el3;
    }

    public void setEl3(Integer el3) {
        this.el3 = el3;
    }


    public boolean isEqualTo(Window window){
        Integer sum1 = this.el1 + this.el2 + this.el3;
        Integer sum2 = window.el1 + window.el2 + window.el3;
        return sum1 == sum2;
    }

    public boolean isLessThan(Window window){
        Integer sum1 = this.el1 + this.el2 + this.el3;
        Integer sum2 = window.el1 + window.el2 + window.el3;
        return sum1 < sum2;
    }

    public boolean isMoreThan(Window window){
        Integer sum1 = this.el1 + this.el2 + this.el3;
        Integer sum2 = window.el1 + window.el2 + window.el3;
        return sum1 > sum2;
    }

}
