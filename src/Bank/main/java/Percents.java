package java;

public class Percents extends Accounts {

    public Percents(int numberAccount, double currency, double percent, int amountDay, Currency coin) {
        super(numberAccount, currency, percent, amountDay, coin);
    }

    // Метод для пополнения счета на фиксированный процент за 30 дней
    public void PercentProfit() {
        if (this.amountDay % 30 == 29) {
            this.currency += this.currency * this.percent;
        }
    }

    @Override
    public void Refill(double quantity) {
        this.currency += quantity ;
    }

    @Override
    public void Withdraw(double quantity) {
        if(this.currency >= quantity) {
            this.currency -= quantity;
        }
    }

    @Override
    public void Transfer(Accounts accounts, double quantity) {
        if(this.currency >= quantity) {
            this.currency -= quantity;
            accounts.currency += quantity;
        }
    }

    @Override
    public String toString() {
        return "Percents{" +
                "numberAccount=" + numberAccount +
                ", currency=" + currency +
                ", percent=" + percent +
                ", amountDay=" + amountDay +
                ", coin=" + coin +
                '}';
    }
}
