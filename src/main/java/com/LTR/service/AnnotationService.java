package com.LTR.service;

import java.util.List;

import com.LTR.entity.Annotation;

public interface AnnotationService {
	
	public abstract List<Annotation> getAll();
	
	public abstract Annotation getOne(int annotationID);
	
	public abstract Annotation addOne(Annotation annotation);
	
	public abstract void delete(int annotationID);
	
}
