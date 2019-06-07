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

@RestController
@RequestMapping("/api/v1/admin/standards")
public class StandardResource {

    @Autowired
    StandardRepository standardRepository;

  /*  @RequestMapping(value = "/{standardName}", method = RequestMethod.GET)
    public Iterable<Standard> getStandard(@PathVariable String standardName) {
        return standardRepository.findByStandardName(standardName);
    }
*/
    @RequestMapping(value = "/{instituteId}", method = RequestMethod.GET)
    public Iterable<Standard> getAllStandard(@PathVariable Integer instituteId) {
        return standardRepository.findAllStandardByInstituteId(instituteId);
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
