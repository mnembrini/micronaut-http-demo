package com.example

import io.micronaut.runtime.EmbeddedApplication
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import org.reactivestreams.Publisher
import reactor.core.publisher.Flux
import spock.lang.Specification

@MicronautTest
class HttpClientTest extends Specification {

  @Inject
  UserClient userClient

  void 'Call user controller'() {
    when:
    Collection<User> users = userClient.getUsers()

    then:
    users.isEmpty()

    when:
    userClient.createUser(new User("Marco", 33))

    then:
    noExceptionThrown()

    expect:
    !userClient.getUserByName("Luigi")

    when:
    User marco = userClient.getUserByName("Marco")

    then:
    marco.name() == "Marco"
    marco.age() == 33
  }


  void 'Reactive works as well'() {
    when:
    Publisher<User> users = userClient.getUsersReactive()

    then:
    List<User> userList = Flux.from(users).collectList().block()
    userList.size() == 1

  }

}
