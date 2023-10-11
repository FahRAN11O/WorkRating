package com.wr.tests;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.wr.operations.WorkRatingDB;
import com.wr.servlets.Inscription;

public class WorkRatingDBTest {
	WorkRatingDB workRatingDb;
	
	@Before
	public void initializeDb() throws ClassNotFoundException {
		Inscription inscription = new Inscription();
		workRatingDb = new WorkRatingDB();	

	}
	
	@After
	public void closeData() throws Exception {
		workRatingDb.closeDB();
	}

	@Test
	public void testGetRequest() {
	}

	@Test
	public void testSetRequest() {
	}

	@Test
	public void testWorkRatingDB() {
		
	}

	@Test
	public void testConnectDB() throws SQLException {
		assertTrue(!workRatingDb.getConnection().isClosed());
	}

	@Test
	public void testCloseDB() {
	}

	@Test
	public void testAjoutUtilisateur() {
	}

}
