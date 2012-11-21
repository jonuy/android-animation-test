package com.jonuy.animationtest;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class SecondActivity extends Activity {
	
	private Button btnBack;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second);
		btnBack = (Button)findViewById(R.id.BackButton);
		btnBack.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Animation anim = AnimationUtils.loadAnimation(SecondActivity.this, R.anim.grow_spin);
				anim.setAnimationListener(new AnimationListener() {
					@Override
					public void onAnimationStart(Animation anim) {}
					
					@Override
					public void onAnimationRepeat(Animation anim) {}
					
					@Override
					public void onAnimationEnd(Animation anim) {
						btnBack.setVisibility(View.INVISIBLE);
						goBack();
					}
				});
				btnBack.startAnimation(anim);
			}
		});
	}
	
	private void goBack() {
		finish();
		overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
	}
	
	@Override
	protected void onResume() {
		findViewById(R.id.BackButton).setVisibility(View.VISIBLE);
		super.onResume();
	}
	
	@Override
	public boolean onKeyUp(int keyCode, KeyEvent event) {
		if(keyCode == KeyEvent.KEYCODE_BACK) {
			goBack();
			return true;
		}
		
		return super.onKeyUp(keyCode, event);
	}
}
