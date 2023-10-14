package com.playdata.panda.service;

import com.playdata.panda.dto.CategoryMain;
import com.playdata.panda.dto.CategorySub;

import java.util.List;

public interface ClassService {
    List<CategoryMain> findCategoryMainList();


    List<CategorySub> findCategorySubList(int category_main_id);
}
