package com.tdf.adrian.dto;

import com.tdf.adrian.dao.ParticipantDAO;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by User on 7/27/2017.
 */
public class CompetitionDTO {

    private Long id;
    private String name;
    private String date;
    private String location;
    private Set<ParticipantDAO> participants = new HashSet<ParticipantDAO>(0);

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Set<ParticipantDAO> getParticipants() {
        return participants;
    }

    public void setParticipants(Set<ParticipantDAO> participants) {
        this.participants = participants;
    }
}
