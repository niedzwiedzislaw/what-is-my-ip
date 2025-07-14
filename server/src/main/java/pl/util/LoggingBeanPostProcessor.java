package pl.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Component
public class LoggingBeanPostProcessor implements BeanPostProcessor {
    Logger logger = LoggerFactory.getLogger(LoggingBeanPostProcessor.class.getSimpleName());

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        logger.debug("Post-processing before initialization: {}", beanName);
        Field[] fields = bean.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (Logger.class.isAssignableFrom(field.getType()) && field.getAnnotation(Logging.class) != null) {
                try {
                    boolean access = field.canAccess(bean);
                    field.setAccessible(true);
                    field.set(bean, LoggerFactory.getLogger(bean.getClass()));
                    field.setAccessible(access);
                } catch (IllegalAccessException e) {
                    logger.error("Failure while setting logger in bean", e);
                }
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
