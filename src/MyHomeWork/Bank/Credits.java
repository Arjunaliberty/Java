package MyHomeWork.Bank;

public class Credits extends Bills {

    public Credits(double currency, double percent, int numberBill) {
        super(currency, percent, numberBill);
    }

    public void Refill(double quantity) {
        this.currency += quantity;
    }

    public void Withdraw(double quantity) {

    }

    public void Transfer(Bills bill, double quantity){

    }
}
