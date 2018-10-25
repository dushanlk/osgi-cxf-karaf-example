package lk.dushan.example.osgi.cxf.core.api;

/**
 * Authored by dushan.p@viewqwest.com on 25/10/18.
 */
public class Example {

    private String username;

    private String password;

    public Example() {
    }

    public Example(String username, String password) {
        this.username = username;
        this.password = password;
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

    @Override
    public String toString() {
        return "Example{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
