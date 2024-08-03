package br.com.projectmanager.repository.impl;

import br.com.projectmanager.model.Task;
import java.util.List;

public interface TaskRepositoryCustom {
    List<Task> findTasksByPriority(Task.Priority priority);
}
