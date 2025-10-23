package racingcar.domain.strategy;

public class NeverMoveStrategy implements MoveStrategy{
    @Override
    public boolean isMoveable() {
        return false;
    }
}
