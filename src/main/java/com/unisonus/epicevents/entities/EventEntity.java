package com.unisonus.epicevents.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "events")
@Getter
@Setter
public class EventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255, nullable = false)
    private String title;

    @Column(length = 500, nullable = false)
    private String description;

    private LocalDateTime startsOn;

    private LocalDateTime endsOn;

    private LocalDateTime created = LocalDateTime.now();

    @Column(nullable = false)
    private String hashTag;
}
