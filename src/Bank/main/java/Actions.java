package java;

public class Actions implements ICommission{

    // Поле для хранения названия компании акции
    private String actionName;
    // Поле для хранения количества дней со дня создания счета, лучше сделать через дату
    private int amountDay;
    // Поле для хранения количества акций
    private int actionCount;
    // Полле для хранения стоимости одной акции
    private double actionValue;
    // Поле для хранения ощей стоимости акций
    private double fullValue = this.actionCount * this.actionValue;
    // Поле для хранения типа валюты в которой хранятся акции
    private Currency coin;

    public Actions(){
        this.actionName = "No Company";
        this.amountDay = 0;
        this.actionCount = 0;
        this.actionValue = 0;
        this.coin = null;
    }

    public Actions(String actionName, int actionCount, int amountDay, double actionValue, Currency coin) {
        this.actionName = actionName;
        this.amountDay = amountDay;
        this.actionCount = actionCount;
        this.actionValue = actionValue;
        this.coin = coin;
    }


    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public int getAmountDay() {
        return amountDay;
    }

    public void setAmountDay(int amountDay) {
        this.amountDay = amountDay;
    }

    public double getFullValue() {
        return fullValue;
    }

    public void setFullValue(double fullValue) {
        this.fullValue = fullValue;
    }

    public int getActionCount() {
        return actionCount;
    }

    public void setActionCount(int actionCount) {
        this.actionCount = actionCount;
    }

    public double getActionValue() {
        return actionValue;
    }

    public void setActionValue(double actionValue) {
        this.actionValue = actionValue;
    }

    public Currency getCoin() {
        return coin;
    }

    public void setCoin(Currency coin) {
        this.coin = coin;
    }

    @Override
    public void Commission(){
        for(int i = 0; i < Currency.values().length; i++) {
            if(coin.ordinal() == 3) {
                // Условие нужно переделать через дату
                if(this.amountDay % 30 == 29) {
                    if(this.fullValue > 100) {
                        this.fullValue -= (this.fullValue / 100) * 0.1;
                    }
                }
                // Еще бы не забыть ввести переменную для хранения взятой комиссии с данного счета
            }
        }
    }

    @Override
    public String toString() {
        return "Actions{" +
                "actionName='" + actionName + '\'' +
                ", amountDay=" + amountDay +
                ", actionCount=" + actionCount +
                ", actionValue=" + actionValue +
                ", fullValue=" + fullValue +
                ", coin=" + coin +
                '}';
    }
}
