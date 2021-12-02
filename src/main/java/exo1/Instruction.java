package exo1;


public class Instruction {

    public void updatePosition(Integer depth, Integer horizontalPosition) {
        switch (this.direction) {
            case FORWARD:
                horizontalPosition += this.amount;
                break;
            case UP:
                depth -= this.amount;
                break;
            case DOWN:
                depth += this.amount;
                break;
        }
    }

    public enum Direction {
        FORWARD,
        DOWN,
        UP
    }

    private Direction direction;
    private Integer amount;


    public Instruction(String directionStr, String amountStr) {
        this.amount = Integer.parseInt(amountStr);
        if (directionStr.equals("forward")) {
            this.direction = Direction.FORWARD;
        } else if (directionStr.equals("down")) {
            this.direction = Direction.DOWN;
        } else if (directionStr.equals("up")) {
            this.direction = Direction.UP;
        }
    }

    @Override
    public String toString() {
        return "Instruction{" +
                "direction=" + direction +
                ", amount=" + amount +
                '}';
    }

    public Direction getDirection() {
        return direction;
    }

    public Integer getAmount() {
        return amount;
    }
}
