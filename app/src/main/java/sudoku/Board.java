package sudoku;

import java.io.InputStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Board
{
    private int[][] board;

    public Board()
    {
        board = new int[9][9];
    }

    public static Board loadBoard(InputStream in)
    {
        Board board = new Board();
        Scanner scanner = new Scanner(in);
        for (int row = 0; row < 9; row++)
        {
            for (int col = 0; col < 9; col++)
            {
                board.setCell(row, col, scanner.nextInt());
            }
        }
        scanner.close();
        return board;
    }

    public boolean isLegal(int row, int col, int value)
    {
        // TODO: check if this is a legal value for the cell
        // it should be between 1 and 9 but also be one of the possible values
        // based on the other values in the row, column, and 3x3 square
        return true;
    }

    public void setCell(int row, int col, int value)
    {
        // TODO: throw exception if the value is not between 1 and 9
        // TODO: throw exception if the value is not a possible value 
        // based on other values in the sudoku grid
        board[row][col] = value;
    }

    public int getCell(int row, int col)
    {
        return board[row][col];
    }

    public boolean hasValue(int row, int col)
    {
        return getCell(row, col) > 0;
    }

    public Set<Integer> getPossibleValues(int row, int col)
    {
        Set<Integer> possibleValues = new HashSet<>();
        for (int i = 1; i <= 9; i++)
        {
            possibleValues.add(i);
        }
        // check the row
        for (int c = 0; c < 9; c++)
        {
            possibleValues.remove(getCell(row, c));
        }
        // check the column
        for (int r = 0; r < 9; r++)
        {
            possibleValues.remove(getCell(r, col));
        }
        // check the 3x3 square
        int startRow = row / 3 * 3;
        int startCol = col / 3 * 3;
        for (int r = startRow; r < startRow + 3; r++)
        {
            for (int c = startCol; c < startCol + 3; c++)
            {
                possibleValues.remove(getCell(r, c));
            }
        }
        return possibleValues;
    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < 9; row++)
        {
            for (int col = 0; col < 9; col++)
            {
                sb.append(getCell(row, col));
                if (col < 8)
                {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

}
