package Maze;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

enum LineColor {
    WHITE, GRAY, BLACK;
}

//A Grid of the maze, Has 4 neighbors, North, South, West, East
public class MazeGrid {

    // all line starts with true because Grid just created
    boolean northLine, southLine, westLine, eastLine;// determine if cell has north,south,west,east line
    boolean isDiscover; // determine if cell was already discover
    LineColor color;
    ArrayList<MazeGrid> neighbors; // the cell's line
    int i; // row
    int j; // column
    int discoverTime; // the cell discoverTime
    int finishTime; // the cell finishTime
    Integer distance; //
    Integer numVisited; //
    MazeGrid previousCell; // the previous cell

    public MazeGrid(int i, int j) {
        this.northLine = this.southLine = this.westLine = this.eastLine = true; // all line accounted for
        this.isDiscover = false;
        this.i = i;
        this.j = j;
        this.neighbors = new ArrayList<MazeGrid>();
        this.color = LineColor.WHITE;
        this.discoverTime = 0;
        this.finishTime = 0;
        distance = 0;
        numVisited = 0;
        this.previousCell = null;

    }

    public void setDiscover() { // Method to setDiscover to true if the cell is discovered
        isDiscover = true;
    }

    public boolean isDiscover() { // If the cell has already been discovered it will return it
        return isDiscover;
    }

    public boolean allLineUp() { // Checks to see if all neighbors has all the lines
        return neighbors.size() == 0;
    }

    @Override
    public boolean equals(Object obj) { // Making two cells equal if they are in the same location
        if (obj == null) {
            return false;
        }
        MazeGrid m = (MazeGrid) obj;
        return m.i == i && m.j == j;
    }

//		@Override
//		public String toString(){
//			return "(" + i + ", " + j + ")";
//		}

    public void breakLine(MazeGrid cell) { // Breaks down the line between two sells and makes them neighbors
        if (cell.i == i && cell.j == j - 1) { // The cell is a west neighbor
            westLine = false;
            cell.eastLine = false;
            neighbors.add(cell);
            cell.neighbors.add(this);
        } else if (cell.i == i && cell.j == j + 1) { // The cell is a east neighbor
            eastLine = false;
            cell.westLine = false;
            neighbors.add(cell);
            cell.neighbors.add(this);
        } else if (cell.j == j && cell.i == i - 1) { // The cell is a north neighbor
            northLine = false;
            cell.southLine = false;
            neighbors.add(cell);
            cell.neighbors.add(this);
        } else if (cell.j == j && cell.i == i + 1) { // The cell is a south neighbor
            southLine = false;
            cell.northLine = false;
            neighbors.add(cell);
            cell.neighbors.add(this);
        }
    }


}
