package com.ssn.mentorapp.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
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
import com.ssn.mentorapp.payload.request.StudentSearchRequest;
import com.ssn.mentorapp.payload.response.StudentResponse;
import com.ssn.mentorapp.payload.response.StudentSearchResponse;
import com.ssn.mentorapp.repository.ParentRepository;
import com.ssn.mentorapp.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	

	@Autowired
	private ParentRepository parentRepository;
	
	@Autowired
	private MongoTemplate mongoTemplate;

	
	public Student updateStudentProfile(StudentDetailsRequest studentDetailsRequest) throws ParseException {
		Student newStudent = studentRepository.findById(studentDetailsRequest.getStudentId()).get();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		newStudent.setStudentName(studentDetailsRequest.getStudentName());
		newStudent.setRegisterNumber(studentDetailsRequest.getRegisterNumber());
		newStudent.setGender(studentDetailsRequest.getGender());
		newStudent.setDob(LocalDate.parse(studentDetailsRequest.getDob()));
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
		newStudent.setPersonalEmail(studentDetailsRequest.getPersonalEmail());	
		return studentRepository.save(newStudent);
	}
	
	
	public Student updateParentProfile(ParentDetailRequest parentDetailRequest) {
		Student newStudent = studentRepository.findById(parentDetailRequest.getStudentId()).get();
		Parent parent = new Parent();
		parent.setParentAddress(parentDetailRequest.getParentAddress());
		parent.setParentEmailId(parentDetailRequest.getParentEmailId());
		parent.setParentName(parentDetailRequest.getParentName());
		
		newStudent.setParent(parent);
		
		return studentRepository.save(newStudent);
	}
	
	public Student updateLocalGuardianDetails(LocalGuardianRequest localGuardianRequest,String studentId) {
		Student newStudent = studentRepository.findById(studentId).get();
		LocalGuardian localGuardian = new LocalGuardian();
		localGuardian.setGuardianName(localGuardianRequest.getGuardianName());
		localGuardian.setMobileNumber(localGuardianRequest.getMobileNumber());
		localGuardian.setEmailId(localGuardianRequest.getEmailId());
		localGuardian.setAddress(localGuardianRequest.getAddress());
		newStudent.setLocalGuardian(localGuardian);
		
		return studentRepository.save(newStudent);
	}
	
	public Student updateschoolRecordDetails(List<SchoolRecordRequest> schoolRequest,String studentId) {
		
		Student newStudent = studentRepository.findById(studentId).get();
		
		List<SchoolRecord> recordList = new ArrayList<SchoolRecord>();
		recordList = schoolRequest.stream().map(schoolReq ->{
				SchoolRecord schoolRecord = new SchoolRecord();
				schoolRecord.setCourse(schoolReq.getCourse());
				schoolRecord.setYearPassedOut(schoolReq.getYearPassedOut());
				schoolRecord.setNameOfSchool(schoolReq.getNameOfSchool());
				schoolRecord.setBoard(schoolReq.getBoard());
				schoolRecord.setPercentage(schoolReq.getPercentage());
				schoolRecord.setTwelfthCutOff(schoolReq.getTwelfthCutOff());
				return schoolRecord;			
		}).collect(Collectors.toList());	
		newStudent.setSchoolRecord(recordList);	
		return studentRepository.save(newStudent);
	}
	
	public Student updatefamilyProfileDetails(List<FamilyProfileRequest> familyRequest,String studentId) {
		
		Student newStudent = studentRepository.findById(studentId).get();
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
	
	public Student updatehobbies(List<HobbiesRequest> hobbiesRequest,String studentId) {
		Student newStudent = studentRepository.findById(studentId).get();
		List<Hobbies> hobbieList = new ArrayList<Hobbies>();
		for (int i= 0;i<hobbiesRequest.size();i++) {
			Hobbies hobbies = new Hobbies();
			hobbies.setHobbie(hobbiesRequest.get(i).getHobbie());
			hobbieList.add(hobbies);
		}	
		newStudent.setHobbies(hobbieList);
		return studentRepository.save(newStudent);
	}
	
	public Student updatestrengthAssessment(StrengthAssessmentRequest strengthAssessmentRequest,String studentId) {
		Student newStudent = studentRepository.findById(studentId).get();
		StrengthAssessment strengthAssessment = new StrengthAssessment();
		strengthAssessment.setiAm(strengthAssessmentRequest.getiAm());
		strengthAssessment.setiCan(strengthAssessmentRequest.getiCan());
		strengthAssessment.setiHave(strengthAssessmentRequest.getiHave());
		
		newStudent.setStrenghAssessment(strengthAssessment);
		
		return studentRepository.save(newStudent);
	}
	
	public Student updategoalsGrid(List<GoalsGridRequest> goalGridRequest,String studentId) {
		Student newStudent = studentRepository.findById(studentId).get();
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
	
	public Student updatechallenges(List<ChallengesRequest> challengesRequest,String studentId) {
		Student newStudent = studentRepository.findById(studentId).get();
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
    
    public List<StudentSearchResponse> searchStudent(StudentSearchRequest studentSearchRequest,int from, int size){
    	    	
    	Page<Student> students = studentRepository.findAllByStudentNameAndBranchAndSectionAndPeriodOfStudy(
    			PageRequest.of(from, size),
    			studentSearchRequest.getStudentName(), 
    			studentSearchRequest.getBranch(),
    			studentSearchRequest.getSection(),
    			studentSearchRequest.getPeriodOfStudy());
    	List<Student> studentList = new ArrayList<Student>();
    	Iterator iter = students.iterator();
    	while(iter.hasNext()) {
    		Student pageStudent = (Student)iter.next();
    		if(pageStudent.getMentorId() == null) {
    			studentList.add(pageStudent);
    		}
    	}
    	List<StudentSearchResponse> studentResponses = convertToStudentSearchResponse(studentList);
    	
    	return studentResponses;
    	
    }
    
    public List<StudentSearchResponse> searchStudentForFaculty(StudentSearchRequest studentSearchRequest,int from, int size){
    	
    	Page<Student> students = studentRepository.findAllByStudentNameAndBranchAndSectionAndPeriodOfStudy(
    			PageRequest.of(from, size),
    			studentSearchRequest.getStudentName(), 
    			studentSearchRequest.getBranch(),
    			studentSearchRequest.getSection(),
    			studentSearchRequest.getPeriodOfStudy());
    	
    	List<StudentSearchResponse> studentResponses = convertToStudentSearchResponse(students.toList());
    	
    	return studentResponses;
    	
    }
    
	
    public List<StudentSearchResponse> convertToStudentSearchResponse(List<Student> studentList){
    	List<StudentSearchResponse> studentSearchResponses = new ArrayList<StudentSearchResponse>();
    	
    	studentSearchResponses = studentList.stream().map(st -> {
    		StudentSearchResponse studentSearchResponse = new StudentSearchResponse();
    		studentSearchResponse.setStudentId(st.getStudentId());
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
	
	public void setMentorIdforStudents(List<StudentSearchRequest> studentSearchRequest,String mentorId){
    	
    	for(int i=0;i<studentSearchRequest.size();i++)
    	{
    	Student newStudent = studentRepository.findById(studentSearchRequest.get(i).getStudentId()).get();
    	newStudent.setMentorId(mentorId);
    	studentRepository.save(newStudent);
    	}	

    }

	public void setMentorIdNullforStudents(List<StudentSearchRequest> studentSearchRequest){
    	
    	for(int i=0;i<studentSearchRequest.size();i++)
    	{
    	Student newStudent = studentRepository.findById(studentSearchRequest.get(i).getStudentId()).get();
    	newStudent.setMentorId(null);
    	studentRepository.save(newStudent);
    	}	

    }
	
}













