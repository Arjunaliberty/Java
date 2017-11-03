package MyHomeWork.Bank;

public class Bank {

    // Поле для хранения названия банка
    String nameBank;
    // Поле для хранения счетов клиентов
    Accounts[] account;

    public Bank(String nameBank, Accounts[] account) {
        this.nameBank = nameBank;
        this.account = account;
    }
}
