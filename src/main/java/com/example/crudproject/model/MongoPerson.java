package com.example.crudproject.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "mongo_person")
public class MongoPerson {
    @Id
    private String id;
    private String name;
    private String notes;

    public MongoPerson() {}
    public MongoPerson(String name, String notes) { this.name = name; this.notes = notes; }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
}
