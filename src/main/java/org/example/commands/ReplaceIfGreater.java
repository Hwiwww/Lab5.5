package org.example.commands;

public class ReplaceIfGreater extends Command{
    public ReplaceIfGreater(){
        super("replace_if_greater");
    }

    @Override
    public void execute(String[] args) {

    }

    @Override
    public String getDescription() {
        return "updates element by key if new bigger than element in collection with the same key";
    }
}
