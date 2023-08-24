package org.geekbang.projects.cs.provider.flk;

import lombok.Data;

/**
 * {
 * "identification":"sm1_1",
 * "length":16
 * }
 */
@Data
public class HmacIdentificationDto extends IdentificationDto {
    /**
     * 长度：必填
     * 16的倍数，最大128
     */
    private Integer length;
}
