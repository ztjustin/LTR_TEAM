package com.LTR.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.LTR.entity.Annotation;
import com.LTR.repository.AnnotationJpaRepository;
import com.LTR.service.AnnotationService;

@Service("annotationServiceImpl")
public class AnnotationServiceImpl implements AnnotationService {
	
	@Autowired
	@Qualifier("annotationJpaRepository")
	private AnnotationJpaRepository annotationJpaRepository;

	@Override
	public List<Annotation> getAll() {
		return annotationJpaRepository.findAll();
	}

	@Override
	public Annotation getOne(int annotationID) {
		return annotationJpaRepository.getOne(annotationID);
	}

	@Override
	public Annotation addOne(Annotation annotation) {
		return annotationJpaRepository.saveAndFlush(annotation);
	}

	@Override
	public void delete(int annotationID) {
		annotationJpaRepository.deleteById(annotationID);
		
	}
	
	

}
