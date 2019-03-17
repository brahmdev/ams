package com.dev.ams.resource;

import com.dev.ams.model.StudentAttendance;
import com.dev.ams.repository.StudentAttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/teacher/attendance")
public class StudentAttendanceResource {

    @Autowired
    StudentAttendanceRepository studentAttendanceRepository;

    @RequestMapping(value = "/id/{studentDetailId}", method = RequestMethod.GET)
    public Iterable<StudentAttendance> getStudentAttendanceById(@PathVariable Integer studentDetailId) {
        return studentAttendanceRepository.findByStudentDetailId(studentDetailId);
    }

    @RequestMapping(value = "/{studentName}", method = RequestMethod.GET)
    public Iterable<StudentAttendance> getStudentAttendanceByName(@PathVariable String studentName) {
        return studentAttendanceRepository.findAttendanceByStudentName(studentName);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Iterable<StudentAttendance> getAllStudentAttendance() {
        return studentAttendanceRepository.findAll();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public StudentAttendance saveOrUpdateStandard(@RequestBody StudentAttendance studentAttendance) {
        return studentAttendanceRepository.save(studentAttendance);
    }
}
