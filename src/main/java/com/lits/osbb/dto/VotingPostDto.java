package com.lits.osbb.dto;

import com.lits.osbb.model.Vote;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.apache.tomcat.jni.User;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class VotingPostDto {
    private Long id;
    private String title;
    private String body;
    private Date beginDate;
    private Date endDate;
    private User author;
    private List<Vote> voteList;

}
