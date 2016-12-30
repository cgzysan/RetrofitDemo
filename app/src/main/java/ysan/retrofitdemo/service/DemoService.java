package ysan.retrofitdemo.service;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import ysan.retrofitdemo.bean.BookBean;

/**
 * 创建者     YSAN
 * 创建时间   2016/12/27 22:53
 * 描述	      ${TODO}
 * <p/>
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */
public interface DemoService {
    @GET("/list")
    Call<BookBean> queryDemo (@Query("page") int page);

    @GET("book/search")
    Call<BookBean> queryMapDemo(@QueryMap Map<String, String> options);

    @GET("/image/{id}")
    Call<BookBean> pathDemo(@Path("id") int id);

    @FormUrlEncoded
    @POST("/")
    Call<BookBean> fieldDemo(@Field("name") String name, @Field("occupation") String occupation );

    @FormUrlEncoded
    @POST("/")
    Call<BookBean> fieldMapDemo(@FieldMap Map<String, String> fields);

}
