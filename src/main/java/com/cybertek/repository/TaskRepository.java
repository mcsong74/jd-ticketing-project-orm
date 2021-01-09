package com.cybertek.repository;

import com.cybertek.entity.Project;
import com.cybertek.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    //JP query
    @Query("select count(t) From Task t where t.project.projectCode=?1 and  t.status <> 'COMPLETED'")
    int totalCountNonCompletedTasks(String projectCode);

    //native query
    @Query(value = "select count(*)" +
            "from tasks t join projects p on t.project_id=p.id " +
            "Where p.project_code =?1 and t.status='COMPLETED'", nativeQuery = true)
    int totalCountCompletedTasks(String projectCode);

    List<Task> findAllByProject(Project project);

}
