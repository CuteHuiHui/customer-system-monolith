package org.geekbang.projects.cs.provider;

import lombok.Data;

import java.util.List;

/**
 * {
 * "algorithmType":"sm4",
 * "encryptData":[{"id": "1","name": "0nKtfXvvMzi8kCjd4gECPA=="},{"id": "2","name":
 * "T0KHgw6Mbm0WDamovC57ZA=="}],
 * "encMode":"cbc",
 * "iv":"AAAAAAAAAAAAAAAAAAAAAA==",
 * "key":"xQM9Kv70IOfYk0A877Uuiw==",
 * "padMode":"PKCS5Padding",
 * "plainIsEncode":"false",
 * "skipFields":["id"]
 * }
 */
@Data
public class BatchDecryptDto<T> extends EncryptOrDecryptDto {

    /**
     * 数据，必填
     * 需要进行解密的数据
     */
    private List<T> encryptData;

    /**
     * 哪些字段不需要加密，必填
     */
    private List<String> skipFields;
}
