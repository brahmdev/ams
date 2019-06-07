package com.dev.ams.resource;

import com.dev.ams.model.Subject;
import com.dev.ams.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/v1/admin/subjects")
public class SubjectResource {

    @Autowired
    SubjectRepository subjectRepository;

    @RequestMapping(value = "/{instituteId}", method = RequestMethod.GET)
    public Iterable<Subject> getAllSubjects(@PathVariable Integer instituteId) {
        return subjectRepository.findAllSubjectByInstituteId(instituteId);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Subject saveOrUpdateSubject(@RequestBody Subject subject) {
        return subjectRepository.save(subject);
    }

    @RequestMapping(value = "/{subjectId}", method = RequestMethod.DELETE)
    public void deleteSubject(@PathVariable Integer subjectId) {
        subjectRepository.deleteBySubjectId(subjectId);
    }

    //TODO need to write an endpoint which will accept subject name, standard name, board name and language to return exact one standard detail

}
