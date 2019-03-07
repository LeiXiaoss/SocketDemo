package com.leixiao.socketDemo.service;

import com.leixiao.socketDemo.dao.FileDao;
import com.leixiao.socketDemo.entiy.File;

public class FileService {
    private FileDao fileDao = new FileDao();

    public int upload(File file){
        return fileDao.update(file);
    }
}
