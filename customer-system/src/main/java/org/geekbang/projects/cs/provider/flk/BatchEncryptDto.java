package org.geekbang.projects.cs.provider.flk;

import lombok.Data;

import java.util.List;

/**
 * {
 * "algorithmType":"sm4",
 * "data":[{"id":1,"name":"zhangsan"},{"id":2,"name":"lisi"}],
 * "encMode":"cbc",
 * "iv":"AAAAAAAAAAAAAAAAAAAAAA==",
 * "key":"xQM9Kv70IOfYk0A877Uuiw==",
 * "padMode":"PKCS5Padding",
 * "plainIsEncode":"false",
 * "skipFields":["id"]
 * }
 */
@Data
public class BatchEncryptDto<T> extends EncryptOrDecryptDto {
    /**
     * 数据，必填
     */
    private List<T> data;


    /**
     * 哪些字段不需要加密，必填
     */
    private List<String> skipFields;
}
