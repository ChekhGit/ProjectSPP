package com.spp.chekh.pmfrontend.controller;

import com.spp.chekh.pmbackend.entity.CountryEntity;
import com.spp.chekh.pmbackend.factory.EntityFactory;
import com.spp.chekh.pmbackend.service.interfaces.CountryService;
import com.spp.chekh.pmbackend.service.interfaces.custom.CreationService;
import com.spp.chekh.pmfrontend.dto.CountryDTO;
import com.spp.chekh.pmfrontend.view.model.entity.CountryViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CountryDataController {

    @Autowired
    private CountryService countryService;

    @Autowired
    private ConversionService conversionService;

    @Autowired
    private EntityFactory entityFactory;

    @Autowired
    private CreationService creationService;

    private final TypeDescriptor countryEntityListTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(CountryEntity.class));
    private final TypeDescriptor countryViewModelListTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(CountryViewModel.class));

    private final TypeDescriptor countryEntityTypeDescriptor = TypeDescriptor.valueOf(CountryEntity.class);
    private final TypeDescriptor countryViewModelTypeDescriptor = TypeDescriptor.valueOf(CountryViewModel.class);

    @RequestMapping(value = "/country", method = RequestMethod.GET)
    @ResponseBody
    public List<CountryViewModel> getAllCountries() {
        List<CountryEntity> countryEntities = countryService.findAll();
        return (List<CountryViewModel>) conversionService.convert(countryEntities, countryEntityListTypeDescriptor, countryViewModelListTypeDescriptor);
    }

    @RequestMapping(value = "/country/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CountryViewModel getCountryById(@PathVariable int id) {
        CountryEntity countryEntity = countryService.findById(id);
        return (CountryViewModel) conversionService.convert(countryEntity, countryEntityTypeDescriptor, countryViewModelTypeDescriptor);
    }

    @RequestMapping(value = "/country/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteCountryById(@PathVariable int id){
        countryService.delete(id);
    }

    @RequestMapping(value = "/country", method = RequestMethod.PUT)
    @ResponseBody
    public void createCountry(@RequestBody CountryDTO countryDTO){
        CountryEntity countryEntity = entityFactory.getCountryEntity(countryDTO.getName());
        creationService.createCountry(countryEntity);
    }
}
