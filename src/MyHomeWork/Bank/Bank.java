package MyHomeWork.Bank;

import java.util.Arrays;

public class Bank {

    // Поле для хранения названия банка
    private String nameBank;
    // поле для хранения id банка
    private int bankId;
    // Поле для хранения счетов клиентов
    private Clients[] clients;

    public Bank(String nameBank, int bankId, Clients[] clients) {
        this.nameBank = nameBank;
        this.bankId = bankId;
        this.clients = clients;
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

    public Clients[] getClients() {
        return clients;
    }

    public void setClients(Clients[] clients) {
        this.clients = clients;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "nameBank='" + nameBank + '\'' +
                ", bankId=" + bankId +
                ", clients=" + Arrays.toString(clients) +
                '}';
    }
}
