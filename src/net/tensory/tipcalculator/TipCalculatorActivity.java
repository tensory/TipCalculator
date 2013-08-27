package net.tensory.tipcalculator;

import java.text.DecimalFormat;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class TipCalculatorActivity extends Activity {
	public EditText etBillAmount;
	public TextView tvTipAmount;
	public DecimalFormat currencyFormat;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tip_calculator);
		// Set up the currency display format.
		currencyFormat = new DecimalFormat("0.00");
		
		etBillAmount = (EditText) findViewById(R.id.et_bill_amount);
		tvTipAmount = (TextView) findViewById(R.id.tv_amount);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tip_calculator, menu);
		return true;
	}
	
	public void onCalculate(View v) {
		Double inputAmount = Double.valueOf(etBillAmount.getText().toString());
		Double percentage = 1.00;
		
		switch (v.getId()) {
		case R.id.btn_10percent:
			percentage = 0.1;
			break;
		case R.id.btn_15percent:
			percentage = 0.15;
			break;
		case R.id.btn_20percent:
			percentage = 0.2;
			break;
		default:
			break;
		}
		Double tip = percentage * inputAmount;
		this.updateTipAmount(tip);
	}
	
	public void updateTipAmount(Double value) {
		// Format the number and convert it to string.
		String formattedValue = currencyFormat.format(value).toString();
		// Set the tip amount
		tvTipAmount.setText(formattedValue);
	}
}
