package com.unisonus.epicevents.services;

import com.unisonus.epicevents.dao.EventRepository;
import com.unisonus.epicevents.dtos.EventInfo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<EventInfo> getUpcomingEvents() {
        return getAllEvents()
                .filter(eventInfo -> eventInfo.getEndsOn().isAfter(LocalDateTime.now()))
                .sorted(Comparator.comparing(EventInfo::getStartsOn))
                .collect(Collectors.toList());
    }

    public List<EventInfo> getPreviusEvents() {
        return getAllEvents().filter(eventInfo -> eventInfo.getEndsOn().isBefore(LocalDateTime.now()))
                .sorted(Comparator.comparing(EventInfo::getStartsOn))
                .collect(Collectors.toList());
    }

    private Stream<EventInfo> getAllEvents() {
        return eventRepository.findAll()
                .stream()
                .map(eventEntity -> new EventInfo(
                        eventEntity.getId(),
                        eventEntity.getTitle(),
                        eventEntity.getDescription(),
                        eventEntity.getStartsOn(),
                        eventEntity.getEndsOn(),
                        eventEntity.getCreated(),
                        eventEntity.getHashTag()));
    }
}
