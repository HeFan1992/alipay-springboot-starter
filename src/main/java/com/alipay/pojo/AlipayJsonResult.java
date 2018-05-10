package com.alipay.pojo;

import java.io.Serializable;

/**
 * 
 * @Title: AlipayJsonResult.java
 * @Package com.alipay.util
 * @Description: 自定义响应数据结构
 * 				这个类是提供给门户，ios，安卓，微信商城用的
 * 				门户接受此类数据后需要使用本类的方法转换成对于的数据类型格式（类，或者list）
 * 				其他自行处理
 * 				200：表示成功
 * 				500：表示错误，错误信息在msg字段中
 * 				501：bean验证错误，不管多少个错误都以map形式返回
 * 				502：拦截器拦截到用户token出错
 * 				555：异常抛出信息
 * Copyright: Copyright (c) 2016
 * Company:Nathan.Lee.Salvatore
 * 
 * @author he.fan
 * @date 2018年4月30日 下午15:21:36 
 * @version V1.0
 */
public class AlipayJsonResult implements Serializable{
	
	private static final long serialVersionUID = 4997293587553904193L;
    /**
     * 响应状态
     */
    private Integer status;
    /**
     * 响应消息
     */
    private String msg;
    /**
     * 响应数据
     */
    private Object data;

    public static AlipayJsonResult build(Integer status,String msg,Object data){
        return new AlipayJsonResult(status,msg,data);
    }
    public static AlipayJsonResult ok(Object data){
        return new AlipayJsonResult(200,"ok",data);
    }
    public static AlipayJsonResult ok(){
        return AlipayJsonResult.ok(null);
    }
    public static AlipayJsonResult errMsg(String msg){
        return new AlipayJsonResult(500,msg,null);
    }
    public static AlipayJsonResult errMap(Object data){
        return new AlipayJsonResult(501,"error",data);
    }
    public static AlipayJsonResult errTokenMsg(String msg){
        return new AlipayJsonResult(502,msg,null);
    }
    public static AlipayJsonResult errException(String msg){
        return new AlipayJsonResult(555,msg,null);
    }

    public AlipayJsonResult() {
    }

    public AlipayJsonResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    @Override
    public String toString() {
        return "AlipayJsonResult{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
