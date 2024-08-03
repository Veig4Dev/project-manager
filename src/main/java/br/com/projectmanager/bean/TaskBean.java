package br.com.projectmanager.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.projectmanager.model.Task;
import br.com.projectmanager.service.TaskService;
import lombok.Getter;
import lombok.Setter;

@Component
@RequestScoped // Use ViewScoped if you want the bean to be preserved across requests within the same view
public class TaskBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private Task task;

    @Getter @Setter
    private Long taskId;

    @Getter @Setter
    private List<Task> tasks;

    @Autowired // Spring annotation to inject TaskService
    private TaskService taskService;

    @PostConstruct
    public void init() {
        if (taskId != null) {
            task = taskService.findById(taskId).orElse(new Task());
        } else {
            task = new Task();
        }
        loadTasks();
    }

    public void saveTask() {
        try {
            taskService.save(task);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Tarefa salva com sucesso!"));
            task = new Task(); // Reset task after save
            loadTasks();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao salvar tarefa", e.getMessage()));
        }
    }

    public void deleteTask(Long id) {
        try {
            taskService.deleteById(id);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Tarefa excluída com sucesso!"));
            loadTasks();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao excluir tarefa", e.getMessage()));
        }
    }

    public void loadTasks() {
        tasks = taskService.findAll();
    }
}
