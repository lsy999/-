package com.lsy.hebao.ui.fragment.me.xinxi.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.lsy.hebao.R;

import java.io.File;
import java.util.ArrayList;

import lib.view.dialog.ActionSheetDialog;
import me.iwf.photopicker.PhotoPicker;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import top.zibin.luban.Luban;
import top.zibin.luban.OnCompressListener;


public class XinxiXiugaiActivity extends AppCompatActivity implements View.OnClickListener {
    private RelativeLayout rl_xinxi_xiugai;
    private ImageView img_clIm_xinxin_xiugai;
    String filesize;
    String imagesize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xinxi_xiugai);
        initView();

    }


    private void initView() {
        rl_xinxi_xiugai = (RelativeLayout) findViewById(R.id.rl_xinxi_xiugai);
        img_clIm_xinxin_xiugai = (ImageView) findViewById(R.id.img_clIm_xinxin_xiugai);
        rl_xinxi_xiugai.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_xinxi_xiugai:
                new ActionSheetDialog(XinxiXiugaiActivity.this)
                        .builder()
                        .setCancelable(false)
                        .setCanceledOnTouchOutside(false)
                        .addSheetItem("拍照", ActionSheetDialog.SheetItemColor.black,
                                new ActionSheetDialog.OnSheetItemClickListener() {
                                    @Override
                                    public void onClick(int which) {
                                        PhotoPicker.builder()
                                                .setPhotoCount(5)
                                                .setShowCamera(true)
                                                .setShowGif(true)
                                                .setPreviewEnabled(false)
                                                .start(XinxiXiugaiActivity.this, PhotoPicker.REQUEST_CODE);
                                    }
                                })
                        .addSheetItem("选择一张照片", ActionSheetDialog.SheetItemColor.black,
                                new ActionSheetDialog.OnSheetItemClickListener() {
                                    @Override
                                    public void onClick(int which) {
                                        PhotoPicker.builder()
                                                .setPhotoCount(5)
                                                .setShowCamera(true)
                                                .setShowGif(true)
                                                .setPreviewEnabled(false)
                                                .start(XinxiXiugaiActivity.this, PhotoPicker.REQUEST_CODE);
                                    }
                                })
                        .addSheetItem("使用荷包小头像", ActionSheetDialog.SheetItemColor.black,
                                new ActionSheetDialog.OnSheetItemClickListener() {
                                    @Override
                                    public void onClick(int which) {
                                        Toast.makeText(XinxiXiugaiActivity.this, "未开发", Toast.LENGTH_LONG).show();
                                    }
                                }).show();
                break;
        }
    }
    /**
     * 压缩单张图片 Listener 方式
     */
    private void compressWithLs(File file) {
        Luban.get(this)
                .load(file)
                .putGear(Luban.THIRD_GEAR)
                .setFilename(System.currentTimeMillis() + "")
                .setCompressListener(new OnCompressListener() {
                    @Override
                    public void onStart() {
                        Toast.makeText(XinxiXiugaiActivity.this, "I'm start", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onSuccess(File file) {
                        Log.i("path", file.getAbsolutePath());

                        Glide.with(XinxiXiugaiActivity.this).load(file).into(img_clIm_xinxin_xiugai);
                        filesize= file.length() / 1024+"k";
                        imagesize=Luban.get(getApplicationContext()).getImageSize(file.getPath())[0] + " * " + Luban.get(getApplicationContext()).getImageSize(file.getPath())[1];

                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                }).launch();
    }
        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);

            if (resultCode == RESULT_OK && requestCode == PhotoPicker.REQUEST_CODE) {
                if (data != null) {
                    ArrayList<String> photos = data.getStringArrayListExtra(PhotoPicker.KEY_SELECTED_PHOTOS);

                    for (int i = 0; i < photos.size(); i++)
                        compressWithLs(new File(photos.get(i)));
                }
            }
        }
}
