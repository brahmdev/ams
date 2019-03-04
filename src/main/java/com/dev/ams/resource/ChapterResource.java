package com.dev.ams.resource;

import com.dev.ams.model.Chapter;
import com.dev.ams.repository.ChapterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/v1/admin/chapters")
public class ChapterResource {

    @Autowired
    ChapterRepository chapterRepository;

    @RequestMapping(value = "/{chapterName}", method = RequestMethod.GET)
    public Iterable<Chapter> getChapter(@PathVariable String chapterName) {
        return chapterRepository.findByChapterName(chapterName);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Iterable<Chapter> getAllChapters() {
        return chapterRepository.findAll();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Chapter saveOrUpdateChapter(@RequestBody Chapter chapter) {
        return chapterRepository.save(chapter);
    }

    @RequestMapping(value = "/{chapterName}", method = RequestMethod.DELETE)
    public void deleteChapter(@PathVariable String chapterName) {
        chapterRepository.deleteByChapterName(chapterName);
    }

    //TODO need to write an endpoint which will accept subject name, standard name, board name and language to return exact one standard detail

}
