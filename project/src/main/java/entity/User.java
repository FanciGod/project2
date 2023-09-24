package entity;

public class User {
    private String username;
    private String password;
    private int ability;

    public User() {
    }

    public User(String username, String password, int ability) {
        this.username = username;
        this.password = password;
        this.ability = ability;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAbility() {
        return ability;
    }

    public void setAbility(int ability) {
        this.ability = ability;
    }
}
