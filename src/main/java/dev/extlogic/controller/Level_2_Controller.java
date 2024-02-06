package dev.extlogic.controller;

import dev.extlogic.service.Level_2_Methods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/level2")
public class Level_2_Controller {
    @Autowired
    private Level_2_Methods level2Methods;

    @GetMapping("steps/{step}")
    public List<String> getSentences(@PathVariable("step") String step) throws IOException {
        return level2Methods.separateSentences(step);
    }
}
