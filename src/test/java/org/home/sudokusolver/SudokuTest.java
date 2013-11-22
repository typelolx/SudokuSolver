package org.home.sudokusolver;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by Type on 23.11.13.
 */
public class SudokuTest extends Assert {

    @Test
    public void shouldSetDimensionWhenInit() {

        Integer[][] arr =
                {{1, 2, 3, 4},
                        {2, 3, 4, 1},
                        {3, 4, 1, 2},
                        {4, 1, 2, 3}};
        Sudoku sudoku = new Sudoku(arr);

        assertEquals(sudoku.getDimension(), 4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgExcWhenInitWronArray() {
        Integer[][] arr = {{1}, {1, 2}, {3, 4, 5}};

        Sudoku sudoku = new Sudoku(arr);

    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgExcWhenInitUnknowArray() {
        Integer[][] arr = {{2, 2}, {1, 1}};

        Sudoku sudoku = new Sudoku(arr);
    }

    @Test
    public void shouldFieldHasValueWhenInitWithValues() {
        Integer[][] arr =
                {{1, 2, 3, 4},
                        {2, 3, 4, 1},
                        {3, 4, 1, 2},
                        {4, 1, 2, 3}};

        Sudoku sudoku = new Sudoku(arr);

        assertEquals(sudoku.getField(0, 0).getValue(), new Integer(1));
    }

    @Test
    public void shouldFieldHasNullValueWhenInitWithNull() {
        Integer[][] arr =
                {{null, 2, 3, 4},
                        {2, 3, 4, 1},
                        {3, 4, 1, 2},
                        {4, 1, 2, 3}};

        Sudoku sudoku = new Sudoku(arr);

        assertNull(sudoku.getField(0, 0).getValue());
    }


}
