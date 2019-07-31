package com.lexieluv.homeworkthirteenth;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.lexieluv.homeworkthirteenth.adapter.DetailAdapter;
import com.lexieluv.homeworkthirteenth.entity.DetailBean;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class FoodActivity extends AppCompatActivity {
    ImageView back;
    static String url = "http://www.imooc.com/api/shopping?type=12";
    ListView no;
    int i = 0;

    @Override
    public void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.no);
        back = findViewById(R.id.back_main);
        no = findViewById(R.id.no);
        AsynctaskSecond asyncTask = new AsynctaskSecond(FoodActivity.this,no);
        asyncTask.execute(url);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FoodActivity.this,MainActivity.class));
            }
        });
    }
}

//异步任务类下载网络数据的类
class AsynctaskSecond extends AsyncTask<String, Void, List<DetailBean>> {
    //传入一个context,为了Myadapter的执行
    private Context context;
    ListView no;

    public AsynctaskSecond(Context context,ListView no) {
        super();
        this.context=context;
        this.no = no;
    }

    //将URL对应的JSON格式数据转化为我们所封装的DetailBean对象
    private List<DetailBean> getJsonData(String url) {
        List<DetailBean> list=new ArrayList<DetailBean>();
        try {
            String jsonString=readStream(new URL(url).openStream());
            //调试是否返回正确json格式的数据字符串
            Log.i("info2", "getJsonData:"+jsonString);
            JSONObject jsonObject;
            DetailBean detailBean;

            //通过传入json格式的数据字符串，用JSON内置函数解析字符串，得到json数据
            jsonObject=new JSONObject(jsonString);
            Log.d("***************333", jsonObject.toString());
            //data就是我们在浏览器看到的data数组,不要把data写成了date，刚就犯了这个错，获取不到数据
            JSONObject jsonObject2=jsonObject.getJSONObject("data");
//            Log.d("***************111", String.valueOf(jsonArray.length()));
            //得到整个data数组后，我们就可以通过遍历数组，得到数组里每个一个对象的值
//            for(int i=0;i<=jsonArray.length();i++){
                detailBean=new DetailBean();
                detailBean.setName(jsonObject2.getString("name"));
                detailBean.setDescription(jsonObject2.getString("description"));
                detailBean.setOriginalprice(Double.parseDouble(jsonObject2.getString("originalprice")));
                detailBean.setPrice(jsonObject2.getString("price"));
                detailBean.setTPrice(Integer.parseInt(jsonObject2.getString("tPrice")));
                detailBean.setImg(jsonObject2.getString("img"));
                list.add(detailBean);
//            }
            //最终结果就是还是用的list返回，但是已经不用array了用的jsonObject
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }

    //通过URL获取网页返回的字符串信息
    private String readStream(InputStream is)
    {
        InputStreamReader isr;
        String result="";
        //一次性将URL的所有JSON格式数据都截取，赋值到result
        //获取的是一个JSON加密的格式，在浏览器访问的时候，系统会自动将乱码格式转换了正常的格式
        try {
            String line="";
            isr=new InputStreamReader(is,"utf-8");
            BufferedReader br=new BufferedReader(isr);
            while((line=br.readLine())!=null){
                result+=line;
                Log.i("info1", "line:"+line);
                Log.i("info1", "result:"+result);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return result;

    }

    @Override
    protected List<DetailBean> doInBackground(String... params) {
        return getJsonData(params[0]);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(List<DetailBean> list) {
        super.onPostExecute(list);
        DetailAdapter adapter=new DetailAdapter(context,list);
        no.setAdapter(adapter);
        Log.d("***************2",list.toString());
    }
}



