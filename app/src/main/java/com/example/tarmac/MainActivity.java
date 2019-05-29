package com.example.tarmac;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
	private String[] titles = {
			"List01",
			"List02",
			"List03",
			"List04",
			"List05",
			"List06",
			"List07",
			"List08",
			"List09",
			"List10",
			"List11",
			"List12"
	};
	private String[] descs = {
			"FUCK0101010101",
			"FUCK0202020202",
			"FUCK0303030303",
			"FUCK0404040404",
			"FUCK0505050505",
			"FUCK0606060606",
			"FUCK0707707077",
			"FUCK8888888888",
			"FUCK9999999999",
			"FUCK1010101010",
			"FUCK1111111111",
			"FUCK1212121212"

	};
	private int[] imgs = {
			R.drawable.w1,
			R.drawable.w2,
			R.drawable.w3,
			R.drawable.w4,
			R.drawable.w5,
			R.drawable.w6,
			R.drawable.w7,
			R.drawable.w8,
			R.drawable.w9,
			R.drawable.w10,
			R.drawable.w11,
			R.drawable.w12
	};
	private String books[] = {
			"《Java疯狂讲义》",
			"《Android疯狂讲义》",
			"《C++ Primer plus》"
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button dateDialog = (Button)findViewById(R.id.dateDialog);
		Button timeDialog = (Button)findViewById(R.id.timeDialog);
		dateDialog.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Calendar c = Calendar.getInstance();
				new DatePickerDialog(MainActivity.this,new DatePickerDialog.OnDateSetListener(){
					@Override
					public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
						Toast.makeText(MainActivity.this, "您选择了"+year+"年"+month+"月"+dayOfMonth+"日", Toast.LENGTH_SHORT).show();
					}
				},c.get(Calendar.YEAR),c.get(Calendar.MONTH),c.get(Calendar.DAY_OF_MONTH)).show();
			}
		});
		timeDialog.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Calendar c = Calendar.getInstance();
				new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
					@Override
					public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
						Toast.makeText(MainActivity.this, "您选择了"+hourOfDay+"时"+minute+"分",Toast.LENGTH_SHORT ).show();
					}
				},c.get(Calendar.HOUR_OF_DAY),c.get(Calendar.MINUTE),true).show();
			}
		});
	}

}
