package com.example.bloom.controller;

import com.example.bloom.entity.BloomItem;
import com.example.bloom.service.BloomFilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bloom")
public class BloomFilterController {

    @Autowired
    private BloomFilterService service;

    @PostMapping("/add")
    public String add(@RequestBody BloomItem item) {
        return service.add(item);
    }

    @GetMapping("/username/{value}")
    public String check(@PathVariable String value) {
        return service.check(value);
    }
}