package org.home.sudokusolver;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Type on 23.11.13.
 */
public class Sudoku {

    public static Integer[] AVAILABLE_DIMENSIONS = new Integer[]{2,4,9,16,25,36,49};

    private int dimension;

    public Field[][] fields;



    public Sudoku(Integer[][] values) throws IllegalArgumentException{

        obtainDimension(values);

        for (int i = 0; i < values.length; ++i) {
            for (int j = 0; i < values[i].length; ++j) {
                Field field = new Field(i, j);
                field.setValue(values[i][j]);
            }
        }
    }

    public int getDimension(){
        return dimension;
    }

    private void obtainDimension(Integer[][] values){

        dimension = values.length;

        for (Integer[] value : values) {
            if (value.length != dimension) throw new IllegalArgumentException();
        }

        if(!Arrays.asList(AVAILABLE_DIMENSIONS).contains(dimension)){
            throw  new IllegalArgumentException();
        }
    }



}
