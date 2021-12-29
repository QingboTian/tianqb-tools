package cn.tianqb.common.extension.processor;

import cn.tianqb.common.extension.DefaultBusinessContext;
import cn.tianqb.common.extension.annotation.Extension;
import cn.tianqb.common.extension.aware.GlobalContextAware;
import cn.tianqb.common.extension.GlobalContext;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.Aware;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.lang.Nullable;

/**
 * @author tianqb
 * @version 1.0
 * @date 2021/12/29 15:05
 **/
public class BusinessExtProcessor implements ApplicationContextAware, BeanPostProcessor, BeanFactoryPostProcessor {
    private GlobalContext globalContext = new GlobalContext();
    private ApplicationContext applicationContext;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Aware) {
            if (bean instanceof GlobalContextAware) {
                GlobalContext beanContext = applicationContext.getBean(GlobalContext.class);
                ((GlobalContextAware) bean).setGlobalContext(beanContext);
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(@Nullable Object bean, String beanName) throws BeansException {
        if (bean != null) {
            if (AnnotationUtils.isAnnotationDeclaredLocally(Extension.class, bean.getClass()) || AnnotationUtils.isAnnotationInherited(Extension.class, bean.getClass())) {
                Extension annotation = bean.getClass().getAnnotation(Extension.class);
                DefaultBusinessContext<String, Object> defaultContext = new DefaultBusinessContext<>();
                String key;
                if (StringUtils.isEmpty(annotation.key()) && StringUtils.isEmpty(annotation.id())) {
                    throw new RuntimeException("annotation Extension key is empty");
                }
                if (!StringUtils.isEmpty(annotation.key())) {
                    key = annotation.key();
                } else {
                    try {
                        ExpressionParser parser = new SpelExpressionParser();
                        Expression exp = parser.parseExpression(annotation.id());
                        key = exp.getValue(String.class);
                    } catch (Exception ex) {
                        throw new RuntimeException("spel parser error, exception is" + ex.getMessage());
                    }
                }
                if (StringUtils.isEmpty(key)) {
                    throw new RuntimeException("annotation Extension key is empty");
                }
                if (!annotation.extClass().isInstance(bean)) {
                    String format = String.format("@Extension field [extClass] checked error, extClass = %s, class = %s", annotation.extClass(), bean.getClass());
                    throw new RuntimeException(format);
                }
                defaultContext.regist(key, bean);
                globalContext.createContext(annotation.extClass(), defaultContext);
            }
        }
        return bean;
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        configurableListableBeanFactory.registerSingleton("globalContext", globalContext);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
