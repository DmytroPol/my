package ua.kiev.prog;

public class User {

    private final String name;
    private final String password;
    private String status;
    private boolean registered = false;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isRegistered() {
        return registered;
    }

    public void setRegistered(boolean registered) {
        this.registered = registered;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return getName();
    }

}
