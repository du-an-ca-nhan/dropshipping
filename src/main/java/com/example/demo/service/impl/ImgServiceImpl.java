package com.example.demo.service.impl;

import com.example.demo.entity.Img;
import com.example.demo.repository.ImgRepository;
import com.example.demo.util.ImgService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ImgServiceImpl implements ImgService {

    @Autowired
    private ImgRepository imgRepository;


    @Override
    public List<Img> findAllByIdProduct(String id) {
        return imgRepository.findAllByProduct_Id(id);
    }
}
