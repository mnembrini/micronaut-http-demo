package com.example;

import io.micronaut.http.annotation.Controller;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.reactivestreams.Publisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

@Controller
public class UserController implements UserOperations{

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    Map<String, User> users = new HashMap<>();

    @Override
    public Collection<User> getUsers() {
        return users.values();
    }

    @Override
    public User getUserByName(String name) {
        return users.get(name);
    }

    @Override
    public void createUser(User user) {
        log.info("Created {}", user);
        users.put(user.name(), user);
    }

    @Override
    public Publisher<User> getUsersReactive() {
        return Flux.fromIterable(users.values());
    }
}
