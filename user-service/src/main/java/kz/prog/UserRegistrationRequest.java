package kz.prog;

public record UserRegistrationRequest(
        String username,
        String password,
        Role role
) {
}
