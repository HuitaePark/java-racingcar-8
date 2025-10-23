package racingcar.domain;

import java.util.List;

public class Winners {

    private final List<String> names;

    public Winners(List<String> winnerList) {
        this.names = winnerList;
    }

    @Override
    public String toString() {
        return String.join(",", names);
    }
}
