package ysan.retrofitdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ysan.retrofitdemo.R;
import ysan.retrofitdemo.bean.BookBean;
import ysan.retrofitdemo.service.DemoService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    private void fieldMap() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.douban.com/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Map<String, String> fields = new HashMap<>();
        fields.put("start", "0");
        fields.put("count", "3");

        Call<BookBean> call = retrofit.create(DemoService.class).fieldMapDemo(fields);
    }

    private void field() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.douban.com/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Call<BookBean> call = retrofit.create(DemoService.class).fieldDemo("zhangsan", "businessman");
    }

    private void path() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.douban.com/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Call<BookBean> call = retrofit.create(DemoService.class).pathDemo(1);
        String url = call.request().url().toString();
        Log.i(">>>", "onCreate :" + url);
    }

    private void query() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.douban.com/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Call<BookBean> call = retrofit.create(DemoService.class).queryDemo(1);
        String url = call.request().url().toString();
        Log.i(">>>", "onCreate :" + url);
    }

    private void queryMap() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.douban.com/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Map<String, String> options = new HashMap<>();
        options.put("start", "0");
        options.put("count", "3");

        Call<BookBean> call = retrofit.create(DemoService.class).queryMapDemo(options);
        String url = call.request().url().toString();
        Log.i(">>>", "onCreate :" + url);
    }

}
