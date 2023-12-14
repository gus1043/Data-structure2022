package design.test;

import java.sql.Connection;

import design.beans.HelperFacade;
import design.beans.MySqlHelper;
import design.beans.OracleHelper;

public class FacadePatternTest {

	public static void main(String[] args) {
		String tableName = "Employee";

		// Generating MySql HTML report and Oracle PDF report without using Facade
		Connection con = MySqlHelper.getMySqlDBConnection();
		MySqlHelper mySqlHelper = new MySqlHelper();
		mySqlHelper.generateMySqlHTMLReport(tableName, con);
		System.out.println("Generated MySql HTML report for table: " + tableName);

		Connection con1 = OracleHelper.getOracleDBConnection();
		OracleHelper oracleHelper = new OracleHelper();
		oracleHelper.generateOraclePDFReport(tableName, con1);
		System.out.println("Generated Oracle PDF report for table: " + tableName);

		// Generating MySql HTML report and Oracle PDF report using Facade
		HelperFacade.generateReport(HelperFacade.DBTypes.MYSQL, HelperFacade.ReportTypes.HTML, tableName);
		System.out.println("Generated MySql HTML report using Facade for table: " + tableName);

		HelperFacade.generateReport(HelperFacade.DBTypes.ORACLE, HelperFacade.ReportTypes.PDF, tableName);
		System.out.println("Generated Oracle PDF report using Facade for table: " + tableName);
	}

}
