package org.home.sudokusolver;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Type on 23.11.13.
 */
public class Sudoku {

    public static Integer[] AVAILABLE_DIMENSIONS = new Integer[]{4,9,16,25,36,49};

    private int dimension;

    public Field[][] fields;



    public Sudoku(Integer[][] values) throws IllegalArgumentException{

        obtainDimension(values);

        fields = new Field[dimension][dimension];

        for (int i = 0; i < dimension; ++i) {
            for (int j = 0; j < dimension; ++j) {
                Field field = new Field(i, j);
                field.setValue(values[i][j]);
                fields[i][j] = field;
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

    public Field getField(int row, int collumn){
        return fields[row][collumn];
    }

    public Field[] getRow(int row){
        return fields[row];
    }

    public Field[] getColumn(int column){
        Field[] colFields = new Field[dimension];
        for(int i = 0;i<dimension;++i){
            colFields[i] = fields[i][column];
        }
        return colFields;
    }


}
