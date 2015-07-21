//==============================================================
//
//  Title:       <application title>
//  Course:      CSC 5991 – Mobile Application Development
//  Application: <number>
//  Author:      <author>
//  Date:        <date>
//  Description:
//  	<brief description of application including its inputs,
//  processing, and outputs>
//
//==============================================================
package wsu.csc5991.qanddfinance;

//Import Android packages
import wsu.csc5991.qanddfinance.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View; 
import android.widget.Button;
import android.widget.TextView;






// Import Java packages
import java.text.DecimalFormat;
import java.util.Calendar;

//--------------------------------------------------------------
// class ActMain
//--------------------------------------------------------------
public class TaxAct extends Activity
{

    //----------------------------------------------------------------
    // Constants
    //----------------------------------------------------------------

	// Declare application constants
	private static final String APP_NAME = "TemplateMain";
	private static final String APP_VERSION = "1.0";

    // Declare format constants
    private static final DecimalFormat FORMAT_TIME_SEGMENT =
    		new DecimalFormat("00");
    private static final DecimalFormat FORMAT_YEAR_SEGMENT = 
    		new DecimalFormat("0000");

    //----------------------------------------------------------------
    // Variables
    //----------------------------------------------------------------

    // Declare variables
   

    //----------------------------------------------------------------
    // Activity overrides
    //----------------------------------------------------------------

    //----------------------------------------------------------------
    // onCreate
    //----------------------------------------------------------------
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
    	
		super.onCreate(savedInstanceState);
		setContentView(R.layout.laytax);
		
        //Get the intent from previous page
		Intent intent = getIntent();
        double mySalary = intent.getDoubleExtra("My Salary", 0);
        Intent intent1 = getIntent();
        double spouseSalary = intent1.getDoubleExtra("Spouse Salary", 0);
        
        //Compute Salary After tax
        Shared.Data.mySalaryAfterTax = mySalary - (mySalary*(Shared.Data.federalTax/100)) - (mySalary*(Shared.Data.stateTax/100));
        Shared.Data.spouseSalaryAfterTax = spouseSalary - (spouseSalary*(Shared.Data.federalTax/100)) - (spouseSalary*(Shared.Data.stateTax/100));
        Shared.Data.combinedAfterTax = (Shared.Data.mySalaryAfterTax) + (Shared.Data.spouseSalaryAfterTax);
        
        //Displays the intent on the page
        TextView displayMySalary = (TextView) findViewById(R.id.tvSalary1);
        displayMySalary.setText("" + Shared.Data.mySalaryAfterTax);
        TextView displaySpouseSalary = (TextView) findViewById(R.id.tvSpouseSalary1);
        displaySpouseSalary.setText("" + Shared.Data.spouseSalaryAfterTax);
        TextView displayCombined = (TextView) findViewById(R.id.tvCombined1);
        displayCombined.setText("" + Shared.Data.combinedAfterTax);
        
        //Transfer Data to next pages
        transferToForecast();
        transferToAdvisor();
	
	}
	
	private void transferToForecast() {
		Button btn = (Button) findViewById(R.id.btnForecast);
		btn.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				//Transfer Data to next activity
				Intent intent = new Intent(getApplicationContext(), ForecastAct.class);
				intent.putExtra("My Salary After Tax", Shared.Data.mySalaryAfterTax);
				intent.putExtra("Spouse Salary After Tax", Shared.Data.spouseSalaryAfterTax);
				intent.putExtra("Combined Salary After Tax", Shared.Data.combinedAfterTax);
				startActivity(intent);
			}
		});
	}
	
	private void transferToAdvisor() {
		Button btn = (Button) findViewById(R.id.btnAdvisor);
		btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// Transfer Data to next activity
				Intent intent = new Intent(getApplicationContext(), AdvisorAct.class);
				intent.putExtra("My Salary After Tax", Shared.Data.mySalaryAfterTax);
				intent.putExtra("Spouse Salary After Tax", Shared.Data.spouseSalaryAfterTax);
				intent.putExtra("Combined Salary After Tax", Shared.Data.combinedAfterTax);
				startActivity(intent);
			}
		});
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu){
		getMenuInflater().inflate(R.menu.tax, menu);
		return true;
	}
}