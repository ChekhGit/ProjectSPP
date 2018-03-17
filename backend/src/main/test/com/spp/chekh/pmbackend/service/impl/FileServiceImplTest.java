package com.spp.chekh.pmbackend.service.impl;

import com.spp.chekh.pmbackend.entity.FileEntity;
import com.spp.chekh.pmbackend.repository.FileRepository;
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
public class FileServiceImplTest {

    @InjectMocks
    private FileServiceImpl fileService;

    @Mock
    private FileRepository fileRepository;

    @Test
    public void testFindAll() {
        final FileEntity MOCKED_FILE_ENTITY = new FileEntity();
        final List<FileEntity> MOCKED_FILE_ENTITY_LIST = new ArrayList<>();
        MOCKED_FILE_ENTITY_LIST.add(MOCKED_FILE_ENTITY);
        Mockito.doReturn(MOCKED_FILE_ENTITY_LIST).when(fileRepository).findAll();

        List<FileEntity> fileEntityList = fileService.findAll();

        assertNotNull(fileEntityList);
        assertEquals(MOCKED_FILE_ENTITY_LIST.size(), fileEntityList.size());
    }

    @Test
    public void testFindById() {
        final int FILE_ID = 1;
        final FileEntity MOCKED_FILE_ENTITY = new FileEntity();
        MOCKED_FILE_ENTITY.setId(FILE_ID);
        Mockito.doReturn(MOCKED_FILE_ENTITY).when(fileRepository).findOne(FILE_ID);

        FileEntity fileEntity = fileService.findById(FILE_ID);

        assertNotNull(fileEntity);
        assertEquals(FILE_ID, fileEntity.getId());
    }

    @Test
    public void testFindFirstByOrderByIdDesc() {
        final FileEntity MOCKED_FILE_ENTITY = new FileEntity();
        Mockito.doReturn(MOCKED_FILE_ENTITY).when(fileRepository).findFirstByOrderByIdDesc();

        FileEntity fileEntity = fileService.findFirstByOrderByIdDesc();

        assertNotNull(fileEntity);
    }
}