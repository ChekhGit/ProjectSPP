package com.spp.chekh.pmbackend.service.impl;

import com.spp.chekh.pmbackend.entity.TargetDistributionEntity;
import com.spp.chekh.pmbackend.repository.TargetDistributionRepository;
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
public class TargetDistributionServiceImplTest {

    @InjectMocks
    private TargetDistributionServiceImpl targetDistributionService;

    @Mock
    private TargetDistributionRepository targetDistributionRepository;

    @Test
    public void testFindAll() {
        final TargetDistributionEntity MOCKED_TARGET_DISTRIBUTION_ENTITY = new TargetDistributionEntity();
        final List<TargetDistributionEntity> MOCKED_TARGET_DIATRIBUTION_ENTITY_LIST = new ArrayList<>();
        MOCKED_TARGET_DIATRIBUTION_ENTITY_LIST.add(MOCKED_TARGET_DISTRIBUTION_ENTITY);
        Mockito.doReturn(MOCKED_TARGET_DIATRIBUTION_ENTITY_LIST).when(targetDistributionRepository).findAll();

        List<TargetDistributionEntity> targetDistributionEntityList = targetDistributionService.findAll();

        assertNotNull(targetDistributionEntityList);
        assertEquals(MOCKED_TARGET_DIATRIBUTION_ENTITY_LIST.size(), targetDistributionEntityList.size());
    }

    @Test
    public void testFindById() {
        final int TARGET_DISTRIBUTION_ID = 1;
        final TargetDistributionEntity MOCKED_TARGET_DISTRIBUTION_ENTITY = new TargetDistributionEntity();
        MOCKED_TARGET_DISTRIBUTION_ENTITY.setId(TARGET_DISTRIBUTION_ID);
        Mockito.doReturn(MOCKED_TARGET_DISTRIBUTION_ENTITY).when(targetDistributionRepository).findOne(TARGET_DISTRIBUTION_ID);

        TargetDistributionEntity targetDistributionEntity = targetDistributionService.findById(TARGET_DISTRIBUTION_ID);

        assertNotNull(targetDistributionEntity);
        assertEquals(TARGET_DISTRIBUTION_ID, targetDistributionEntity.getId());
    }

    @Test
    public void testFindByIdTarget() {
        final int TARGET_ID = 1;
        final TargetDistributionEntity MOCKED_TARGET_DISTRIBUTION_ENTITY = new TargetDistributionEntity();
        MOCKED_TARGET_DISTRIBUTION_ENTITY.setIdTarget(TARGET_ID);
        final List<TargetDistributionEntity> MOCKED_TARGET_DISTRIBUTION_ENTITY_LIST = new ArrayList<>();
        MOCKED_TARGET_DISTRIBUTION_ENTITY_LIST.add(MOCKED_TARGET_DISTRIBUTION_ENTITY);
        Mockito.doReturn(MOCKED_TARGET_DISTRIBUTION_ENTITY_LIST).when(targetDistributionRepository).findByIdTarget(TARGET_ID);

        List<TargetDistributionEntity> targetDistributionEntityList = targetDistributionService.findByIdTarget(TARGET_ID);

        assertNotNull(targetDistributionEntityList);
        assertEquals(MOCKED_TARGET_DISTRIBUTION_ENTITY_LIST.size(), targetDistributionEntityList.size());
        assertEquals(TARGET_ID, targetDistributionEntityList.get(0).getIdTarget());
    }
}