package nutrtiondesigner.nude.repository;

import nutrtiondesigner.nude.model.domain.Answer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
    Page<Answer> findAllByQuestions_Code(Long code, Pageable pageable);
}
