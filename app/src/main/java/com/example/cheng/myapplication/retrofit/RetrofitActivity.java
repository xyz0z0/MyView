package com.example.cheng.myapplication.retrofit;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.cheng.myapplication.R;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitActivity extends AppCompatActivity {

    private static String ENDPOINT = "http://172.16.20.244:8080/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);


        Button button_1 = findViewById(R.id.retrofit_button_1);
        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadPerson();
            }
        });


    }

    private void uploadPhoto(String fileName) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ENDPOINT) //设置网络请求的Url地址
                .addConverterFactory(GsonConverterFactory.create()) //设置数据解析器
                .build();

        // 创建 网络请求接口 的实例
        UploadPersonInterface request = retrofit.create(UploadPersonInterface.class);

        File file = new File(getExternalFilesDir(null), fileName);
        String base64Bitmap=null;
        try {
            FileInputStream fis = new FileInputStream(file );
            Bitmap bitmap = BitmapFactory.decodeStream(fis);
            base64Bitmap = convertImageToStringForServer(bitmap);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        RequestBody reqFileStr = RequestBody.create(MediaType.parse("text/html;charset=UTF-8"), base64Bitmap);
        //对 发送请求 进行封装
        Call<PersonResponse> call = request.postPhoto(reqFileStr);
        //发送网络请求(异步)
        call.enqueue(new Callback<PersonResponse>() {
            //请求成功时回调
            @Override
            public void onResponse(Call<PersonResponse> call, Response<PersonResponse> response) {
                //请求处理,输出结果
//                Log.d("cxg", response.body().getMsg());
//                Log.d("cxg", response.body().getResult() + " ");
//                if (response.body().getResult() == 0) {
//
//                    Toast.makeText(AddSampleActivity.this, "成功", Toast.LENGTH_SHORT).show();
//                } else {
//                    Toast.makeText(AddSampleActivity.this, "失败", Toast.LENGTH_SHORT).show();
//                }
                Log.d("cxg","------------");
                Log.d("cxg--!",response.body().getMsg());
                Log.d("cxg","------------");

                if (response.body().getResult() == 0) {
                    Log.d("cxg","success");
//                Log.d("cxg",response.body().toString());
                    Log.d("cxg",response.body().toString());
                    Toast.makeText(RetrofitActivity.this, "成功", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(RetrofitActivity.this, "失败", Toast.LENGTH_SHORT).show();
                }
            }

            //请求失败时候的回调
            @Override
            public void onFailure(Call<PersonResponse> call, Throwable throwable) {
                Log.d("cxg", "error");
                Toast.makeText(RetrofitActivity.this, "网络请求失败", Toast.LENGTH_SHORT).show();
                throwable.printStackTrace();
            }
        });
    }


    private void uploadPerson() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ENDPOINT) //设置网络请求的Url地址
                .addConverterFactory(GsonConverterFactory.create()) //设置数据解析器
                .build();

        // 创建 网络请求接口 的实例
        UploadPersonInterface request = retrofit.create(UploadPersonInterface.class);

//        Person person = new Person("张三", 1, 2, "3");
        //对 发送请求 进行封装
//        Call<PersonResponse> call = request.getCall(2018, "王大锤2", "2018002", 001);
        //发送网络请求(异步)
//        call.enqueue(new Callback<PersonResponse>() {
//            //请求成功时回调
//            @Override
//            public void onResponse(Call<PersonResponse> call, Response<PersonResponse> response) {
//                //请求处理,输出结果
////                response.body().show();
////                Log.d("cxg", "test");
////                Log.d("cxg", response.toString());
////                Log.d("cxg",response.body().toString());
//                Log.d("cxg",response.body().getMsg());
//                Log.d("cxg",response.message());
//                if (response.body().getResult()==0){
//
//                    Toast.makeText(RetrofitActivity.this, "成功", Toast.LENGTH_SHORT).show();
//                }else {
//                    Toast.makeText(RetrofitActivity.this, "失败", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            //请求失败时候的回调
//            @Override
//            public void onFailure(Call<PersonResponse> call, Throwable throwable) {
//                Log.d("cxg", "error");
//                Toast.makeText(RetrofitActivity.this, "网络请求失败", Toast.LENGTH_SHORT).show();
//                throwable.printStackTrace();
//            }
//        });

    }

    public static String convertImageToStringForServer(Bitmap imageBitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        if (imageBitmap != null) {
            imageBitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream); // 100 表示不压缩
            byte[] byteArray = stream.toByteArray();
            return Base64.encodeToString(byteArray, Base64.DEFAULT);
        } else {
            return null;
        }
    }
}
