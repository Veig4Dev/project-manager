package br.com.projectmanager.repository;

import br.com.projectmanager.model.Task;
import br.com.projectmanager.repository.impl.TaskRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long>, TaskRepositoryCustom {
}
