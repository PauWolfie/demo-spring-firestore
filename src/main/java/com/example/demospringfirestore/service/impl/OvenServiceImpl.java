package com.example.demospringfirestore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demospringfirestore.commons.GenericServiceImpl;
import com.example.demospringfirestore.dto.OvenDTO;
import com.example.demospringfirestore.model.Oven;
import com.example.demospringfirestore.service.api.OvenServiceAPI;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.Firestore;

@Service
public class OvenServiceImpl extends GenericServiceImpl<Oven, OvenDTO> implements OvenServiceAPI {
	
	@Autowired
	private Firestore firestore;

	@Override
	public CollectionReference getCollection() {
		return firestore.collection("ovens");
	}

}
