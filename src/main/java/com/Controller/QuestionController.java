package com.Controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.entity.Answer;
import com.entity.Question;
import com.java.spring.service.AnswerService;
import com.java.spring.service.QuestionService;
@ComponentScan(basePackages = "com.java.spring.service")
@ComponentScan(basePackages = "com.entity")
@ComponentScan(basePackages = "com.java.spring.service.questionService")
@RestController
@RequestMapping(value={"/question"})
public class QuestionController {

	@Autowired
	private QuestionService questionService;
	@Autowired 
	private AnswerService  answerService;

	List<Answer> answers=null;

	@PostMapping(value="/create",headers="Accept=application/json")
	public ResponseEntity<String> creatQuestion(@RequestBody Question question,UriComponentsBuilder ucBuilder){
		List<Answer> answers=question.getAnswers();
		if(null!=answers) {
			for(Answer answer:answers) {
				answerService.addAnswer(answer);	
			}			
		}
		questionService.createQuestion(question);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/question/{id}").buildAndExpand(question.getId()).toUri());
		return new ResponseEntity<String>(headers,HttpStatus.CREATED);
	}


	@GetMapping(value="/Q/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Question> getQuestionById(@PathVariable("id") int id) {
		Question question=questionService.findById(id);
		if(null==question) {
			Logger.getLogger("nothing found...."+question);
			return new ResponseEntity<Question>(HttpStatus.NOT_FOUND);
		}
		int qId=question.getId();
		String qName=question.getqName();
		Question q=new Question();
		q.setId(qId);
		q.setqName(qName);
		return new ResponseEntity<Question>(q,HttpStatus.OK);
	}
	
	@GetMapping(value="/A/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Answer> getAnswerById(@PathVariable("id") int id) {
		Answer answer=answerService.findById(id);
		if(null==answer) {
			Logger.getLogger("nothing found...."+answer);
			return new ResponseEntity<Answer>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Answer>(answer,HttpStatus.OK);
	}

	@GetMapping(value="/getQuestions", headers="Accept=application/json")
	public List<Question> getQuestions(){
		List<Question> questions=questionService.getQuestion();
		return questions;
	}

	@GetMapping(value="/getAnswers", headers="Accept=application/json")
	public List<Answer> getAnswers(){
		List<Answer> answers=answerService.getAnswers();
		return answers;
	}
	
	@PutMapping(value="/updateQuestion",headers="Accept=application/json")
	public ResponseEntity<Question> updateQuestion(@RequestBody Question question){
		Question qstion=questionService.findById(question.getId());
		if(null==qstion) {
			return new ResponseEntity<Question>(HttpStatus.NOT_FOUND);
		}
		Question updatedQuestion=questionService.update(question,question.getId());
		return new ResponseEntity<Question>(updatedQuestion,HttpStatus.OK);
		
	}
	
	@PutMapping(value="/updateAnswer",headers="Accept=application/json")
	public ResponseEntity<Answer> updateAnswer(@RequestBody Answer answer){
		Answer ans=answerService.findById(answer.getId());
		if(null==ans) {
			return new ResponseEntity<Answer>(HttpStatus.NOT_FOUND);
		}
		Answer updatedAnswer=answerService.update(ans,answer.getId());
		return new ResponseEntity<Answer>(updatedAnswer,HttpStatus.OK);
		
	}
	
}
