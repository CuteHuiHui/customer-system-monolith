package org.geekbang.projects.cs.provider.flk;

import lombok.Data;

/**
 * {
 * "identification":"sm4_1"
 * }
 */
@Data
public class IdentificationDto {
    /**
     * 密钥标识：必填
     * 密钥标识，长度小于等于28，字符英文数字和下划线，用于完整性校验
     */
    private String identification;
}
