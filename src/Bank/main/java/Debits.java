package java;

public class Debits extends Accounts {
    // Конструктор класса дебитного счета
    public Debits(int numberAccount, double currency, double percent, int amountDay, Currency coin) {
        super(numberAccount, currency, percent, amountDay, coin);
    }

    // Метод для пополнения счета
    @Override
    public void Refill(double quantity) {
        this.currency += quantity ;
    }

    // Метод для снятия денег со счета
    @Override
    public void Withdraw(double quantity) {
        if(this.currency >= quantity) {
            this.currency -= quantity;
        }
    }

    // Метод для перевода денег со счета на счет
    @Override
    public void Transfer(Accounts accounts, double quantity) {
        if(this.currency >= quantity) {
            this.currency -= quantity;
            accounts.currency += quantity;
        }
    }


    @Override
    public String toString() {
        return "Debits{" +
                "numberAccount=" + numberAccount +
                ", currency=" + currency +
                ", percent=" + percent +
                ", amountDay=" + amountDay +
                ", coin=" + coin +
                '}';
    }
}
