package dev.extlogic.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BotController {

    @Value("${openai.model}")
    private String model;
}
