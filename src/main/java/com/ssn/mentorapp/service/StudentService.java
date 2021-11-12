package com.ssn.mentorapp.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssn.mentorapp.model.Challenges;
import com.ssn.mentorapp.model.FamilyProfile;
import com.ssn.mentorapp.model.GoalsGrid;
import com.ssn.mentorapp.model.Hobbies;
import com.ssn.mentorapp.model.LocalGuardian;
import com.ssn.mentorapp.model.Parent;
import com.ssn.mentorapp.model.SchoolRecord;
import com.ssn.mentorapp.model.StrengthAssessment;
import com.ssn.mentorapp.model.Student;
import com.ssn.mentorapp.payload.request.ChallengesRequest;
import com.ssn.mentorapp.payload.request.FamilyProfileRequest;
import com.ssn.mentorapp.payload.request.GoalsGridRequest;
import com.ssn.mentorapp.payload.request.HobbiesRequest;
import com.ssn.mentorapp.payload.request.LocalGuardianRequest;
import com.ssn.mentorapp.payload.request.ParentDetailRequest;
import com.ssn.mentorapp.payload.request.SchoolRecordRequest;
import com.ssn.mentorapp.payload.request.StrengthAssessmentRequest;
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
	
	public Student updateschoolRecordDetails(SchoolRecordRequest schoolRequest) {
		Student newStudent = studentRepository.findById(schoolRequest.getStudentId()).get();
		SchoolRecord schoolRecord = new SchoolRecord();
		schoolRecord.setSchoolRecordId(schoolRequest.getSchoolRecordId());
		schoolRecord.setCourse(schoolRequest.getCourse());
		schoolRecord.setYearPassedOut(schoolRequest.getYearPassedOut());
		schoolRecord.setNameOfSchool(schoolRequest.getNameOfSchool());
		schoolRecord.setBoard(schoolRequest.getBoard());
		
		newStudent.setStudentId(schoolRequest.getStudentId());
		newStudent.setSchoolRecord(schoolRecord);
		
		return studentRepository.save(newStudent);
	}
	
	public Student updatefamilyProfileDetails(FamilyProfileRequest familyRequest) {
		Student newStudent = studentRepository.findById(familyRequest.getStudentId()).get();
		FamilyProfile familyProfile = new FamilyProfile();
		familyProfile.setFamilyProfileId(familyRequest.getFamilyProfileId());
		familyProfile.setRelationShip(familyRequest.getRelationShip());
		familyProfile.setAge(familyRequest.getAge());
		familyProfile.setEducationalQualification(familyRequest.getEducationalQualification());
		familyProfile.setOccupation(familyRequest.getOccupation());
		familyProfile.setAnnualIncome(familyRequest.getAnnualIncome());
		
		newStudent.setStudentId(familyRequest.getStudentId());
		newStudent.setFamilyProfile(familyProfile);
		
		return studentRepository.save(newStudent);
	}
	
	public Student updatehobbies(HobbiesRequest hobbiesRequest) {
		Student newStudent = studentRepository.findById(hobbiesRequest.getStudentId()).get();
		Hobbies hobbies = new Hobbies();
		hobbies.setHobbieId(hobbiesRequest.getHobbieId());
		hobbies.setHobbie(hobbiesRequest.getHobbie());
		
		newStudent.setStudentId(hobbiesRequest.getStudentId());
		newStudent.setHobbies(hobbies);
		
		return studentRepository.save(newStudent);
	}
	
	public Student updatestrengthAssessment(StrengthAssessmentRequest strengthAssessmentRequest) {
		Student newStudent = studentRepository.findById(strengthAssessmentRequest.getStudentId()).get();
		StrengthAssessment strengthAssessment = new StrengthAssessment();
		strengthAssessment.setStrengthAssesmentId(strengthAssessmentRequest.getStrengthAssesmentId());
		strengthAssessment.setiAm(strengthAssessmentRequest.getiAm());
		strengthAssessment.setiCan(strengthAssessmentRequest.getiCan());
		strengthAssessment.setiHave(strengthAssessmentRequest.getiHave());
		
		newStudent.setStudentId(strengthAssessmentRequest.getStudentId());
		newStudent.setStrenghAssessment(strengthAssessment);
		
		return studentRepository.save(newStudent);
	}
	
	public Student updategoalsGrid(GoalsGridRequest goalGridRequest) {
		Student newStudent = studentRepository.findById(goalGridRequest.getStudentId()).get();
		GoalsGrid goalsGrid = new GoalsGrid();
		goalsGrid.setGoalId(goalGridRequest.getGoalId());
		goalsGrid.setDomain(goalGridRequest.getDomain());
		goalsGrid.setGoal(goalGridRequest.getGoal());
		goalsGrid.setPlanOfAction(goalGridRequest.getPlanOfAction());
		
		newStudent.setStudentId(goalGridRequest.getStudentId());
		newStudent.setGoalsGrid(goalsGrid);
		
		return studentRepository.save(newStudent);
	}
	
	public Student updatechallenges(ChallengesRequest challengesRequest) {
		Student newStudent = studentRepository.findById(challengesRequest.getStudentId()).get();
		Challenges challenges  = new Challenges();
		challenges.setChallengeId(challengesRequest.getChallengeId());
		challenges.setChallenges(challengesRequest.getChallenges());
		challenges.setDomain(challengesRequest.getDomain());
		challenges.setSourceOfSupport(challengesRequest.getSourceOfSupport());
		
		newStudent.setStudentId(challengesRequest.getStudentId());
		newStudent.setChallenges(challenges);
		
		return studentRepository.save(newStudent);
	}

}
