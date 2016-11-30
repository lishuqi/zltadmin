package com.ljy.manage.service.log;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.abel533.entity.Example;
import com.ljy.entity.Log;
import com.ljy.manage.mapper.LogMapper;
import com.ljy.manage.service.base.BaseServiceImpl;
import com.ljy.manage.service.systemlog.SystemServiceLog;

@Service("logService")
public class LogServiceImpl extends BaseServiceImpl<Log> implements LogService{

	@Resource(name = "logMapper")
	private LogMapper logMapper;
	
	@Override
	@SystemServiceLog(description = "定时删除")
	public void deleteAll() throws Exception {
		 this.logMapper.deleteAll();
	}

}
