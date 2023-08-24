package org.geekbang.projects.cs.provider.flk;

import lombok.Data;

@Data
public class EncryptOrDecryptDto {
    /**
     * 密钥标识，必填
     * 密钥标识，生成密钥时传入的标识
     */
    private String key;

    /**
     * 算法类型，必填
     * 加密的算法类型,目前系统支持sm1,sm4
     */
    private String algorithmType;

    /**
     * 加密模式，必填
     * 采用的加密模式，系统支持ecb,cbc,cfb,ofb，推荐cbc，不允许使用ecb模式
     */
    private String encMode;

    /**
     * 初始向量，非必填
     * Base64格式的初始向量，加密模式为cbc,cfb,ofb时该参数不能为空，解码后长度为16位，可自定义
     */
    private String iv;

    /**
     * 填充模式，必填
     * 加密运算所采用的填充模式，系统支持PKCS5Padding和NoPadding
     */
    private String padMode;

    /**
     * 明文是否编码，非必填
     * 明文是否进行了base64编码 true/false
     */
    private Boolean plainIsEncode;
}
