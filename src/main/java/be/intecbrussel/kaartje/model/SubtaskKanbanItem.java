package be.intecbrussel.kaartje.model;

public interface SubtaskKanbanItem {

    String getStatus();

    String getSubtaskId();

    String getSubtaskName();

    String getTaskName();

    String getAssignedTo();

    String getDueDate();
}
