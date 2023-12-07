package lotto.view;

import java.util.List;
import lotto.Lotto;

public class OutputView {
    private static final String NEW_LINE = "\n";
    public static void printLottoNumbers(List<Lotto> lottos) {
        System.out.println(NEW_LINE + lottos.size() + "개를 구매했습니다.");

        lottos.forEach(System.out::println);
    }
}
