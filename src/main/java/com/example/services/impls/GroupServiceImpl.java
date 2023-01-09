package com.example.services.impls;

import com.example.convert.group.GroupRequestConvert;
import com.example.convert.group.GroupResponseConvert;
import com.example.dto.request.GroupRequest;
import com.example.dto.response.GroupResponse;
import com.example.models.entities.Group;
import com.example.repositories.GroupRepository;
import com.example.services.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;
    private final GroupRequestConvert groupRequestConvert;
    private final GroupResponseConvert groupResponseConvert;


    @Override
    public GroupResponse saveGroup(GroupRequest groupRequest) {
        Group group = groupRequestConvert.create(groupRequest);
        groupRepository.save(group);
        return groupResponseConvert.viewGroup(group);
    }

    @Override
    public List<GroupResponse> getAllGroups() {
        return groupResponseConvert.getAllGroups(groupRepository.findAll());
    }

    @Override
    public GroupResponse getGroupById(Long groupId) {
        Group group = groupRepository.findById(groupId).get();
        return groupResponseConvert.viewGroup(group);
    }

    @Override
    public GroupResponse deleteGroupById(Long groupId) {
        Group group = groupRepository.findById(groupId).get();
        groupRepository.delete(group);
        return groupResponseConvert.viewGroup(group);
    }

    @Override
    public GroupResponse updateGroup(Long groupId, GroupRequest groupRequest) {
        Group group = groupRepository.findById(groupId).get();
        groupRequestConvert.update(group, groupRequest);
        return groupResponseConvert.viewGroup(groupRepository.save(group));
    }
}
