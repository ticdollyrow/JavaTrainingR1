package org.example.Builder.LombokBuilderPattern;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class LombokPost {
    private String title;
    private String text;

}
