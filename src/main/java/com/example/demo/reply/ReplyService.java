package com.example.demo.reply;

import com.example.demo.reply.model.Reply;
import com.example.demo.reply.model.ReplyDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReplyService {
    private final ReplyRepository replyRepository;
    public ReplyDto.ReplyresDto register(ReplyDto.ReplyregDto dto) {
        Reply entity = replyRepository.save(dto.toEntity());

        return ReplyDto.ReplyresDto.from(entity);
    }
}
