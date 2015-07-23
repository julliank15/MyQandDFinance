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
import java.text.DecimalFormatSymbols;
import java.util.Calendar;

//--------------------------------------------------------------
// class ActMain
//--------------------------------------------------------------
public class AdvisorAct extends Activity
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
    
    //method to format decimals to two significant figures
    private static DecimalFormatSymbols DFS;
    private static DecimalFormat myFormatter;
    public static String DoubleToFormatedString(double value) {
        DFS = new DecimalFormatSymbols();
        DFS.setDecimalSeparator('.');
        myFormatter = new DecimalFormat("#.00");
        myFormatter.setDecimalFormatSymbols(DFS);
        return myFormatter.format(value);
    }

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
		setContentView(R.layout.layadvisor);
		
        //Get the intent from previous page
		Intent intent = getIntent();
        double combinedAfterTax = intent.getDoubleExtra("Combined Salary After Tax", 0);
        
        //Compute Salary After tax
        double fixedCosts = combinedAfterTax*0.5;
        double savings = combinedAfterTax*0.2;
        double flexSpending = combinedAfterTax*0.3;
        
        //Displays the intent on the page
        TextView displayFixedCosts = (TextView) findViewById(R.id.tvFixed1);
        displayFixedCosts.setText("" + DoubleToFormatedString(fixedCosts));
        TextView displaySavings = (TextView) findViewById(R.id.tvSavings1);
        displaySavings.setText("" + DoubleToFormatedString(savings));
        TextView displayFlexSpending = (TextView) findViewById(R.id.tvFlex1);
        displayFlexSpending.setText("" + DoubleToFormatedString(flexSpending));
        
        //define enum variables for text message output
        Shared.Data.fixedCost = DoubleToFormatedString(fixedCosts);
    	Shared.Data.flexSpending = DoubleToFormatedString(flexSpending);
    	Shared.Data.savings = DoubleToFormatedString(savings);
        
        //Transfer Data to next pages
        transferToForecast();
	
	}
	
	private void transferToForecast() {
		Button btn = (Button) findViewById(R.id.btnForecast);
		btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// Transfer Data to next activity
				Intent intent = new Intent(getApplicationContext(), ForecastAct.class);
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