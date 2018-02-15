package com.spp.chekh.pmfrontend.controller;

import com.spp.chekh.pmbackend.entity.PositionEntity;
import com.spp.chekh.pmbackend.service.interfaces.PositionService;
import com.spp.chekh.pmfrontend.view.model.entity.PositionViewModel;
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
public class PositionDataController {

    @Autowired
    private PositionService positionService;

    @Autowired
    private ConversionService conversionService;

    private final TypeDescriptor positionEntityTypeDescriptor = TypeDescriptor.valueOf(PositionEntity.class);
    private final TypeDescriptor positionViewModelTypeDescriptor = TypeDescriptor.valueOf(PositionViewModel.class);

    private final TypeDescriptor positionEntityListTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(PositionEntity.class));
    private final TypeDescriptor positionViewModelListTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(PositionViewModel.class));

    @RequestMapping(value = "/position", method = RequestMethod.GET)
    @ResponseBody
    public List<PositionViewModel> getAllPositions() {
        List<PositionEntity> positionEntityList = positionService.findAll();
        return (List<PositionViewModel>) conversionService.convert(positionEntityList, positionEntityListTypeDescriptor, positionViewModelListTypeDescriptor);
    }

    @RequestMapping(value = "/position/{id}", method = RequestMethod.GET)
    @ResponseBody
    public PositionViewModel getPositionById(@PathVariable int id) {
        PositionEntity positionEntity = positionService.findById(id);
        return (PositionViewModel) conversionService.convert(positionEntity, positionEntityTypeDescriptor, positionViewModelTypeDescriptor);
    }
}
