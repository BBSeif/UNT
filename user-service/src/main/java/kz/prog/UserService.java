package kz.prog;

import org.springframework.stereotype.Service;

@Service
public record UserService (UserRepository userRepository) {

    public void registerUser(UserRegistrationRequest request) {
            User user = User.builder()
                    .username(request.username())
                    .password(request.password())
                    .role(request.role())
                    .build();

//            todo: check if username valid
//            todo: check if username not taken


            userRepository.save(user);
    }



}
