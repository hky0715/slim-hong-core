package slim.hong.core.model;

public class Member {

    private Long id;
    private String username;

    public Member(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

}
