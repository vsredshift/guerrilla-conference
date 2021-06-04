package com.vsredshift.conference.repositories;


import com.vsredshift.conference.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long> {
}
