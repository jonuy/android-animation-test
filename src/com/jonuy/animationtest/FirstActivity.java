/**
 * Based on guides from:
 *  - http://blog.stylingandroid.com/archives/129
 *  - http://blog.stylingandroid.com/archives/137
 *  - http://blog.stylingandroid.com/archives/171
 */

package com.jonuy.animationtest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class FirstActivity extends Activity implements OnClickListener {
	
	private Button btnNormal;
	private Button btnLinear;
	private Button btnOvershoot;
	private Button btnAccelerateDecelerate;
	private Button btnAccelerate;
	private Button btnAnticipate;
	private Button btnAnticipateOvershoot;
	private Button btnBounce;
	private Button btnCycle;
	private Button btnDecelerate;
	private Button btnSlideUp;
	private Button btnSlideDown;
	
	private int animatingBtnId;
	private int animatingInTransition;
	private int animatingOutTransition;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.first);
		
		btnNormal = (Button)findViewById(R.id.btnNormal);
		btnLinear = (Button)findViewById(R.id.btnLinear);
		btnOvershoot = (Button)findViewById(R.id.btnOvershoot);
		btnAccelerateDecelerate = (Button)findViewById(R.id.btnAccelerateDecelerate);
		btnAccelerate = (Button)findViewById(R.id.btnAccelerate);
		btnAnticipate = (Button)findViewById(R.id.btnAnticipate);
		btnAnticipateOvershoot = (Button)findViewById(R.id.btnAnticipateOvershoot);
		btnBounce = (Button)findViewById(R.id.btnBounce);
		btnCycle = (Button)findViewById(R.id.btnCycle);
		btnDecelerate = (Button)findViewById(R.id.btnDecelerate);
		btnSlideUp = (Button)findViewById(R.id.btnSlideUp);
		btnSlideDown = (Button)findViewById(R.id.btnSlideDown);
		
		btnNormal.setOnClickListener(this);
		btnLinear.setOnClickListener(this);
		btnOvershoot.setOnClickListener(this);
		btnAccelerateDecelerate.setOnClickListener(this);
		btnAccelerate.setOnClickListener(this);
		btnAnticipate.setOnClickListener(this);
		btnAnticipateOvershoot.setOnClickListener(this);
		btnBounce.setOnClickListener(this);
		btnCycle.setOnClickListener(this);
		btnDecelerate.setOnClickListener(this);
		btnSlideUp.setOnClickListener(this);
		btnSlideDown.setOnClickListener(this);
	}
	
	private void goNext() {
		startActivity(new Intent(FirstActivity.this, SecondActivity.class));
		if (animatingInTransition > 0 && animatingOutTransition > 0) {
			// NOTE: overridePendingTransition must be called after startActivity
			overridePendingTransition(animatingInTransition, animatingOutTransition);
		}
		
		if (animatingBtnId == R.id.btnNormal) {
			Button btn = (Button)findViewById(animatingBtnId);
			btn.setVisibility(View.INVISIBLE);
		}
	}
	
	@Override
	protected void onResume() {
		btnNormal.setVisibility(View.VISIBLE);
		
		super.onResume();
	}
	
	@Override
	public void onClick(View v) {
		
		switch(v.getId()) {
		case R.id.btnNormal:
			animatingInTransition = 0;
			animatingOutTransition = 0;
			break;
		case R.id.btnLinear:
			animatingInTransition = R.anim.slide_in_left_linear;
			animatingOutTransition = R.anim.slide_out_left_linear;
			break;
		case R.id.btnOvershoot:
			animatingInTransition = R.anim.slide_in_left_overshoot;
			animatingOutTransition = R.anim.slide_out_left_overshoot;
			break;
		case R.id.btnAccelerateDecelerate:
			animatingInTransition = R.anim.slide_in_left_accelerate_decelerate;
			animatingOutTransition = R.anim.slide_out_left_accelerate_decelerate;
			break;
		case R.id.btnAccelerate:
			animatingInTransition = R.anim.slide_in_left_accelerate;
			animatingOutTransition = R.anim.slide_out_left_accelerate;
			break;
		case R.id.btnAnticipate:
			animatingInTransition = R.anim.slide_in_left_anticipate;
			animatingOutTransition = R.anim.slide_out_left_anticipate;
			break;
		case R.id.btnAnticipateOvershoot:
			animatingInTransition = R.anim.slide_in_left_anticipate_overshoot;
			animatingOutTransition = R.anim.slide_out_left_anticipate_overshoot;
			break;
		case R.id.btnBounce:
			animatingInTransition = R.anim.slide_in_left_bounce;
			animatingOutTransition = R.anim.slide_out_left_bounce;
			break;
		case R.id.btnCycle:
			animatingInTransition = R.anim.slide_in_left_cycle;
			animatingOutTransition = R.anim.slide_out_left_cycle;
			break;
		case R.id.btnDecelerate:
			animatingInTransition = R.anim.slide_in_left_decelerate;
			animatingOutTransition = R.anim.slide_out_left_decelerate;
			break;
		case R.id.btnSlideUp:
			animatingInTransition = R.anim.slide_in_up;
			animatingOutTransition = R.anim.slide_out_up;
			break;
		case R.id.btnSlideDown:
			animatingInTransition = R.anim.slide_in_down;
			animatingOutTransition = R.anim.slide_out_down;
			break;
		}
		
		animatingBtnId = v.getId();
		
		if (animatingBtnId == R.id.btnNormal) {
			Animation anim = AnimationUtils.loadAnimation(FirstActivity.this, R.anim.fade_out);
			anim.setAnimationListener(new AnimationListener() {
				@Override
				public void onAnimationStart(Animation anim) {}
				
				@Override
				public void onAnimationRepeat(Animation anim) {}
				
				@Override
				public void onAnimationEnd(Animation anim) {
					goNext();
				}
			});
			v.startAnimation(anim);
		}
		else {
			goNext();
		}
	}
	
}
