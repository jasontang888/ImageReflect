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
	    gallery = (myGallery) findViewById(R.id.mygallery);     // ��ȡ�Զ����myGallery�ؼ�      
	           
	    adapter = new ImageAdapter(this);         
	    adapter.createReflectedImages();    // ������ӰЧ��      
	    gallery.setAdapter(adapter);      
	               
	    gallery.setOnItemSelectedListener(new OnItemSelectedListener() {    // ����ѡ���¼�����      
	        @Override 
	        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {      
	            tvTitle.setText(adapter.titles[position]);      
	        }      
	           
	        @Override 
	        public void onNothingSelected(AdapterView<?> parent) {      
	        }      
	    });      
	           
	    gallery.setOnItemClickListener(new OnItemClickListener() {          // ���õ���¼�����      
	        @Override 
	        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {      
	            Toast.makeText(Main.this, "img " + (position+1) + " selected", Toast.LENGTH_SHORT).show();      
	        }      
	    });      
	}
}