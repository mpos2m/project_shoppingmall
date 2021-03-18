package project_shoppingmall.dao;

import java.util.List;

import project_shoppingmall.dto.Grade;

public interface GradeDao {
	List<Grade> selectGradeByAll();
	Grade selectGradeByGrade(Grade grade);
	
	int insertGrade(Grade grade);
	int updateGrade(Grade grade);
	int deleteGrade(String grade);
}
