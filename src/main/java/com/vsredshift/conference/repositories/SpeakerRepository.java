package com.vsredshift.conference.repositories;

import com.vsredshift.conference.models.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeakerRepository extends JpaRepository<Speaker, Long> {
}
