package org.example.commands;

public class Exit extends Command {

    public Exit() {
        super("exit");
    }

    @Override
    public void execute(String[] args) {
        System.exit(0);
    }

    @Override
    public String getDescription() {
        return "ends the program without saving it to a file";
    }
}
