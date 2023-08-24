package org.geekbang.projects.cs.provider.flk;

import lombok.Data;

/**
 * {
 * "data":"fhasdfff",
 * "plainIsEncode":false,
 * "key":"sm1_1"
 * }
 */
@Data
public class HmacWithIdentDto {
    /**
     * 明文是否编码：非必填
     * 明文是否进行了base64编码
     */
    private Boolean plainIsEncode;
    /**
     * 数据：必填
     * 进行hmac的数据
     */
    private String data;
    /**
     * 密钥标识：必填
     * 生成密钥时传入的标识
     */
    private String key;

}
