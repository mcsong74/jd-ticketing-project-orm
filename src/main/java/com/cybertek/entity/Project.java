package com.cybertek.entity;

import com.cybertek.enums.Status;
import lombok.*;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="projects")
@Where(clause = "is_deleted=false")
public class Project extends BaseEntity {
    private String projectName;

    @Column(unique = true)//server side validation
    private String projectCode;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="manager_id")
    private User assignedManager;


    private LocalDate startDate;
    private LocalDate endDate;

    private String projectDetails;
    @Enumerated(EnumType.STRING)
    private Status projectStatus;




}
