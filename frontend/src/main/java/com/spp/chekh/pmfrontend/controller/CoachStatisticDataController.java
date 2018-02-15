package com.spp.chekh.pmfrontend.controller;

import com.spp.chekh.pmbackend.entity.CoachStatisticEntity;
import com.spp.chekh.pmbackend.service.interfaces.CoachStatisticService;
import com.spp.chekh.pmfrontend.view.model.entity.CoachStatisticViewModel;
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
public class CoachStatisticDataController {

    @Autowired
    private CoachStatisticService coachStatisticService;

    @Autowired
    private ConversionService conversionService;

    private final TypeDescriptor coachStatisticEntityTypeDescriptor = TypeDescriptor.valueOf(CoachStatisticEntity.class);
    private final TypeDescriptor coachStatisticViewModelTypeDescriptor = TypeDescriptor.valueOf(CoachStatisticViewModel.class);

    private final TypeDescriptor coachStatisticEntityListTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(CoachStatisticEntity.class));
    private final TypeDescriptor coachStatisticViewModelListTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(CoachStatisticViewModel.class));

    @RequestMapping(value = "/coach/statistic", method = RequestMethod.GET)
    @ResponseBody
    public List<CoachStatisticViewModel> getAllCoachesStatistics() {
        List<CoachStatisticEntity> coachStatisticEntityList = coachStatisticService.findAll();
        return (List<CoachStatisticViewModel>) conversionService.convert(coachStatisticEntityList, coachStatisticEntityListTypeDescriptor, coachStatisticViewModelListTypeDescriptor);
    }

    @RequestMapping(value = "/coach/statistic/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CoachStatisticViewModel getCoachStatisticByStatisticId(@PathVariable int id) {
        CoachStatisticEntity coachStatisticEntity = coachStatisticService.findById(id);
        return (CoachStatisticViewModel) conversionService.convert(coachStatisticEntity, coachStatisticEntityTypeDescriptor, coachStatisticViewModelTypeDescriptor);
    }
}
