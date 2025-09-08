package com.example.notifications;

public abstract class NotifierDecorator implements Notifier {
    protected final Notifier wrapped;

    public NotifierDecorator(Notifier wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public void notify(String text) {
        wrapped.notify(text);
    }
}
