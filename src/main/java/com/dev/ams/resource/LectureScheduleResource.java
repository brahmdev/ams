package com.dev.ams.resource;

import com.dev.ams.model.LectureSchedule;
import com.dev.ams.repository.LecturesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin/lectures")
public class LectureScheduleResource {

    @Autowired
    LecturesRepository lectureRepository;

    @RequestMapping(value = "/{lectureId}", method = RequestMethod.GET)
    public Iterable<LectureSchedule> getLectureById(@PathVariable String lectureId) {
        return lectureRepository.findByLectureId(lectureId);
    }

    @RequestMapping(value = "/subjects/{subjectId}", method = RequestMethod.GET)
    public Iterable<LectureSchedule> getLecturueBySubject(@PathVariable String subjectId) {
        return lectureRepository.findBySubjectId(subjectId);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Iterable<LectureSchedule> getAllLectures() {
        return lectureRepository.findAll();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public LectureSchedule saveOrUpdateLectures(@RequestBody LectureSchedule lecture) {
        return lectureRepository.save(lecture);
    }

    @RequestMapping(value = "/{lectureId}", method = RequestMethod.DELETE)
    public void deleteByLectureId(@PathVariable String lectureId) {
        lectureRepository.deleteByLectureId(lectureId);
    }

    @RequestMapping(value = "/subjects/{subjectId}", method = RequestMethod.DELETE)
    public void deleteBySubjectId(@PathVariable String subjectId) {
        lectureRepository.deleteBySubjectId(subjectId);
    }

}
