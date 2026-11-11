package com.site.actor_management.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Data
@ToString
@Component
@AllArgsConstructor
@NoArgsConstructor
public class Actor {
    private Integer id;
    private String name;
    private String movieName;
}
