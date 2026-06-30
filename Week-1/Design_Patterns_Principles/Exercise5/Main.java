public class Main {
    public static void main(String[] args) {
        Notifier emailOnly = new EmailNotifier();
        System.out.println("--- Email Only ---");
        emailOnly.send("Server is down!");

        Notifier emailAndSMS = new SMSNotifierDecorator(new EmailNotifier());
        System.out.println("\n--- Email + SMS ---");
        emailAndSMS.send("Disk space low!");

        Notifier allChannels = new SlackNotifierDecorator(
                new SMSNotifierDecorator(new EmailNotifier()));
        System.out.println("\n--- Email + SMS + Slack ---");
        allChannels.send("Critical alert: Database unreachable!");
    }
}
