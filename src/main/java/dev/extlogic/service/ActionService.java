package dev.extlogic.service;

import dev.extlogic.entity.Action;
import dev.extlogic.entity.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class ActionService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private StepGeneratorService stepGeneratorService;

    public Page savePage(String pageName, String url){
        return mongoTemplate.save(new Page(pageName, url), "pages");
    }

    public String getPageName(String url) {
        return mongoTemplate.find(new Query(Criteria.where("url").is(url)), String.class).get(0);
    }

    public void createStep(Action action) {
        String pageName = action.getPage().getPageName();
        if( pageName == null || pageName.isEmpty()){
            savePage(action.getPage());
        }
        stepGeneratorService.generateStep(action);
    }

    public Page savePage(Page page) {
        return mongoTemplate.save(page, "pages");
    }

    public String getNLP(Action action) {
        return stepGeneratorService.generateStepNLP(action);
    }
}
