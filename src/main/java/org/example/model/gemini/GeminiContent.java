package org.example.model.gemini;

import java.util.List;

public class GeminiContent {

    private final List<GeminiPart> parts;

    public GeminiContent(String texto) {
        this.parts = List.of(new GeminiPart(texto));
    }

    public List<GeminiPart> getParts() {
        return parts;
    }
}