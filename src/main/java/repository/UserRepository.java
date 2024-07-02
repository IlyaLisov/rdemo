package repository;

import model.User;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class UserRepository {

    private final Set<User> users = new HashSet<>();

    public Optional<User> find(Long id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }

    public List<User> findAll() {
        return List.copyOf(users);
    }

    public void save(User user) {
        users.add(user);
    }

}
