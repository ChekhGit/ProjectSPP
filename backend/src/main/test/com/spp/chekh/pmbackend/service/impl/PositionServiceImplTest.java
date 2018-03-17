package com.spp.chekh.pmbackend.service.impl;

import com.spp.chekh.pmbackend.entity.PositionEntity;
import com.spp.chekh.pmbackend.repository.PositionRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class PositionServiceImplTest {

    @InjectMocks
    private PositionServiceImpl positionService;

    @Mock
    private PositionRepository positionRepository;

    @Test
    public void testFindAll() {
        final PositionEntity MOCKED_POSITION_ENTITY = new PositionEntity();
        final List<PositionEntity> MOCKED_POSITION_ENTITY_LIST = new ArrayList<>();
        MOCKED_POSITION_ENTITY_LIST.add(MOCKED_POSITION_ENTITY);
        Mockito.doReturn(MOCKED_POSITION_ENTITY_LIST).when(positionRepository).findAll();

        List<PositionEntity> positionEntityList = positionService.findAll();

        assertNotNull(positionEntityList);
        assertEquals(MOCKED_POSITION_ENTITY_LIST.size(), positionEntityList.size());
    }

    @Test
    public void testFindById() {
        final int POSITION_ID = 1;
        final PositionEntity MOCKED_POSITION_ENTITY = new PositionEntity();
        MOCKED_POSITION_ENTITY.setId(POSITION_ID);
        Mockito.doReturn(MOCKED_POSITION_ENTITY).when(positionRepository).findOne(POSITION_ID);

        PositionEntity positionEntity = positionService.findById(POSITION_ID);

        assertNotNull(positionEntity);
        assertEquals(POSITION_ID, positionEntity.getId());
    }
}