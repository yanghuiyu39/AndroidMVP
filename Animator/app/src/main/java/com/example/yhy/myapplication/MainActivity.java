package com.example.yhy.myapplication;

import android.content.Context;
import android.os.Build;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnticipateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.yhy.myapplication.retrofit.ApiService;
import com.example.yhy.myapplication.retrofit.GetIpInfoResponse;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
     ImageView iamge;
     ImageView iamge1;
     ImageView iamge2;
    int statusBarHeight;
    View viewStatusBarTop;
     boolean isUp = true;
    private void iii(){
        if (isUp) {
            isUp=false;
            //插值器，这里选取，开始向前甩和结束向后甩
            AnticipateInterpolator anticipation = new AnticipateInterpolator(-6.0f);
            //、持续时间、Y坐标偏离（负值是向上）、X坐标偏离、加入插值器
            iamge1.animate().setDuration(300).translationYBy(-200).translationXBy(237).setInterpolator(anticipation);
            iamge2.animate().setDuration(300).translationYBy(-200).translationXBy(-237).setInterpolator(anticipation);
        }
        else {
            isUp=true;
            AnticipateInterpolator anticipation = new AnticipateInterpolator(-3.0f);
            iamge1.animate().setDuration(300).translationYBy(200).translationXBy(-237).setInterpolator(anticipation);
            iamge2.animate().setDuration(300).translationYBy(200).translationXBy(237).setInterpolator(anticipation);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//       requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);



        iamge= (ImageView) findViewById(R.id.iamge);
        iamge1= (ImageView) findViewById(R.id.image1);
        iamge2= (ImageView) findViewById(R.id.image2);

        iamge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iii();
            }
        });

   //     ViewPropertyAnimator.animate(mTextview).setDuration(0).translationYBy(-30).translationXBy(-20).setInterpolator(anticipation);



//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            // 设置状态栏透明
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            //  设置根布局的参数
//            ViewGroup rootView = (ViewGroup) ((ViewGroup) findViewById(android.R.id.content)).getChildAt(0);
//            ViewCompat.setFitsSystemWindows(rootView,false);
//            rootView.setClipToPadding(true);
//        }
     //   final TextView mTextview= (TextView) findViewById(R.id.text1);
      //  mTextview.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
             //   mTextview.scrollBy(0,30);
             //   mTextview. offsetTopAndBottom(40);
//                Retrofit retrofit = new Retrofit.Builder()
//                        .baseUrl("https://api.github.com")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .client(new OkHttpClient())
//                        .build();
//                ApiService apiService = retrofit.create(ApiService.class);
//
//                Call<GetIpInfoResponse> call = apiService.getIpInfo("63.223.108.42");
//                call.enqueue(new Callback<GetIpInfoResponse>() {
//                    @Override
//                    public void onResponse(Call<GetIpInfoResponse> call, Response<GetIpInfoResponse> response) {
//                        GetIpInfoResponse getIpInfoResponse = response.body();
//                        mTextview.setText(getIpInfoResponse.data.country);
//                    }
//
//                    @Override
//                    public void onFailure(Call<GetIpInfoResponse> call, Throwable t) {
//
   //                 }


   //   });






//        MyButton button =new MyButton();
//        //注册监听器
//        button.setOnclickListener(new MyOnclickListener() {
//            @Override
//            public void onClick() {
//                System.out.println("按钮被点击了");
//            }
//        });
//
//        //模拟用户点击
//        button.doClick();
    }

    protected void immerseLayout() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            statusBarHeight = getStatusBarHeight(this.getApplicationContext());
            viewStatusBarTop = findViewById(R.id.status_bar_top);
            SwipeRefreshLayout.LayoutParams params2 = (SwipeRefreshLayout.LayoutParams) viewStatusBarTop.getLayoutParams();
            params2.height = statusBarHeight;
            viewStatusBarTop.setLayoutParams(params2);
            viewStatusBarTop.setVisibility(View.GONE);
        }
    }

    public int getStatusBarHeight(Context context) {
        if (statusBarHeight != 0)
            return statusBarHeight;

        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            statusBarHeight = context.getResources().getDimensionPixelSize(resourceId);
        }
        return statusBarHeight;
    }
}
