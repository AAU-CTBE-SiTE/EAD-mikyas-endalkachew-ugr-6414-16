package com.site.actor_management.controller;

import com.site.actor_management.model.Actor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ActorController {

    List<Actor> actors = new ArrayList<>();

    public ActorController() {
        actors.add(new Actor(1, "John Snow", "Game of Thrones"));
        actors.add(new Actor(2, "Jane Smith", "Mystery Island"));

    }

    @GetMapping("/actor")
    public List<Actor> getActorDetails() {
        return actors;
    }

    @GetMapping("/actor/{id}")
    public Actor getActorById(@PathVariable int id) {
        for(Actor actor : actors) {
            if(actor.getId() == id) {
                return actor;
            }
        }
        return null;
    }

    @PostMapping("/actor")
    public Actor addActor(@RequestBody Actor newActor) {
        actors.add(newActor);
        return newActor;
    }

    @PutMapping("/actor/{id}")
    public Actor updateActor(@PathVariable int id, @RequestBody Actor updatedActor) {
        for (Actor actor : actors) {
            if (actor.getId() == id) {
                actor.setName(updatedActor.getName());
                actor.setMovieName(updatedActor.getMovieName());
                return actor;
            }
        }
        return null;
    }

    @PatchMapping("/actor/{id}")
    public Actor patchActor(@PathVariable int id, @RequestBody Actor partialActor) {
        for (Actor actor : actors) {
            if (actor.getId() == id) {
                if(partialActor.getName() != null) {
                    actor.setName(partialActor.getName());
                }

                if(partialActor.getMovieName() != null) {
                    actor.setMovieName(partialActor.getMovieName());
                }
                return actor;
            }
        }
        return null;
    }

    @DeleteMapping("/actor/{id}")
    public String deleteActor(@PathVariable int id) {
        for (Actor actor : actors) {
            if (actor.getId() == id) {
                actors.remove(actor);
                return "Actor has been deleted";
            }
        }
        return "Error deleting Actor";
    }
}
