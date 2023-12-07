package lotto;

import static lotto.LottoConstants.ERROR;
import static lotto.LottoConstants.MAX_LOTTO_NUMBER;
import static lotto.LottoConstants.MIN_LOTTO_NUMBER;

import java.util.List;

public class WinningChecker {

    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningChecker(Lotto winningLotto, int bonusNumber) {
        validateRange(bonusNumber);
        validateDuplication(winningLotto, bonusNumber);

        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateRange(int bonusNumber) {
        if (bonusNumber < MIN_LOTTO_NUMBER || bonusNumber > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ERROR + "보너스 번호가 올바른 범위 안에 들어오지 않습니다.");
        }
    }

    private void validateDuplication(Lotto winningLotto, int bonusNumber) {
        if (winningLotto.doesHaveBonusNumber(bonusNumber)) {
            throw new IllegalArgumentException(ERROR + "당첨 번호와 보너스 번호가 중복됩니다.");
        }
    }

    public List<Prize> calculatePrizes(List<Lotto> lottos) {
        return lottos.stream()
                .map(this::calculatePrize)
                .toList();
    }

    private Prize calculatePrize(Lotto lotto) {
        int correctCount = lotto.getCorrectCount(winningLotto);

        if (correctCount == Prize.SECOND.getCorrectCount()) {
            return determineSecondOrThird(lotto.doesHaveBonusNumber(bonusNumber));
        }

        for (Prize prize : Prize.getPrizesExcludingFiveCorrect()) {
            if (prize.getCorrectCount() == correctCount) {
                return prize;
            }
        }

        return null;
    }

    private Prize determineSecondOrThird(boolean hasBonusNumber) {
        if (hasBonusNumber) {
            return Prize.SECOND;
        }
        return Prize.THIRD;
    }

}
