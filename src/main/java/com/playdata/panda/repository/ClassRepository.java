package com.playdata.panda.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.playdata.panda.dto.CategoryMain;
import com.playdata.panda.dto.CategorySub;
import com.playdata.panda.dto.ClassListDTO;
import com.playdata.panda.dto.LoginSuccessDTO;
import com.playdata.panda.dto.PandaClass;
import com.playdata.panda.dto.Review;

@Mapper
public interface ClassRepository {
    List<CategoryMain> findCategoryMainList();

    List<CategorySub> findCategorySubList(int category_main_id);
    List<ClassListDTO> selectClassTeacherList(LoginSuccessDTO user);
    List<ClassListDTO> selectClassStudentList(LoginSuccessDTO user);
    int registerClass(PandaClass dto);
    ClassListDTO getClassInfo(String class_id);
	void registerReview(Review review);
	int saveOne(Review review);;
}

