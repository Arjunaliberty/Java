package MyHomeWork.Bank;

public class Percents extends Bills {

    Percents(double currency, int numberBill) {
        super(currency, numberBill);
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
        return "Percents{" +
                "currency=" + currency +
                ", numberBill=" + numberBill +
                '}';
    }
}
