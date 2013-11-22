package org.home.sudokusolver;


import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;

public class FieldTest extends Assert{


    @Before
    public void setUp(){

    }

    @Test
    public void shouldSetValueWhenSettingPossibleValuesWithOneEntry(){

        List<Integer> integers = new ArrayList<Integer>();
        integers.add(0);

        Field field = new Field(0,0);

        field.setPossibleValues(integers);

        assertNotNull(field.getValue());
    }

    @Test
    public void shouldntSetValueWhenSettingPossibleValuesWithMultEntries(){
        List<Integer> integers = new ArrayList<Integer>();
        integers.add(0);
        integers.add(1);


        Field field = new Field(0,0);

        field.setPossibleValues(integers);

        assertTrue(field.getValue()==null);
    }

    @Test
    public void shouldAddOnePossibleValuesWhenSettingNotNullValue(){
        Field field = new Field(0,0);
        field.setValue(1);

        assertEquals(field.getPossibleValues().size(),1);

    }

}
