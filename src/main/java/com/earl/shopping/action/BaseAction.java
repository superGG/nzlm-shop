package com.earl.shopping.action;

import java.io.InputStream;
import java.lang.reflect.ParameterizedType;
import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.earl.shopping.server.GoodsService;
import com.earl.shopping.server.TypesService;
import com.earl.shopping.serverImpl.GoodsServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 通用的增删改查action层.
 * @author Administrator
 *
 * @param <T>
 */
public class BaseAction<T> extends ActionSupport implements RequestAware,
		SessionAware, ApplicationAware, ModelDriven<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8149565301937545170L;

	protected T model;

	protected Map<String, Object> request;
	protected Map<String, Object> session;
	protected Map<String, Object> application;

	protected InputStream jsonInputStream;

	public InputStream getJsonInputStream() {
		return jsonInputStream;
	}

	// TODO 需要手动注入Server
	protected GoodsService goodsServer = GoodsServiceImpl.getInstance();

	protected TypesService typesServer;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public BaseAction() {
		ParameterizedType type = (ParameterizedType) this.getClass()
				.getGenericSuperclass();
		Class clazz = (Class) type.getActualTypeArguments()[0];
		try {
			model = (T) clazz.newInstance();
			System.out.println(model);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	public T getModel() {
		return model;
	}

	public void setApplication(Map<String, Object> application) {
		this.application = application;

	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
