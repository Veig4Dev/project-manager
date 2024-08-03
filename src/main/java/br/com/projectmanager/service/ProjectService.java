package br.com.projectmanager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projectmanager.model.Project;
import br.com.projectmanager.repository.ProjectRepository;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project save(Project project) {
        return projectRepository.save(project);
    }

    public Optional<Project> findById(Long id) {
        return Optional.ofNullable(projectRepository.findOne(id));
    }

    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    public void deleteById(Long id) {
        projectRepository.delete(id);
    }
}
