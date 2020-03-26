package Model;

import java.util.ArrayList;

/**
 * @author Hanna My Jansson
 * @version 1.0
 */
public class TaskRegister {
    private ArrayList<Task> taskList;
    private int lastId;

    public TaskRegister() {
        taskList = new ArrayList<>();
        lastId = -1;
    }


    public void addTask(Task task){
        if(task!=null) {
            task.setID(generateId());
            taskList.add(task);
        }

    }

    public void removeWithId(int taskId){
        Task task = new Task(taskId);
        taskList.remove(task);
    }

    public void removeTask(Task task){
        taskList.remove(task);
    }

    public void removeWithIndex(int index){
        taskList.remove(index);
    }

    public Task getTaskWithIndex(int index) {
        return taskList.get(index);

    }

    public Task getTaskWithId(int id) {
        int index = taskList.indexOf(new Task(id));
        return taskList.get(index);
    }

    private int generateId(){
        lastId++;
        return lastId;
    }
}
