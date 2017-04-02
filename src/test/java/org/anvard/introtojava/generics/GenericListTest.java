package org.anvard.introtojava.generics;

import org.anvard.introtojava.generics.GenericList;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.junit.*;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by andywaz on 2017-04-01.
 */

@RunWith(MockitoJUnitRunner.class)
public class GenericListTest {
    List<Integer> numberList=new ArrayList<Integer>();

    @Before
    public void setUp(){
        numberList.add( 4 );
        numberList.add( 6 );
    }

    @Test
    public void addNumberInList(){
        int result = GenericList.sum( numberList );
        Assert.assertNotNull( result );
        Assert.assertEquals( result,10 );
    }

    @Test
    public void getSortedCharacterList(){
        List<String> myList =
                Arrays.asList("a1", "a2", "b1", "c2", "c1");
        List<String> result= GenericList.getSortedCharacters(myList);
        Assert.assertEquals( result.get(1), "C2" );

    }
}
