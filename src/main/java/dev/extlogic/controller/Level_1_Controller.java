package dev.extlogic.controller;

import com.netflix.discovery.converters.Auto;
import dev.extlogic.service.Level_1_Methods;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/level1")
public class Level_1_Controller {

    @Autowired
    private Level_1_Methods level1Methods;

    @PostMapping("desc")
    public String findDesc(@RequestParam("file")MultipartFile file, @RequestParam("stepIndex") int index) throws IOException {
        Workbook workbook = new XSSFWorkbook(file.getInputStream());
        return level1Methods.getDescription(workbook.getSheetAt(0), index);
    }

    @PostMapping("step")
    public String findStep(@RequestParam("file")MultipartFile file, @RequestParam("stepIndex") int index) throws IOException {
        Workbook workbook = new XSSFWorkbook(file.getInputStream());
        return level1Methods.getStep(workbook.getSheetAt(0), index);
    }

    @PostMapping("data")
    public String findData(@RequestParam("file")MultipartFile file, @RequestParam("stepIndex") int index) throws IOException {
        Workbook workbook = new XSSFWorkbook(file.getInputStream());
        return level1Methods.getData(workbook.getSheetAt(0), index);
    }
}
