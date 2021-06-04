package com.vsredshift.conference.controllers;

import com.vsredshift.conference.models.Session;
import com.vsredshift.conference.repositories.SessionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sessions")
public class SessionsController {

    @Autowired
    private SessionRepository sessionRepository;

    @GetMapping
    public List<Session> list() {
        return sessionRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Session get(@PathVariable Long id) {
        return sessionRepository.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // add 201 response
    public Session create(@RequestBody final Session session) {
        return sessionRepository.saveAndFlush(session);
    }

    @DeleteMapping(value = "{id}")
    public void delete(@PathVariable Long id) {
        // Also need to check for children records before deleting
        sessionRepository.deleteById(id);
    }
/*
    @PutMapping(value = "{id}")
    public Session update(@PathVariable Long id, @RequestBody Session session) {
    }*/

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Session update(@PathVariable Long id, @RequestBody Session session) {
        // PUT method. All attributes passed in. Compare with PATCH
        //TODO: Add validation that correctly updated, otherwise 400 bad payload
        Session existingSession = sessionRepository.getById(id);
        BeanUtils.copyProperties(session, existingSession, "session_id");  // ignore/DON'T update PK "session_id"
        return sessionRepository.saveAndFlush(existingSession);
    }
}
