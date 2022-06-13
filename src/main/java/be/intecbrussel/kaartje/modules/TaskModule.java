package be.intecbrussel.kaartje.modules;

import be.intecbrussel.kaartje.dtos.TaskPersistRequest;
import be.intecbrussel.kaartje.model.Employee;
import be.intecbrussel.kaartje.model.Task;
import be.intecbrussel.kaartje.model.TaskKanbanItem;
import be.intecbrussel.kaartje.repositories.TaskRepository;
import be.intecbrussel.kaartje.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class TaskModule {
    private static final Logger log = LoggerFactory.getLogger(TaskModule.class);

    @Autowired
    TaskRepository repository;

    @Autowired
    EmployeeModule employeeModule;


    public List<TaskKanbanItem> getTaskBanbanitems() {
        List<TaskKanbanItem> taskKanbanItems = repository.getTaskBanbanitems();
        TaskKanbanItem taskKanbanItem = taskKanbanItems.get(0);
        log.info("PROJECT_MAN : TaskModule : getTaskBanbanitems : taskKanbanItem : " + toString(taskKanbanItem));
        return taskKanbanItems;
    }

    private String toString(TaskKanbanItem taskKanbanItem) {
        return "[Status :" + taskKanbanItem.getStatus()
                + " taskId: " + taskKanbanItem.getTaskId()
                + " taskName: " + taskKanbanItem.getTaskName()
                + " userStoryName : " + taskKanbanItem.getUserStoryName()
                + " assignedTo : " + taskKanbanItem.getAssignedTo()
                + " dueDate : " + taskKanbanItem.getDueDate();
    }

    public void save(TaskPersistRequest taskPersistRequest) {
        if (taskPersistRequest != null) {
            boolean employeesFound = false;
            Task task = Utils.convertToTask(taskPersistRequest);
            if (task != null) {
                repository.save(task);
            }
        }
    }


    public void update(TaskPersistRequest taskPersistRequest) {
        log.info("PROJECT_MAN : TaskModule : update : task : " + taskPersistRequest);
        boolean employeesFound = false;
        List<Employee> employees = new ArrayList<>();
        if (taskPersistRequest != null) {
            Long taskId = Long.parseLong(taskPersistRequest.getTaskId());

            if (taskId != null) {
                Task task = findByTaskId(taskId);
                if (task != null) {
                    task = Utils.convertToTask(taskPersistRequest, task);
                    repository.save(task);
                }
            }
        }
    }

    public List<Task> findAll() {
        System.out.println("getting list of tasks");
        List<Task> tasks = repository.findAll();
        System.out.println("got list of tasks : " + tasks);
        return tasks;
    }


    public boolean existsById(Long taskId) {
        if (taskId != null) {
            return repository.existsById(taskId);
        } else {
            return false;
        }
    }


    public List<Task> findAllById(Long taskId) {
        log.info("PROJECT_MAN : TaskModule : findAllById : taskId : " + taskId);
        List<Task> tasks = null;
        if (taskId != null) {
            boolean res = repository.existsById(taskId);
            if (res) {
                log.info("PROJECT_MAN : TaskModule : findAllById : exists taskId : " + taskId);
                List<Long> ids = new ArrayList();
                ids.add(taskId);
                tasks = repository.findAllById(ids);
            }
            log.info("PROJECT_MAN : TaskModule : findAllById : tasks found : " + tasks);
        }
        return tasks;
    }


    public Task findByTaskId(Long taskId) {
        log.info("PROJECT_MAN : TaskModule : find : find taskId : " + taskId);
        Task task = null;
        if (taskId != null) {
            List<Task> tasks = findAllById(taskId);
            task = tasks.get(0);
        }
        log.info("PROJECT_MAN : TaskModule : find : task : " + task);
        return task;
    }


    public void delete(Long taskId) {
        log.info("PROJECT_MAN : TaskModule : delete : find taskId : " + taskId);
        if (taskId != null) {
            Task task = findByTaskId(taskId);
            log.info("PROJECT_MAN : TaskModule : delete : task : " + task);
            repository.delete(task);
        }
    }


    public void update(Long taskId, Task theTask) {
        if (theTask != null && taskId != null) {
            Task task = findByTaskId(taskId);
            task = Utils.updateTask(task, theTask);
            System.out.println("Saving Task taskId: " + taskId);
            repository.save(task);
        }
    }

}
