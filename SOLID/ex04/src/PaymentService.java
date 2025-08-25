import java.util.HashMap;
import java.util.Map;

public class PaymentService {
    private final Map<String, PaymentProvider> providers = new HashMap<>();

    public PaymentService() {
        providers.put("CARD", new CardPaymentProvider());
        providers.put("UPI", new UpiPaymentProvider());
        providers.put("WALLET", new WalletPaymentProvider());
    }

    public String pay(Payment payment) {
        PaymentProvider provider = providers.get(payment.getProvider());
        if (provider == null) throw new RuntimeException("No provider");
        return provider.pay(payment);
    }
}

interface PaymentProvider {
    String pay(Payment payment);
}

class CardPaymentProvider implements PaymentProvider {
    public String pay(Payment payment) {
        return "Charged card: " + payment.getAmount();
    }
}

class UpiPaymentProvider implements PaymentProvider {
    public String pay(Payment payment) {
        return "Paid via UPI: " + payment.getAmount();
    }
}

class WalletPaymentProvider implements PaymentProvider {
    public String pay(Payment payment) {
        return "Wallet debit: " + payment.getAmount();
    }
}