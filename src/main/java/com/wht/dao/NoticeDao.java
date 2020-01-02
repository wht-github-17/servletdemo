package com.wht.dao;

import com.wht.domain.Notice;
import com.wht.util.DBUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class NoticeDao {
    public List<Notice> select(){
        List<Notice> notices=null;
        String sql="select * from notice order by n_time desc limit 1";
        List<Map<String,Object>> list=DBUtil.executeQuery(sql,null);
        if(list!=null && list.size()>0){
            notices=new ArrayList<>();
            for(Map  map:list){
                Notice notice=new Notice();
                notice.setDetails(Optional.ofNullable(map.get("details")).toString());
                notice.setnId(Integer.parseInt(map.get("n_id").toString()));
                notice.setnTime(Optional.ofNullable(map.get("n_time")).toString());
                notice.setTitle(Optional.ofNullable(map.get("title")).toString());
                notices.add(notice);
            }
        }
        return notices;
    }
}
