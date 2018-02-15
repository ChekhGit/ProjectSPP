package com.spp.chekh.pmfrontend.controller;

import com.spp.chekh.pmbackend.entity.CountryEntity;
import com.spp.chekh.pmbackend.service.interfaces.CountryService;
import com.spp.chekh.pmfrontend.view.model.entity.CountryViewModel;
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
public class CountryDataController {

    @Autowired
    private CountryService countryService;

    @Autowired
    private ConversionService conversionService;

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
}
