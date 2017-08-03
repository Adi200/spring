package com.tdf.adrian.dao;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.tdf.adrian.dto.CompetitionDTO;
import com.tdf.adrian.dto.ParticipantDTO;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by User on 7/27/2017.
 */

@Entity
@Table(name = "Competitions", catalog = "competitions")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class CompetitionDAO {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="competition_id" , unique = true, nullable = false)
    private Long id;
    private String name;
    private String date;
    private String location;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="id")
    private Set<ParticipantDAO>  participants = new HashSet<ParticipantDAO>(0);

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

    public void addParticipant(ParticipantDAO participant) {
        this.participants.add(participant);
    }


    public CompetitionDTO toDTO() {
        CompetitionDTO competition = new CompetitionDTO();
        competition.setId(getId());
        competition.setName(getName());
        competition.setDate(getDate());
        competition.setLocation(getLocation());
        return competition;
    }

    public static CompetitionDAO fromDTO(CompetitionDTO competitionDto){
        CompetitionDAO participant= new CompetitionDAO();
        participant.setId(competitionDto.getId());
        participant.setName(competitionDto.getName());
        participant.setDate(competitionDto.getDate());
        participant.setLocation(competitionDto.getLocation());
        return participant;
    }

    public boolean isBucharest(String city){
        if(city.equals("Bucharest"))
            return true;
    return false;
    }

}
