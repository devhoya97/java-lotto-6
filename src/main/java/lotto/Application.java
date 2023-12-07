package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        PurchaseAmount purchaseAmount = new PurchaseAmount(InputView.getPurchaseAmount());
        List<Lotto> lottos = buyLottos(purchaseAmount);
        OutputView.printLottoNumbers(lottos);

        Lotto winningLotto = new Lotto(InputView.getWinningNumbers());
        WinningChecker winningChecker = new WinningChecker(winningLotto, InputView.getBonusNumber());
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
}
