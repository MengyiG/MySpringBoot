package dev.mengyi.runnerz.run;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RunRepository {
    private List<Run> runs = new ArrayList<>();

    List<Run> findAll() {
        return runs;
    }

    @PostConstruct
    private void init(){
        runs.add(new Run(1, "First Run", LocalDateTime.now(), LocalDateTime.now().plus(30, ChronoUnit.MINUTES), 5, Location.OUTDOOR));
        runs.add(new Run(2, "Second Run", LocalDateTime.now(), LocalDateTime.now().plus(60, ChronoUnit.MINUTES), 6, Location.OUTDOOR));
        runs.add(new Run(3, "Third Run", LocalDateTime.now(), LocalDateTime.now().plus(90, ChronoUnit.MINUTES), 10, Location.OUTDOOR));
    }

    Optional<Run> findById(Integer id) {
//                return runs.stream().filter(run -> run.id() == id).findFirst().get();
//        if the Optional is empty, no Run object matches the filter, so it will throw a NoSuchElementException
        return runs.stream().filter(run -> run.id() == id).findFirst();
    }
}
