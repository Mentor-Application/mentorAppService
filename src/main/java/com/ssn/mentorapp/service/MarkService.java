package com.ssn.mentorapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssn.mentorapp.model.Marks;
import com.ssn.mentorapp.payload.request.MarkRequest;
import com.ssn.mentorapp.payload.response.MarkResponse;
import com.ssn.mentorapp.repository.MarkRepository;

@Service
public class MarkService {

	@Autowired
	private MarkRepository markRepository;

	public Marks updateMark(MarkRequest markRequest) {
		
		Optional<Marks> mark = markRepository
				.findBySemesterNameAndStudentIdAndSubjectCode(markRequest.getSemesterName(),
						markRequest.getStudentId(), markRequest.getSubjectCode());

		if (!mark.isEmpty()) {
			mark.get().setFirstCatMark(markRequest.getFirstCatMark());
			mark.get().setSecondCatMark(markRequest.getSecondCatMark());
			mark.get().setThirdCatMark(markRequest.getThirdCatMark());
			mark.get().setInternalMark(markRequest.getInternalMark());
			mark.get().setSemesterName(markRequest.getSemesterName());
			mark.get().setStudentId(markRequest.getStudentId());
			mark.get().setSubjectCode(markRequest.getSubjectCode());
			mark.get().setSubjectName(markRequest.getSubjectName());
			return markRepository.save(mark.get());
		} else {
			Marks newMark = new Marks();
			newMark.setFirstCatMark(markRequest.getFirstCatMark());
			newMark.setSecondCatMark(markRequest.getSecondCatMark());
			newMark.setThirdCatMark(markRequest.getThirdCatMark());
			newMark.setInternalMark(markRequest.getInternalMark());
			newMark.setSemesterName(markRequest.getSemesterName());
			newMark.setStudentId(markRequest.getStudentId());
			newMark.setSubjectCode(markRequest.getSubjectCode());
			newMark.setSubjectName(markRequest.getSubjectName());
			return markRepository.save(newMark);
		}
	}

	public List<MarkResponse> getMarks(String studentId,String semesterName) {
		List<Marks> marks = markRepository.findAllByStudentIdAndSemesterName(studentId,semesterName);
		
		return convertToMarkResponse(marks);
	}

	public List<MarkResponse> convertToMarkResponse(List<Marks> marks) {
		List<MarkResponse> markResponses = new ArrayList<MarkResponse>();
		markResponses = marks.stream().map(m -> {
			MarkResponse markResponse = new MarkResponse();
			markResponse.setMarkId(m.getMarkId());
			markResponse.setFirstCatMark(m.getFirstCatMark());
			markResponse.setSecondCatMark(m.getSecondCatMark());
			markResponse.setThirdCatMark(m.getThirdCatMark());
			markResponse.setInternalMark(m.getInternalMark());
			markResponse.setStudentId(m.getStudentId());
			markResponse.setSemesterName(m.getSemesterName());
			markResponse.setSubjectCode(m.getSubjectCode());
			markResponse.setSubjectName(m.getSubjectName());
			return markResponse;
		}).collect(Collectors.toList());

		return markResponses;
	}

}
