package br.com.projectmanager.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tasks")
public class Task {

    public enum Priority {
        VERY_HIGH, HIGH, LOW, VERY_LOW
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(length = 1000)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Priority priority;

    @Column(nullable = false)
    private Integer estimatedHours;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;
}
