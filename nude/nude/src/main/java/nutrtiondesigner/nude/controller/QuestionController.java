package nutrtiondesigner.nude.controller;

import lombok.RequiredArgsConstructor;
import nutrtiondesigner.nude.model.dto.*;
import nutrtiondesigner.nude.service.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/questions")
public class QuestionController {

    private final QuestionService questionService;

    @PostMapping
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity insertQuestion(@RequestBody QuestionInsertDto questionInsertDto) {
        questionService.insertQuestion(questionInsertDto);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity getQuestionList() {
        List<QuestionsDto> questions = questionService.getQuestionList();

        return new ResponseEntity(questions, HttpStatus.OK);
    }

    @GetMapping("/{code}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity getAnswerList(@PathVariable("code") Long questionCode) {
        List<AnswerDto> answers = questionService.getAnswers(questionCode);

        return new ResponseEntity<>(answers, HttpStatus.OK);
    }

    @PostMapping("/{code}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity insertAnswer(@PathVariable("code") Long questionCode, @RequestBody InsertAnswerDto insertAnswerDto) {
        questionService.insertAnswer(questionCode, insertAnswerDto);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
