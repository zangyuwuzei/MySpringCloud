package com.zywz.common.util;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Administrator
 */
@Data
@ApiModel("封装的返回实体")
public class Response<T> implements Serializable {
    /**
     * 返回码
     */
    @ApiModelProperty("状态码")
    private int code;
    /**
     * 返回描述
     */
    @ApiModelProperty("状态解释")
    private String msg;
    /**
     * 返回数据
     */
    @ApiModelProperty("数据体")
    private T data;



    public Response() {
    }

    public Response(ResponseCode tmResponseCode, T data) {
        this.code = tmResponseCode.getCode();
        this.msg = tmResponseCode.getMsg();
        this.data = data;
    }

    /**
     * 请求成功,不需要返回数据
     * @return
     */
    public Response Sucess() {
        Response response = new Response();
        response.code = ResponseCode.SUCCESS.getCode();
        response.msg = ResponseCode.SUCCESS.getMsg();
        return response;
    }

    /**
     * 请求失败,不需要返回数据
     * @return
     */
    public Response Error() {
        Response response = new Response();
        response.code = ResponseCode.ERROR.getCode();
        response.msg = ResponseCode.ERROR.getMsg();
        return response;
    }

    /**
     * 请求失败,需要返回数据
     * @param data
     * @return
     */
    public Response ErrorData(Object data) {
        return new Response(ResponseCode.ERROR, data);
    }

    /**
     * 请求成功,需要返回数据
     * @param data
     * @return
     */
    public Response SucessData(Object data) {
        return new Response(ResponseCode.SUCCESS, data);
    }

}
