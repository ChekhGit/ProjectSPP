package com.spp.chekh.pmfrontend.controller;

import com.spp.chekh.pmbackend.entity.CoachEntity;
import com.spp.chekh.pmbackend.service.interfaces.CoachService;
import com.spp.chekh.pmbackend.service.interfaces.CoachStatisticService;
import com.spp.chekh.pmfrontend.view.model.custom.CoachTableViewModel;
import com.spp.chekh.pmfrontend.view.model.entity.CoachViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CoachDataController {

    @Autowired
    private CoachService coachService;

    @Autowired
    private CoachStatisticService coachStatisticService;

    @Autowired
    private ConversionService conversionService;

    private final TypeDescriptor coachEntityListTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(CoachEntity.class));
    private final TypeDescriptor coachViewModelListTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(CoachViewModel.class));
    private final TypeDescriptor coachTableViewModelListTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(CoachTableViewModel.class));
    private final TypeDescriptor coachEntityTypeDescriptor = TypeDescriptor.valueOf(CoachEntity.class);
    private final TypeDescriptor coachTableViewModelTypeDescriptor = TypeDescriptor.valueOf(CoachTableViewModel.class);
    private final TypeDescriptor coachViewModelTypeDescriptor = TypeDescriptor.valueOf(CoachViewModel.class);

    @RequestMapping(value = "/coach", method = RequestMethod.GET)
    @ResponseBody
    public List<CoachViewModel> getAllCoaches() {
        List<CoachEntity> coachEntities = coachService.findAll();
        return (List<CoachViewModel>) conversionService.convert(coachEntities, coachEntityListTypeDescriptor, coachViewModelListTypeDescriptor);
    }

    @RequestMapping(value = "/coach/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CoachTableViewModel getCoachById(@PathVariable int id) {
        CoachEntity coachEntity = coachService.findById(id);
        return (CoachTableViewModel) conversionService.convert(coachEntity, coachEntityTypeDescriptor, coachTableViewModelTypeDescriptor);
    }

    @RequestMapping(value = "/team/{id}/coach", method = RequestMethod.GET)
    @ResponseBody
    public List<CoachTableViewModel> getAllCoachesByTeamId(@PathVariable int id) {
        List<CoachEntity> coachEntities = coachService.findByIdTeam(id);
        return (List<CoachTableViewModel>) conversionService.convert(coachEntities, coachEntityListTypeDescriptor, coachTableViewModelListTypeDescriptor);
    }

    @RequestMapping(value = "/coach/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteCoachById(@PathVariable int id){
        coachStatisticService.delete(id);
    }
}
