package com.lsy.hebao.ui.actvity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;

import com.lsy.hebao.R;

import butterknife.ButterKnife;
import lib.view.animation.ThreeDRotateAnimation;

public class SplashActivity extends Activity {
    ImageView coinIv;  //下落的图片
    ImageView walletIv; //中间伸缩动画
    ImageView hiIv; //hi展开动画
    Button startBtn; //开始动画按钮

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initView();
        ButterKnife.bind(this);
        //启动动画
        startCoin();
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startCoin();
            }
        });
    }

    private void initView() {
        coinIv= (ImageView) findViewById(R.id.coin_iv);
        walletIv= (ImageView) findViewById(R.id.wallet_iv);
        hiIv= (ImageView) findViewById(R.id.hi_iv);
        startBtn= (Button) findViewById(R.id.start_btn);
    }

    /**
     * 开启下落动画  使用补间位移动画和旋转动画
     */
    private void startCoin() {
        //因为其本身是中心点 所以要从-50%p 开始
        Animation animationTranslate = AnimationUtils.loadAnimation(this, R.anim.anim_welcome_top_in);

        //旋转动画
        ThreeDRotateAnimation animation3D = new ThreeDRotateAnimation();
        animation3D.setRepeatCount(2);

        AnimationSet animationSet = new AnimationSet(true);
        animationSet.setDuration(2000);
        animationSet.addAnimation(animation3D);
        animationSet.addAnimation(animationTranslate);
        animationSet.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                startWallet();
                starthi();
                //setWallet()
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        coinIv.startAnimation(animationSet);
    }

    /**
     *  设置一个属性值动画 判断钱包缩放动画的开启时间
     */
    private void setWallet() {
        final ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, 1);
        valueAnimator.setDuration(800);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float fraction = animation.getAnimatedFraction();
                if (fraction >= 0.75) {
                    valueAnimator.cancel();
                    startWallet();

                }
            }
        });
        valueAnimator.start();
    }

    /**
     * 启动缩放动画
     */
    private void startWallet() {
        // x轴缩放
        ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(walletIv, "scaleX", 1, 1.1f, 0.9f, 1);
        objectAnimator1.setDuration(600);
        // y轴缩放
        ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(walletIv, "scaleY", 1, 0.75f, 1.25f, 1);
        objectAnimator2.setDuration(600);
        // 同时执行x，y轴缩放动画
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setInterpolator(new LinearInterpolator());
        animatorSet.playTogether(objectAnimator1, objectAnimator2);
        animatorSet.start();
    }
    /**
     * hi的缩放动画
     */
    private void starthi() {
        Animation animationSet = AnimationUtils.loadAnimation(this, R.anim.anim_welcome_set);
        animationSet.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                hiIv.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                //动画结束之后跳转到认证页面
                Intent intent=new Intent(SplashActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        hiIv.startAnimation(animationSet);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
