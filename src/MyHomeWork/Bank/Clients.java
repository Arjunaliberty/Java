package MyHomeWork.Bank;

public class Client {
    private String name;
    private String surname;
    private int passnumber;

    public Client( String name, String surname, int passnumber) {
        this.name = name;
        this.surname = surname;
        this.passnumber = passnumber;
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

    public int getPassnumber() {
        return passnumber;
    }

    public void setPassnumber(int passnumber) {
        this.passnumber = passnumber;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", passnumber=" + passnumber +
                '}';
    }
}
