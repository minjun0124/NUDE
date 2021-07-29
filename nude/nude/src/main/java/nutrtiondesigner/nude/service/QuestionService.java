package nutrtiondesigner.nude.service;

import lombok.RequiredArgsConstructor;
import nutrtiondesigner.nude.model.domain.Answer;
import nutrtiondesigner.nude.model.domain.Question;
import nutrtiondesigner.nude.model.domain.User;
import nutrtiondesigner.nude.model.dto.*;
import nutrtiondesigner.nude.repository.AnswerRepository;
import nutrtiondesigner.nude.repository.QuestionRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;
    private final UserService userService;

    @Transactional
    public void insertQuestion(QuestionInsertDto questionInsertDto) {
        User user = userService.getMyUserWithAuthorities().orElse(null);
        Question question = questionInsertDto.toEntity(user);
        questionRepository.save(question);
    }

    public List<QuestionsDto> getQuestionList() {
        User user = userService.getMyUserWithAuthorities().orElse(null);
        //TODO: Sort by created date
        PageRequest pageRequest = PageRequest.of(0, 7);
        Page<Question> questionPage = questionRepository.findAllByUserId(user.getId(), pageRequest);
        Page<QuestionsDto> questionsDtos = questionPage.map(q -> new QuestionsDto(q));

        return questionsDtos.getContent();
    }

    @Transactional
    public void insertAnswer(Long questionCode, InsertAnswerDto insertAnswerDto) {
        Question question = questionRepository.findById(questionCode).orElse(null);
        Answer answer = insertAnswerDto.toEntity(question);

        answerRepository.save(answer);
    }

    public List<AnswerDto> getAnswers(Long questionCode) {
        PageRequest pageRequest = PageRequest.of(0, 7);
        Page<Answer> answers = answerRepository.findAllByQuestions_Code(questionCode, pageRequest);
        Page<AnswerDto> answerDtos = answers.map(a -> new AnswerDto(a));

        return answerDtos.getContent();
    }
}
