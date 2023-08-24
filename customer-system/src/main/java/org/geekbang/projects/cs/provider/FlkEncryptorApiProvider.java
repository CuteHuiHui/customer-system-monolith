package org.geekbang.projects.cs.provider;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.net.URI;

/**
 * 弗兰科加密机接口调用
 */
@FeignClient(name = "flk-encryptor", url = "https://test")
public interface FlkEncryptorApiProvider {
    /**
     * 1.1.1 根据密钥标识生成hmac密钥
     *
     * @param baseUri
     * @param param
     * @return
     */
    @PostMapping(path = "key/hmac/identification", consumes = "application/json")
    EncryptorApiResponse hmacIdentification(URI baseUri, @RequestBody HmacIdentificationDto param);

    /**
     * 1.1.2 hmac-根据密钥标识
     *
     * @param baseUri
     * @param param
     * @return
     */
    @PostMapping(path = "/crypto/hmacWithIdent", consumes = "application/json")
    EncryptorApiResponse hmacWithIdent(URI baseUri, @RequestBody HmacWithIdentDto param);

    /**
     * 1.1.1 生成对称密钥-根据密钥标识
     *
     * @param baseUri
     * @param param
     * @return
     */
    @PostMapping(path = "/key/symmetric/identification", consumes = "application/json")
    EncryptorApiResponse symmetricIdentification(URI baseUri, @RequestBody IdentificationDto param);

    /**
     * 1.1.2 对称加密-密钥标识
     *
     * @param baseUri
     * @param param
     * @return
     */
    @PostMapping(path = "/crypto/sysEncrypt/identification", consumes = "application/json")
    EncryptorApiResponse sysEncryptIdentification(URI baseUri, @RequestBody EncryptDto param);

    /**
     * 1.1.3 对称解密-密钥标识
     *
     * @param baseUri
     * @param param
     * @return
     */
    @PostMapping(path = "/crypto/sysDecrypt/identification", consumes = "application/json")
    EncryptorApiResponse sysDecryptIdentification(URI baseUri, @RequestBody DecryptDto param);

    /**
     * 外部密钥数据对称加密-批量
     *
     * @param baseUri
     * @param param
     * @return
     */
    @PostMapping(path = "/crypto/external/symmetricEncryptBatch", consumes = "application/json")
    EncryptorApiResponse symmetricEncryptBatch(URI baseUri, @RequestBody BatchEncryptDto param);


    /**
     * 外部密钥数据对称解密-批量
     *
     * @param baseUri
     * @param param
     * @return
     */
    @PostMapping(path = "/crypto/external/symmetricDecryptBatch", consumes = "application/json")
    EncryptorApiResponse symmetricDecryptBatch(URI baseUri, @RequestBody BatchDecryptDto param);
}
