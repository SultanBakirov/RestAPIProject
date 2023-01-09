package com.example.dto.response;

import lombok.*;

import java.util.Date;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class GroupResponse {

    private Long id;

    private String groupName;

    private Date dateOfStart;

    private String image;

}
