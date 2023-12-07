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
        
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateRange(int bonusNumber) {
        if (bonusNumber < MIN_LOTTO_NUMBER || bonusNumber > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ERROR + "보너스 번호가 올바른 범위 안에 들어오지 않습니다.");
        }
    }

    private void validateWinningNumbers(List<Integer> winningNumbers) {

    }

    private void validateBonusNumber(List<Integer> winningNumbers, int bonusNumber) {

    }

    public List<Prize> calculatePrizes(List<Lotto> lottos) {
        return null;
    }

    private Prize calculatePrize(Lotto lotto) {
        return null;
    }

}
