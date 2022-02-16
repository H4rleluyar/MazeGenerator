package Maze;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MazeMain {

    public static void main(String[] args) throws IOException{

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a maze size from 4 to 10: ");
        int size = 10; // Generating a default size for error
        try {
            String s = scanner.nextLine();
            size = Integer.parseInt(s);
            if (!(size >= 4 && size <= 10))
                size = 10;
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid Size. Generating default maze size 10");
        }
        // Default maze

        MazeGen maze = new MazeGen(size);
        System.out.println("Default maze:\n\n" + maze + "\n");

        //Breadth-First search version
        BFS maze2 = new BFS(size);
        maze2.breadthFirstSearch();
        System.out.println("Breadth-first search:\n");
        System.out.println(maze2.printBFS());
        System.out.println("\n" + maze2.printShortBFS());


        // Depth-First search version
        DFS maze1 = new DFS(size);
        maze1.depthFirstSearch();
        System.out.println("Depth-first search:\n");
        String actual = maze1.printDFS();
        System.out.println(actual);
        System.out.println("\n" + maze1.printShortDFS());
    }

}
