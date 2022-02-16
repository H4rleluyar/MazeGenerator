package Maze;

import java.util.ArrayList;

public class DFS extends MazeGen {

    private ArrayList<MazeGrid> DFSCell;
    private boolean printShortDFS;
    private boolean printDFS;

    public DFS(int size) {
        super(size);
        DFSCell = new ArrayList<MazeGrid>();
        printDFS = false;
        printShortDFS = false;
    }

    public String printDFS() { // Returns the DFS maze solution
        printDFS = true;
        String s = this.toString();
        printDFS = false;
        return s;
    }

    public String printShortDFS() { // Returns the shortest DFS path
        printShortDFS = true;
        for (int x = DFSCell.size() - 2; x > -1; x--)
            if (DFSCell.get(x).finishTime < DFSCell.get(x + 1).finishTime) // compare the time of cell to see which path
                // to choose for shortest time
                DFSCell.remove(x);
        String s = this.toString();
        printShortDFS = false;
        return s;
    }

    public void depthFirstSearch() { // Depth-First search solution to solve the maze
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                maze[i][j].color = LineColor.WHITE; // White for indicating initial vertices
        time = 0;
        for (MazeGrid[] arr : maze)
            for (MazeGrid cell : arr)
                if (cell.color == LineColor.WHITE)
                    dfsVisit(cell);
        stop = false;
    }

    private void dfsVisit(MazeGrid cell) { // Using DFS to recursively visit a cell
        if (cell.equals(new MazeGrid(size - 1, size - 1))) { // keeps track of nodes that are visited through a
            // depth-first search
            stop = true;
            DFSCell.add(cell);
        }
        if (!stop)
            DFSCell.add(cell);
        cell.color = LineColor.GRAY;
        time++; // increase the time base on when cell found
        cell.discoverTime = time; // set the discover time for the cell
        for (MazeGrid n : cell.neighbors) // search all neighbors of the nodes
            if (n.color == LineColor.WHITE)
                dfsVisit(n);

        cell.color = LineColor.BLACK;
        time++;
        cell.finishTime = time;
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

                    Integer time = (Integer) cell.discoverTime;
                    Integer visited = cell.numVisited;

                    if (printDFS && time < 10 && DFSCell.contains(cell))
                        chars[i][j] = time.toString() + " ";
                    else if (printDFS && time >= 10 && DFSCell.contains(cell))
                        chars[i][j] = time.toString() + "";
                    else if (printShortDFS && DFSCell.contains(cell)) // '##' For the shortest path for DFS
                        chars[i][j] = "##";
                    else
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
