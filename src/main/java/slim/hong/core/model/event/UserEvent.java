package slim.hong.core.model.event;

public class UserEvent {

    private String username;

    public UserEvent(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
