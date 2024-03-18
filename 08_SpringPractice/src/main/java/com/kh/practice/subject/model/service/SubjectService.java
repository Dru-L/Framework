package com.kh.practice.subject.model.service;

import java.util.List;

import com.kh.practice.subject.model.vo.Subject;

public interface SubjectService {

	List<Subject> getSubjectsByDeparmentNo(String departmentNo);

	int save(Subject subject);

	int joinProfessor(String classNo, String professorNo);

}
