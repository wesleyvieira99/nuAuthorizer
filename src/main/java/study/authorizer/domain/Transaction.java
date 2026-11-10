package study.authorizer.domain;

import java.time.LocalDateTime;
import java.util.Objects;

public record Transaction (
        String merchant,
        int amount,
        LocalDateTime time
) {

    public Transaction {
        Objects.requireNonNull(merchant, "merchant must be not null!");
        if(merchant.isBlank()) {
            throw new IllegalArgumentException("merchant must be not blank");
        }
        if(amount < 0) {
            throw new IllegalArgumentException("value must be greater than zero");
        }

    }

}
