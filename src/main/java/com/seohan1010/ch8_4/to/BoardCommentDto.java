package com.seohan1010.ch8_4.to;

import java.time.LocalDate;
import java.util.Objects;

public class BoardCommentDto {

   private Long cno;
   private Long pcno;
   private String commenter;
   private String comment;
   private LocalDate registerDate;


    public BoardCommentDto() {
    }

    @Override
    public String toString() {
        return "BoardCommentDto{" +
                "cno=" + cno +
                ", pcno=" + pcno +
                ", commenter='" + commenter + '\'' +
                ", comment='" + comment + '\'' +
                ", registerDate=" + registerDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardCommentDto that = (BoardCommentDto) o;
        return Objects.equals(cno, that.cno) && Objects.equals(pcno, that.pcno) && Objects.equals(commenter, that.commenter) && Objects.equals(comment, that.comment) && Objects.equals(registerDate, that.registerDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cno, pcno, commenter, comment, registerDate);
    }

    public Long getCno() {
        return cno;
    }

    public void setCno(Long cno) {
        this.cno = cno;
    }

    public Long getPcno() {
        return pcno;
    }

    public void setPcno(Long pcno) {
        this.pcno = pcno;
    }

    public String getCommenter() {
        return commenter;
    }

    public void setCommenter(String commenter) {
        this.commenter = commenter;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDate getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDate registerDate) {
        this.registerDate = registerDate;
    }
}
