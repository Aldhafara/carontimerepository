package com.carontime.on_time.model.result;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Result {
    private List<String> messages = new ArrayList<>();

    public Result() {}

    public Result(String ... messages) {
        this.messages = Arrays.asList(messages);
    }

    public List<String> getMessages() {
        return this.messages;
    }

    public String getMessage(int id) {
        return this.messages.get(id);
    }

    public void addMessage(String message) {
        messages.add(message);
    }

    public void removeMessage(int id) {
        messages.remove(id);
    }

    public boolean hasMessages() {
        return !messages.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        messages.forEach(m -> stringBuilder.append(m).append(System.lineSeparator()));
        return stringBuilder.toString();
    }
}
