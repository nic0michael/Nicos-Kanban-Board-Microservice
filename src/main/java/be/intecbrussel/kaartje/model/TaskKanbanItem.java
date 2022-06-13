package be.intecbrussel.kaartje.model;

public interface TaskKanbanItem {

    String getStatus();

    String getTaskId();

    String getTaskName();

    String getUserStoryName();

    String getAssignedTo();

    String getDueDate();

}
