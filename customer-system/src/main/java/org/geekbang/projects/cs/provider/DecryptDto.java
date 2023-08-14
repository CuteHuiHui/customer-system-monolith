package org.geekbang.projects.cs.provider;

import lombok.Data;

/**
 * {
 * "algorithmType":"sm4",
 * "data":"1234567812345678",
 * "encMode":"cbc",
 * "iv":"AAAAAAAAAAAAAAAAAAAAAA==",
 * "key":"sm4_1",
 * "padMode":"PKCS5Padding",
 * "plainIsEncode":"false"
 * }
 */
@Data
public class DecryptDto extends EncryptOrDecryptDto {

    /**
     * 数据，必填
     * 需要进行解密的数据
     */
    private String encryptData;
}
