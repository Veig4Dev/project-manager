package br.com.projectmanager.repository.impl;

import br.com.projectmanager.model.Task;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaskRepositoryImpl implements TaskRepositoryCustom {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Task> findTasksByPriority(Task.Priority priority) {
        String hql = "FROM Task t WHERE t.priority = :priority";
        TypedQuery<Task> query = entityManager.createQuery(hql, Task.class);
        query.setParameter("priority", priority);
        return query.getResultList();
    }
}
