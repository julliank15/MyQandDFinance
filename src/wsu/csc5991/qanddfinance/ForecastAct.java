//==============================================================
//
//  Title:       <application title>
//  Course:      CSC 5991 � Mobile Application Development
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
import android.widget.EditText;
import android.widget.TextView;










// Import Java packages
import java.text.DecimalFormat;
import java.util.Calendar;

//--------------------------------------------------------------
// class ActMain
//--------------------------------------------------------------
public class ForecastAct extends Activity
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
		setContentView(R.layout.layforecast);
	  
        //Transfer Data to next pages
        transferToResults();
	
	}
	
	private void transferToResults() {
		Button btn = (Button) findViewById(R.id.btnForecast);
		btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//Get the information from the EditTexts
				EditText retirementTextEntry = (EditText) findViewById(R.id.etRetire1);
				String retirementUserData = retirementTextEntry.getText().toString();
				Shared.Data.MonthlyRetire = Integer.parseInt(retirementUserData);
				EditText kidsTextEntry = (EditText) findViewById(R.id.etKids1);
				String kidsUserData = kidsTextEntry.getText().toString();
				Shared.Data.MonthlyKids = Integer.parseInt(kidsUserData);
				
				// Transfer Data to next activity
				Intent intent = new Intent(getApplicationContext(), ResultsAct.class);
				intent.putExtra("Monthly Retirement", Shared.Data.MonthlyRetire);
				intent.putExtra("Monthly Kids", Shared.Data.MonthlyKids);
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