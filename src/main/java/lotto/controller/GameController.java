package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottosManager;
import lotto.domain.wrapper.BonusNumber;
import lotto.domain.wrapper.PurchaseAmount;
import lotto.service.ConsoleInputParser;
import lotto.service.PrizeChecker;
import lotto.service.VendingMachine;
import lotto.domain.PrizeReception;
import lotto.utils.Prize;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {
    InputView inputView = new InputView();
    ConsoleInputParser consoleInputParser = new ConsoleInputParser();
    OutputView outputView = new OutputView();

    public void play() {
        PurchaseAmount purchaseAmount = getValidPurchaseAmount();
        LottosManager plyerLottosManager = buyLottos(purchaseAmount);
        printLottos(plyerLottosManager);
        Lotto winningLotto = getValidWinningLotto();
        BonusNumber bonusNumber = getValidBonusNumber(winningLotto);
        PrizeChecker prizeChecker = new PrizeChecker(winningLotto, bonusNumber);
        PrizeReception prizeReception = plyerLottosManager.getPrizeReception(prizeChecker);
        printPrizeResults(prizeReception);
        printPrizeProfit(prizeReception, purchaseAmount);
    }

    private PurchaseAmount getValidPurchaseAmount() {
        boolean isCorrectInput = false;
        PurchaseAmount purchaseAmount = null;
        while (!isCorrectInput) {
            try {
                purchaseAmount = getPurchaseAmount();
                isCorrectInput = true;
            } catch (IllegalArgumentException illegalArgumentException) {
                outputView.printErrorMessage(illegalArgumentException.getMessage());
            }
        }
        return purchaseAmount;
    }

    private PurchaseAmount getPurchaseAmount() {
        outputView.printGetPurchaseAmountMessage();
        String input = inputView.getInputFromConsole();
        return consoleInputParser.toPurchaseAmount(input);
    }

    private LottosManager buyLottos(PurchaseAmount purchaseAmount) {
        VendingMachine vendingMachine = new VendingMachine(purchaseAmount);
        return vendingMachine.getLottos();
    }

    private void printLottos(LottosManager playerLottosManager) {
        outputView.printBuyingMessage(playerLottosManager.getLottoCount());
        outputView.printLottos(playerLottosManager.toString());
    }

    private Lotto getValidWinningLotto() {
        boolean isCorrectInput = false;
        Lotto winningLotto = null;
        while (!isCorrectInput) {
            try {
                winningLotto = getWinningLotto();
                isCorrectInput = true;
            } catch (IllegalArgumentException illegalArgumentException) {
                outputView.printErrorMessage(illegalArgumentException.getMessage());
            }
        }
        return winningLotto;
    }

    private Lotto getWinningLotto() {
        outputView.printGetWinningLottoMessage();
        String input = inputView.getInputFromConsole();
        return consoleInputParser.toLotto(input);
    }

    private BonusNumber getValidBonusNumber(Lotto winningLotto) {
        boolean isCorrectInput = false;
        BonusNumber bonusNumber = null;
        while (!isCorrectInput) {
            try {
                bonusNumber = getBonusNumber(winningLotto);
                isCorrectInput = true;
            } catch (IllegalArgumentException illegalArgumentException) {
                outputView.printErrorMessage(illegalArgumentException.getMessage());
            }
        }
        return bonusNumber;
    }

    private BonusNumber getBonusNumber(Lotto winningLotto) {
        outputView.printGetBonusNumberMessage();
        String input = inputView.getInputFromConsole();
        return consoleInputParser.toBounsNumber(input, winningLotto);
    }

    private void printPrizeResults(PrizeReception prizeReception) {
        outputView.printPrizeMessageStartMessage();
        for (Prize prize : Prize.values()) {
            if (prize == Prize.NO_PRIZE) {
                continue;
            }
            outputView.printPrizeMessages(
                    prize.getSameCount(), prize.getPrizeProfit(), prizeReception.getPrizeCount(prize));
        }
    }

    private void printPrizeProfit(PrizeReception prizeReception, PurchaseAmount purchaseAmount) {
        outputView.printProfitRate(prizeReception.getProfitRate(purchaseAmount));
    }
}
