package com.example.notifications;

public class SlackDecorator extends NotifierDecorator {
    private final String channel;

    public SlackDecorator(Notifier wrapped, String channel) {
        super(wrapped);
        this.channel = channel;
    }

    @Override
    public void notify(String text) {
        super.notify(text);
        System.out.println("[SLACK -> #" + channel + "]: " + text);
    }
}
