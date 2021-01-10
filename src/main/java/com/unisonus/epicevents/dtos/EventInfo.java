package com.unisonus.epicevents.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class EventInfo {

    private Long id;
    private String title;
    private String description;
    private LocalDateTime startsOn;
    private LocalDateTime endsOn;
    private LocalDateTime created;
    private String hashTag;
}
