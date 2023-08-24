package org.geekbang.projects.cs.provider.flk;

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
     * 根据指定长度生成对应的随机数，得到 base64 算法编码后的随机数
     *
     * @param baseUri
     * @param param   { "length":16 }
     * @return {"msg":"success","code":200,"data":"b0c47aV8/yZGcgj2Q+OvPg=="}
     */
    @PostMapping(path = "/crypto/genRandom", consumes = "application/json")
    EncryptorApiResponse cryptoGenRandom(URI baseUri, @RequestBody LengthDto param);

    /**
     * 1.1.1 根据密钥标识生成hmac密钥
     *
     * @param baseUri
     * @param param   {"length":16,"identification":"sm1_1"}
     * @return { "code": 200, "msg": "success!", "data": null }
     */
    @PostMapping(path = "/key/hmac/identification", consumes = "application/json")
    EncryptorApiResponse hmacIdentification(URI baseUri, @RequestBody HmacIdentificationDto param);

    /**
     * 1.1.2 hmac-根据密钥标识
     *
     * @param baseUri
     * @param param   {"data":"fhasdfff","plainIsEncode":false,"key":"sm1_1"}
     * @return {"msg":"success","code":200,"data":"mDFvJVtHcGeka5fKfdeCjodASrf9IUlRpKj3ehOqCLo="}
     */
    @PostMapping(path = "/crypto/hmacWithIdent", consumes = "application/json")
    EncryptorApiResponse hmacWithIdent(URI baseUri, @RequestBody HmacWithIdentDto param);

    /**
     * 1.1.1 生成对称密钥-根据密钥标识
     *
     * @param baseUri
     * @param param   {"identification":"sm4_1"}
     * @return { "code": 200, "msg": "success!", "data": null }
     */
    @PostMapping(path = "/key/symmetric/identification", consumes = "application/json")
    EncryptorApiResponse symmetricIdentification(URI baseUri, @RequestBody IdentificationDto param);

    /**
     * 1.1.2 对称加密-密钥标识
     *
     * @param baseUri
     * @param param   {"data":"1234567812345678","iv":"AAAAAAAAAAAAAAAAAAAAAA==","algorithmType":"sm4","padMode":"PKCS5Padding","plainIsEncode":false,"key":"sm4_1","encMode":"cbc"}
     * @return {"msg":"success","code":200,"data":"egiLbuBR+YeLzznuOP0HTRsdn1WMX6vj5dQwft1dlQ8="}
     */
    @PostMapping(path = "/crypto/sysEncrypt/identification", consumes = "application/json")
    EncryptorApiResponse sysEncryptIdentification(URI baseUri, @RequestBody EncryptDto param);

    /**
     * 1.1.3 对称解密-密钥标识
     *
     * @param baseUri
     * @param param   {"iv":"AAAAAAAAAAAAAAAAAAAAAA==","algorithmType":"sm4","padMode":"PKCS5Padding","encryptData":"egiLbuBR+YeLzznuOP0HTRsdn1WMX6vj5dQwft1dlQ8=","plainIsEncode":false,"key":"sm4_1","encMode":"cbc"}
     * @return {"msg":"success","code":200,"data":"1234567812345678"}
     */
    @PostMapping(path = "/crypto/sysDecrypt/identification", consumes = "application/json")
    EncryptorApiResponse sysDecryptIdentification(URI baseUri, @RequestBody DecryptDto param);

    /**
     * 外部密钥数据对称加密-批量
     *
     * @param baseUri
     * @param param   {"data":[{"name":"zhangsan","id":1},{"name":"lisi","id":2}],"iv":"AAAAAAAAAAAAAAAAAAAAAA==","skipFields":["id"],"algorithmType":"sm4","padMode":"PKCS5Padding","plainIsEncode":false,"key":"xQM9Kv70IOfYk0A877Uuiw==","encMode":"cbc"}
     * @return {"msg":"success","code":200,"data":[{"name":"3aQ8OGWfpNf6IK2FtOtaug==","id":"1"},{"name":"YGJZ2YnYyNxfkhLmb/F+MQ==","id":"2"}]}
     */
    @PostMapping(path = "/crypto/external/symmetricEncryptBatch", consumes = "application/json")
    EncryptorApiResponse symmetricEncryptBatch(URI baseUri, @RequestBody BatchEncryptDto param);

    /**
     * 外部密钥数据对称解密-批量
     *
     * @param baseUri
     * @param param   {"iv":"AAAAAAAAAAAAAAAAAAAAAA==","skipFields":["id"],"algorithmType":"sm4","padMode":"PKCS5Padding","encryptData":[{"name":"3aQ8OGWfpNf6IK2FtOtaug==","id":1},{"name":"YGJZ2YnYyNxfkhLmb/F+MQ==","id":2}],"plainIsEncode":false,"key":"xQM9Kv70IOfYk0A877Uuiw==","encMode":"cbc"}
     * @return {"msg":"success","code":200,"data":[{"name":"zhangsan","id":"1"},{"name":"lisi","id":"2"}]}
     */
    @PostMapping(path = "/crypto/external/symmetricDecryptBatch", consumes = "application/json")
    EncryptorApiResponse symmetricDecryptBatch(URI baseUri, @RequestBody BatchDecryptDto param);
}
