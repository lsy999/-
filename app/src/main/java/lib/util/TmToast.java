package lib.util;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.lsy.hebao.R;


/**
 * Created by lsy on 2017/4/18.
 */

public class TmToast extends Toast{
    private MediaPlayer mPlayer;
    private boolean isSound;

    public TmToast(Context context)
    {
        this(context, false);
    }

    // isSound 表示是否播放音乐;;;;
    public TmToast(Context context, boolean isSound)
    {
        super(context);

        this.isSound = isSound;

        mPlayer = MediaPlayer.create(context, R.raw.yingbi);
        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
        {
            @Override
            public void onCompletion(MediaPlayer mp)
            {
                mp.release();// 释放资源。让资源得到释放;;
            }
        });
    }

    @Override
    public void show()
    {
        super.show();
        if (isSound)
        {
            mPlayer.start();
        }
    }

    /**
     * 设置是否播放声音
     */
    public void setIsSound(boolean isSound)
    {
        this.isSound = isSound;
    }

    /**
     * 获取控件实例
     *
     * @param context
     * @param text
     *            提示消息
     * @param isSound
     *            是否播放声音
     * @return
     */
    public static TmToast show(Context context, CharSequence text, boolean isSound, int duration)
    {
        TmToast result = new TmToast(context, isSound);
        LayoutInflater inflate = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        View v = inflate.inflate(R.layout.pullable_new_data_toast, null);
        // v.setMinimumWidth(dm.widthPixels);// 设置控件最小宽度为手机屏幕宽度
        TextView tv = (TextView) v.findViewById(R.id.new_data_toast_message);
        tv.setText(text);
        result.setView(v);
        result.setDuration(duration);// 设置 显示多长时间;;;;
        result.setGravity(Gravity.BOTTOM, 0, (int) (dm.density * 85));
        return result;
    }
}
