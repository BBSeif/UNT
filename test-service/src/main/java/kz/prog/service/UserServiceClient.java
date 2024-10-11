package kz.prog.service;

import kz.prog.User;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserServiceClient {

    private final RestTemplate restTemplate;

    public UserServiceClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public User getUserById(Long id) {
        return restTemplate.getForObject("http://localhost:8081/api/users/" + id, User.class);
    }
}
