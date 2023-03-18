package ca.medaviebluecross.assessment;

import ca.medaviebluecross.assessment.model.CeilingFan;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class AssessmentApplication implements CommandLineRunner {

    public static void main(String[] args) {
        log.info("Starting the Application");
        SpringApplication.run(AssessmentApplication.class, args);
        log.info("Application finished");
    }

    @Override
    public void run(String... args) {
        CeilingFan ceilingFan = new CeilingFan();
        log.info("Default - Current speed: {}, current direction: {}", ceilingFan.getSpeed(), ceilingFan.getDirection());
        ceilingFan.pullCordToChangeSpeed();
        log.info("After pulling speed cord - current speed: {}, current direction: {}", ceilingFan.getSpeed(), ceilingFan.getDirection());
        ceilingFan.pullCordToChangeSpeed();
        log.info("After pulling speed cord - current speed: {}, current direction: {}", ceilingFan.getSpeed(), ceilingFan.getDirection());
        ceilingFan.pullCordToChangeSpeed();
        log.info("After pulling speed cord - current speed: {}, current direction: {}", ceilingFan.getSpeed(), ceilingFan.getDirection());
        ceilingFan.pullCordToChangeSpeed();
        log.info("After pulling speed cord - current speed: {}, current direction: {}", ceilingFan.getSpeed(), ceilingFan.getDirection());
        ceilingFan.pullCordToChangeDirection();
        log.info("After pulling direction cord - current speed: {}, current direction: {}", ceilingFan.getSpeed(), ceilingFan.getDirection());
        ceilingFan.pullCordToChangeDirection();
        log.info("After pulling direction cord - current speed: {}, current direction: {}", ceilingFan.getSpeed(), ceilingFan.getDirection());

    }
}
