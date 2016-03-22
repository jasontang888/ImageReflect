package com.homer.reflect;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.TextView;
import android.widget.Toast;

public class Main extends Activity {

	private TextView tvTitle; 	
	private myGallery gallery; 	
	private ImageAdapter adapter;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		initRes();
	}
	
	private void initRes(){      
	    tvTitle = (TextView) findViewById(R.id.tvTitle);      
	    gallery = (myGallery) findViewById(R.id.mygallery);     // 获取自定义的myGallery控件      
	           
	    adapter = new ImageAdapter(this);         
	    adapter.createReflectedImages();    // 创建倒影效果      
	    gallery.setAdapter(adapter);      
	               
	    gallery.setOnItemSelectedListener(new OnItemSelectedListener() {    // 设置选择事件监听      
	        @Override 
	        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {      
	            tvTitle.setText(adapter.titles[position]);      
	        }      
	           
	        @Override 
	        public void onNothingSelected(AdapterView<?> parent) {      
	        }      
	    });      
	           
	    gallery.setOnItemClickListener(new OnItemClickListener() {          // 设置点击事件监听      
	        @Override 
	        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {      
	            Toast.makeText(Main.this, "img " + (position+1) + " selected", Toast.LENGTH_SHORT).show();      
	        }      
	    });      
	}
}