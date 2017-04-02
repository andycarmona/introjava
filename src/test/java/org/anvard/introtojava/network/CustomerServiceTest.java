package org.anvard.introtojava.network;

import org.anvard.introtojava.Customer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.AdditionalAnswers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;

/**
 * Created by andywaz on 2017-04-02.
 */
@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {


    @Mock
    private CustomerService Cs;

    @Before
    public void setUp() {

        MockitoAnnotations.initMocks(this);

        Mockito.when(Cs.getCustomer(anyLong()))
                .thenReturn("George")
                .thenCallRealMethod()
        .thenThrow( IllegalStateException.class);
    }

    @Test
    public void getAllCustomers() {

        String result = Cs.getAllCustomers();
        String[] resultArray = result.split( "\n" );

        Assert.assertNotNull( result );
        Assert.assertEquals( resultArray[1].contains( "George" ), true );
    }

    @Test
    public void getCustomer() {
        Cs = new CustomerService();
        String result1 = Cs.getCustomer( 100 );
        String result2 = Cs.getCustomer( 101 );
        String result3 = Cs.getCustomer( -1 );
        Assert.assertEquals( result1.contains( "George" ), true );
        Assert.assertEquals( result2.contains( "John" ), true );


    }
}
