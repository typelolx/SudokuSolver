package org.home.sudokusolver;


import java.util.Arrays;


public class Sudoku {

    public static final Integer[] AVAILABLE_DIMENSIONS = new Integer[]{4,9,16,25,36,49};

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
            if (value.length != dimension) throw new IllegalArgumentException("Not square matrix!");
        }

        if(!Arrays.asList(AVAILABLE_DIMENSIONS).contains(dimension)){
            throw  new IllegalArgumentException("Unsupportable dimension");
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

    public Field[][] getPartView(){
        Field[][] parts = new Field[dimension][dimension];

        int rowsInPath = (int) Math.sqrt(dimension);

        for(int partNum = 0; partNum < dimension; ++partNum){
              for(int i = 0; i < rowsInPath; ++i){
                  for(int j = 0; j < rowsInPath;++j){
                      int rowNum = (partNum / rowsInPath) * rowsInPath + i;
                      int colNum = ((partNum ) % rowsInPath) * rowsInPath + j;
                      parts[partNum][i*rowsInPath + j] = fields[rowNum][colNum];
                  }
              }
        }

        return parts;
    }

    public Field[] getPart(int partCount){

        if(partCount > dimension || partCount < 1) throw new IllegalArgumentException("Wrong part id");

        return getPartView()[partCount-1];

    }

}
