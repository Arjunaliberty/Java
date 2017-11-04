package MyHomeWork.Bank;

public class Debits extends Accounts implements ICommission {
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
    // Реализация методля за вычисления комиссии со счтета от интрефейса ICommission
    @Override
    public void Commission(){
        for (int i = 0; i < Currency.values().length; i++){
            switch (Currency.values()[i].ordinal()){
                case 0:
                    if (this.amountDay % 30 == 29) {
                        this.currency -= this.currency * 0.02;
                        // Еще бы не забыть ввести переменную для хранения взятой комиссии с данного счета
                    }
                    break;
                case 1:
                    if (this.amountDay % 30 == 29) {
                        this.currency -= this.currency * 0.02;
                    }
                    break;
                case 2:
                    if (this.amountDay % 30 == 29) {
                        this.currency -= this.currency * 0.5;
                    }
                    break;
                case 3:
                    if (this.amountDay % 30 == 29) {
                        this.currency -= this.currency * 0.01;
                    }
                    break;
            }
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
