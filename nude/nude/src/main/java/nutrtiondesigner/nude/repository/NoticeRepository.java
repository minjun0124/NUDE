package nutrtiondesigner.nude.repository;

import nutrtiondesigner.nude.model.domain.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<Notice, Long> {
}
