package com.example.demo.util;

import com.example.demo.entity.Img;

import java.util.List;

public interface ImgService {

    List<Img> findAllByIdProduct(String id);
}
