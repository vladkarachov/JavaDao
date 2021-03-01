package cashMachine.entities;

public class User {
    public long id;
    private int role;
    public String login;
    private String password;

    public User(long id, int role, String login, String password) {
        this.id = id;
        this.role = role;
        this.login = login;
        this.password = password;
    }

    public boolean isPassCorrect(String pswd){
        return pswd.equals(password);
    }

    public int getRole() {
        return role;
    }
}
