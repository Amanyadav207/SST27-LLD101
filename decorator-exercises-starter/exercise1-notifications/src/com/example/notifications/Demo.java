package com.example.notifications;

public class Demo {
    public static void main(String[] args) {
        Notifier base = new EmailNotifier("user@example.com");

        // Baseline
        base.notify("Baseline email only.");

        System.out.println("\n--- Combinations ---");

        // a) Email + SMS
        Notifier smsAndEmail = new SmsDecorator(base, "+91-99999-11111");
        smsAndEmail.notify("Build green ✅");

        // b) Email + WhatsApp
        Notifier waAndEmail = new WhatsAppDecorator(base, "user_wa");
        waAndEmail.notify("Code review done 👌");

        // c) Email + Slack
        Notifier slackAndEmail = new SlackDecorator(base, "devops");
        slackAndEmail.notify("Server restarted 🔄");

        // d) Email + WhatsApp + Slack
        Notifier full = new SlackDecorator(new WhatsAppDecorator(base, "user_wa"), "deployments");
        full.notify("Deployment completed 🚀");
    }
}
