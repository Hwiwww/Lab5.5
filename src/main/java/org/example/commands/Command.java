package org.example.commands;


public abstract class Command {
    public final String name;

    protected Command(String name) {
        this.name = name;
    }


    public abstract void execute(String[] args);


    public String getName() {
        return name;
    }


    public abstract String getDescription();

}
