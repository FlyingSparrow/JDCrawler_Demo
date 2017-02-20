package com.sparrow.crawler.mtime.main;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.sparrow.crawler.entity.mtime.MtimeModel;
import com.sparrow.crawler.entity.mtime.MtimeUrl;
import com.sparrow.crawler.mtime.db.MYSQLControl;
import com.sparrow.crawler.mtime.db.MyDataSource;
import com.sparrow.crawler.mtime.parse.MtimeParse;

public class MtimeThread extends Thread{
    public static DataSource ds = MyDataSource.getDataSource("jdbc:mysql://127.0.0.1:3306/moviedata");
    public static QueryRunner qr = new QueryRunner(ds);
    String Starturl = "";
    String Id="";
    //构造函数，初始化使用
    public  MtimeThread (String Starturl,String Id){
        this.Starturl = Starturl;
        this.Id = Id;
    }
    public void run(){
        List<MtimeModel> moviedatas=new ArrayList<MtimeModel>();
        //这里采用jsoup直接模拟访问网页
        try {
            Document doc = Jsoup.connect(Starturl).userAgent("bbb").timeout(120000).get();
            moviedatas =MtimeParse.getData(doc);

        } catch (IOException e) {
            e.printStackTrace();
        }
        for (MtimeModel mt:moviedatas) {
            System.out.println("prmovieId:"+mt.getPrmovieId()+"  movieId:"+mt.getMovieId()+"  Title:"+mt.getTitle()
                    +"   url:"+mt.getUrl());
        }
        try {
            MYSQLControl.executeUpdate(moviedatas,Id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException{
        ResultSetHandler<List<MtimeUrl>> h = new BeanListHandler<MtimeUrl>(MtimeUrl.class);
        List<MtimeUrl> Starturls = qr.query("SELECT id,url FROM moviedata.movie WHERE website='时光网' and is_crawler=0", h);
        //创建固定大小的线程池
        ExecutorService exec = Executors.newFixedThreadPool(5);
        for (MtimeUrl Start:Starturls) {
            //执行线程
             exec.execute(new MtimeThread(Start.getUrl(),Start.getId()));
        }
        //线程关闭
        exec.shutdown();
    }
}