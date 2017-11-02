package MyHomeWork.Bank;

public class Clients {
    private String name;
    private String surname;
    private int passNumber;

    public Clients( String name, String surname, int passNumber) {
        this.name = name;
        this.surname = surname;
        this.passNumber = passNumber;
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

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", passnumber=" + passNumber +
                '}';
    }
}
