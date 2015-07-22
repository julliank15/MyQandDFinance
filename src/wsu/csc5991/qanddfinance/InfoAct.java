package wsu.csc5991.qanddfinance;

import java.text.DecimalFormat;
import java.util.Calendar;

import wsu.csc5991.qanddfinance.R;
import android.app.Activity;
import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InfoAct extends Activity {
	// ----------------------------------------------------------------
	// Constants
	// ----------------------------------------------------------------

	// Declare application constants
	private static final String APP_NAME = "TemplateMain";
	private static final String APP_VERSION = "1.0";

	// Declare format constants
	private static final DecimalFormat FORMAT_TIME_SEGMENT = new DecimalFormat(
			"00");
	private static final DecimalFormat FORMAT_YEAR_SEGMENT = new DecimalFormat(
			"0000");

	// ----------------------------------------------------------------
	// onCreate
	// ----------------------------------------------------------------
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		System.out.println("### DEBUG ### onCreate started at " + currentTime()
				+ ".");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layinfo);

		setUpDoMathButton();
		
	}

	private void setUpDoMathButton() {
		Button btnSubmit = (Button) findViewById(R.id.btnSubmit);
		btnSubmit.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				
				
				// Define controls and variables
				EditText salaryTextEntry = (EditText) findViewById(R.id.etSalary);
				String salaryUserData = salaryTextEntry.getText().toString();
				Shared.Data.Salary = Double.parseDouble(salaryUserData);
				EditText ageTextEntry = (EditText) findViewById(R.id.etAge);
				String ageUserData = ageTextEntry.getText().toString();
				Shared.Data.UserAge = Integer.parseInt(ageUserData);
				EditText spouseSalaryTextEntry = (EditText) findViewById(R.id.etSpouseSalary);
				String spouseSalaryUserData = spouseSalaryTextEntry.getText().toString();
				Shared.Data.SpouseSalary = Double.parseDouble(spouseSalaryUserData);
				

				Intent intent = new Intent(getApplicationContext(), TaxAct.class);
				intent.putExtra("My Salary", Shared.Data.Salary);
				intent.putExtra("My Age", Shared.Data.UserAge);
				intent.putExtra("Spouse Salary", Shared.Data.SpouseSalary);
				// intent.putExtra("Parameter Name1", userNumber1);
				startActivity(intent);
			}
		});
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.info, menu);
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
