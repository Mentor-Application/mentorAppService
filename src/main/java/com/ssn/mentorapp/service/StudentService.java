package com.ssn.mentorapp.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.ssn.mentorapp.model.Challenges;
import com.ssn.mentorapp.model.FamilyProfile;
import com.ssn.mentorapp.model.GoalsGrid;
import com.ssn.mentorapp.model.Hobbies;
import com.ssn.mentorapp.model.LocalGuardian;
import com.ssn.mentorapp.model.SchoolRecord;
import com.ssn.mentorapp.model.StrengthAssessment;
import com.ssn.mentorapp.model.Student;
import com.ssn.mentorapp.payload.request.ChallengesRequest;
import com.ssn.mentorapp.payload.request.FamilyProfileRequest;
import com.ssn.mentorapp.payload.request.GoalsGridRequest;
import com.ssn.mentorapp.payload.request.HobbiesRequest;
import com.ssn.mentorapp.payload.request.LocalGuardianRequest;
import com.ssn.mentorapp.payload.request.SchoolRecordRequest;
import com.ssn.mentorapp.payload.request.StrengthAssessmentRequest;
import com.ssn.mentorapp.payload.request.StudentDetailsRequest;
import com.ssn.mentorapp.payload.request.StudentSearchRequest;
import com.ssn.mentorapp.payload.response.StudentResponse;
import com.ssn.mentorapp.payload.response.StudentSearchResponse;
import com.ssn.mentorapp.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public Student updateStudentProfile(StudentDetailsRequest studentDetailsRequest) throws ParseException {
		Student newStudent = studentRepository.findByEmailId(studentDetailsRequest.getEmailId()).get();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
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
	
	
	
	
	public Student updateLocalGuardianDetails(LocalGuardianRequest localGuardianRequest) {
		Student newStudent = studentRepository.findById(localGuardianRequest.getStudentId()).get();
		LocalGuardian localGuardian = new LocalGuardian();
		localGuardian.setGuardianName(localGuardianRequest.getGuardianName());
		localGuardian.setMobileNumber(localGuardianRequest.getMobileNumber());
		localGuardian.setEmailId(localGuardianRequest.getEmailId());
		localGuardian.setAddress(localGuardianRequest.getAddress());
		
		newStudent.setStudentId(localGuardianRequest.getStudentId());
		newStudent.setLocalGuardian(localGuardian);
		
		return studentRepository.save(newStudent);
	}
	
	public Student updateschoolRecordDetails(List<SchoolRecordRequest> schoolRequest) {
		
		Student newStudent = studentRepository.findById(schoolRequest.get(0).getStudentId()).get();
		
		List<SchoolRecord> recordList = new ArrayList<SchoolRecord>();
		recordList = schoolRequest.stream().map(schoolReq ->{
				SchoolRecord schoolRecord = new SchoolRecord();
				schoolRecord.setCourse(schoolReq.getCourse());
				schoolRecord.setYearPassedOut(schoolReq.getYearPassedOut());
				schoolRecord.setNameOfSchool(schoolReq.getNameOfSchool());
				schoolRecord.setBoard(schoolReq.getBoard());
				schoolRecord.setTwelfthCutOff(schoolReq.getTwelfthCutOff());
				return schoolRecord;			
		}).collect(Collectors.toList());	
		newStudent.setSchoolRecord(recordList);	
		return studentRepository.save(newStudent);
	}
	
	public Student updatefamilyProfileDetails(List<FamilyProfileRequest> familyRequest) {
		
		Student newStudent = studentRepository.findById(familyRequest.get(0).getStudentId()).get();
		List<FamilyProfile> familyList = new ArrayList<FamilyProfile>();
		
		for (int i= 0;i<familyRequest.size();i++) {
			FamilyProfile familyProfile = new FamilyProfile();
			familyProfile.setRelationShip(familyRequest.get(i).getRelationShip());
			familyProfile.setAge(familyRequest.get(i).getAge());
			familyProfile.setEducationalQualification(familyRequest.get(i).getEducationalQualification());
			familyProfile.setOccupation(familyRequest.get(i).getOccupation());
			familyProfile.setAnnualIncome(familyRequest.get(i).getAnnualIncome());
			familyList.add(familyProfile);	
		}
		
		newStudent.setFamilyProfile(familyList);
		
		return studentRepository.save(newStudent);
	}
	
	public Student updatehobbies(List<HobbiesRequest> hobbiesRequest) {
		Student newStudent = studentRepository.findById(hobbiesRequest.get(0).getStudentId()).get();
		List<Hobbies> hobbieList = new ArrayList<Hobbies>();
		for (int i= 0;i<hobbiesRequest.size();i++) {
			Hobbies hobbies = new Hobbies();
			hobbies.setHobbie(hobbiesRequest.get(i).getHobbie());
			hobbieList.add(hobbies);
		}	
		newStudent.setHobbies(hobbieList);
		return studentRepository.save(newStudent);
	}
	
	public Student updatestrengthAssessment(StrengthAssessmentRequest strengthAssessmentRequest) {
		Student newStudent = studentRepository.findById(strengthAssessmentRequest.getStudentId()).get();
		StrengthAssessment strengthAssessment = new StrengthAssessment();
		strengthAssessment.setiAm(strengthAssessmentRequest.getiAm());
		strengthAssessment.setiCan(strengthAssessmentRequest.getiCan());
		strengthAssessment.setiHave(strengthAssessmentRequest.getiHave());
		
		newStudent.setStudentId(strengthAssessmentRequest.getStudentId());
		newStudent.setStrenghAssessment(strengthAssessment);
		
		return studentRepository.save(newStudent);
	}
	
	public Student updategoalsGrid(List<GoalsGridRequest> goalGridRequest) {
		Student newStudent = studentRepository.findById(goalGridRequest.get(0).getStudentId()).get();
		List<GoalsGrid> goalsList = new ArrayList<GoalsGrid>();
		
		for (int i= 0;i<goalGridRequest.size();i++) {
			GoalsGrid goalsGrid = new GoalsGrid();
			goalsGrid.setDomain(goalGridRequest.get(i).getDomain());
			goalsGrid.setGoal(goalGridRequest.get(i).getGoal());
			goalsGrid.setPlanOfAction(goalGridRequest.get(i).getPlanOfAction());
			goalsList.add(goalsGrid);
		}
		
		newStudent.setGoalsGrid(goalsList);
		
		return studentRepository.save(newStudent);
	}
	
	public Student updatechallenges(List<ChallengesRequest> challengesRequest) {
		Student newStudent = studentRepository.findById(challengesRequest.get(0).getStudentId()).get();
		List<Challenges> challengeList = new ArrayList<Challenges>();
		
		for (int i= 0;i<challengesRequest.size();i++){
			Challenges challenges  = new Challenges();
			challenges.setChallenges(challengesRequest.get(i).getChallenges());
			challenges.setDomain(challengesRequest.get(i).getDomain());
			challenges.setSourceOfSupport(challengesRequest.get(i).getSourceOfSupport());
			challengeList.add(challenges);
		}
		
		newStudent.setChallenges(challengeList);
		
		return studentRepository.save(newStudent);
	}

	
    public List<StudentResponse> getStudentByMentorId(String mentorId){
    	List<Student> existingStudents = studentRepository.findAllByMentorId(mentorId);
    	List<StudentResponse> studentResponse = convertToStudentResponse(existingStudents);
    	return  studentResponse;
 
    }
    
    public List<StudentSearchResponse> searchStudent(StudentSearchRequest studentSearchRequest){
//    	Query query = new Query();
//    	Pageable pageable = PageRequest.of(0, 1);
//    	query.with(pageable);
//    	query.addCriteria( new Criteria().orOperator(
//    			Criteria.where("section").is(studentSearchRequest.getSection()),
//    			Criteria.where("studentName").regex("^"+studentSearchRequest.getStudentName()),
//    			Criteria.where("registerNumber").is(studentSearchRequest.getRegisterNumber()),
//    			Criteria.where("branch").is(studentSearchRequest.getBranch()),
//    			Criteria.where("periodOfStudy").is(studentSearchRequest.getPeriodOfStudy())
//    			
//    			));
//    	List<Student> students = mongoTemplate.find(query, Student.class);
    	
    	
    	List<Student> students = studentRepository.findAllByStudentNameAndRegisterNumberAndBranchAndSectionAndPeriodOfStudy(
    			studentSearchRequest.getStudentName(), 
    			studentSearchRequest.getRegisterNumber(), 
    			studentSearchRequest.getBranch(),
    			studentSearchRequest.getSection(),
    			studentSearchRequest.getPeriodOfStudy());
    	
    	List<StudentSearchResponse> studentResponses = convertToStudentSearchResponse(students);
    	
    	return studentResponses;
    	
    }
	
    public List<StudentSearchResponse> convertToStudentSearchResponse(List<Student> studentList){
    	List<StudentSearchResponse> studentSearchResponses = new ArrayList<StudentSearchResponse>();
    	
    	studentSearchResponses = studentList.stream().map(st -> {
    		StudentSearchResponse studentSearchResponse = new StudentSearchResponse();
    		studentSearchResponse.setRegisterNumber(st.getRegisterNumber());
    		studentSearchResponse.setBranch(st.getBranch());
    		studentSearchResponse.setPeriodOfStudy(st.getPeriodOfStudy());
    		studentSearchResponse.setSection(st.getSection());
    		studentSearchResponse.setStudentName(st.getStudentName());
    		return studentSearchResponse;
    	}).collect(Collectors.toList());
    	
    	return studentSearchResponses;
    }
    
	public List<StudentResponse> convertToStudentResponse(List<Student> studentList){
		List<StudentResponse> studentResponses = new ArrayList<StudentResponse>();
		
		studentResponses = studentList.stream().map(student -> {
			StudentResponse studentResponse = new  StudentResponse();
			studentResponse.setStudentId(student.getStudentId());
			studentResponse.setStudentName(student.getStudentName());
			studentResponse.setRegisterNumber(student.getRegisterNumber());
			studentResponse.setGender(student.getGender());
			studentResponse.setBranch(student.getBranch());
			studentResponse.setSection(student.getSection());
//			studentResponse.setMobileNumber(student.getMobileNumber());
//			studentResponse.setFatherMobileNumber(student.getFatherMobileNumber());
//			studentResponse.setMotherMobileNumber(student.getMotherMobileNumber());
//			studentResponse.setReligion(student.getReligion());
//			studentResponse.setCommunity(student.getCommunity());
//			studentResponse.setBloodGroup(student.getBloodGroup());
//			studentResponse.setStudentType(student.getStudentType());
//			studentResponse.setAddressForCommunication(student.getAddressForCommunication());
//			studentResponse.setPeriodOfStudy(student.getPeriodOfStudy());
//			studentResponse.setPhoto(student.getPhoto());
//			studentResponse.setRoomNumber(student.getRoomNumber());
//			studentResponse.setBusRouteNumber(student.getBusRouteNumber());
//			studentResponse.setEmailId(student.getEmailId());
//			studentResponse.setLocalGuardian(student.getLocalGuardian());
//			studentResponse.setFamilyProfile(student.getFamilyProfile());
//			studentResponse.setSchoolRecord(student.getSchoolRecord());
//			studentResponse.setHobbies(student.getHobbies());
//			studentResponse.setStrenghAssessment(student.getStrenghAssessment());
//			studentResponse.setGoalsGrid(student.getGoalsGrid());
//			studentResponse.setChallenges(student.getChallenges());
			return studentResponse;
		}).collect(Collectors.toList());
				
				
		return studentResponses;	
		
	}
}













