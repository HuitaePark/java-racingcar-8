package racingcar.domain;

public record Position(int value) {
    public Position next() {
        return new Position(value+1);
    }
}
