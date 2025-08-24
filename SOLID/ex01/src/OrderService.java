public class OrderService {
    EmailClient email = new EmailClient();
    TaxRate taxRate = new TaxRate();

    void checkout(String customerEmail, double subtotal) {
        double total = taxRate.totalWithTax(subtotal);
        email.send(customerEmail, "Thanks! Your total is " + total);
        System.out.println("Order stored (pretend DB).");
    }
}