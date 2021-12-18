package com.ssn.mentorapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssn.mentorapp.model.Disciplinary;
import com.ssn.mentorapp.model.Overall;
import com.ssn.mentorapp.payload.request.DisciplinaryRequest;
import com.ssn.mentorapp.payload.request.OverallRequest;
import com.ssn.mentorapp.service.DisciplinaryService;
import com.ssn.mentorapp.service.OverallService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/overall")
public class OverallController {
	
	@Autowired
	private OverallService overallService;
	
	@PostMapping("/update")
	public ResponseEntity<?> setYearDetails(@RequestBody OverallRequest overallRequest)
	{
		
		Overall overall = overallService.updateYearDetails(overallRequest);
		return ResponseEntity.ok(overall);
	}
	@GetMapping("/{studentId}/list")
	public ResponseEntity<?> getYearDetails(@PathVariable("studentId")String studentId)
	{
		Overall overall=overallService.getYearDetails(studentId);
		return ResponseEntity.ok(overall);
	}
}
