package com.example.demo.reply.model;

import com.example.demo.board.model.Board;
import com.example.demo.board.model.BoardDto;
import lombok.Builder;
import lombok.Getter;

public class ReplyDto {
    public static class ReplyregDto{
        private String contents;

        public Reply toEntity(){
            return Reply.builder()
                    .contents(this.contents)
                    .build();
        }

    }
    @Getter
    @Builder
    public static class ReplyresDto{
        private Long idx;
        private String contents;
        private String writer;
        private String posttitle;

        public static ReplyresDto from(Reply entity){
            return ReplyresDto.builder()
                    .idx(entity.getIdx())
                    .contents(entity.getContents())
                    .writer(entity.getUser().getName())
                    .posttitle(entity.getBoard().getTitle())
                    .build();
        }
    }
    @Builder
    @Getter
    public static class ListRes {
        private Long idx;
        private String contents;
        private String writer;
        private String title;

        public static ReplyDto.ListRes from(Reply entity) {
            return ListRes.builder()
                    .idx(entity.getIdx())
                    .contents(entity.getContents())
                    .writer(entity.getUser().getName())
                    .title(entity.getBoard().getTitle())
                    .build();
        }
    }
}
