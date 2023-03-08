package teamWeb.utils;

import org.springframework.beans.BeanUtils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.stream.Collectors;

public class BeanUtil {

    public static <T, K> void merge(T dest, K src) {
        BeanInfo destBeanInfo;
        BeanInfo srcBeanInfo;
        try {
            destBeanInfo = Introspector.getBeanInfo(dest.getClass());
            srcBeanInfo = Introspector.getBeanInfo(src.getClass());
        } catch (IntrospectionException e) {
            return;
        }

        Map<String, PropertyDescriptor> srcDescriptorMap = new HashMap<String, PropertyDescriptor>();
        for (PropertyDescriptor srcDescriptor : srcBeanInfo.getPropertyDescriptors()) {
            if (srcDescriptor.getReadMethod() != null) {
                srcDescriptorMap.put(srcDescriptor.getReadMethod().getName(), srcDescriptor);
            }
        }

        try {
            for (PropertyDescriptor destDescriptor : destBeanInfo.getPropertyDescriptors()) {

                if (destDescriptor.getWriteMethod() == null || destDescriptor.getReadMethod() == null) {
                    continue;
                }

                PropertyDescriptor srcDescriptor = srcDescriptorMap.get(destDescriptor.getReadMethod().getName());
                if (srcDescriptor == null) {
                    continue;
                }

                Object srcValue = srcDescriptor.getReadMethod().invoke(src);
                if (srcValue == null) {
                    continue;
                }
                destDescriptor.getWriteMethod().invoke(dest, srcValue);

            }
        } catch (InvocationTargetException | IllegalAccessException e) {
            return;
        }
    }

    public static <T> T makeNullValueBean(Class<T> tClass) {
        try {
            T t = tClass.newInstance();

            Arrays.asList(t.getClass().getDeclaredFields()).forEach(field -> {
                field.setAccessible(true);
                try {
                    field.set(t, null);
                } catch (IllegalAccessException e) {

                }
            });

            return t;
        } catch (InstantiationException | IllegalAccessException e) {
            return null;
        }
    }

    public static <T> T makeNullValueBean(T t) {
        Arrays.asList(t.getClass().getDeclaredFields()).forEach(field -> {
            field.setAccessible(true);
            try {
                field.set(t, null);
            } catch (IllegalAccessException e) {

            }
        });
        return t;
    }


    public static <R, T> R newAndCopy(T source, Class<R> targetClass) {
        if (source == null) {
            return null;
        }

        R target;
        try {
            target = targetClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            return null;
        }
        if (target == null) {
            return null;
        }
        BeanUtils.copyProperties(source, target);
        return target;
    }

    public static <R, T> List<R> newAndCopy(List<T> sourceList, Class<R> targetClass) {
        if (sourceList == null) {
            return null;
        }
        return sourceList.stream().map(source -> {
            R target = newAndCopy(source, targetClass);
            return target;
        }).filter(Objects::nonNull).collect(Collectors.toList());
    }


    public static <R, T> R convert(T source, Class<R> targetClass) {
        return newAndCopy(source, targetClass);
    }

    public static <R, T> List<R> convert(List<T> sourceList, Class<R> targetClass) {
        return newAndCopy(sourceList, targetClass);
    }

    public static <R, T> R convert(T source, R target) {
        if (source == null) {
            return null;
        }
        BeanUtils.copyProperties(source, target);
        return target;
    }

    public static <R, T> R copy(T source, R target) {
        if (source == null || target == null) {
            return target;
        }
        BeanUtils.copyProperties(source, target);
        return target;
    }
}
