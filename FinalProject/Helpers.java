package FinalProject;

public class Helpers {
    /* Payment Simulation */
    private boolean simulatePayment(double amount, double paymentMoney) {
        System.out.println("Simulando pagamento");
        System.out.println("Valor a pagar: " + amount + "€");

        if (paymentMoney >= amount) {
            System.out.println("Pagamento realizado com sucesso!");
            double change = paymentMoney - amount;
            System.out.printf("Troco:  %.2f€ \n", change);
            return true;
        } else if (paymentMoney < amount) {
            System.out.println("Pagamento não realizado. Insuficiente dinheiro.");
            return false;
        }
        return true; // Simulate a successful payment
    }
}
