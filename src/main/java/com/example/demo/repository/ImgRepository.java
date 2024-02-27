package com.example.demo.repository;

import com.example.demo.entity.Img;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ImgRepository extends JpaRepository<Img, String> {

    List<Img> findAllByProduct_Id(String id);
}
