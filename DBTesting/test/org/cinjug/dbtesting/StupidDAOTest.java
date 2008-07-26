package org.cinjug.dbtesting;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@ContextConfiguration(locations={"classpath:dbtesting.xml"})
@TransactionConfiguration(transactionManager="txMgr")
public class StupidDAOTest extends AbstractTransactionalTestNGSpringContextTests {
	
	public StupidDAOTest() {
		super();
	}
	
	private int beforeRowCountOutsideTx;
	private int beforeRowCountInsideTx;
	
	@Autowired
	private StupidDAO targetDAO;

	@BeforeTransaction
	public void storeRowCount() {
        simpleJdbcTemplate.update("CREATE TABLE stupid_data (id INTEGER IDENTITY, name VARCHAR NOT NULL, inserted_date DATE NOT NULL)");
        beforeRowCountOutsideTx = super.countRowsInTable("stupid_data");
	}

	@BeforeMethod
	public void insertRowAndStoreCountInTx() {
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("name", "preTest");
		args.put("ins_date", new Date());
		simpleJdbcTemplate.update("insert into stupid_data (name, inserted_date) values (:name, :ins_date)", args);
		
		beforeRowCountInsideTx = super.countRowsInTable("stupid_data");
	}
	
	@Test(groups={"functional", "integration"})
	public void testTenInserts() {
		targetDAO.insertRows(10);		
		assert(super.countRowsInTable("stupid_data") == 10 + beforeRowCountInsideTx);
	}

	@AfterMethod
	public void checkRowCountInTx() {
		assert(super.countRowsInTable("stupid_data") == 10 + beforeRowCountInsideTx);
	}
	
	@AfterTransaction
	public void checkRowCount() {
		assert(super.countRowsInTable("stupid_data") == beforeRowCountOutsideTx);
	}

/*    
    @Test(groups={"functional"})
    @NotTransactional
    public void performNonDatabaseRelatedAction() {
        assert("Todd" != "Dork");
    }

*/}
