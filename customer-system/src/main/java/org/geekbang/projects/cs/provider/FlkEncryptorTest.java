package org.geekbang.projects.cs.provider;

import cn.hutool.json.JSONUtil;
import org.geekbang.projects.cs.Application;
import org.geekbang.projects.cs.entity.staff.CustomerStaff;
import org.geekbang.projects.cs.service.ICustomerStaffService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;

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
//        try {
//            URI baseUri = new URI("https://10.20.141.134:9443/hamc1248");
//            HmacIdentificationDto req1 = new HmacIdentificationDto();
//            req1.setLength(16);
//            req1.setIdentification("sm1_1");
//            EncryptorApiResponse resp1 = flkEncryptorApiProvider.hmacIdentification(baseUri, req1);
//            System.out.println("完整性：" + JSONUtil.toJsonStr(resp1));
//
//            HmacWithIdentDto req2 = new HmacWithIdentDto();
//            req2.setKey("sm1_1");
//            req2.setPlainIsEncode(false);
//            req2.setData("fhasdfff");
//            EncryptorApiResponse resp2 = flkEncryptorApiProvider.hmacWithIdent(baseUri, req2);
//            System.out.println("完整性：" + JSONUtil.toJsonStr(resp2));
//
//            IdentificationDto req3 = new IdentificationDto();
//            req3.setIdentification("sm4_1");
//            EncryptorApiResponse resp3 = flkEncryptorApiProvider.symmetricIdentification(baseUri, req3);
//            System.out.println("机密性：" + JSONUtil.toJsonStr(resp3));
//
//            EncryptDto req4 = new EncryptDto();
//            req4.setKey("sm4_1");
//            req4.setAlgorithmType("sm4");
//            req4.setData("1234567812345678");
//            req4.setEncMode("cbc");
//            req4.setIv("AAAAAAAAAAAAAAAAAAAAAA==");
//            req4.setPadMode("PKCS5Padding");
//            req4.setPlainIsEncode(false);
//            EncryptorApiResponse resp4 = flkEncryptorApiProvider.sysEncryptIdentification(baseUri, req4);
//            System.out.println("机密性加密：" + JSONUtil.toJsonStr(resp4));
//
//            DecryptDto req5 = new DecryptDto();
//            req5.setKey("sm4_1");
//            req5.setAlgorithmType("sm4");
//            req5.setEncryptData("fe9nL3aTCAbTa9hIBseK5fFljWvIYnyczInmVIioqVE");
//            req5.setEncMode("cbc");
//            req5.setIv("AAAAAAAAAAAAAAAAAAAAAA==");
//            req5.setPadMode("PKCS5Padding");
//            req5.setPlainIsEncode(false);
//            EncryptorApiResponse resp5 = flkEncryptorApiProvider.sysDecryptIdentification(baseUri, req5);
//            System.out.println("机密性解密：" + JSONUtil.toJsonStr(resp5));
//        } catch (URISyntaxException e) {
//            throw new RuntimeException(e);
//        }

//        ICustomerStaffService bean = SpringContextHolder.getBean(ICustomerStaffService.class);
    }
}
