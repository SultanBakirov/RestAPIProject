package com.example.convert.group;

import com.example.dto.response.GroupResponse;
import com.example.models.entities.Group;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GroupResponseConvert {

    public GroupResponse viewGroup(Group group) {
        if (group == null) {
            return null;
        }
        GroupResponse groupResponse = new GroupResponse();
        groupResponse.setId(group.getId());
        groupResponse.setGroupName(group.getGroupName());
        groupResponse.setDateOfStart(group.getDateOfStart());
        groupResponse.setImage(group.getImage());
        return groupResponse;
    }

    public List<GroupResponse> getAllGroups(List<Group> groups) {
        List<GroupResponse> groupResponses = new ArrayList<>();
        for (Group group: groups) {
            groupResponses.add(viewGroup(group));
        }
        return groupResponses;
    }
}
