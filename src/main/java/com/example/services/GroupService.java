package com.example.services;

import com.example.dto.request.GroupRequest;
import com.example.dto.response.GroupResponse;

import java.util.List;

public interface GroupService {

    GroupResponse saveGroup(GroupRequest groupRequest);

    List<GroupResponse> getAllGroups();

    GroupResponse getGroupById(Long groupId);

    GroupResponse deleteGroupById(Long groupId);

    GroupResponse updateGroup(Long groupId, GroupRequest groupRequest);

}
