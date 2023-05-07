package com.hss.config.typeFilter;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

public class MyTypeFilter implements TypeFilter {

	/**
	 *
	 * @param metadataReader 读取到当前正在扫描的信息
	 * @param metadataReaderFactory 可以读取到其他任何类的信息
	 * for other classes (such as superclasses and interfaces)
	 * @return
	 * @throws IOException
	 */
	@Override
	public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
		//获取当前类注解的信息
		AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
		//获取当前类的类信息
		ClassMetadata classMetadata = metadataReader.getClassMetadata();
		//获取当前类资源（如类的路径）
		Resource resource = metadataReader.getResource();
		if(classMetadata.getClassName().equals("com.hss.domain.Person")){
			return true;
		}
		return false;
	}
}
