package org.example;
import org.example.system.Console;
import java.io.File;


public class Main {
    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Something wrong with argument (file_path)");
        }
        else {
            File file = new File(args[0]);
            if (file.canRead() && file.canWrite()){
                Console console = new Console();
                console.start(System.in, args);
            }
            else {
                System.out.println("You do not have enough root");
            }
        }
    }
}