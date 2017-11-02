package MyHomeWork.Bank;

public class Percents extends Bills {

    Percents(double currency, double percent, int numberBill) {
        super(currency, percent, numberBill);
    }

    // Метод для вычисления состояния счета по фиксированному проценту за месяц
    public void PercentProfit() {
        this.currency += this.currency * (this.percent / 100);
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
