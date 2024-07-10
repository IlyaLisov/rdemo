package task1.complex.repository;

import task1.complex.model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class UserRepository {

    private final Map<Long, User> users = new HashMap<>();

    public Optional<User> find(Long id) {
        User user = users.get(id);
        return Optional.ofNullable(user);
    }

    public List<User> findAll() {
        return List.copyOf(users.values());
    }

    public void save(User user) {
        users.put(user.getId(), user);
    }

}
