package com.playdata.panda.repository;

import com.playdata.panda.dto.CategoryMain;
import com.playdata.panda.dto.CategorySub;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClassRepository {
    List<CategoryMain> findCategoryMainList();

    List<CategorySub> findCategorySubList(int category_main_id);
}
