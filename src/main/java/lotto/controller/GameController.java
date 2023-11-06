package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottosManager;
import lotto.domain.wrapper.LottoNumber;
import lotto.domain.wrapper.PurchaseAmount;
import lotto.service.PrizeChecker;
import lotto.service.VendingMachine;
import lotto.service.PrizeManager;
import lotto.utils.Prize;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void play() {
        PurchaseAmount purchaseAmount = getPurchaseAmout();
        LottosManager plyerLottosManager = buyLottos(purchaseAmount);
        printLottos(plyerLottosManager);
        List<Integer> winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber(winningNumbers);
        PrizeChecker prizeChecker = new PrizeChecker(new Lotto(winningNumbers), new LottoNumber(bonusNumber));
        PrizeManager prizeManager = new PrizeManager(plyerLottosManager.getPrizeCounts(prizeChecker));
        printPrizeResults(prizeManager);
        printPrizeProfit(prizeManager, purchaseAmount);
    }

    private PurchaseAmount getPurchaseAmout() {
        outputView.printGetPurchaseAmountMessage();
        return new PurchaseAmount(inputView.getPurchaseAmount());
    }

    private LottosManager buyLottos(PurchaseAmount purchaseAmount) {
        VendingMachine vendingMachine = new VendingMachine(purchaseAmount);
        return vendingMachine.getLottos();
    }

    private void printLottos(LottosManager playerLottosManager) {
        outputView.printBuyingMessage(playerLottosManager.getLottoCount());
        outputView.printLottos(playerLottosManager.toString());
    }

    private List<Integer> getWinningNumbers() {
        outputView.printGetWinningNumbersMessage();
        return inputView.getWinningNumbers();
    }

    private int getBonusNumber(List<Integer> winningNumbers) {
        outputView.printGetBonusNumberMessage();
        return inputView.getBonusNumber(winningNumbers);
    }

    private void printPrizeResults(PrizeManager prizeManager) {
        outputView.printPrizeMessageStartMessage();
        for (Prize prize : Prize.values()) {
            if (prize == Prize.NO_PRIZE) {
                continue;
            }
            outputView.printPrizeMessages(
                    prize.getSameCount(), prize.getPrizeProfit(), prizeManager.getPrizeCount(prize));
        }
    }

    private void printPrizeProfit(PrizeManager prizeManager, PurchaseAmount purchaseAmount) {
        outputView.printProfitRate(prizeManager.getProfitRate(purchaseAmount));
    }
}
