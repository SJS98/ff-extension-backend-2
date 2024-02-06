package dev.extlogic.service;

import dev.extlogic.entity.Action;
import dev.extlogic.entity.Element;
import dev.extlogic.entity.Nlp;
import dev.extlogic.entity.Step;
import dev.extlogic.util.ActionType;
import dev.extlogic.util.AppConstants;
import dev.extlogic.util.ElementType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class StepGeneratorService {

    Map<Integer, String> nlps;
    @Autowired
    private RestTemplate restTemplate;

    {
        nlps = new HashMap<>();
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(AppConstants.NPL_FILE_PATH));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        int i = 1;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (!(line.isEmpty() || line.isBlank())) {
                nlps.put(i++, line.split("-")[1]);
            }
        }

        getNlp(ActionType.ENTER_INTO, ElementType.TEXTFIELD, List.of("wait"));
        scanner.close();
    }

    public Step generateStep(Action action) {

        ActionType actionType = action.getAction();

        Element element = action.getElement();

        Nlp nlp = getNlp(actionType, element);

        String stepString = generateStepString(nlp, element);

        return null;
    }

    private String generateStepString(Nlp nlp, Element element) {
        return nlp.getNlp().replaceAll("element", element.getName());
    }

    private Nlp getNlp(ActionType action, Element element) {
        return null;
    }

    private Nlp getNlp(ActionType actionType, ElementType elementType, List<String> extra) {

        boolean found=false;

        List<String> nlpsFound = findNlps(actionType, elementType);
        List<String> nlpsFoundWithExtra = new ArrayList<>();
        for(String singleNlp: nlpsFound) {
            if(singleNlp.toLowerCase().contains(""))
                nlpsFoundWithExtra.add(singleNlp);
        }
        System.out.println("nlpString: " + nlpString);
//        nlpString = nlps.values().stream()
//                .filter(nlp -> nlp.toLowerCase().contains(actionType.toString().toLowerCase())
//                        || nlp.toLowerCase().contains(elementType.toString().toLowerCase()))
//                .collect(Collectors.toList());
//        nlpString.forEach(System.out::println);

        return null;
    }

    private List<String> findNlps(ActionType actionType, ElementType elementType) {

        List<String> nlpString = nlps.values().stream().filter(nlp -> {

                    if (actionType.toString().contains("_")) {
                        String[] s = actionType.toString().toLowerCase().split("_");
                        boolean b = nlp.toLowerCase().contains(s[0]) && nlp.toLowerCase().contains(s[1])
                                || nlp.toLowerCase().contains(elementType.toString().toLowerCase());

                        if(b)
                            log.info(b+" : "+ Arrays.toString(s)+" : "+nlp);
                        return b;
                    }else {
                        boolean b = nlp.toLowerCase().contains(actionType.toString().toLowerCase())
                                && nlp.toLowerCase().contains(elementType.toString().toLowerCase());
                        log.info(b+" : "+actionType.toString().toLowerCase()+" : "+nlp);
                        return b;
                    }
                })
                .collect(Collectors.toList());
            return nlpString;
    }

    public String generateStepNLP(Action action) {
//        getNlp(ActionType.CLICK, ElementType.BUTTON);
        return null;
    }
}