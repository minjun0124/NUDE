package nutrtiondesigner.nude.repository;

import nutrtiondesigner.nude.model.domain.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    Page<Question> findAllByUserId(Long id, Pageable pageable);
}
