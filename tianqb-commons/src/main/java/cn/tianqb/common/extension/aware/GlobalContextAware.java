package cn.tianqb.common.extension.aware;

import cn.tianqb.common.extension.GlobalContext;
import org.springframework.beans.factory.Aware;

/**
 * @author tianqb
 * @version 1.0
 * @date 2021/12/29 15:05
 **/
public interface GlobalContextAware extends Aware {
    void setGlobalContext(GlobalContext globalContext);
}
