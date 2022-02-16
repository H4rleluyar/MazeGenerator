package Maze;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class MazeTest {

    /**
     * Test the time of DFS and BFS of a maze with size 4
     * @throws IOException
     */
    @Test
    public void testSizeFourTime() {

        int size = 4;
        MazeGen maze = new MazeGen(size);
        System.out.println("Original maze size 4:\n\n" + maze + "\n");

        //depth-first search
        long start = System.currentTimeMillis();
        DFS maze1 = new DFS(size);
        maze1.depthFirstSearch();
        System.out.println("Depth-first search:\n");
        System.out.println(maze1.printDFS());
        System.out.println("\n" + maze1.printShortDFS());
        long end = System.currentTimeMillis();
        System.out.println("DFS: size: 4 time taken: " + (end - start) + " milliseconds\n");

        //breadth-first search
        start = System.currentTimeMillis();
        BFS maze2 = new BFS(size);
        maze2.breadthFirstSearch();
        System.out.println("Breadth-first search:\n");
        System.out.println(maze2.printBFS());
        System.out.println("\n" + maze2.printShortBFS());
        end = System.currentTimeMillis();
        System.out.println("BFS: size: 4 time taken: " + (end - start) + " milliseconds\n");
    }

    /**
     * Test the result of DFS and BFS to see if it matches
     * @throws IOException
     */
    @Test
    public void testSizeFourResult() throws IOException{

        int size = 4;

        //depth-first search
        DFS maze1 = new DFS(size);
        maze1.depthFirstSearch();
        String actual = maze1.printDFS(); //test printDFS
        String expected = Testing.readFile("DFS4.txt"); //compare to expected output in txt file
        String actual2 = maze1.printShortDFS(); //test printShortDFS
        String expected2 = Testing.readFile("DFSS4.txt"); //compare to expected output in txt file
        assertTrue(actual.equals(expected));
        assertTrue(actual2.equals(expected2));


        //breadth-first search
        BFS maze2 = new BFS(size);
        maze2.breadthFirstSearch();
        String actual3 = maze2.printBFS(); //test printBFS
        String expected3 = Testing.readFile("BFS4.txt"); //compare to expected output in txt file
        String actual4 = maze2.printShortBFS(); //test printShortBFS
        String expected4 = Testing.readFile("BFSS4.txt"); //compare to expected output in txt file
        assertTrue(actual3.equals(expected3));
        assertTrue(actual4.equals(expected4));
    }


    /**
     * Tests the timing of DFS and BFS of a maze with size 5
     */
    @Test
    public void testSizeFiveTime(){

        int size = 5;
        MazeGen maze = new MazeGen(size);
        System.out.println("Original maze size 5:\n\n" + maze + "\n");

        //depth-first search
        long start = System.currentTimeMillis();
        DFS maze1 = new DFS(size);
        maze1.depthFirstSearch();
        System.out.println("Depth-first search:\n");
        System.out.println(maze1.printDFS());
        System.out.println("\n" + maze1.printShortDFS());
        long end = System.currentTimeMillis();
        System.out.println("DFS: size: 5 time taken: " + (end - start) + " milliseconds\n");

        //breadth-first search
        start = System.currentTimeMillis();
        BFS maze2 = new BFS(size);
        maze2.breadthFirstSearch();
        System.out.println("Breadth-first search:\n");
        System.out.println(maze2.printBFS());
        System.out.println("\n" + maze2.printShortBFS());
        end = System.currentTimeMillis();
        System.out.println("BFS: size: 5 time taken: " + (end - start) + " milliseconds\n");
    }

    /**
     * Tests the timing of DFS and BFS of a maze with size 6
     */
    @Test
    public void testSizeSixTime(){

        int size = 6;
        MazeGen maze = new MazeGen(size);
        System.out.println("Original maze size 6:\n\n" + maze + "\n");

        //depth-first search
        long start = System.currentTimeMillis();
        DFS maze1 = new DFS(size);
        maze1.depthFirstSearch();
        System.out.println("Depth-first search:\n");
        System.out.println(maze1.printDFS());
        System.out.println("\n" + maze1.printShortDFS());
        long end = System.currentTimeMillis();
        System.out.println("DFS: size 6 time taken: " + (end - start) + " milliseconds\n");

        //breadth-first search
        start = System.currentTimeMillis();
        BFS maze2 = new BFS(size);
        maze2.breadthFirstSearch();
        System.out.println("Breadth-first search:\n");
        System.out.println(maze2.printBFS());
        System.out.println("\n" + maze2.printShortBFS());
        end = System.currentTimeMillis();
        System.out.println("BFS: size 6 time taken: " + (end - start) + " milliseconds\n");
    }

    /**
     * Tests the timing of DFS and BFS of a maze with size 7
     */
    @Test
    public void testSizeSevenTime(){

        int size = 7;
        MazeGen maze = new MazeGen(size);
        System.out.println("Original maze size 7:\n\n" + maze + "\n");

        //depth-first search
        long start = System.currentTimeMillis();
        DFS maze1 = new DFS(size);
        maze1.depthFirstSearch();
        System.out.println("Depth-first search:\n");
        System.out.println(maze1.printDFS());
        System.out.println("\n" + maze1.printShortDFS());
        long end = System.currentTimeMillis();
        System.out.println("DFS: size: 7 time taken: " + (end - start) + " milliseconds\n");

        //breadth-first search
        start = System.currentTimeMillis();
        BFS maze2 = new BFS(size);
        maze2.breadthFirstSearch();
        System.out.println("Breadth-first search:\n");
        System.out.println(maze2.printBFS());
        System.out.println("\n" + maze2.printShortBFS());
        end = System.currentTimeMillis();
        System.out.println("BFS: size: 7 time taken: " + (end - start) + " milliseconds\n");
    }

    /**
     * Tests the timing of DFS and BFS of a maze with size 8
     */
    @Test
    public void testSizeEightTime(){

        int size = 8;
        MazeGen maze = new MazeGen(size);
        System.out.println("Original maze size 8:\n\n" + maze + "\n");

        //depth-first search
        long start = System.currentTimeMillis();
        DFS maze1 = new DFS(size);
        maze1.depthFirstSearch();
        System.out.println("Depth-first search:\n");
        System.out.println(maze1.printDFS());
        System.out.println("\n" + maze1.printShortDFS());
        long end = System.currentTimeMillis();
        System.out.println("DFS: size: 8 time taken: " + (end - start) + " milliseconds\n");

        //breadth-first search
        start = System.currentTimeMillis();
        BFS maze2 = new BFS(size);
        maze2.breadthFirstSearch();
        System.out.println("Breadth-first search:\n");
        System.out.println(maze2.printBFS());
        System.out.println("\n" + maze2.printShortBFS());
        end = System.currentTimeMillis();
        System.out.println("BFS: size: 8 time taken: " + (end - start) + " milliseconds\n");
    }

    /**
     * Tests the timing of DFS and BFS of a maze with size 9
     */
    @Test
    public void testSizeNineTime(){

        int size = 9;
        MazeGen maze = new MazeGen(size);
        System.out.println("Original maze size 9:\n\n" + maze + "\n");

        //depth-first search
        long start = System.currentTimeMillis();
        DFS maze1 = new DFS(size);
        maze1.depthFirstSearch();
        System.out.println("Depth-first search:\n");
        System.out.println(maze1.printDFS());
        System.out.println("\n" + maze1.printShortDFS());
        long end = System.currentTimeMillis();
        System.out.println("DFS: size: 9 time taken: " + (end - start) + " milliseconds\n");

        //breadth-first search
        start = System.currentTimeMillis();
        BFS maze2 = new BFS(size);
        maze2.breadthFirstSearch();
        System.out.println("Breadth-first search:\n");
        System.out.println(maze2.printBFS());
        System.out.println("\n" + maze2.printShortBFS());
        end = System.currentTimeMillis();
        System.out.println("BFS: size: 9 time taken: " + (end - start) + " milliseconds\n");
    }

    /**
     * Tests the timing of DFS and BFS of a maze with size 10
     */
    @Test
    public void testSizeTenTime(){

        int size = 10;
        MazeGen maze = new MazeGen(size);
        System.out.println("Original maze size 10:\n\n" + maze + "\n");

        //depth-first search
        long start = System.currentTimeMillis();
        DFS maze1 = new DFS(size);
        maze1.depthFirstSearch();
        System.out.println("Depth-first search:\n");
        System.out.println(maze1.printDFS());
        System.out.println("\n" + maze1.printShortDFS());
        long end = System.currentTimeMillis();
        System.out.println("DFS: size: 10 time taken: " + (end - start) + " milliseconds\n");

        //breadth-first search
        start = System.currentTimeMillis();
        BFS maze2 = new BFS(size);
        maze2.breadthFirstSearch();
        System.out.println("Breadth-first search:\n");
        System.out.println(maze2.printBFS());
        System.out.println("\n" + maze2.printShortBFS());
        end = System.currentTimeMillis();
        System.out.println("BFS: size: 10 time taken: " + (end - start) + " milliseconds\n");
    }

    /**
     * Tests the Result of DFS and BFS of a maze with size 10
     * @throws IOException
     */
    @Test
    public void testSizeTenResult() throws IOException{
        int size = 10;

        //depth-first search
        DFS maze1 = new DFS(size);
        maze1.depthFirstSearch();
        String actual = maze1.printDFS(); //test printDFS
        String expected = Testing.readFile("DFS10.txt"); //compare to expected output in txt file
        String actual2 = maze1.printShortDFS(); //test printShortDFS
        String expected2 = Testing.readFile("DFSS10.txt"); //compare to expected output in txt file
        assertTrue(actual.equals(expected));
        assertTrue(actual2.equals(expected2));


        //breadth-first search
        BFS maze2 = new BFS(size);
        maze2.breadthFirstSearch();
        String actual3 = maze2.printBFS(); //test printBFS
        String expected3 = Testing.readFile("BFS10.txt"); //compare to expected output in txt file
        String actual4 = maze2.printShortBFS(); //test printShortBFS
        String expected4 = Testing.readFile("BFSS10.txt"); //compare to expected output in txt file
        assertTrue(actual3.equals(expected3));
        assertTrue(actual4.equals(expected4));
    }


    /**
     * Tests if the DFS short path and BFS short path are the same
     */
    @Test
    public void testDFSBFS() {
        //depth-first search
        int size = 4;
        DFS maze1 = new DFS(size);
        maze1.depthFirstSearch();
        String actual = maze1.printShortDFS(); //test printDFS

        //breadth-first search
        BFS maze2 = new BFS(size);
        maze2.breadthFirstSearch();
        String actual2 = maze2.printShortBFS(); //test printShortBFS
        assertTrue(actual.equals(actual2));

    }
}
