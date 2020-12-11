package hw2.enums;

public enum LoginUser {

    DEFAULT_USER("Roman","Jdi1234", "ROMAN IOVLEV");

    private String login;
    private String password;
    private String username;

    LoginUser(String login, String password, String username) {
        this.login = login;
        this.password = password;
        this.username = username;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }


}
