package lib.util;

import com.lsy.hebao.R;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by yang on 2016/7/6.
 */
public class Stats_icon {
    private final static Map<String,Integer> mIcon =new HashMap<String,Integer>(){
        {
            /**
             * 我的信息
             */
            put("lv.1", R.drawable.infor_img_tq1disable);
            put("lv.2", R.drawable.infor_img_tq2disable);
            put("lv.3", R.drawable.infor_img_tq3disable);
            put("lv.4", R.drawable.infor_img_tq4disable);
            put("lv.5", R.drawable.infor_img_tq5disable);
            put("lv.6", R.drawable.infor_img_tq6disable);
            put("lv.7", R.drawable.infor_img_tq7disable);
            put("lv.8", R.drawable.infor_img_tq8disable);
            put("lv.9", R.drawable.infor_img_tq9disable);
            put("lv.10", R.drawable.infor_img_tq10disable);
            put("lv.11", R.drawable.infor_img_tq11disable);
            put("lv.13", R.drawable.infor_img_tq12disable);
            put("lv.13", R.drawable.infor_img_tq13disable);
            put("lv.14", R.drawable.infor_img_tq14disable);
            put("lv.15", R.drawable.infor_img_tq15disable);
        }
    };
    private final static Map<String,Integer> mUnIcon =new HashMap<String,Integer>(){
        {
            /**
             * 我的信息
             */
            put("lv.1", R.drawable.infor_img_tq1);
            put("lv.2", R.drawable.infor_img_tq2);
            put("lv.3", R.drawable.infor_img_tq3);
            put("lv.4", R.drawable.infor_img_tq4);
            put("lv.5", R.drawable.infor_img_tq5);
            put("lv.6", R.drawable.infor_img_tq6);
            put("lv.7", R.drawable.infor_img_tq7);
            put("lv.8", R.drawable.infor_img_tq8);
            put("lv.9", R.drawable.infor_img_tq9);
            put("lv.10", R.drawable.infor_img_tq10);
            put("lv.11", R.drawable.infor_img_tq11);
            put("lv.13", R.drawable.infor_img_tq12);
            put("lv.13", R.drawable.infor_img_tq13);
            put("lv.14", R.drawable.infor_img_tq14);
            put("lv.15", R.drawable.infor_img_tq15);

        }
    };
    public static int getStatIcon(String stat_id) {
        int resId = 0;
        try {
            HashMap.Entry<String, Integer> entry = null;
            //采用Iterator遍历Hashmap
            Iterator<HashMap.Entry<String, Integer>> iterator = mIcon.entrySet().iterator();
            while (iterator.hasNext()) {
                entry = iterator.next();
                if (stat_id.equals(entry.getKey())) {
                    resId = entry.getValue();
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resId;
    }
    public static int getUnStatIcon(String stat_id) {
        int resId = 0;
        try {
            HashMap.Entry<String, Integer> entry = null;
            //采用Iterator遍历Hashmap
            Iterator<HashMap.Entry<String, Integer>> iterator = mUnIcon.entrySet().iterator();
            while (iterator.hasNext()) {
                entry = iterator.next();
                if (stat_id.equals(entry.getKey())) {
                    resId = entry.getValue();
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resId;
    }

}
