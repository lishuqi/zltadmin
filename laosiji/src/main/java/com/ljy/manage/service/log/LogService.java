package com.ljy.manage.service.log;

import com.ljy.entity.Log;
import com.ljy.manage.service.base.BaseService;

public interface LogService extends BaseService<Log> {

	void deleteAll() throws Exception;

}
