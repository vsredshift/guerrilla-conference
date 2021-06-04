package com.vsredshift.conference.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

@Entity(name = "speakers")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Speaker {

    // Attributes

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer speaker_id;

    private String first_name;
    private String last_name;
    private String title;
    private String company;
    private String speaker_bio;

    @Lob    // Large object
    @Type(type = "org.hibernate.type.BinaryType")
    private byte [] speaker_photo;


    @ManyToMany(mappedBy = "speakers")
    @JsonIgnore     // Handling Serialization
    private List<Session> sessions;


    // Constructors

    public Speaker() {

    }

    public Speaker(Integer speaker_id, String first_name, String last_name, String title, String company, String speaker_bio) {
        this.speaker_id = speaker_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.title = title;
        this.company = company;
        this.speaker_bio = speaker_bio;
    }
// Getters & Setters

    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    public Integer getSpeaker_id() {
        return speaker_id;
    }

    public void setSpeaker_id(Integer speaker_id) {
        this.speaker_id = speaker_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getSpeaker_bio() {
        return speaker_bio;
    }

    public void setSpeaker_bio(String speaker_bio) {
        this.speaker_bio = speaker_bio;
    }

    public byte[] getSpeaker_photo() {
        return speaker_photo;
    }

    public void setSpeaker_photo(byte[] speaker_photo) {
        this.speaker_photo = speaker_photo;
    }

}
