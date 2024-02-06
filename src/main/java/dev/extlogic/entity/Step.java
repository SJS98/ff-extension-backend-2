package dev.extlogic.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

// wait till element is visible
@Getter
@Setter
public class Step {
    private String npl;
    private List<Object> values;
}
