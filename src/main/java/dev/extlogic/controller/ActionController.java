package dev.extlogic.controller;

import common.ResponseDTO;
import dev.extlogic.entity.Action;
import dev.extlogic.service.ActionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

@RestController
@Slf4j
public class ActionController {

    @Autowired
    private ActionService actionService;

    @GetMapping
    public String home() {
        return "Home";
    }

    @GetMapping("/page/is-contains")
    public String verifyPage(@RequestParam("url") String url) {
        return actionService.getPageName(url);
    }

    @PostMapping("/action")
    public void createStep(@RequestBody Action action) {
        actionService.createStep(action);
    }

    @GetMapping("/getnlp")
    public String getNLP(Action action) {
        return actionService.getNLP(action);
    }

    @GetMapping("/nlpfile")
    public ResponseEntity<ResponseDTO> getNplFile() throws IOException {
        log.info("API called");
        ResponseDTO responseDTO = new ResponseDTO();
        byte[] allBytes = new FileInputStream("C:\\Users\\User\\Downloads\\ext-logic\\ext-logic\\src\\ResourceData\\nlps.txt").readAllBytes();
//        responseDTO.setData(allBytes);

        responseDTO.string = "Demo Data String";
        responseDTO.data = allBytes;
        log.info(Arrays.toString(allBytes));

        return ResponseEntity.ok(responseDTO);
    }
}
