package lotto.service;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import lotto.Application;
import lotto.domain.Lottos;
import lotto.domain.wrapper.PurchaseAmout;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoVendingMachineTest extends NsTest {

    @DisplayName("구입 금액에 따라 구입한 개수만큼 로또가 랜덤 번호를 기반으로 생성된다.")
    @Test
    void buyLottos() {
        // given
        PurchaseAmout purchaseAmout = new PurchaseAmout(8000);
        LottoVendingMachine lottoVendingMachine = new LottoVendingMachine(purchaseAmout);
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    Lottos lottos = lottoVendingMachine.getLottos();
                    System.out.println(lottos.toString());
                    assertThat(output()).contains(
                            "[8, 21, 23, 41, 42, 43]",
                            "[3, 5, 11, 16, 32, 38]",
                            "[7, 11, 16, 35, 36, 44]",
                            "[1, 8, 11, 31, 41, 42]",
                            "[13, 14, 16, 38, 42, 45]",
                            "[7, 11, 30, 40, 42, 43]",
                            "[2, 13, 22, 32, 38, 45]",
                            "[1, 3, 5, 14, 22, 45]"
                    );
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}