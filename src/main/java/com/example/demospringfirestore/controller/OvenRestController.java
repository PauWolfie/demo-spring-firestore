package com.example.demospringfirestore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demospringfirestore.dto.OvenDTO;
import com.example.demospringfirestore.model.Oven;
import com.example.demospringfirestore.service.api.OvenServiceAPI;

@RestController
@RequestMapping(value = "/mychef-api/oven")
@CrossOrigin("*")
public class OvenRestController {

	@Autowired
	private OvenServiceAPI ovenServiceAPI;

	@GetMapping(value = "/all")
	public List<OvenDTO> getAll() throws Exception {
		return ovenServiceAPI.getAll();
	}

	@GetMapping(value = "/find/{id}")
	public OvenDTO find(@PathVariable String id) throws Exception {
		return ovenServiceAPI.get(id);
	}

	@PostMapping(value = "/save/{id}")
	public ResponseEntity<String> save(@RequestBody Oven oven, @PathVariable String id) throws Exception {
		if (id == null || id.length() == 0 || id.equals("null")) {
			id = ovenServiceAPI.save(oven);
		} else {
			ovenServiceAPI.save(oven, id);
		}
		return new ResponseEntity<String>(id, HttpStatus.OK);
	}

	@GetMapping(value = "/delete/{id}")
	public ResponseEntity<OvenDTO> delete(@PathVariable String id) throws Exception {
		OvenDTO oven = ovenServiceAPI.get(id);
		if (oven != null) {
			ovenServiceAPI.delete(id);
		} else {
			return new ResponseEntity<OvenDTO>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<OvenDTO>(oven, HttpStatus.OK);
	}

}
