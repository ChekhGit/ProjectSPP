package com.spp.chekh.pmbackend.service.interfaces;

import com.spp.chekh.pmbackend.entity.FileEntity;

import java.util.List;

public interface FileService {
    List<FileEntity> findAll();
    FileEntity findById(int id);
    FileEntity findFirstByOrderByIdDesc();
    FileEntity save(FileEntity entity);
    void delete(int id);
}
