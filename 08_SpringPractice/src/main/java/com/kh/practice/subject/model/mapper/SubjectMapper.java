package com.kh.practice.subject.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.kh.practice.subject.model.vo.Subject;

@Mapper
public interface SubjectMapper {

	List<Subject> selectAllByDepartmentNo(@Param("deptNo") String deptNo);
	
	int insertSubject(Subject subject);
	
	int insertClassAndProfessor(@Param("classNo") String classNo, @Param("professorNo") String professorNo);
}
