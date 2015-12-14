package com.app;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.domain.EntityList;
import com.domain.FakeResource;

@RestController
@RequestMapping("/fakeresource")
public class FakeResourceController {

	private static List<FakeResource> resList = new ArrayList<>();

	static {
		resList.add(
				new FakeResource(1, "first_res", "It is a first resource!"));
		resList.add(new FakeResource(2, "second_res",
				"just another second resource"));
	}

	@RequestMapping(value = "/{resourceId}", method = RequestMethod.GET)
	public ResponseEntity<FakeResource> getFakeResource(
			@PathVariable Long resourceId) {
		for (FakeResource resource : resList) {
			if (resource.getId() == resourceId) {
				return new ResponseEntity<FakeResource>(resource,
						HttpStatus.OK);
			}
		}
		return new ResponseEntity<FakeResource>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(method = RequestMethod.GET)
	EntityList<FakeResource> returnAllFakeResources() {
		EntityList<FakeResource> listOfFakeResources = new EntityList<>(resList);
		return listOfFakeResources;
	}

	@RequestMapping(method = RequestMethod.POST)
	ResponseEntity<?> addFakeResource(@RequestBody FakeResource input) {

		FakeResource newRes = new FakeResource(getFakeResourceNextId(),
				input.getName(), input.getDescription());
		resList.add(newRes);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setLocation(ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(newRes.getId()).toUri());
		return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);

	}

	private long getFakeResourceNextId() {

		long result = 0;
		for (FakeResource resource : resList) {
			if (resource.getId() >= result) {
				result = resource.getId() + 1;
			}
		}

		return result;
	}

}
