package com.playdata.panda.service;

import java.util.List;

import com.playdata.panda.dto.CategoryMain;
import com.playdata.panda.dto.CategorySub;
import com.playdata.panda.dto.ClassListDTO;
import com.playdata.panda.dto.PandaClass;
import com.playdata.panda.dto.Review;

public interface ClassService {
    List<CategoryMain> findCategoryMainList();


    List<CategorySub> findCategorySubList(int category_main_id);
    List<ClassListDTO> selectClassList();
    void registerClass(PandaClass dto);
    ClassListDTO getClassInfo(String class_id);
    void registerReview(Review review);
}
