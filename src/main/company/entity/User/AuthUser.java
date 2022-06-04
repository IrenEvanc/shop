package company.entity.User;

import company.entity.User.User;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class AuthUser extends  org.springframework.security.core.userdetails.User {
    @NonNull
    private User user;

    public AuthUser (User user) {
        super(user.getUsername(), user.getPassword(), user.getAuthorities());
        this.user=user;
    }

    public long id (){
        return user.getId();
    }
}
