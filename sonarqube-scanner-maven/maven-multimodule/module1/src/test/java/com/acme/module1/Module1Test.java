package com.acme.module1;

import org.junit.Assert;
import org.junit.Test; 


public class Module1Test {

private String INPUT = "13412";
	    @Test 
	    public void testLength() { 
	        Assert.assertEquals(INPUT,"13412");  
	    }
	    
	    @Test 
	    public void testLengthCopy() { 
	        Assert.assertEquals(INPUT,"13412");  
	    }
}
