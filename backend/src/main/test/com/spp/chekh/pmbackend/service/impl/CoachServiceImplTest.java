package com.spp.chekh.pmbackend.service.impl;

import com.spp.chekh.pmbackend.entity.CoachEntity;
import com.spp.chekh.pmbackend.repository.CoachRepository;
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
public class CoachServiceImplTest {

    @InjectMocks
    private CoachServiceImpl coachService;

    @Mock
    private CoachRepository coachRepository;

    @Test
    public void testFindAll() {
        final CoachEntity MOCKED_COACH_ENTITY = new CoachEntity();
        final List<CoachEntity> MOCKED_COACH_ENTITY_LIST = new ArrayList<>();
        MOCKED_COACH_ENTITY_LIST.add(MOCKED_COACH_ENTITY);
        Mockito.doReturn(MOCKED_COACH_ENTITY_LIST).when(coachRepository).findAll();

        List<CoachEntity> coachEntityList = coachService.findAll();

        assertNotNull(coachEntityList);
        assertEquals(MOCKED_COACH_ENTITY_LIST.size(), coachEntityList.size());
    }

    @Test
    public void testFindById() {
        final int COACH_ID = 1;
        final CoachEntity MOCKED_COACH_ENTITY = new CoachEntity();
        MOCKED_COACH_ENTITY.setId(COACH_ID);
        Mockito.doReturn(MOCKED_COACH_ENTITY).when(coachRepository).findOne(COACH_ID);

        CoachEntity coachEntity = coachService.findById(COACH_ID);

        assertNotNull(coachEntity);
        assertEquals(COACH_ID, coachEntity.getId());
    }

    @Test
    public void testFindByIdTeam() {
        final int TEAM_ID = 1;
        final CoachEntity MOCKED_COACH_ENTITY = new CoachEntity();
        MOCKED_COACH_ENTITY.setIdTeam(TEAM_ID);
        final List<CoachEntity> MOCKED_COACH_ENTITY_LIST = new ArrayList<>();
        MOCKED_COACH_ENTITY_LIST.add(MOCKED_COACH_ENTITY);
        Mockito.doReturn(MOCKED_COACH_ENTITY_LIST).when(coachRepository).findByIdTeam(TEAM_ID);

        List<CoachEntity> coachEntityList = coachService.findByIdTeam(TEAM_ID);

        assertNotNull(coachEntityList);
        assertEquals(MOCKED_COACH_ENTITY_LIST.size(), coachEntityList.size());
        assertEquals(TEAM_ID, coachEntityList.get(0).getIdTeam());
    }
}