package com.spp.chekh.pmbackend.repository;

import com.spp.chekh.pmbackend.entity.FileEntity;
import org.springframework.data.repository.CrudRepository;

public interface FileRepository extends CrudRepository<FileEntity, Integer> {
    FileEntity findFirstByOrderByIdDesc();
}
