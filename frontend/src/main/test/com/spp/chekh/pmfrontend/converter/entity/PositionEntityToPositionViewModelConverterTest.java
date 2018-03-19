package com.spp.chekh.pmfrontend.converter.entity;

import com.spp.chekh.pmbackend.entity.PositionEntity;
import com.spp.chekh.pmfrontend.view.model.entity.PositionViewModel;
import org.junit.Test;

import static org.junit.Assert.*;

public class PositionEntityToPositionViewModelConverterTest {

    @Test
    public void testConvert() {
        final int ID = 1;
        final String NAME = "TestPositionName";
        final PositionEntity MOCKED_POSITION_ENTITY = new PositionEntity();
        MOCKED_POSITION_ENTITY.setId(ID);
        MOCKED_POSITION_ENTITY.setName(NAME);

        PositionEntityToPositionViewModelConverter positionEntityToPositionViewModelConverter = new PositionEntityToPositionViewModelConverter();
        PositionViewModel positionViewModel = positionEntityToPositionViewModelConverter.convert(MOCKED_POSITION_ENTITY);

        assertNotNull(positionViewModel);
        assertEquals(String.valueOf(ID), positionViewModel.getId());
        assertEquals(NAME, positionViewModel.getName());
    }
}