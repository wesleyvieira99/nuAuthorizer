package study.authorizer.domain;

import java.time.LocalDateTime;
import java.util.Objects;

public record Transaction (
        String merchant,
        int amount,
        LocalDateTime time
) {

    public Transaction {
        Objects.requireNonNull(merchant, "merchant must not be null");
        Objects.requireNonNull(time, "time must not be null");

        if (merchant.isBlank()) {
            throw new IllegalArgumentException("merchant must not be blank");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("amount must be greater than zero");
        }

    }

}
