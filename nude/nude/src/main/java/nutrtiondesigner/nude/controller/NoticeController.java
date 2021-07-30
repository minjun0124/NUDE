package nutrtiondesigner.nude.controller;

import lombok.RequiredArgsConstructor;
import nutrtiondesigner.nude.model.dto.board.InsertNoticeDto;
import nutrtiondesigner.nude.model.dto.board.NoticeDto;
import nutrtiondesigner.nude.service.NoticeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notices")
public class NoticeController {

    private final NoticeService noticeService;

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity insertNotice(@RequestBody InsertNoticeDto insertNoticeDto) {
        noticeService.insertNotice(insertNoticeDto);

        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity getNotices() {
        List<NoticeDto> noticeList = noticeService.getNotices();

        return new ResponseEntity(noticeList, HttpStatus.OK);
    }

    @GetMapping("/{noticeCode}")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity getNoticeDetail(@PathVariable Long noticeCode) {
        NoticeDto noticeDetail = noticeService.getNoticeDetail(noticeCode);

        return new ResponseEntity(noticeDetail, HttpStatus.OK);
    }
}
