package entity;

public class User {
    private int Id;
    private String username;
    private String password;
    private int ability;
    private String name;

    public User() {
    }

    public User(int id, String username, String password, int ability, String name) {
        Id = id;
        this.username = username;
        this.password = password;
        this.ability = ability;
        this.name = name;
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

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
