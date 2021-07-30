package nutrtiondesigner.nude.service;

import lombok.RequiredArgsConstructor;
import nutrtiondesigner.nude.model.domain.Notice;
import nutrtiondesigner.nude.model.dto.board.InsertNoticeDto;
import nutrtiondesigner.nude.model.dto.board.NoticeDto;
import nutrtiondesigner.nude.repository.NoticeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class NoticeService {

    private final NoticeRepository noticeRepository;

    @Transactional
    public void insertNotice(InsertNoticeDto insertNoticeDto) {
        Notice notice = insertNoticeDto.toEntity();
        noticeRepository.save(notice);
    }

    public List<NoticeDto> getNotices() {
        PageRequest pageRequest = PageRequest.of(0, 8, Sort.by(Sort.Direction.DESC, "createdDate"));
        Page<Notice> noticePage = noticeRepository.findAll(pageRequest);
        Page<NoticeDto> noticeDtoPage = noticePage.map(n -> new NoticeDto(n));

        return noticeDtoPage.getContent();
    }

    @Transactional
    public NoticeDto getNoticeDetail(Long noticeCode) {
        Notice notice = noticeRepository.findById(noticeCode).get();
        notice.upViewCount();
        NoticeDto noticeDto = new NoticeDto(notice);
        noticeDto.setContents(notice.getContents());

        return noticeDto;
    }
}
