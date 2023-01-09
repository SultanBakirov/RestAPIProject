package com.example.api;

import com.example.dto.request.GroupRequest;
import com.example.dto.response.GroupResponse;
import com.example.services.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/group")
public class GroupController {

    private final GroupService groupService;

    @PostMapping("/save")
    public GroupResponse saveGroup(@RequestBody GroupRequest groupRequest) {
        return groupService.saveGroup(groupRequest);
    }

    @GetMapping("/getAll")
    public List<GroupResponse> getAllGroups() {
        return groupService.getAllGroups();
    }

    @GetMapping("/{groupId}")
    public GroupResponse getGroupById(@PathVariable Long groupId) {
        return groupService.getGroupById(groupId);
    }

    @PutMapping("/{groupId}")
    public GroupResponse updateGroup(@PathVariable Long groupId, @RequestBody GroupRequest groupRequest) {
        return groupService.updateGroup(groupId, groupRequest);
    }

    @DeleteMapping("/{groupId}")
    public GroupResponse deleteGroupById(@PathVariable Long groupId) {
        return groupService.deleteGroupById(groupId);
    }
}
