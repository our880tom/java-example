package com.example.junit;

import junit.framework.TestSuite;

public class TestSuiteTester {

	public static junit.framework.Test suite() {
		TestSuite suite = new TestSuite();
		suite.addTestSuite(MyTest.class);
		return suite;
	}
}

