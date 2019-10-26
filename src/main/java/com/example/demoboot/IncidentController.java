package com.example.demoboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("incidents")
public class IncidentController {

    private IncidentRepository repository;

    @Autowired
    public IncidentController(IncidentRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public void addIncident(@RequestBody Incident incident) {
        incident.setCreationDate(new Date());
        repository.save(incident);
    }

    @GetMapping
    public List<Incident> getIncident() {
        return repository.findAll();
    }
}
