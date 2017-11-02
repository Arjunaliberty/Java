package MyHomeWork.Bank;

public abstract class Bills {

    // Поле для хранения количества денежных знаков
    protected double currency = 0;
    // Поле для хранения номера счета
    protected  int numberBill;

    public Bills(double currency, int numberBill) {
        this.currency = currency;
        this.numberBill = numberBill;
    }

    public double getCurrency() {
        return currency;
    }

    public void setCurrency(double currency) {
        this.currency = currency;
    }

    public int getNumberBill() {
        return numberBill;
    }

    public void setNumberBill(int numberBill) {
        this.numberBill = numberBill;
    }

    // Абстрактный метод для пополнения счета деньгами
    protected abstract void Refill(double quantity);
    // Абстрактный метод для снятия со счета денег
    protected abstract void Withdraw(double quantity);
    // Абстрактный метод для перевода денег со счета на счет
    protected abstract void Transfer(Bills bill, double quantity);

    @Override
    public String toString() {
        return "Bills{" +
                "currency=" + currency +
                ", numberBill=" + numberBill +
                '}';
    }
}
