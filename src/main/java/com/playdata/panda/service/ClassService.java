package com.playdata.panda.service;

import java.util.List;

import com.playdata.panda.dto.CategoryMain;
import com.playdata.panda.dto.CategorySub;
import com.playdata.panda.dto.ClassListDTO;

public interface ClassService {
    List<CategoryMain> findCategoryMainList();


    List<CategorySub> findCategorySubList(int category_main_id);
    List<ClassListDTO> selectClassList();
    
}
