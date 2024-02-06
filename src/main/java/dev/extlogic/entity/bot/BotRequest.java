package dev.extlogic.entity.bot;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class BotRequest {
    private String model;
    private List<Message> messages = new ArrayList<>();

    public BotRequest(String model, String prompt) {
        this.model = model;
        this.messages.add(new Message("user", prompt)) ;
    }
}
