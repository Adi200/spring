package com.tdf.adrian.service;

import com.tdf.adrian.dao.*;
import com.tdf.adrian.dto.CompetitionDTO;
import com.tdf.adrian.dto.ParticipantDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by User on 8/1/2017.
 */
@Service
public class MainService {

    @Autowired
    private CompetitionRepository competitionRepository;

    @Autowired
    private ParticipantRepository participantRepository;

    public void addParticipant(ParticipantDTO participantDTO, Long competitionId) {
      ParticipantDAO participant = ParticipantDAO.fromDTO(participantDTO);
        CompetitionDAO competition = competitionRepository.findOne(competitionId);
        competition.addParticipant(participant);
        //competitionRepository.save(competition);
        participantRepository.save(participant);
    }

    public void deleteParticipant(Long participantId){
        participantRepository.delete(participantId);
    }


    public void addCompetition(CompetitionDTO competitionDTO){
       CompetitionDAO competition = CompetitionDAO.fromDTO(competitionDTO);
       competitionRepository.save(competition);

    }

    public void deleteCompetition(Long competitionId){
        competitionRepository.delete(competitionId);
    }

}
