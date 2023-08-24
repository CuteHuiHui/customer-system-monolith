package org.geekbang.projects.cs.provider.flk;

import cn.hutool.json.JSONUtil;
import org.geekbang.projects.cs.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;

/**
 * 弗兰科加密机接口调用
 */

@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
public class FlkEncryptorTest {
    @Autowired
    private FlkEncryptorApiProvider flkEncryptorApiProvider;

    @Test
    public void test() {

        try {
            URI baseUri = new URI("https://10.20.141.76:9443/hamc1381");
            LengthDto req = new LengthDto();
            req.setLength(16);
            EncryptorApiResponse resp = flkEncryptorApiProvider.cryptoGenRandom(baseUri, req);
            System.out.println("随机数为：" + JSONUtil.toJsonStr(req));
            System.out.println("随机数为：" + JSONUtil.toJsonStr(resp));

            HmacIdentificationDto req1 = new HmacIdentificationDto();
            req1.setLength(16);
            req1.setIdentification("sm1_1");
            EncryptorApiResponse resp1 = flkEncryptorApiProvider.hmacIdentification(baseUri, req1);
            System.out.println("完整性：" + JSONUtil.toJsonStr(req1));
            System.out.println("完整性：" + JSONUtil.toJsonStr(resp1));

            HmacWithIdentDto req2 = new HmacWithIdentDto();
            req2.setKey("sm1_1");
            req2.setPlainIsEncode(false);
            req2.setData("fhasdfff");
            EncryptorApiResponse resp2 = flkEncryptorApiProvider.hmacWithIdent(baseUri, req2);
            System.out.println("完整性：" + JSONUtil.toJsonStr(req2));
            System.out.println("完整性：" + JSONUtil.toJsonStr(resp2));

            IdentificationDto req3 = new IdentificationDto();
            req3.setIdentification("sm4_1");
            EncryptorApiResponse resp3 = flkEncryptorApiProvider.symmetricIdentification(baseUri, req3);
            System.out.println("机密性：" + JSONUtil.toJsonStr(req3));
            System.out.println("机密性：" + JSONUtil.toJsonStr(resp3));

            EncryptDto req4 = new EncryptDto();
            req4.setKey("sm4_1");
            req4.setAlgorithmType("sm4");
            req4.setData("1234567812345678");
            req4.setEncMode("cbc");
            req4.setIv("AAAAAAAAAAAAAAAAAAAAAA==");
            req4.setPadMode("PKCS5Padding");
            req4.setPlainIsEncode(false);
            EncryptorApiResponse resp4 = flkEncryptorApiProvider.sysEncryptIdentification(baseUri, req4);
            System.out.println("机密性加密：" + JSONUtil.toJsonStr(req4));
            System.out.println("机密性加密：" + JSONUtil.toJsonStr(resp4));

            DecryptDto req5 = new DecryptDto();
            req5.setKey("sm4_1");
            req5.setAlgorithmType("sm4");
            req5.setEncryptData(resp4.getData().toString());
            req5.setEncMode("cbc");
            req5.setIv("AAAAAAAAAAAAAAAAAAAAAA==");
            req5.setPadMode("PKCS5Padding");
            req5.setPlainIsEncode(false);
            EncryptorApiResponse resp5 = flkEncryptorApiProvider.sysDecryptIdentification(baseUri, req5);
            System.out.println("机密性解密：" + JSONUtil.toJsonStr(req5));
            System.out.println("机密性解密：" + JSONUtil.toJsonStr(resp5));


            BatchEncryptDto req6 = new BatchEncryptDto();
            req6.setKey("xQM9Kv70IOfYk0A877Uuiw==");
            req6.setAlgorithmType("sm4");
            req6.setData(Arrays.asList(new DtoTest1(1L,"zhangsan"),new DtoTest1(2L,"lisi")));
            req6.setEncMode("cbc");
            req6.setIv("AAAAAAAAAAAAAAAAAAAAAA==");
            req6.setPadMode("PKCS5Padding");
            req6.setPlainIsEncode(false);
            req6.setSkipFields(Arrays.asList("id"));
            EncryptorApiResponse resp6 = flkEncryptorApiProvider.symmetricEncryptBatch(baseUri, req6);
            System.out.println("批量加密：" + JSONUtil.toJsonStr(req6));
            System.out.println("批量加密：" + JSONUtil.toJsonStr(resp6));


            BatchDecryptDto req7 = new BatchDecryptDto();
            req7.setKey("xQM9Kv70IOfYk0A877Uuiw==");
            req7.setAlgorithmType("sm4");
            req7.setEncryptData(Arrays.asList(new DtoTest1(1L,"3aQ8OGWfpNf6IK2FtOtaug=="),new DtoTest1(2L,"YGJZ2YnYyNxfkhLmb/F+MQ==")));
            req7.setEncMode("cbc");
            req7.setIv("AAAAAAAAAAAAAAAAAAAAAA==");
            req7.setPadMode("PKCS5Padding");
            req7.setPlainIsEncode(false);
            req7.setSkipFields(Arrays.asList("id"));
            EncryptorApiResponse resp7 = flkEncryptorApiProvider.symmetricDecryptBatch(baseUri, req7);
            System.out.println("批量解密：" + JSONUtil.toJsonStr(req7));
            System.out.println("批量解密：" + JSONUtil.toJsonStr(resp7));
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

    }
}
