package MyHomeWork.Bank;

public class Debits extends Bills {
    // Конструктор класса дебитного счета
    public Debits(double currency, double percent, int numberBill) {
        super(currency, percent, numberBill);
    }

    public void Refill(double quantity) {
        this.currency += quantity ;
    }

    public void Withdraw(double quantity) {
        if(this.currency >= quantity) {
            this.currency -= quantity;
        }
    }

    public void Transfer(Bills bill, double quantity) {
        if(this.currency >= quantity) {
            bill.currency += quantity;
            this.currency -= quantity;
        }
    }

    @Override
    public String toString() {
        return "Debits{" +
                "currency=" + currency +
                ", numberBill=" + numberBill +
                '}';
    }
}
