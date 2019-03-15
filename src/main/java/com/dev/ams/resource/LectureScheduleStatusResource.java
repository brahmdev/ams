package com.dev.ams.resource;

import com.dev.ams.model.LectureScheduleStatus;
import com.dev.ams.repository.LectureStatusRepository;
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
@RequestMapping("/api/v1/admin/lectures/status")
public class LectureScheduleStatusResource {

    @Autowired
    LectureStatusRepository lectureStatusRepository;

    @RequestMapping(value = "/{scheduleId}", method = RequestMethod.GET)
    public Iterable<LectureScheduleStatus> getLectureStatusByscheduleId(@PathVariable String scheduleId) {
        return lectureStatusRepository.findByStatusByScheduleId(scheduleId);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Iterable<LectureScheduleStatus> getAllLecturesStatus() {
        return lectureStatusRepository.findAll();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public LectureScheduleStatus saveOrUpdateLectures(@RequestBody LectureScheduleStatus lecture) {
        return lectureStatusRepository.save(lecture);
    }

    @RequestMapping(value = "/{scheduleId}", method = RequestMethod.DELETE)
    public void deleteByLectureId(@PathVariable String scheduleId) {
        lectureStatusRepository.deleteByLectureScheduleByScheduleId(scheduleId);
    }

}

