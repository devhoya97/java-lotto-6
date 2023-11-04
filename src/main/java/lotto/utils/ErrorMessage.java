package lotto.utils;

public enum ErrorMessage {
    ERROR_PREFIX("[ERROR] "),
    CHANGE_REMAINED_ERROR("구입 금액이 로또 가격으로 나누어 떨어지지 않아 잔돈이 발생합니다."),
    NO_MONEY_ERROR("구입 금액은 0보다 작거나 같을 수 없습니다."),
    LOTTO_NUMBER_RANGE_ERROR("로또 번호는 %d~%d사이의 숫자여야 합니다."),
    LOTTO_NUMBERS_LENGTH_ERROR("로또는 총 %d개의 번호로 이루어져야 합니다."),
    LOTTO_NUMBER_DUPLICATION_ERROR("로또 번호에 중복이 있습니다."),
    WINNING_NUMBERS_CONTAINS_BONUS_NUMBER("보너스 번호가 당첨 번호와 중복됩니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_PREFIX + message;
    }

    public String getFormattedMessage(int number) {
        return ERROR_PREFIX + String.format(message, number);
    }
    public String getFormattedMessage(int minNumber, int maxNumber) {
        return ERROR_PREFIX + String.format(message, minNumber, maxNumber);
    }
}
