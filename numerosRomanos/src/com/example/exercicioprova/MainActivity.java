package com.example.exercicioprova;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	private EditText editdecimal, editromano;
	private Button butconverterdecimal, butconverterromano, butlimpar,butsair;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		editdecimal = (EditText) findViewById(R.id.editdecimal);
		editromano = (EditText) findViewById(R.id.editromano);
		butconverterdecimal = (Button) findViewById(R.id.butconverterdecimal);
		editdecimal.requestFocus();
		butconverterromano = (Button) findViewById(R.id.butconverterromano);
		butlimpar= (Button) findViewById(R.id.butlimpar);
		butsair= (Button) findViewById(R.id.butsair);
		converterClick();
		
	}

	public void converterClick() {
		butconverterdecimal.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String valorCampo = editdecimal.getText().toString(); 
				//if(valorCampo)
				if (!valorCampo.isEmpty()) {
					ConverterDecimalRomano converterDecimal = new ConverterDecimalRomano();
					Integer decimal = Integer.parseInt(valorCampo);
					String romano = converterDecimal.converter(decimal);
					editromano.setText(romano);
				}
			}
		});
		
		butconverterromano.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String valorCampo = editromano.getText().toString(); 
				if(!valorCampo.isEmpty()){
					ConverterRomanoDecimal converterRomano = new ConverterRomanoDecimal();
					String romano = valorCampo.toUpperCase();
					Integer decimal = converterRomano.converter(romano);
					editdecimal.setText(decimal.toString());
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	public void limparClick(View v){
		editdecimal.setText("");
		editromano.setText("");
		editdecimal.requestFocus();
	}

	public void sairClick(View view){
		this.finish();
	
		
	}
}
