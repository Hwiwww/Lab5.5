package org.example;
import org.example.system.*;

import java.io.File;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Environment environment = Environment.getInstance();
        CollectionManager collectionManager = new CollectionManager();
        CommandManager commandManager = new CommandManager();
        FileManager fileManager = new FileManager();
        DragonGenerator dragonGenerator = new DragonGenerator();
        Scanner scanner = new Scanner(System.in);
        Console console = new Console();

        environment.setConsole(console);
        environment.setCollectionManager(collectionManager);
        environment.setCommandManager(commandManager);
        environment.setFileManager(fileManager);
        environment.setDragonGenerator(dragonGenerator);
        environment.setScanner(scanner);

        if (args.length == 0) {
            System.out.println("Something wrong with argument (file_path)");
        }
        else {
            File file = new File(args[0]);
            if (file.canRead() && file.canWrite()) {
                environment.getConsole().start(System.in, args);
            }
            else {
                System.out.println("You do not have enough root");
            }
        }
    }
}