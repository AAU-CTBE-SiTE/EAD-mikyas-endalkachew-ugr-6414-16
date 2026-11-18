
package com.site.actor_management.controller;

import com.site.actor_management.model.Actor;
import com.site.actor_management.repository.ActorRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ActorController {

    private final ActorRepository actorRepository;

    public ActorController(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    // GET: Retrieve all actors
    @GetMapping("/actor")
    public List<Actor> getActorDetails() {
        return actorRepository.findAll();
    }

    // GET: Retrieve actor by ID
    @GetMapping("/actor/{id}")
    public ResponseEntity<Actor> getActorById(@PathVariable int id) {

        return actorRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST: Add new actor
    @PostMapping("/actor")
    public Actor addActor(@RequestBody Actor newActor) {
        return actorRepository.save(newActor);
    }

    // PUT: Update actor
    @PutMapping("/actor/{id}")
    public ResponseEntity<Actor> updateActor(
            @PathVariable int id,
            @RequestBody Actor updatedActor) {

        return actorRepository.findById(id)
                .map(actor -> {

                    actor.setName(updatedActor.getName());
                    actor.setMovieName(updatedActor.getMovieName());

                    Actor savedActor = actorRepository.save(actor);

                    return ResponseEntity.ok(savedActor);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // PATCH: Partially update actor
    @PatchMapping("/actor/{id}")
    public ResponseEntity<Actor> patchActor(
            @PathVariable int id,
            @RequestBody Actor partialActor) {

        return actorRepository.findById(id)
                .map(actor -> {

                    if (partialActor.getName() != null) {
                        actor.setName(partialActor.getName());
                    }

                    if (partialActor.getMovieName() != null) {
                        actor.setMovieName(partialActor.getMovieName());
                    }

                    Actor savedActor = actorRepository.save(actor);

                    return ResponseEntity.ok(savedActor);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE: Delete actor
    @DeleteMapping("/actor/{id}")
    public ResponseEntity<Void> deleteActor(@PathVariable int id) {

        if (!actorRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        actorRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
