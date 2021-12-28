package com.ssn.mentorapp;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ssn.mentorapp.controller.AuthController;
import com.ssn.mentorapp.model.Role;
import com.ssn.mentorapp.payload.request.SignUpRequest;

@SpringBootApplication
public class MentorappApplication implements CommandLineRunner {

	public static final String SAMPLE_XLSX_FILE_PATH = "C:\\projects\\mentorApplication\\src\\main\\resources\\mentorlogin.xlsx";

	public static void main(String[] args) {
		SpringApplication.run(MentorappApplication.class, args);
	}
	
	@Autowired
	private AuthController authController;
	
	

	@Override
	public void run(String... args) throws Exception {
//		Workbook workbook = WorkbookFactory.create(new File(SAMPLE_XLSX_FILE_PATH));
//		Sheet sheet = workbook.getSheetAt(0);
//		DataFormatter dataFormatter = new DataFormatter();
//		Iterator<Row> rowIterator = sheet.rowIterator();
//		List<SignUpRequest> mentors = new ArrayList<SignUpRequest>();
//		Set<String> mentorRole = new HashSet<String>();
//		mentorRole.add("mentor");
//		while (rowIterator.hasNext()) {
//			Row row = rowIterator.next();
//
//			Iterator<Cell> cellIterator = row.cellIterator();
//			SignUpRequest newMentor = new SignUpRequest();
//			while (cellIterator.hasNext()) {
//				Cell cell = cellIterator.next();
//				String cellValue = dataFormatter.formatCellValue(cell);
//				if(newMentor.getUserName() == null) {
//					newMentor.setUserName(cellValue);
//				}
//				else if(newMentor.getEmail() == null) {
//					newMentor.setEmail(cellValue);
//				}
//				else {
//					newMentor.setPassword(cellValue);
//				}
//				newMentor.setRoles(mentorRole);
//				
//			}
//			authController.signUpUser(newMentor);
//		}
//
	}

}
