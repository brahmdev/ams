package com.dev.ams.resource;

import com.dev.ams.model.Standard;
import com.dev.ams.repository.StandardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/admin/standards")
public class StandardResource {

    @Autowired
    StandardRepository standardRepository;

    @RequestMapping(value = "/{branchId}", method = RequestMethod.GET)
    public Iterable<Standard> getAllStandard(@PathVariable Integer branchId) {
        return standardRepository.findAllStandardByBranchId(branchId);
    }

    @RequestMapping(value = "/{branchId}/lookup", method = RequestMethod.GET)
    public Map<Integer, String> getAllStandardsLookUp(@PathVariable Integer branchId) {
        Iterable<Standard> standards = standardRepository.findAllStandardByBranchId(branchId);
        Map<Integer, String> standardLookUp = new HashMap<Integer, String>();
        for (Standard standard: standards) {
            standardLookUp.put(standard.getId(), standard.getCode());
        }
        return standardLookUp;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Standard saveOrUpdateStandard(@RequestBody Standard standard) {
        return standardRepository.save(standard);
    }

    @RequestMapping(value = "/{standardId}", method = RequestMethod.DELETE)
    public void deleteStandard(@PathVariable Integer standardId) {
        standardRepository.deleteByStandardId(standardId);
    }

    //TODO need to write an endpoint which will accept standard name, board name and language to return exact one standard detail
}
