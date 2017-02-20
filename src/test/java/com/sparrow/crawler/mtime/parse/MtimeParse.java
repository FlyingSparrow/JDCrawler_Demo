package com.sparrow.crawler.mtime.parse;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.nodes.Document;

import com.alibaba.fastjson.JSON;
import com.sparrow.crawler.entity.mtime.JsonModel;
import com.sparrow.crawler.entity.mtime.MtimeModel;

public class MtimeParse {
    public static List<MtimeModel> getData (Document doc)  {
        List<MtimeModel> mtimeData=new ArrayList<MtimeModel>();
        //获取待解析的html文件
        String html=doc.html();
        //fastJson测试
        //just contain the preview
        List<JsonModel> mtimeJsonData=new ArrayList<JsonModel>();
        Pattern data1 = Pattern.compile("预告片\":(.*?)\\,(\"拍摄花絮|\"精彩片段)");
        Matcher dataMatcher1 = data1.matcher(html);
        String da1="";
        while (dataMatcher1.find()) {
           //待解析的json字符串
            da1=dataMatcher1.group(1);
        }
        if (da1.length()!=0) {
            List<JsonModel> jsonmodel1 = JSON.parseArray(da1,JsonModel.class);
            for (JsonModel jso:jsonmodel1 ) {
                JsonModel mtimeModel=new JsonModel();
                String VideoID="mtime"+jso.getVideoId();
                String MovieID="mtime"+jso.getMovieId();
                String ShortTitle=jso.getShortTitle();
                String url="http://video.mtime.com/"+jso.getVideoId()+"/?mid"+jso.getMovieId();
                mtimeModel.setPrmovieId(VideoID);
                mtimeModel.setUrl(url);
                mtimeModel.setMovieId(MovieID);
                mtimeModel.setShortTitle(ShortTitle);
                mtimeJsonData.add(mtimeModel);
            }
        }

        return mtimeData;
    }
}