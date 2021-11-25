package com.example;

import io.micronaut.http.client.annotation.Client;

@Client("/")
public interface UserClient extends UserOperations {
}
