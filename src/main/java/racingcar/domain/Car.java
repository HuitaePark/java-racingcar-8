package racingcar.domain;

import racingcar.domain.strategy.MoveStrategy;

public class Car {

    private final String name;
    private Position position;


    public Car(String name) {
        verifyCarName(name);
        this.name = name;
        this.position = new Position(0);
    }

    public void move(MoveStrategy strategy) {
        if (strategy.isMoveable()) {
            this.position = position.next();
        }
    }

    public String getName() {
        return name;
    }

    public int distance() {
        return this.position.value();
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(position.value());
    }

    private void verifyCarName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 5자를 넘을수 없습니다.");
        }
    }

}
