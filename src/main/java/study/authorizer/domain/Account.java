package study.authorizer.domain;

import java.util.ArrayList;
import java.util.List;

public record Account(
        boolean active,
        int availableLimit,
        List<Transaction> history
) {

    //Principal Constructor
    public Account {
        if(availableLimit < 0 ) {
            throw new IllegalArgumentException("availableLimit must be non negative number");
        }
        //If the history was not passed, create a empty imutable list for this param.
        history = (history == null) ? List.of() : List.copyOf(history);
    }

    //Factory Method for create a clean Account without transactions history
    public Account create(boolean active, int availableLimit) {
        return new Account(active, availableLimit, List.of());
    }

    //Wither pure functional: creates and returns a new Account updating the availableLimit and updating history
    public Account recordTransaction(Transaction transaction) {
        var updatedHistory = new ArrayList<Transaction>(this.history.size() + 1);
        updatedHistory.addAll(this.history);
        updatedHistory.add(transaction);
        return new Account(this.active, this.availableLimit - transaction.amount(), updatedHistory);
    }
}
