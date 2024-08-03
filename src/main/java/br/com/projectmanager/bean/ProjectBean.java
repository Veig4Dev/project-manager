package br.com.projectmanager.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.projectmanager.model.Project;
import br.com.projectmanager.service.ProjectService;
import br.com.projectmanager.service.TaskService;
import lombok.Getter;
import lombok.Setter;

@Component
@RequestScoped
public class ProjectBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private Project project;

    @Getter @Setter
    private Long projectId;

    @Getter @Setter
    private List<Project> projects;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private TaskService taskService;

    @PostConstruct
    public void init() {
        if (projectId != null) {
            project = projectService.findById(projectId).orElse(new Project());
        } else {
            project = new Project();
        }
        loadProjects();
    }

    public void saveProject() {
        try {
            projectService.save(project);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Projeto salvo com sucesso!"));
            project = new Project(); // Reset project after save
            loadProjects();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao salvar projeto", e.getMessage()));
        }
    }

    public void deleteProject(Long id) {
        try {
            projectService.deleteById(id);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Projeto excluído com sucesso!"));
            loadProjects();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao excluir projeto", e.getMessage()));
        }
    }

    public void loadProjects() {
        projects = projectService.findAll();
    }
}
