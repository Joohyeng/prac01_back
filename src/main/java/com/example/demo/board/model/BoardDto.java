package com.example.demo.board.model;

import com.example.demo.reply.model.ReplyDto;
import com.example.demo.user.model.User;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;

public class BoardDto {
    @Getter
    @Schema(description = "제목, 제목은 50글자까지만 입력 가능합니다.", required = true, example = "제목01")
    public static class RegReq {
        private String title;
        private String contents;

        public Board toEntity() {
            return Board.builder()
                    .title(this.title)
                    .contents(this.contents)
                    .build();
        }
    }

    @Builder
    @Getter
    public static class RegRes {
        private Long idx;
        private String title;
        private String contents;

        public static RegRes from(Board entity) {
            return RegRes.builder()
                    .idx(entity.getIdx())
                    .title(entity.getTitle())
                    .contents(entity.getContents())
                    .build();
        }
    }

    @Builder
    @Getter
    public static class ListRes {
        private Long idx;
        private String title;
        private String writer;
        private int replyCount;
        private int likesCount;

        public static ListRes from(Board entity) {
            return ListRes.builder()
                    .idx(entity.getIdx())
                    .title(entity.getTitle())
                    .writer(entity.getUser().getName())
                    .replyCount(entity.getRlist().size())
                    .likesCount(entity.getLikesList().size())
                    .build();
        }
    }

    @Builder
    @Getter
    public static class ReadRes {
        private Long idx;
        private String title;
        private String contents;
        private String writer;
        private List<ReplyDto.ReplyresDto> replyList;
        private int likesCount;
        public static ReadRes from(Board entity) {
            return ReadRes.builder()
                    .idx(entity.getIdx())
                    .title(entity.getTitle())
                    .contents(entity.getContents())
                    .writer(entity.getUser().getName())
                    .replyList(entity.getRlist().stream()
                            .map(ReplyDto.ReplyresDto::from).toList())
                    .likesCount(entity.getLikesList().size())
                    .build();
        }
    }
}
