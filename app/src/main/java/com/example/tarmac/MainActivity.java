package com.example.tarmac;

import android.app.ProgressDialog;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
	final static int MAX_STATUS = 100;
	private int[] data = new int[50];
	int progressStatus = 0;
	int hasData = 0;
	ProgressDialog pd1, pd2;
	//	更新进度的handler
	Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			if (msg.what == 0x123) {
				pd2.setProgress(progressStatus);
			}
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.learn_layout);
	}

	public void showSpinner(View src) {
		ProgressDialog.show(this, "任务执行中", "任务执行中，请等待", false, true);
	}

	public void showIndeterminate(View src) {
		pd1 = new ProgressDialog(MainActivity.this);
		pd1.setTitle("任务执行中");
		pd1.setMessage("任务执行中，请耐心等待");
		pd1.setIndeterminate(false);
		pd1.setCancelable(true);
		pd1.show();
	}

	public void showProgress(View src) {
		progressStatus = 0;
		hasData = 0;
		pd2 = new ProgressDialog(MainActivity.this);
		pd2.setMax(MAX_STATUS);
		pd2.setTitle("任务完成百分比");
		pd2.setMessage("耗时任务的完成百分比");
		pd2.setCancelable(true);
		pd2.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		pd2.setIndeterminate(false);
		pd2.show();
		new Thread() {
			@Override
			public void run() {
				while (progressStatus < MAX_STATUS) {
					progressStatus = MAX_STATUS * doWork() / data.length;
					handler.sendEmptyMessage(0x123);
				}
				pd2.dismiss();
			}
		}.start();
	}

	public int doWork() {
		data[hasData++] = (int) (Math.random() * 100);
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return hasData;
	}
}
