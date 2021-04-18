package pl.wsb.students.course.app.repository;

import org.springframework.data.repository.CrudRepository;
import pl.wsb.students.course.app.model.Actor;

public interface ActorRepository extends CrudRepository<Actor, Integer> {

}
