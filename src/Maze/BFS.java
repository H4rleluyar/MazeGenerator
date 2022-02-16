package Maze;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS extends MazeGen {

    private ArrayList<MazeGrid> BFSCell; // the MazeGrid for BFS version of the maze
    private boolean printShortBFS;
    private boolean printBFS;

    /**
     *
     * @param size to enter the size for the maze
     */
    public BFS(int size) {
        super(size); //call super to get constructor from Maze Gen to make a maze
        BFSCell = new ArrayList<MazeGrid>(); //create new MazeGrid for BFS
        printBFS = false; //set to f
        printShortBFS = false;
    }

    public String printBFS() { // Returns BFS maze solution
        printBFS = true;
        String s = this.toString();
        printBFS = false;
        return s;
    }

    public String printShortBFS() { // Returns the shortest BFS path
        BFSCell = new ArrayList<MazeGrid>();
        MazeGrid cell = maze[size - 1][size - 1];
        while (cell != null) {
            BFSCell.add(cell);
            cell = cell.previousCell;
        }
        printShortBFS = true;
        String s = this.toString();
        printShortBFS = false;
        return s;
    }

    public void breadthFirstSearch() {
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                maze[i][j].color = LineColor.WHITE;
        Queue<MazeGrid> queue = new LinkedList<MazeGrid>();
        // choose first node as starting node
        int visit = 0;
        MazeGrid cell = maze[0][0];
        cell.distance = 0;
        cell.color = LineColor.GRAY;
        cell.numVisited = visit;
        visit++;
        BFSCell.add(cell);
        queue.add(cell);
        while (queue.size() != 0) {
            cell = queue.remove();
            if (cell.i == size - 1 && cell.j == size - 1)
                stop = true;
            for (MazeGrid v : cell.neighbors)
                if (v.color == LineColor.WHITE) {
                    v.color = LineColor.GRAY;
                    v.numVisited = visit;
                    visit++;
                    v.distance = cell.distance + 1;
                    v.previousCell = cell;
                    if (v.i == size - 1 && v.j == size - 1)
                        stop = true;
                    if (!stop)
                        BFSCell.add(v);
                    queue.add(v);
                }

            cell.color = LineColor.BLACK;
        }
        BFSCell.add(maze[size - 1][size - 1]);

    }

    @Override
    public String toString() { // The overriding of the toString method prints the structure of the maze
        String[][] chars = new String[size * 2 + 1][size * 2 + 1];
        String s = "";
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

                    if (printBFS && visited < 10 && BFSCell.contains(cell))
                        chars[i][j] = visited.toString() + " ";
                    else if (printBFS && visited >= 10 && BFSCell.contains(cell))
                        chars[i][j] = visited.toString() + "";
                    else if (printShortBFS && BFSCell.contains(cell)) // '##' For the shortest path for BFS
                        chars[i][j] = "##";
                    else
                        chars[i][j] = "  "; // ' ' Cells
                } else
                    chars[i][j] = "  "; // ' ' Row line break
            }
        }
        for (int i = 0; i < chars.length; i++) { // Making a space for the outside right edge of the wall
            for (int j = 0; j < chars.length; j++)
                s += chars[i][j];
            s += "\n";
        }
        return s;

    }
}
