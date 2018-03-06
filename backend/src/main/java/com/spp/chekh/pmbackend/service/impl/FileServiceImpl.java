package com.spp.chekh.pmbackend.service.impl;

import com.google.common.collect.Lists;
import com.spp.chekh.pmbackend.entity.FileEntity;
import com.spp.chekh.pmbackend.repository.FileRepository;
import com.spp.chekh.pmbackend.service.interfaces.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private FileRepository fileRepository;

    @Override
    public List<FileEntity> findAll() {
        return Lists.newArrayList(fileRepository.findAll());
    }

    @Override
    public FileEntity findById(int id) {
        return fileRepository.findOne(id);
    }

    @Override
    public FileEntity findFirstByOrderByIdDesc() {
        return fileRepository.findFirstByOrderByIdDesc();
    }

    @Override
    public FileEntity save(FileEntity entity) {
        return fileRepository.save(entity);
    }

    @Override
    public void delete(int id) {
        fileRepository.delete(id);
    }
}
