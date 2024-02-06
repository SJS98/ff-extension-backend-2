package dev.extlogic.entity;

import dev.extlogic.util.ElementType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
public class Element {
    private String name;
    private ElementType type;
    private List<Path> paths;
    private List<ElementProperty> properties;
}
