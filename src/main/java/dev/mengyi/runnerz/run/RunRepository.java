package dev.mengyi.runnerz.run;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
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
        runs.add(new Run(1, "First Run", LocalDateTime.now(), LocalDateTime.now().plusMinutes(30), 5, Location.OUTDOOR));
        runs.add(new Run(2, "Second Run", LocalDateTime.now(), LocalDateTime.now().plusMinutes(60), 6, Location.OUTDOOR));
        runs.add(new Run(3, "Third Run", LocalDateTime.now(), LocalDateTime.now().plusMinutes(90), 10, Location.OUTDOOR));
    }

    Optional<Run> findById(Integer id) {
//                return runs.stream().filter(run -> run.id() == id).findFirst().get();
//        if the Optional is empty, no Run object matches the filter, so it will throw a NoSuchElementException
        return runs.stream().filter(run -> run.id() == id).findFirst();
    }

    void create(Run run) {
        runs.add(run);
    }

    void update(Run run, Integer id) {
        Optional<Run> runToUpdate = findById(run.id());
        if(runToUpdate.isPresent()){
            runs.set(runs.indexOf(runToUpdate.get()), run);
        }
    }

    void delete(Integer id) {
        runs.removeIf(run -> run.id() == id);
    }
}
