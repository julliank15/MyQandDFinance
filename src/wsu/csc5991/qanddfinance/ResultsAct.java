package wsu.csc5991.qanddfinance;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class ResultsAct extends Activity {
	
	//Global Variables
	private int monthlyKids;
	private int myAge;
	private int kid1Age;
	private int kid2Age;
	private int kid3Age;
	private int kid4Age;
	private int kid5Age;
	private double inflationValue = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layresults);
		
		//Get the intent from previous pages
		Intent intent = getIntent();
		monthlyKids = intent.getIntExtra("Monthly Kids", 0);
		Intent intent1 = getIntent();
		kid1Age = intent1.getIntExtra("Kid1 Age", 0);
		Intent intent2 = getIntent();
		kid2Age = intent2.getIntExtra("Kid2 Age", 0);
		Intent intent3 = getIntent();
		kid3Age = intent3.getIntExtra("Kid3 Age", 0);
		Intent intent4 = getIntent();
		kid4Age = intent4.getIntExtra("Kid4 Age", 0);
		Intent intent5 = getIntent();
		kid5Age = intent5.getIntExtra("Kid5 Age", 0);
		Intent intent6 = getIntent();
		myAge = intent6.getIntExtra("My Age", 0);
		
		//Compute Savings
		int kid1Savings = ((18 - kid1Age) * 12) * monthlyKids; 
		int kid2Savings = ((18 - kid2Age) * 12) * monthlyKids;
		int kid3Savings = ((18 - kid3Age) * 12) * monthlyKids;
		int kid4Savings = ((18 - kid4Age) * 12) * monthlyKids;
		int kid5Savings = ((18 - kid5Age) * 12) * monthlyKids;
		double retirementSavings = Shared.Data.MonthlyRetire*12;
		for (int i=1; i<(Shared.Data.retireAge - Shared.Data.UserAge); i++)
		{
			inflationValue = (retirementSavings + inflationValue); 
			inflationValue = inflationValue - (inflationValue * 0.0322);
			//retirementSavings = retirementSavings - (retirementSavings*0.0322);
			
		}
		
		//Display the values
		TextView displayMonthlyRetirement = (TextView) findViewById(R.id.tvMonthlyRetire1);
		displayMonthlyRetirement.setText("" + inflationValue);
		TextView displayKid1Age = (TextView) findViewById(R.id.tvKid1Savings1);
		displayKid1Age.setText("" + kid1Savings);
		TextView displayKid2Age = (TextView) findViewById(R.id.tvKid2Savings1);
		displayKid2Age.setText("" + kid2Savings);
		TextView displayKid3Age = (TextView) findViewById(R.id.tvKid3Savings1);
		displayKid3Age.setText("" + kid3Savings);
		TextView displayKid4Age = (TextView) findViewById(R.id.tvKid4Savings1);
		displayKid4Age.setText("" + kid4Savings);
		TextView displayKid5Age = (TextView) findViewById(R.id.tvKid5Savings1);
		displayKid5Age.setText("" + kid5Savings);
		
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
