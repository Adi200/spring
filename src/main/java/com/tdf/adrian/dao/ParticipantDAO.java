package com.tdf.adrian.dao;

import com.tdf.adrian.dto.ParticipantDTO;
import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.zip.DataFormatException;

/**
 * Created by User on 7/26/2017.
 */
@Entity
@Table(name = "Participants", catalog = "competitions")
public class ParticipantDAO {


    private Long id;
    private String name;
    private int number;
    private Date dateOfBirth;
    private ParticipantType type;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }


    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "participant_id", unique = true, nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Enumerated(EnumType.STRING)
    public ParticipantType getType() {
        return type;
    }

    public void setType(ParticipantType type) {
        this.type = type;

    }
    public  ParticipantDTO toDTO() {
        ParticipantDTO participant = new ParticipantDTO();
        participant.setId(getId());
        participant.setName(getName());
        participant.setNumber(getNumber());
        participant.setDateOfBirth(getDateOfBirth());
        participant.setType(getType());
        return participant;
    }

    public static ParticipantDAO fromDTO(ParticipantDTO participantDto){

        ParticipantDAO participant= new ParticipantDAO();
        participant.setId(participantDto.getId());
        participant.setName(participantDto.getName());
        participant.setNumber(participantDto.getNumber());
        participant.setDateOfBirth(participantDto.getDateOfBirth());
        participant.setType(participantDto.getType());
        return participant;
    }

    public boolean pTypeValidation(ParticipantType type){
        switch (type){
            case ACTIVE:return true;
            case MEDIUM:return true;
            case LOW:return false;
        }

        return false;
    }

}