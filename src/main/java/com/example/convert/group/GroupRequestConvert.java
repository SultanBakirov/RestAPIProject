package com.example.convert.group;

import com.example.dto.request.GroupRequest;
import com.example.models.entities.Group;
import org.springframework.stereotype.Component;

@Component
public class GroupRequestConvert {

    public Group create(GroupRequest groupRequest) {
        if (groupRequest == null) {
            return null;
        }
        Group group = new Group();
        group.setGroupName(groupRequest.getGroupName());
        group.setDateOfStart(groupRequest.getDateOfStart());
        group.setImage(groupRequest.getImage());
        return group;
    }

    public void update(Group group, GroupRequest groupRequest) {
        group.setGroupName(groupRequest.getGroupName());
        group.setDateOfStart(groupRequest.getDateOfStart());
        group.setImage(groupRequest.getImage());
    }
}
