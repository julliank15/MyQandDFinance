//==============================================================
//
//  Class: Shared
//  Description:
//  	This class holds the shared data.
//
//==============================================================
package wsu.csc5991.qanddfinance;

import wsu.csc5991.qanddfinance.R.string;

//--------------------------------------------------------------
// enum Shared
//--------------------------------------------------------------
public enum Shared
{
 
	// Define enum value
	Data;
	 
	// Declare enum fields
	public double Salary;
	public int MonthlyRetire;
	public string FName;
	public int UserAge;
	public int SpouseAge;
	public string SpouseName;
	public double SpouseSalary;
	public double mySalaryAfterTax;
	public double spouseSalaryAfterTax;
	public double combinedAfterTax;
	public double stateTax;
	public double federalTax = 23;
	public int retireAge;
	public double inflation = 3.22;
	public String receivedMessage;
	public String fixedCost;
	public String flexSpending;
	public String savings;
	

	

}