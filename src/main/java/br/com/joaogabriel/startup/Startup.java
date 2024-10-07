package br.com.joaogabriel.startup;

import br.com.joaogabriel.entity.Role;
import br.com.joaogabriel.entity.User;
import br.com.joaogabriel.repository.UserRepository;
import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Singleton;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Singleton
public class Startup {

    private final UserRepository userRepository;
    private final Logger logger = Logger.getLogger(getClass().getSimpleName());

    public Startup(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void addUser(@Observes StartupEvent event) {
        logger.log(Level.INFO, "Adding user: { Username: Batman, Password: BruceWayne } on system.");
        User user = new User("Batman", "BruceWayne", List.of(new Role("ADMIN")));
        this.userRepository.persist(user);
    }


}
