package com.xdf.bling.qa.common.base;
import lombok.Data;
import java.io.Serializable;

@Data
public class BaseRequest implements Serializable {
    private String requestId;
}
