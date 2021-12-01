package com.ssn.mentorapp.service;

import java.util.ArrayList;
import java.util.List;
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
		Marks mark = markRepository
				.findBySemesterNameAndStudentIdAndSubjectCodeAndExamType(markRequest.getSemesterName(),
						markRequest.getStudentId(), markRequest.getSubjectCode(), markRequest.getExamType())
				.get();

		if (mark != null) {
			mark.setExamType(markRequest.getExamType());
			mark.setMark(markRequest.getMark());
			mark.setSemesterName(markRequest.getSemesterName());
			mark.setStudentId(markRequest.getStudentId());
			mark.setSubjectCode(markRequest.getSubjectCode());
			mark.setSubjectName(markRequest.getSubjectName());
			return markRepository.save(mark);
		} else {
			Marks newMark = new Marks();
			newMark.setExamType(markRequest.getExamType());
			newMark.setMark(markRequest.getMark());
			newMark.setSemesterName(markRequest.getSemesterName());
			newMark.setStudentId(markRequest.getStudentId());
			newMark.setSubjectCode(markRequest.getSubjectCode());
			newMark.setSubjectName(markRequest.getSubjectName());
			return markRepository.save(newMark);
		}
	}

	public List<MarkResponse> getMarks(List<MarkRequest> markRequests) {
		List<Marks> marks = new ArrayList<Marks>();
		for (int i = 0; i < markRequests.size(); i++) {
			marks.add(markRepository.findBySemesterNameAndStudentIdAndSubjectCodeAndExamType(
					markRequests.get(i).getSemesterName(), markRequests.get(i).getStudentId(),
					markRequests.get(i).getSubjectCode(), markRequests.get(i).getExamType()).get());
		}
		return convertToMarkResponse(marks);
	}

	public List<MarkResponse> convertToMarkResponse(List<Marks> marks) {
		List<MarkResponse> markResponses = new ArrayList<MarkResponse>();
		markResponses = marks.stream().map(m -> {
			MarkResponse markResponse = new MarkResponse();
			markResponse.setMarkId(m.getMarkId());
			markResponse.setMark(m.getMark());
			markResponse.setStudentId(m.getStudentId());
			markResponse.setSemesterName(m.getSemesterName());
			markResponse.setSubjectCode(m.getSubjectCode());
			markResponse.setSubjectName(m.getSubjectName());
			return markResponse;
		}).collect(Collectors.toList());

		return markResponses;
	}

}
