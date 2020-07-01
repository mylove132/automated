package com.xdf.bling.qa.common.entity;

import com.xdf.bling.qa.common.base.CommonCode;
import com.xdf.bling.qa.common.base.ICode;

public class ResultUtil {

    private ResultUtil() throws Exception {
        throw new Exception("响应结果类不需要初始化");
    }

    public static  <T> Result<T> success(T data){
        return success(CommonCode.SUCCESS, data);
    }

    public static  <T> Result<T> fail(String msg){
        CommonCode.FAIL.setCode(msg);
        return fail(CommonCode.FAIL);
    }

    private static <T> Result<T> success(ICode code, T data){
        Result<T> result = new Result<T>();
        result.setMsg(code.msg());
        result.setCode(code.code());
        result.setData(data);
        return result;
    }

    public static <T> Result<T> fail(ICode code){
        Result<T> result = new Result<T>();
        result.setMsg(code.msg());
        result.setCode(code.code());
        result.setData(null);
        return result;
    }
}
