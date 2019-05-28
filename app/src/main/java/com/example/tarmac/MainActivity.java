package com.example.tarmac;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.ViewSwitcher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	GridView gv;
	ImageSwitcher is;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		List<Map<String,Object>> listItems = new ArrayList<Map<String,Object>>();
		for (int i = 0; i < imgs.length; i++) {
			Map<String,Object> item = new HashMap<String, Object>();
			item.put("image", imgs[i]);
			listItems.add(item);
		}
		SimpleAdapter simpleAdapter = new SimpleAdapter(this, listItems, R.layout.array_layout,new String[]{"image"},new int[]{R.id.iv});
		gv = (GridView)findViewById(R.id.gv);
		gv.setAdapter(simpleAdapter);
		is = (ImageSwitcher)findViewById(R.id.switcher);
		is.setFactory(new ViewSwitcher.ViewFactory() {
			@Override
			public View makeView() {
				ImageView imageView = new ImageView(MainActivity.this);
				imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
				imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
				return imageView;
			}
		});
		gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				is.setImageResource(imgs[position]);
			}
		});
	}
}
