package study.authorizer.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ModelTest {
    private static final LocalDateTime SAMPLE_TIME = LocalDateTime.of(2026,11, 10, 12,0, 0);

    @Test
    void shouldCreateImmutableAccountAndProtectHistory() {
        var externalList = new ArrayList<Transaction>();
        externalList.add(new Transaction("Uber", 20, SAMPLE_TIME));

        var account = new Account(true, 100, externalList);
        externalList.clear(); //For trying to mutate the list

        assertEquals(1, account.history().size());
        assertThrows(UnsupportedOperationException.class, () ->
            account.history().add(new Transaction("iFood", 30, SAMPLE_TIME))
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"" ," ", "   "})
    void shouldRejectBlankMerchant(String invalidMerchant) {
        assertThrows(IllegalArgumentException.class, () ->
                new Transaction(invalidMerchant, 10, SAMPLE_TIME)
        );
    }

}
