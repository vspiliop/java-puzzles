package gy.etiolo.puzzles.streams;

import java.util.*;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.reducing;

/**
 * This is an example of how you can group invoices per month and the resulting group of invoices
 * can be further reduced to a single invoice that has the sum amount of its group.
 */
public class GroupInvoicesPerMonthAndReduce {

    public static void main(String ... args) {
        List<Invoice> invoices = List.of(new Invoice(1, 100), new Invoice(1, 200),
                new Invoice(2, 300), new Invoice(2, 300));

        Collection<Invoice> result = groupInvoices(invoices);
        result.stream().forEach(System.out::println);
    }

    private static Collection<Invoice> groupInvoices(List<Invoice> invoices) {

        Map<Integer, Invoice> collect = invoices.stream().collect(groupingBy(i -> i.month,
                collectingAndThen(
                    reducing((Invoice i1, Invoice i2) -> new Invoice(i1.month, i1.amount + i2.amount)),
                        Optional::get)));

        return collect.values();
    }

    private static class Invoice {
        private int month;
        private int amount;

        public Invoice(int month, int amount) {
            this.month = month;
            this.amount = amount;
        }

        @Override
        public String toString() {
            return String.format("month: %d, amount: %d", month, amount);
        }
    }
}
