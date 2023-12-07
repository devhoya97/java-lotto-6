package lotto;

import static lotto.LottoConstants.ERROR;
import static lotto.LottoConstants.PRICE_PER_LOTTO;

public class PurchaseAmount {

    private final long money;

    public PurchaseAmount(long money) {
        validate(money);
        this.money = money;
    }

    private void validate(long money) {
        if ((money <= 0) || (money % PRICE_PER_LOTTO != 0)) {
            throw new IllegalArgumentException(ERROR + "로또 구입 금액이 로또 가격으로 나누어 떨어지지 않습니다.");
        }
    }

    public int calculateAvailableLottoCount() {
        return (int) (money / PRICE_PER_LOTTO);
    }

    public long getMoney() {
        return money;
    }
}
