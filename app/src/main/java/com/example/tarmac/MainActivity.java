package com.example.tarmac;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.List;

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
	private SearchView sv;
	private ListView lv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		lv = (ListView) findViewById(R.id.lv);
		lv.setAdapter(new ArrayAdapter<String>(this, R.layout.array_layout, descs));
		lv.setTextFilterEnabled(true);

		sv = (SearchView) findViewById(R.id.sv);
		sv.setIconifiedByDefault(true);
		sv.setSubmitButtonEnabled(true);
		sv.setQueryHint("查找");
		sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
			@Override
			public boolean onQueryTextSubmit(String query) {
				Toast.makeText(MainActivity.this, "您的选择是" + query, Toast.LENGTH_SHORT).show();
				return false;
			}

			@Override
			public boolean onQueryTextChange(String newText) {
				if (TextUtils.isEmpty(newText)) {
					lv.clearTextFilter();
				} else {
					lv.setFilterText(newText);
				}
				return true;
			}
		});
	}
}
