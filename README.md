# Campus Lost & Found – with accounts

**Student:** YOUR NAME HERE
**Course:** CSC 311 – Advanced Programming, Module 9 (Security)

A Spring Boot app where visitors register, sign in, and then see the Campus Lost & Found page.
Uses Spring Security (BCrypt-hashed passwords stored in H2) and Thymeleaf pages.

## Requirements

- Java 21
- Maven (or open the project in IntelliJ, which bundles Maven)

## How to run

```bash
mvn spring-boot:run
```

Then open <http://localhost:8080>. You will be sent to the sign-in page.

1. Click **Create an account**, choose a username (3+ characters) and password (6+ characters).
2. Sign in with the new account.
3. Report an item, then click **Sign out**.

## H2 console

Open <http://localhost:8080/h2-console> and connect with:

- JDBC URL: `jdbc:h2:file:./data/lostfound-db`
- User: `sa`, password: (empty)

`SELECT * FROM APP_USERS;` shows passwords stored as BCrypt hashes starting with `$2a$`.

## Project layout

| File | Purpose |
|------|---------|
| `config/SecurityConfig.java` | `PasswordEncoder` bean and `SecurityFilterChain` rules |
| `user/AppUser.java` | Entity mapped to `app_users` |
| `user/AppUserRepository.java` | `findByUsername`, `existsByUsername` |
| `user/DatabaseUserDetailsService.java` | Loads users for Spring Security |
| `user/RegistrationController.java` | `/register` form and validation |
| `user/LoginController.java` | Serves the custom `/login` page |
| `HomeController.java` | Serves the Lost & Found page at `/` |
| `templates/` | `register.html`, `login.html`, `index.html` |
