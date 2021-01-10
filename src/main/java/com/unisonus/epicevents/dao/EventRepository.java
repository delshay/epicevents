package com.unisonus.epicevents.dao;

import com.unisonus.epicevents.entities.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<EventEntity, Long> {
}
