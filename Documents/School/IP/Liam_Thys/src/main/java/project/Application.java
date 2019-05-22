package project;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import project.model.Gerecht;
import project.repo.GerechtRepository;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner runnerGerechten(GerechtRepository gerechtRepository){
        return args -> {
            gerechtRepository.save(new Gerecht("Kervelsoep",2, "SOEP"));
            gerechtRepository.save(new Gerecht("Balletjes met tomatensaus",5.25, "DAGSCHOTEL"));
            gerechtRepository.save(new Gerecht("Veggie nuggets",2, "VEGGIE"));
        };
    }
}
