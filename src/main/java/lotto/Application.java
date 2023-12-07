package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        PurchaseAmount purchaseAmount = getValidPurchaseAmount();
        List<Lotto> lottos = buyLottos(purchaseAmount);
        OutputView.printLottoNumbers(lottos);

        Lotto winningLotto = getValidWinningLotto();
        WinningChecker winningChecker = getValidWinningChecker(winningLotto);
        List<Prize> prizes = winningChecker.calculatePrizes(lottos);
        double profitRate = ProfitRateCalculator.calculate(prizes, purchaseAmount.getMoney());

        OutputView.printResult(prizes, profitRate);
    }

    public static List<Lotto> buyLottos(PurchaseAmount purchaseAmount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int count = 0; count < purchaseAmount.calculateAvailableLottoCount(); count++) {
            lottos.add(new Lotto());
        }

        return lottos;
    }

    public static PurchaseAmount getValidPurchaseAmount() {
        while (true) {
            try {
                return new PurchaseAmount(InputView.getPurchaseAmount());
            } catch (IllegalArgumentException illegalArgumentException) {
                OutputView.printErrorMessage(illegalArgumentException.getMessage());
            }
        }
    }

    public static Lotto getValidWinningLotto() {
        while (true) {
            try {
                return new Lotto(InputView.getWinningNumbers());
            } catch (IllegalArgumentException illegalArgumentException) {
                OutputView.printErrorMessage(illegalArgumentException.getMessage());
            }
        }
    }

    public static WinningChecker getValidWinningChecker(Lotto winningLotto) {
        while (true) {
            try {
                return new WinningChecker(winningLotto, InputView.getBonusNumber());
            } catch (IllegalArgumentException illegalArgumentException) {
                OutputView.printErrorMessage(illegalArgumentException.getMessage());
            }
        }
    }
}
