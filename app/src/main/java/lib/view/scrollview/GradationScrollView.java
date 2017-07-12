package lib.view.scrollview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;
public class GradationScrollView extends ScrollView {

    /**
	 *  滑动改变监听
	 */
	public interface ScrollViewListener {
		void onScrollChanged(GradationScrollView scrollView, int x, int y, int oldx, int oldy);
	}

	private ScrollViewListener scrollViewListener = null;

	public GradationScrollView(Context context) {
		super(context);
	}

	public GradationScrollView(Context context, AttributeSet attrs,
                               int defStyle) {
		super(context, attrs, defStyle);
	}

	public GradationScrollView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	/**
	 * 设置监听
	 * @param scrollViewListener
     */
	public void setScrollViewListener(ScrollViewListener scrollViewListener) {
		this.scrollViewListener = scrollViewListener;
	}

	@Override
	protected void onScrollChanged(int x, int y, int oldx, int oldy) {
		super.onScrollChanged(x, y, oldx, oldy);
		if (scrollViewListener != null) {
			//这个方法23 之后才开放 目前为了兼容先写了个接口
			scrollViewListener.onScrollChanged(this, x, y, oldx, oldy);
		}
	}

}