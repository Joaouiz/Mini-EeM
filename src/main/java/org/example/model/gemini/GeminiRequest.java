package org.example.model.gemini;

import java.util.List;

public class GeminiRequest {

    private List<GeminiContent> contents;

    public GeminiRequest(String prompt) {
        this.contents = List.of(new GeminiContent(prompt));
    }

    public List<GeminiContent> getContents() {
        return contents;
    }
}