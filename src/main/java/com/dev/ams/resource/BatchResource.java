package com.dev.ams.resource;

import com.dev.ams.model.Batch;
import com.dev.ams.repository.BatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/admin/batches")
public class BatchResource {

    @Autowired
    BatchRepository batchRepository;

    @RequestMapping(value = "/{branchId}", method = RequestMethod.GET)
    public Iterable<Batch> getAllBatch(@PathVariable Integer branchId) {
        return batchRepository.findAllBatchByBranchId(branchId);
    }

    @RequestMapping(value = "/standard/{standardId}/lookup", method = RequestMethod.GET)
    public Map<Integer, String> getAllBatchOfStandard(@PathVariable Integer standardId) {
        Iterable<Batch> batches =  batchRepository.findAllBatchByStandardId(standardId);
        Map<Integer, String> batchLookUp = new HashMap<Integer, String>();
        for (Batch batch: batches) {
            batchLookUp.put(batch.getId(), batch.getCode());
        }
        return batchLookUp;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Batch saveOrUpdateBatch(@RequestBody Batch batch) {
        if (batch.getCreated() == null) {
            batch.setCreated(new Date());
        } else {
            batch.setUpdated(new Date());
        }
        return batchRepository.save(batch);
    }

    @RequestMapping(value = "/{batchId}", method = RequestMethod.DELETE)
    public void deleteBatch(@PathVariable Integer batchId) {
        batchRepository.deleteByBatchId(batchId);
    }

    //TODO need to write an endpoint which will accept Batch name, board name and language to return exact one Batch detail
}
