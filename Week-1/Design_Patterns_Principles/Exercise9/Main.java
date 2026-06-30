public class Main {
    public static void main(String[] args) {
        Light livingRoom = new Light("Living Room");
        Light bedroom = new Light("Bedroom");

        Command livingOn = new LightOnCommand(livingRoom);
        Command livingOff = new LightOffCommand(livingRoom);
        Command bedOn = new LightOnCommand(bedroom);
        Command bedOff = new LightOffCommand(bedroom);

        RemoteControl remote = new RemoteControl();

        System.out.println("--- Using Remote Control ---");
        remote.setCommand(livingOn);
        remote.pressButton();

        remote.setCommand(bedOn);
        remote.pressButton();

        remote.setCommand(livingOff);
        remote.pressButton();

        remote.setCommand(bedOff);
        remote.pressButton();
    }
}
