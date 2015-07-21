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
import android.view.MenuItem;
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
		setContentView(R.layout.laytax);
		
        //Get the intent from previous page
		Intent intent = getIntent();
        double mySalary = intent.getDoubleExtra("My Salary", 0);
        Intent intent1 = getIntent();
        double spouseSalary = intent1.getDoubleExtra("Spouse Salary", 0);
        
        //Compute Salary After tax
        Shared.Data.mySalaryAfterTax = mySalary - (mySalary*(Shared.Data.federalTax/100)) - (mySalary*(Shared.Data.stateTax/100));
        Shared.Data.spouseSalaryAfterTax = spouseSalary; // -(spouseSalary-tax);
        Shared.Data.combinedAfterTax = (Shared.Data.mySalaryAfterTax) + (Shared.Data.spouseSalaryAfterTax);
        
        //Displays the intent on the page
        TextView displayMySalary = (TextView) findViewById(R.id.tvSalary1);
        displayMySalary.setText("" + DoubleToFormatedString(Shared.Data.mySalaryAfterTax));
        TextView displaySpouseSalary = (TextView) findViewById(R.id.tvSpouseSalary1);
        displaySpouseSalary.setText("" + DoubleToFormatedString(Shared.Data.spouseSalaryAfterTax));
        TextView displayCombined = (TextView) findViewById(R.id.tvCombined1);
        displayCombined.setText("" + DoubleToFormatedString(Shared.Data.combinedAfterTax));
        
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
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	// ----------------------------------------------------------------
	// onStart
	// ----------------------------------------------------------------
	@Override
	protected void onStart() {
		System.out.println("### DEBUG ### onStart started at " + currentTime()
				+ ".");
		super.onStart();
	}

	// ----------------------------------------------------------------
	// onResume
	// ----------------------------------------------------------------
	@Override
	protected void onResume() {
		System.out.println("### DEBUG ### onResume started at " + currentTime()
				+ ".");
		super.onResume();
	}

	// ----------------------------------------------------------------
	// onPause
	// ----------------------------------------------------------------
	@Override
	protected void onPause() {
		System.out.println("### DEBUG ### onPause started at " + currentTime()
				+ ".");
		super.onPause();
	}

	// ----------------------------------------------------------------
	// onStop
	// ----------------------------------------------------------------
	@Override
	protected void onStop() {
		System.out.println("### DEBUG ### onStop started at " + currentTime()
				+ ".");
		super.onStop();
	}

	// ----------------------------------------------------------------
	// onRestart
	// ----------------------------------------------------------------
	@Override
	protected void onRestart() {
		System.out.println("### DEBUG ### onRestart started at "
				+ currentTime() + ".");
		super.onRestart();
	}

	// ----------------------------------------------------------------
	// onDestroy
	// ----------------------------------------------------------------
	@Override
	protected void onDestroy() {
		System.out.println("### DEBUG ### onDestroy started at "
				+ currentTime() + ".");
		super.onDestroy();
	}

	// ----------------------------------------------------------------
	// onBackPressed
	// The default behavior of the Android Back button is to destroy
	// the current activity but leave the application in the menu
	// list. We override it here so that the button does nothing.
	// ----------------------------------------------------------------
	@Override
	public void onBackPressed() {
		System.out.println("### DEBUG ### Back button pressed at "
				+ currentTime() + ".");
		// super.onBackPressed();
	}

	// ----------------------------------------------------------------
	// General utilities
	// ----------------------------------------------------------------

	// ----------------------------------------------------------------
	// currentTime
	// ----------------------------------------------------------------
	private String currentTime() {

		// Declare variables
		int y;
		String yStr;
		int mn;
		String mnStr;
		int d;
		String dStr;
		int h;
		String hStr;
		int mi;
		String miStr;
		int s;
		String sStr;
		Calendar timeNow;

		// Get current time
		timeNow = Calendar.getInstance();
		y = timeNow.get(Calendar.YEAR);
		mn = timeNow.get(Calendar.MONTH) + 1;
		d = timeNow.get(Calendar.DAY_OF_MONTH);
		h = timeNow.get(Calendar.HOUR_OF_DAY);
		mi = timeNow.get(Calendar.MINUTE);
		s = timeNow.get(Calendar.SECOND);

		// Format current time as string
		yStr = FORMAT_YEAR_SEGMENT.format(y);
		mnStr = FORMAT_TIME_SEGMENT.format(mn);
		dStr = FORMAT_TIME_SEGMENT.format(d);
		hStr = FORMAT_TIME_SEGMENT.format(h);
		miStr = FORMAT_TIME_SEGMENT.format(mi);
		sStr = FORMAT_TIME_SEGMENT.format(s);
		return (yStr + "-" + mnStr + dStr + ", " + hStr + ":" + miStr + ":" + sStr);

	}
}
