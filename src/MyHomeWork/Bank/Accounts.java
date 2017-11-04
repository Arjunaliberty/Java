package MyHomeWork.Bank;

enum Currency {
    USD,
    EUR,
    RUB,
    BYN
}

public abstract class Accounts {

    // Поле для хранения номера счета
    protected  int numberAccount;
    // Поле для хранения количества средств на счету
    protected double currency;
    // Поле для хранения фиксированного процента по вкладу
    protected double percent;
    // Поле для хранения количества дней со дня создания счета
    protected int amountDay;
    // Поле для хранения типа валюты
    protected Currency coin;

    public Accounts() {
        this.numberAccount = 0;
        this.currency = 0;
        this.percent = 1;
        this.amountDay = 0;
        this.coin = null;
    }

    public Accounts(int numberAccount, double currency, double percent, int amountDay, Currency coin) {
        this.numberAccount = numberAccount;
        this.currency = currency;
        this.percent = percent;
        this.amountDay = amountDay;
        this.coin = coin;
    }

    public int getNumberAccount() {
        return numberAccount;
    }

    public void setNumberAccount(int numberAccount) {
        this.numberAccount = numberAccount;
    }

    public double getCurrency() {
        return currency;
    }

    public void setCurrency(double currency) {
        this.currency = currency;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    public int getAmountDay() {
        return amountDay;
    }

    public void setAmountDay(int amountDay) {
        this.amountDay = amountDay;
    }

    public Currency getCoin() {
        return coin;
    }

    public void setCoin(Currency coin) {
        this.coin = coin;
    }

    // Абстрактный метод для пополнения счета деньгами
    protected abstract void Refill(double quantity);
    // Абстрактный метод для снятия денег со счета
    protected abstract void Withdraw(double quantity);
    // Абстрактный метод для перевода денег со счета на счет
    protected abstract void Transfer(Accounts bill, double quantity);

    @Override
    public String toString() {
        return "Accounts{" +
                "numberAccount=" + numberAccount +
                ", currency=" + currency +
                ", percent=" + percent +
                ", amountDay=" + amountDay +
                ", coin=" + coin +
                '}';
    }
}
