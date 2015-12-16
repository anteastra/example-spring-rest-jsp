package com.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.domain.EntityList;
import com.domain.FakeResource;
import com.domain.FakeResourceV1;
import com.domain.FakeResourceV2;


@RestController
@RequestMapping("/fakeversion")
public class FakeResourceControllerVersion {
	
	private static FakeResourceV1 res1 = new FakeResourceV1("v1"); 
	private static FakeResourceV2 res2 = new FakeResourceV2("v2", "it is new resource");

	@RequestMapping(method = RequestMethod.GET, headers={"Accept=application/vnd.company.app-2.0.0+json", "Accept=application/vnd.company.app-2.0.0+xml"})
	ResponseEntity<FakeResourceV2> returnFakeResourcesNew() {
		return new ResponseEntity<FakeResourceV2>(res2, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, headers={"Accept=application/vnd.company.app-1.0.0+json", "Accept=application/vnd.company.app-1.0.0+xml"})
	ResponseEntity<FakeResourceV1> returnFakeResourcesOld() {
		return new ResponseEntity<FakeResourceV1>(res1, HttpStatus.OK);
	}

}
