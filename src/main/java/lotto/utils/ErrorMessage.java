package lotto.utils;

public enum ErrorMessage {
    ERROR_PREFIX("[ERROR] "),
    LOTTO_NUMBER_RANGE_ERROR("로또 번호는 %d~%d사이의 숫자여야 합니다."),
    LOTTO_NUMBERS_LENGTH_ERROR("로또는 총 %d개의 번호로 이루어져야 합니다."),
    LOTTO_NUMBER_DUPLICATION_ERROR("로또 번호에 중복이 있습니다.");

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
