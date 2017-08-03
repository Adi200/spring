package com.tdf.adrian.dto;


import com.tdf.adrian.dao.CompetitionDAO;
import com.tdf.adrian.dao.CompetitionRepository;
import com.tdf.adrian.dao.ParticipantDAO;
import com.tdf.adrian.dto.CompetitionDTO;
import com.tdf.adrian.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;


/**
 * Created by User on 7/26/2017.
 */

@RestController
public class CompetitionController {
    CompetitionDAO competitionObj = new CompetitionDAO();

    @Autowired
    private CompetitionRepository competitionRepository;

    @Autowired
    MainService mainService;


    @RequestMapping(value = "/competition/add", method = RequestMethod.POST)
    public @ResponseBody
    String addCompetition(@RequestBody CompetitionDTO competition) {
        if(competitionObj.isBucharest(competition.getLocation())){
        mainService.addCompetition(competition);
        return "Competition added!";}
        return "Wrong location!";
    }

//    @RequestMapping(value = "/getCompetitionDAO")
//    public ResponseEntity<CompetitionDAO> get() {
//        System.out.println(competition.getId());
//        System.out.println( competition.getName());
//        System.out.println( competition.getNumber());
//        System.out.println( competition.isFlag());
//        System.out.println( competition.getDateOfBirth());
//        System.out.println( competition.getSpecialAttribute());
//        System.out.println( competition.getCompetition());
//
//// CompetitionDAO competition = new CompetitionDAO();
////        competition.setName("Adrian");
////        competition.setNumber(10);
////        competition.setFlag(true);
////        competition.setDateOfBirth("27/07/1990");
////        competition.setSpecialAttribute("Medium");
////        competition.setCompetition("Tour de France");
//
//        return new ResponseEntity<CompetitionDAO>(competition, HttpStatus.OK);
//    }

    @RequestMapping(value = "/competition/get", method = RequestMethod.GET)
    public CompetitionDAO getCompetition(@RequestParam(value = "Id") Long id) {
        return competitionRepository.findOne(id);
    }

    @RequestMapping(value = "/competition/delete", method = RequestMethod.DELETE)
    public String deleteCompetition(@RequestParam(value = "Id") Long id) {
        mainService.deleteCompetition(id);
        return "Competition deleted!";
    }

//    @RequestMapping(value="/xxxx", method=RequestMethod.GET)
//    public CompetitionDAO doStuff() {
//        CompetitionDAO x = new CompetitionDAO();
//        //userRepository.findAll();
//        return x;
//    }
//
//    @RequestMapping(value="/xxx", method=RequestMethod.GET)
//    public Collection<CompetitionDAO> competititionsToArrayList(){
//        Collection<CompetitionDAO> arrayListOfCompetitions= new ArrayList<CompetitionDAO>();
//        arrayListOfCompetitions=makeCollection(competitionRepository.findAll());
//
//        return arrayListOfCompetitions;
//    }
//
//
//
//    public static  Collection<CompetitionDAO> makeCollection(Iterable<CompetitionDAO> iter) {
//        Collection<CompetitionDAO> list = new ArrayList<CompetitionDAO>();
//        for (CompetitionDAO item : iter) {
//            list.add(item);
//        }
//        return list;
//    }
}
