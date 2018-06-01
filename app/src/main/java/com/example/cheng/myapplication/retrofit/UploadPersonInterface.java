package com.example.cheng.myapplication.retrofit;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface UploadPersonInterface {


    /**
     * private String personName;  //人员名称
     private Integer orgId;      //组织结构
     private Integer devId;      //设备ID
     private String cardNo;      //工号
     private String photo;       //照片路径
     private String address;
     * @param devId
     * @param personName
     * @param cardNo
     * @param orgId
     * @return
     */
    @POST("attendance/persons/insert")
    @FormUrlEncoded
    Call<PersonResponse> getCall(
            @Field("devId") int devId,
            @Field("address") String address,
            @Field("personName") String personName,
            @Field("cardNo") String cardNo,
            @Field("orgId") int orgId,
            @Field("photo") String photo
    );

    @POST("attendance/persons/uploadImg")
    Call<PersonResponse> postPhoto(
            @Body RequestBody friend);
}
