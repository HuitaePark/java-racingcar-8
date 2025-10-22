package racingcar.domain;

public class Car {

    private Position position;

    public Car() {
        this.position = new Position(0);
    }

    public void move(int i) {
        if(i>=4){
            this.position = position.next();
        }
    }

    public int distance() {
        return this.position.value();
    }
}
