package lotto.domain.wrapper;

import lotto.utils.LottoConstantValue;
import lotto.utils.ErrorMessage;

public class PurchaseAmout {
    private static final int NO_MONEY = 0;
    private int purchaseAmout;

    public PurchaseAmout(int purchaseAmout) {
        validate(purchaseAmout);
        this.purchaseAmout = purchaseAmout;
    }

    public int getLottoCount() {
        return purchaseAmout / LottoConstantValue.LOTTO_PRICE.get();
    }

    private void validate(int purchaseAmout) {
        validateMoreThanZero(purchaseAmout);
        validateChangeNoRemaining(purchaseAmout);
    }

    private void validateMoreThanZero(int purchaseAmout) {
        if (purchaseAmout <= NO_MONEY) {
            throw new IllegalArgumentException(ErrorMessage.NO_MONEY.getMessage());
        }
    }

    private void validateChangeNoRemaining(int purchaseAmout) {
        if (purchaseAmout % LottoConstantValue.LOTTO_PRICE.get() != NO_MONEY) {
            throw new IllegalArgumentException(ErrorMessage.CHANGE_REMAINED.getMessage());
        }
    }
}
