package lotto;

import static lotto.LottoConstants.LOTTO_SIZE;
import static lotto.LottoConstants.MAX_LOTTO_NUMBER;
import static lotto.LottoConstants.MIN_LOTTO_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto() {
        numbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_SIZE);
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    public int getCorrectCount(List<Integer> winningNumbers) {
        return 0;
    }

    public boolean hasBonusNumber(int bonusNumber) {
        return false;
    }

    // TODO: 추가 기능 구현
}
