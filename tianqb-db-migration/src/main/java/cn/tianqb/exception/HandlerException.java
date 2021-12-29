package cn.tianqb.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tianqingbo3
 * @version 1.0
 * @date 2021/12/20 17:10
 */
@ControllerAdvice
@Slf4j
public class HandlerException {

    @ExceptionHandler(value = SystemException.class)
    @ResponseBody
    public Map<String, Object> systemException(SystemException e) {
        Map<String, Object> result = new HashMap<>(8);
        result.put("code", e.getCode());
        result.put("msg", e.getMessage());
        return result;
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Map<String, Object> exception(Exception e) {
        Map<String, Object> result = new HashMap<>(8);
        result.put("code", 500);
        result.put("msg", "服务异常，请稍后再试");
        return result;
    }

}
