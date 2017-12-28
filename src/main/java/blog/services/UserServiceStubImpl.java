package blog.services;

import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Created by fanzhe on 2017/12/27.
 */
@Service
public class UserServiceStubImpl implements UserService {
    @Override
    public boolean authenticate(String username, String password) {
        // Provide a sample password check:username == password
        return Objects.equals(username, password);
    }
}
