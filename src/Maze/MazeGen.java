package Maze;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class MazeGen {

    protected Random randomGen;
    protected MazeGrid maze[][]; // the maze
    protected int size;// the size of the MazeGrid
    protected int time; // use to keep track of the time it takes to go through maze/find cell
    protected boolean stop = false;

    public MazeGen(int size) {

        // initialize all variables
        time = 0;
        this.size = size;
        randomGen = new Random(); // Making a new random call randomGen
        randomGen.setSeed(4); //use to determine how the maze will generate

        maze = new MazeGrid[size][size]; // Make new MazeGrid based on user input size
        // A for loop are use to make a new Matrix/Grid starting from 0 to size
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                maze[i][j] = new MazeGrid(i, j);

                // if statement use to determine the start position
                if (i == 0 && j == 0) {
                    maze[i][j].northLine = false;
                }

                // if statement use to determine the end location
                if (i == size - 1 & j == size - 1) {
                    maze[i][j].southLine = false;
                }
            }
        }
        MazeGenerator();
    }

    public ArrayList<MazeGrid> FreshMaze(MazeGrid cell) { // ArrayList of the neighbors that have all its walls intact
        // and that haven't been visited
        ArrayList<MazeGrid> neighbors = new ArrayList<MazeGrid>();
        int i = cell.i;
        int j = cell.j;

        if (j - 1 >= 0 && maze[i][j - 1].allLineUp() // West neighbor
                && !maze[i][j - 1].isDiscover())
            neighbors.add(maze[i][j - 1]);
        if (j + 1 < size && maze[i][j + 1].allLineUp() // East neighbor
                && !maze[i][j + 1].isDiscover())
            neighbors.add(maze[i][j + 1]);
        if (i - 1 >= 0 && maze[i - 1][j].allLineUp() // North neighbor
                && !maze[i - 1][j].isDiscover())
            neighbors.add(maze[i - 1][j]);
        if (i + 1 < size && maze[i + 1][j].allLineUp() // South neighbor
                && !maze[i + 1][j].isDiscover())
            neighbors.add(maze[i + 1][j]);

        return neighbors;
        // 			i - 1
        // j - 1 	[i]/[j] 	j + 1
        // 			i + 1
    }

    // Method generates a perfect maze based off pseudocode in project description
    public void MazeGenerator() {
        Stack<MazeGrid> stack = new Stack<MazeGrid>(); // Creating a CellStack to hold list of cell locations
        int TotalCells = size * size; // set TotalCells = number of cells in the grid
        MazeGrid CurrentCell = maze[0][0]; // choose the starting cell and call it CurrentCell
        CurrentCell.setDiscover();
        int VisitedCells = 1; // set VisitedCells = 1

        while (VisitedCells < TotalCells) {
            ArrayList<MazeGrid> neighbors = FreshMaze(CurrentCell); // find all neighbors of CurrentCell with all walls
            // intact
            if (!neighbors.isEmpty()) { // if (one or more found choose one at random)
                int index = randomGen.nextInt(neighbors.size());
                MazeGrid cell = neighbors.get(index);
                CurrentCell.breakLine(cell); // knock down the wall between it and CurrentCell
                stack.push(CurrentCell); // push CurrentCell location on the CellStack
                CurrentCell = cell; // make the new cell CurrentCell
                CurrentCell.setDiscover();
                VisitedCells++; // add 1 to VisitedCells
            } else if (!stack.isEmpty())
                CurrentCell = stack.pop(); // pop the most recent cell entry off the CellStack, make it CurrentCell
        }
    }

    @Override
    public String toString() { // The overriding of the toString method prints the structure of the maze
        String[][] chars = new String[size * 2 + 1][size * 2 + 1];
        String space = "";
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars.length; j++) {
                MazeGrid cell = null; // Cell is null if there isn't a cell there
                if (i % 2 == 1 && j % 2 == 1)
                    cell = maze[i / 2][j / 2];
                if ((i == 0 && j == 1) || (i == size * 2 && j == size * 2 - 1)) // Space for the start and end of maze
                    chars[i][j] = "  ";
                else if (chars[i][j] == null && i % 2 == 0 && j % 2 == 0) // '+' for the corners of the maze
                    chars[i][j] = "+";
                else if (i == 0 || i == chars.length - 1) // '--' For the very top and bottom row
                    chars[i][j] = "--";
                else if (i % 2 == 1 && (j == 0 || j == chars[0].length - 1)) // '|' For the very left and right column
                    chars[i][j] = "|";
                else if (cell != null) {
                    if (cell.westLine)
                        chars[i][j - 1] = "|"; // '|' For the west line column
                    else
                        chars[i][j - 1] = " "; // ' ' For the west line break
                    if (cell.eastLine)
                        chars[i][j + 1] = "|"; // '|' For the east line column
                    else
                        chars[i][j + 1] = " "; // ' ' For the east line break
                    if (cell.northLine)
                        chars[i - 1][j] = "--"; // '--' For north of the cell
                    if (cell.southLine)
                        chars[i + 1][j] = "--"; // '--' For south of the cell

                    chars[i][j] = "  "; // ' ' Cells
                } else
                    chars[i][j] = "  "; // ' ' Row line break
            }
        }
        for (int i = 0; i < chars.length; i++) { // Making a space for the outside right edge of the wall
            for (int j = 0; j < chars.length; j++)
                space += chars[i][j];
            space += "\n";
        }
        return space;

    }

}