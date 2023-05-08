package com.hss.anntation;

import java.lang.annotation.*;

/**
 * 自定义标签
 */
@Target(value = {ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited()
public @interface LogAnnotation {
	String desc();
}

