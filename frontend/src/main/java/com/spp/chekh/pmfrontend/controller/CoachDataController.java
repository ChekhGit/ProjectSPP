package com.spp.chekh.pmfrontend.controller;

import com.spp.chekh.pmbackend.entity.CoachEntity;
import com.spp.chekh.pmbackend.service.interfaces.CoachService;
import com.spp.chekh.pmfrontend.view.model.entity.CoachViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CoachDataController {

    @Autowired
    private CoachService coachService;

    @Autowired
    private ConversionService conversionService;

    private final TypeDescriptor coachEntityListTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(CoachEntity.class));
    private final TypeDescriptor coachViewModelListTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(CoachViewModel.class));

    @RequestMapping(value = "/coach", method = RequestMethod.GET)
    @ResponseBody
    public List<CoachViewModel> getAllCoaches() {
        List<CoachEntity> coachEntities = coachService.findAll();
        return (List<CoachViewModel>) conversionService.convert(coachEntities, coachEntityListTypeDescriptor, coachViewModelListTypeDescriptor);
    }
}
