package com.wht.service;

import com.wht.dao.NoticeDao;
import com.wht.domain.Notice;

import java.util.List;

public class NoticeService {
    NoticeDao noticeDao=new NoticeDao();
    public List<Notice> getNotice(){
        return noticeDao.select();
    }
}
