package MyHomeWork.Bank;

import java.util.Arrays;

public class Bank {

    // Поле для хранения названия банка
    private String nameBank;
    // поле для хранения id банка
    private int bankId;
    // Поле для хранения счетов клиентов
    private Accounts[] account;

    public Bank(String nameBank, int bankId, Accounts[] account) {
        this.nameBank = nameBank;
        this.bankId = bankId;
        this.account = account;
    }


    public String getNameBank() {
        return nameBank;
    }

    public void setNameBank(String nameBank) {
        this.nameBank = nameBank;
    }

    public int getBankId() {
        return bankId;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }

    public Accounts[] getAccount() {
        return account;
    }

    public void setAccount(Accounts[] account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "nameBank='" + nameBank + '\'' +
                ", bankId=" + bankId +
                ", account=" + Arrays.toString(account) +
                '}';
    }
}
