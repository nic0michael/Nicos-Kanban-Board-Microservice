package be.intecbrussel.kaartje.repositories;

import be.intecbrussel.kaartje.model.Employee;
import be.intecbrussel.kaartje.model.EmployeeUserStory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findByEmployeeId(Long employeeId);

//	@Query(nativeQuery=true,value="SELECT e.fullname as fullName,COUNT(eu.employee_id) as userstoryCount " + 
//			"FROM employee e left join employee_user_story eu ON eu.employee_id=e.employee_id " + 
//			"GROUP BY e.fullname ")

    @Query(nativeQuery = true, value = "SELECT count(*) as userstoryCount, e.fullname as fullName" +
            " FROM employee e" +
            " LEFT JOIN task t ON t.assigned_to = e.employee_id" +
            " LEFT JOIN user_story u ON u.user_story_id = t.user_story_id" +
            " WHERE t.task_id IS NOT NULL" +
            " GROUP BY e.fullname" +
            " ORDER BY userstoryCount desc")
	List<EmployeeUserStory> employeeUserStorys();

}

