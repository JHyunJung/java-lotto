package mission.lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos() {
        this.lottos = new ArrayList<>();
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    public void add(Lotto lotto) {
        lottos.add(lotto);
    }

    public RankLottos checkWin(List<Integer> list) {

        Map<KLottoRank, Integer> winResult = lottos.stream()
                .map(lotto -> {
                    int count = lotto.matchCount(list);
                    return count >= 3 ? lotto.checkRank(count) : null;
                })
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(e -> 1)));

        return new RankLottos(winResult);
    }

}