package com.example;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.validation.Validated;
import java.util.Collection;
import java.util.List;
import org.reactivestreams.Publisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Validated
public interface UserOperations {

    @Get("/users")
    Collection<User> getUsers();

    @Get("/users/{name}")
    User getUserByName(String name);

    @Post
    void createUser(User user);

    @Get("/usersReactive")
    Publisher<User> getUsersReactive();


}
