package org.geekbang.projects.cs.provider.flk;

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
public class EncryptDto extends EncryptOrDecryptDto {

    /**
     * 数据，必填
     * 需要进行加密的数据
     */
    private String data;
}
