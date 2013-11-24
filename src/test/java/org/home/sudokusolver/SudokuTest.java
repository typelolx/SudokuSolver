package org.home.sudokusolver;

import junit.framework.Assert;
import org.junit.Test;

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

        new Sudoku(arr);

    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgExcWhenInitUnknowArray() {
        Integer[][] arr = {{2, 2}, {1, 1}};

        new Sudoku(arr);
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

    @Test
    public void shouldReturnCorrectPartViewWhenInit4Dimension() {
        Integer[][] arr =
                {{1, 2, 3, 4},
                        {2, 3, 4, 1},
                        {3, 4, 1, 2},
                        {4, 1, 2, 3}};
        Integer[][] parts = {
                {1, 2, 2, 3}, {3, 4, 4, 1}, {3, 4, 4, 1}, {1, 2, 2, 3}
        };

        Sudoku sudoku = new Sudoku(arr);

        String partsString = "{";
        for (Integer[] ar : parts) {
            partsString += "{";
            for (Integer i : ar) {
                partsString += i + ",";
            }
            partsString += "},";
        }
        partsString += "}";
        assertEquals(partsString, sudokuToStringByParts(sudoku));
    }

    @Test
    public void shouldReturnCorrectPartViewWhenInit9Dimension() {
        Integer[][] arr = {
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {2, 3, 4, 5, 6, 7, 8, 9, 1},
                {3, 4, 5, 6, 7, 8, 9, 1, 2},
                {4, 5, 6, 7, 8, 9, 1, 2, 3},
                {5, 6, 7, 8, 9, 1, 2, 3, 4},
                {6, 7, 8, 9, 1, 2, 3, 4, 5},
                {7, 8, 9, 1, 2, 3, 4, 5, 6},
                {8, 9, 1, 2, 3, 4, 5, 6, 7},
                {9, 1, 2, 3, 4, 5, 6, 7, 8}
        };

        Integer[][] parts = {
                {1, 2, 3, 2, 3, 4, 3, 4, 5}, {4, 5, 6, 5, 6, 7, 6, 7, 8}, {7, 8, 9, 8, 9, 1, 9, 1, 2},
                {4, 5, 6, 5, 6, 7, 6, 7, 8}, {7, 8, 9, 8, 9, 1, 9, 1, 2}, {1, 2, 3, 2, 3, 4, 3, 4, 5},
                {7, 8, 9, 8, 9, 1, 9, 1, 2}, {1, 2, 3, 2, 3, 4, 3, 4, 5}, {4, 5, 6, 5, 6, 7, 6, 7, 8}
        };

        Sudoku sudoku = new Sudoku(arr);

        String partsString = "{";
        for (Integer[] ar : parts) {
            partsString += "{";
            for (Integer i : ar) {
                partsString += i + ",";
            }
            partsString += "},";
        }
        partsString += "}";
        assertEquals(partsString, sudokuToStringByParts(sudoku));
    }


    private String sudokuToStringByParts(Sudoku sudoku) {
        String valuesString = "{";
        for (Field[] ar : sudoku.getPartView()) {
            valuesString += "{";
            for (Field i : ar) {
                valuesString += i.getValue() + ",";
            }
            valuesString += "},";
        }
        valuesString += "}";

        return valuesString;
    }


}
