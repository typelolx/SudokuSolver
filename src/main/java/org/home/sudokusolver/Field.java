package org.home.sudokusolver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by Type on 22.11.13.
 */
public class Field {

    private List<Integer> possibleValues;

    private final int collumn;
    private final int row;

    public Field(int row, int collumn) {
        this.row = row;
        this.collumn = collumn;

        possibleValues = new ArrayList<Integer>();
    }

    public Integer getValue() {
        if(possibleValues.size()==1){
            return possibleValues.get(0);
        }
        return null;
    }

    public void setValue(Integer v){
        if(v!=null){
            possibleValues.clear();
            possibleValues.add(v);
        }
    }

    public List<Integer> getPossibleValues() {
        return Collections.unmodifiableList(possibleValues);
    }

    public void setPossibleValues(Collection<Integer> values) {

        possibleValues.clear();
        possibleValues.addAll(values);
    }


    public int getCollumn() {
        return collumn;
    }

    public int getRow() {
        return row;
    }
}
