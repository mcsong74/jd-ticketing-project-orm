package com.cybertek.entity;

import com.cybertek.enums.Status;
import lombok.*;
import org.hibernate.annotations.Where;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name="projects")
@Where(clause = "is_deleted=false")
public class Project extends BaseEntity {
    private String projectName;
    private String projectCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="manager_id")
    private User assignedManager;

    private LocalDate startDate;
    private LocalDate endDate;

    private Status projectStatus;
    private String projectDetails;




}
