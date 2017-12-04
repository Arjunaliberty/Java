package java;

public class Clients {
    private String name;
    private String surname;
    private int passNumber;
    private Accounts[] accounts;
    private Actions[] actions;
    private  Metalls[] metalls;

    public Clients( String name, String surname, int passNumber, Accounts[] accounts, Actions[] actions, Metalls[] metalls) {
        this.name = name;
        this.surname = surname;
        this.passNumber = passNumber;
        this.accounts = accounts;
        this.actions = actions;
        this.metalls = metalls;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getPassNumber() {
        return passNumber;
    }

    public void setPassNumber(int passNumber) {
        this.passNumber = passNumber;
    }

    public Accounts[] getAccounts() {
        return accounts;
    }

    public void setAccounts(Accounts[] accounts) {
        this.accounts = accounts;
    }

    public Actions[] getActions() {
        return actions;
    }

    public void setActions(Actions[] actions) {
        this.actions = actions;
    }

    public Metalls[] getMetalls() {
        return metalls;
    }

    public void setMetalls(Metalls[] metalls) {
        this.metalls = metalls;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", passnumber=" + passNumber +
                '}';
    }


}
