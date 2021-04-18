package pl.wsb.students.course.app.service;

import org.springframework.stereotype.Service;
import pl.wsb.students.course.app.model.Actor;
import pl.wsb.students.course.app.repository.ActorRepository;

import javax.transaction.Transactional;
import java.util.Date;

@Service
@Transactional
public class ActorService {

    private final ActorRepository actorRepository;

    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    public Iterable<Actor> listAll() {
        return actorRepository.findAll();
    }

    public Actor find(Integer id) {
        return actorRepository.findById(id).orElse(null);
    }

    public void delete(Integer id) {
        actorRepository.deleteById(id);
    }

    public void save(Actor actor) {
        if (actor.getModified() == null) {
            actor.setModified(new Date());
        }   //if
        actorRepository.save(actor);
    }
}
