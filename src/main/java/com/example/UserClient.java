package com.example;

import io.micronaut.http.client.annotation.Client;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Client("/")
public interface UserClient extends UserOperations{
}
