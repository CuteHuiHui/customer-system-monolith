package org.geekbang.projects.cs.provider.flk;

import lombok.Data;

import java.io.Serializable;

@Data
public class EncryptorApiResponse<T> implements Serializable {

    /**
     * 状态码：200正常
     */
    private int code;
    /**
     * 响应信息：success正常
     */
    private String msg;
    /**
     * 数据体
     *     Base64格式的hmac结果，base64解码为byte数组，固定为32字节
     */
    private T data;
}
