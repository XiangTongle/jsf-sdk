/**
 * Copyright 2004-2048 .
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ipd.jsf.gd.config.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import com.ipd.jsf.gd.config.ServerConfig;

/**
 * Title: 需要实现InitializingBean和DisposableBean<br>
 *
 * Description: <br>
 */
public class ServerBean<T> extends ServerConfig implements
		InitializingBean, DisposableBean, BeanNameAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2573189057118212659L;

	/**
	 * slf4j logger for this class
	 */
	private final static Logger LOGGER = LoggerFactory
			.getLogger(ServerBean.class);

	/**
	 * 默认构造函数，不允许从外部new
	 */
	protected ServerBean() {

	}

	private transient String beanName;

	/**
	 * @param name
	 * @see org.springframework.beans.factory.BeanNameAware#setBeanName(java.lang.String)
	 */
	@Override
	public void setBeanName(String name) {
		this.beanName = name;
	}

	/**
	 * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		// LOGGER.info("Start server with beanName {} afterPropertiesSet", beanName);
        //if(!CommonUtils.isUnitTestMode()){
            // 不主动启动，改为第一个服务发布时启动
            //start();
        //}
	}

	/**
	 * @see org.springframework.beans.factory.DisposableBean#destroy()
	 */
	@Override
	public void destroy() throws Exception {
		LOGGER.info("Stop server with beanName {}", beanName);
		stop();
	}

}