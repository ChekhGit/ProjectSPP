package com.spp.chekh.pmbackend.service.impl;

import com.spp.chekh.pmbackend.entity.CoachStatisticEntity;
import com.spp.chekh.pmbackend.repository.CoachStatisticRepository;
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
public class CoachStatisticServiceImplTest {

    @InjectMocks
    private CoachStatisticServiceImpl coachStatisticService;

    @Mock
    private CoachStatisticRepository coachStatisticRepository;

    @Test
    public void testFindAll() {
        final CoachStatisticEntity MOCKED_COACH_STATISTIC_ENTITY = new CoachStatisticEntity();
        final List<CoachStatisticEntity> MOCKED_COACH_STATISTIC_ENTITY_LIST = new ArrayList<>();
        MOCKED_COACH_STATISTIC_ENTITY_LIST.add(MOCKED_COACH_STATISTIC_ENTITY);
        Mockito.doReturn(MOCKED_COACH_STATISTIC_ENTITY_LIST).when(coachStatisticRepository).findAll();

        List<CoachStatisticEntity> coachStatisticEntityList = coachStatisticService.findAll();

        assertNotNull(coachStatisticEntityList);
        assertEquals(MOCKED_COACH_STATISTIC_ENTITY_LIST.size(), coachStatisticEntityList.size());
    }

    @Test
    public void testFindById() {
        final int COACH_STATISTIC_ID = 1;
        final CoachStatisticEntity MOCKED_COACH_ENTITY = new CoachStatisticEntity();
        MOCKED_COACH_ENTITY.setId(COACH_STATISTIC_ID);
        Mockito.doReturn(MOCKED_COACH_ENTITY).when(coachStatisticRepository).findOne(COACH_STATISTIC_ID);

        CoachStatisticEntity coachStatisticEntity = coachStatisticService.findById(COACH_STATISTIC_ID);

        assertNotNull(coachStatisticEntity);
        assertEquals(COACH_STATISTIC_ID, coachStatisticEntity.getId());
    }

    @Test
    public void testFindLast() {
        final CoachStatisticEntity MOCKED_COACH_ENTITY = new CoachStatisticEntity();
        Mockito.doReturn(MOCKED_COACH_ENTITY).when(coachStatisticRepository).findFirstByOrderByIdDesc();

        CoachStatisticEntity coachStatisticEntity = coachStatisticService.findLast();

        assertNotNull(coachStatisticEntity);
    }
}