package com.example.demo;

import com.example.demo.exception.EntityIdNotNullException;
import com.example.demo.exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BirdsResource {

    @Autowired
    private BirdsRepository birdsRepository;

    @GetMapping("/birds")
    public List<Birds> findAll() {
        return birdsRepository.findAll();
    }

    @PostMapping("/birds")
    public Birds store(@RequestBody Birds bird) throws EntityIdNotNullException {
        if (bird.getId() != null) {
            throw new EntityIdNotNullException("A new Bird does't not have an ID");
        }
        return birdsRepository.save(bird);
    }

    @GetMapping("/birds/{id}")
    public Birds findAll(@PathVariable Long id) throws EntityNotFoundException {
        Optional<Birds> birdsOptional = birdsRepository.findById(id);
        if (birdsOptional.isEmpty()) {
            throw new EntityNotFoundException("Bird was not found for parameters {id=" + id + "}");
        }
        return birdsOptional.get();
    }
}
