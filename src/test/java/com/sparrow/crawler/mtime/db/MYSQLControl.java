package com.sparrow.crawler.mtime.db;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sparrow.crawler.entity.mtime.MtimeComment;
import com.sparrow.crawler.entity.mtime.MtimeModel;

public class MYSQLControl {
    static final Log logger = LogFactory.getLog(MYSQLControl.class);
    static DataSource ds = MyDataSource.getDataSource("jdbc:mysql://127.0.0.1:3306/moviedata");
    static QueryRunner qr = new QueryRunner(ds);
    //第一类方法
    public static void executeUpdate(String sql){
      try {
        qr.update(sql);
      } catch (SQLException e) {
          logger.error(e);
      }
    }
    //第二类数据库操作方法
    public static void executeUpdate(List<MtimeModel> moviedata,String id) throws SQLException {
        //定义一个Object数组，行列
        Object[][] params = new Object[moviedata.size()][4];
        for ( int i=0; i<params.length; i++ ){
            params[i][0] = moviedata.get(i).getPrmovieId();
            params[i][1] = moviedata.get(i).getMovieId();
            params[i][2] = moviedata.get(i).getUrl();
            params[i][3] = moviedata.get(i).getTitle();
        }
        try{
            qr.batch("insert into movieURL (prmovieId, movieId, url, title)"
                    + "values (?,?,?,?)", params);
            qr.update("update movie set is_crawler=1 where id='"+id+"'");
        }catch( Exception e){
            logger.error(e);
        }

    }

    //操作评论的数据库
    public static void executeUpdate1(List<MtimeComment> moviedata,String id) throws SQLException {

        Object[][] params = new Object[moviedata.size()][3];
        for ( int i=0; i<params.length; i++ ){
            params[i][0] = moviedata.get(i).getCommentId();
            params[i][1] = moviedata.get(i).getComment();
            params[i][2] = moviedata.get(i).getTime() ;
        }
        try{
            qr.batch("insert into moviecomment (comm_id, prmovieId,comment, time)"
                    + "values (?,'"+id+"',?,?)", params);
            qr.update("update movieurl set is_crawler=1 where prmovieId='"+id+"'");
        }catch( Exception e){
            logger.error(e);
        }

    }
}