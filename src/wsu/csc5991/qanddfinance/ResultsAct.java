package wsu.csc5991.qanddfinance;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class ResultsAct extends Activity {
	
	//Global Variables
	
	private int myAge;
	
	private double inflationValue = 0;

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
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layresults);
		
		
		double retirementSavings = Shared.Data.MonthlyRetire*12;
		for (int i=1; i<(Shared.Data.retireAge - Shared.Data.UserAge); i++)
		{
			inflationValue = (retirementSavings + inflationValue); 
			inflationValue = inflationValue - (inflationValue * 0.0322);
			//retirementSavings = retirementSavings - (retirementSavings*0.0322);
			
		}
		
		//Display the values
		TextView displayMonthlyRetirement = (TextView) findViewById(R.id.tvMonthlyRetire1);
		displayMonthlyRetirement.setText("" + DoubleToFormatedString (inflationValue));
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.results, menu);
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
}
