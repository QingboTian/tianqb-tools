package cn.tianqb.extension;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @author tianqingbo3
 * @version 1.0
 * @date 2021/12/29 20:56
 */
@Getter
@Setter
@ToString
public class Pipeline {

    private List<Class<ExtensionPoint>> handler;
}
