package com.example.springboot311tasksonhandapplicaton.models;

import java.io.Serializable;
import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
/**
 * taskItem
 */

 @Getter
 @Setter
 @Entity
 @Table(name="list_of_tasks")

public class TaskItem implements Serializable{

    //describe the type of sequence to use when henerating Ids
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String description;
    private Boolean isDone;

    private String currentState;
    private Instant whenCreated;
    private Instant lastUpdate;
    private String category;
    //private Date dueDate;

    @Override
    public String toString(){
        return String.format("Task Item{id=%d, category='%s', description='%s,isDone='%s',whenCreated='%s', lastUpdate='%s', currentState='%s'}",
        id,category, description,isDone,whenCreated,lastUpdate,currentState);
    }
}