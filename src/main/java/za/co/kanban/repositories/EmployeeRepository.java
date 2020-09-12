package za.co.kanban.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import za.co.kanban.model.Employee;
import za.co.kanban.model.EmployeeUserStory;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	public Employee findByEmployeeId(Long employeeId);

//	@Query(nativeQuery=true,value="SELECT e.fullname as fullName,COUNT(eu.employee_id) as userstoryCount " + 
//			"FROM employee e left join employee_user_story eu ON eu.employee_id=e.employee_id " + 
//			"GROUP BY e.fullname ")
	
	@Query(nativeQuery=true,value="SELECT count(*) as userstoryCount, e.fullname as fullName" + 
			" FROM employee e" + 
			" LEFT JOIN task t ON t.assigned_to = e.employee_id" + 
			" LEFT JOIN user_story u ON u.user_story_id = t.user_story_id" + 
			" WHERE t.task_id IS NOT NULL" + 
			" GROUP BY e.fullname" + 
			" ORDER BY userstoryCount desc")
	public List<EmployeeUserStory> employeeUserStorys();

}

