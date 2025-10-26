package racingcar.domain.model;

import java.util.List;

public class Winners {

    private final List<String> names;

    public Winners(List<String> winnerList) {
        this.names = winnerList;
    }

    public String displayNames() {
        return String.join(",", names);
    }
}
