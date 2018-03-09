package notesapp.config;

import notesapp.model.Note;
import notesapp.model.User;
import notesapp.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = {UserRepository.class})
@Configuration
public class MongoDBConfig  {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository) {
        return strings -> {
            userRepository.deleteAll();

            User u1 = new User("Jose","Jose123");
            u1.addNote(new Note("1","Esta es mi primera nota"));
            u1.addNote(new Note("2","Esta es mi segunda nota"));
            u1.addNote(new Note("3","Esta es mi tercera nota"));

            User u2 = new User("David", "David123");
            u2.addNote(new Note("1","This is my first note"));
            u2.addNote(new Note("2","This is my second note"));
            u2.addNote(new Note("3","This is my third note"));

            userRepository.save(u1);
            userRepository.save(u2);
        };
    }

}
