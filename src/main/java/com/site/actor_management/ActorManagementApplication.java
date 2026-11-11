package com.site.actor_management;

import com.site.actor_management.model.Actor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ActorManagementApplication {

	public static void main(String[] args) {

		SpringApplication.run(ActorManagementApplication.class, args);

//		Actor actor = new Actor();
//		actor.setName("John Snow");
//		actor.setMovieName("Game of Thrones");
//		System.out.println(actor);
	}

}
