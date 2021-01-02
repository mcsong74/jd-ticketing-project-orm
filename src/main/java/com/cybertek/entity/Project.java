package com.cybertek.entity;

import lombok.*;

import javax.validation.constraints.AssertTrue;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Project extends BaseEntity {
    private String projectName;
    private String projectCode;
    private String assignedManager;
    private String startDate;
    private String endDate;
    private String projectDetails;

    public Project(Long id, LocalDateTime insertDateTime, Long insertUserId, LocalDateTime lastUpdateDateTime, Long lastUpdateUserId, String projectName, String projectCode, String assignedManager, String startDate, String endDate, String projectDetails) {
        super(id, insertDateTime, insertUserId, lastUpdateDateTime, lastUpdateUserId);
        this.projectName = projectName;
        this.projectCode = projectCode;
        this.assignedManager = assignedManager;
        this.startDate = startDate;
        this.endDate = endDate;
        this.projectDetails = projectDetails;
    }
}
