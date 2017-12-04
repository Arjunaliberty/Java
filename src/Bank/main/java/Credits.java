package java;

public class Credits extends Accounts {

    public Credits(int numberAccount, double currency, double percent, int amountDay, Currency coin) {

        super(numberAccount, currency, percent, amountDay, coin);
    }

    // Метод для сняти процента с суммы вклада
    private void decreaseCurrency(double quantity) {
        this.currency -= quantity * this.percent;
    }

    @Override
    public void Refill(double quantity) {
        this.currency += quantity ;
    }

    @Override
    public void Withdraw(double quantity) {
        if(this.currency >= quantity) {
            this.currency -= quantity;
        } else if((this.currency > 0 && this.currency < quantity) || (this.currency < 0)){
            decreaseCurrency(quantity);
            this.currency -= quantity;
        }
    }

    @Override
    public void Transfer(Accounts accounts, double quantity) {
        if(this.currency >= quantity) {
            this.currency -= quantity;
            accounts.currency += quantity;
        } else if((this.currency > 0 && this.currency < quantity) || (this.currency < 0)){
            decreaseCurrency(quantity);
            accounts.currency += quantity;
            this.currency -= quantity;
        }
    }

}
