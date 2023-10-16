package com.playdata.panda.service;

import com.playdata.panda.dto.CategoryMain;
import com.playdata.panda.dto.CategorySub;
import com.playdata.panda.dto.ClassListDTO;
import com.playdata.panda.repository.ClassRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClassServiceImpl implements ClassService {

    // 필드
    private final ClassRepository classRepository;

    /**
     * findCategoryMainList
     * @return List<CategoryMain>
     * 기능 : 카테고리 대분류 불러올 수 있습니다.
     */
    @Override
    public List<CategoryMain> findCategoryMainList() {

        return classRepository.findCategoryMainList();
    }

    @Override
    public List<CategorySub> findCategorySubList(int category_main_id){
        return classRepository.findCategorySubList(category_main_id);
    }

	@Override
	public List<ClassListDTO> selectClassList() {
		return classRepository.selectClassList();
	}

}
