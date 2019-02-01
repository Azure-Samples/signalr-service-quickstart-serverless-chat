package com.function;

public class SignalRMessageBuilder {
    private SignalRMessage message = new SignalRMessage();
    public SignalRMessageBuilder(String target) {
        super();
        message.target = target;
    }

    public SignalRMessageBuilder addArgument(Object arg) {
        message.arguments.add(arg);
        return this;
    }

    public SignalRMessage build() {
        return message;
    }
}