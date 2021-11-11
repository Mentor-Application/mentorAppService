package com.ssn.mentorapp.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssn.mentorapp.model.LocalGuardian;
import com.ssn.mentorapp.model.Parent;
import com.ssn.mentorapp.model.Student;
import com.ssn.mentorapp.payload.request.LocalGuardianRequest;
import com.ssn.mentorapp.payload.request.ParentDetailRequest;
import com.ssn.mentorapp.payload.request.StudentDetailsRequest;
import com.ssn.mentorapp.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	
	public Student updateStudentProfile(StudentDetailsRequest studentDetailsRequest) throws ParseException {
		Student newStudent = new Student();
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		newStudent.setStudentId(studentDetailsRequest.getStudentId());
		newStudent.setStudentName(studentDetailsRequest.getStudentName());
		newStudent.setRegisterNumber(studentDetailsRequest.getRegisterNumber());
		newStudent.setGender(studentDetailsRequest.getGender());
		newStudent.setDob(format.parse(studentDetailsRequest.getDob()));
		newStudent.setBranch(studentDetailsRequest.getBranch());
		newStudent.setSection(studentDetailsRequest.getSection());
		newStudent.setMobileNumber(studentDetailsRequest.getMobileNumber());
		newStudent.setFatherMobileNumber(studentDetailsRequest.getFatherMobileNumber());
		newStudent.setMotherMobileNumber(studentDetailsRequest.getMotherMobileNumber());
		newStudent.setReligion(studentDetailsRequest.getReligion());
		newStudent.setCommunity(studentDetailsRequest.getCommunity());
		newStudent.setBloodGroup(studentDetailsRequest.getBloodGroup());
		newStudent.setStudentType(studentDetailsRequest.getStudentType());
		newStudent.setAddressForCommunication(studentDetailsRequest.getAddressForCommunication());
		newStudent.setPeriodOfStudy(studentDetailsRequest.getPeriodOfStudy());
		newStudent.setPhoto(studentDetailsRequest.getPhoto());
		newStudent.setRoomNumber(studentDetailsRequest.getRoomNumber());
		newStudent.setBusRouteNumber(studentDetailsRequest.getBusRouteNumber());
		newStudent.setEmailId(studentDetailsRequest.getEmailId());
		
		return studentRepository.save(newStudent);
	}
	
	
	public Student updateParentDetails(ParentDetailRequest parentDetailRequest) {

		Student newStudent = studentRepository.findById(parentDetailRequest.getStudentId()).get();
		Parent parent = new Parent();
		parent.setParentId(parentDetailRequest.getParentId());
		parent.setParentName(parentDetailRequest.getParentName());
		parent.setAddress(parentDetailRequest.getAddress());
		parent.setEmailId(parentDetailRequest.getEmailId());
		
		newStudent.setStudentId(parentDetailRequest.getStudentId());
		newStudent.setParent(parent);
		
		return studentRepository.save(newStudent);
	}
	
	
	public Student updateLocalGuardianDetails(LocalGuardianRequest localGuardianRequest) {
		Student newStudent = studentRepository.findById(localGuardianRequest.getStudentId()).get();
		LocalGuardian localGuardian = new LocalGuardian();
		localGuardian.setGuardianId(localGuardianRequest.getGuardianId());
		localGuardian.setGuardianName(localGuardianRequest.getGuardianName());
		localGuardian.setMobileNumber(localGuardianRequest.getMobileNumber());
		localGuardian.setEmailId(localGuardianRequest.getEmailId());
		localGuardian.setAddress(localGuardianRequest.getAddress());
		
		newStudent.setStudentId(localGuardianRequest.getStudentId());
		newStudent.setLocalGuardian(localGuardian);
		
		return studentRepository.save(newStudent);
	}

}
