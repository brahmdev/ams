package com.dev.ams.resource;

import com.dev.ams.model.Branch;
import com.dev.ams.repository.BranchRepository;
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
@RequestMapping("/api/v1/admin/branches")
public class BranchResource {

    @Autowired
    BranchRepository branchRepository;

    @RequestMapping(value = "/{instituteId}", method = RequestMethod.GET)
    public Iterable<Branch> getAllBranches(@PathVariable Integer instituteId) {
        return branchRepository.findAllBranchByInstituteId(instituteId);
    }

    @RequestMapping(value = "/{instituteId}/lookup", method = RequestMethod.GET)
    public Map<Integer, String> getAllBranchsLookUp(@PathVariable Integer instituteId) {
        Iterable<Branch> branches = branchRepository.findAllBranchByInstituteId(instituteId);
        Map<Integer, String> branchLookUp = new HashMap<Integer, String>();
        for (Branch branch: branches) {
            branchLookUp.put(branch.getId(), branch.getCode());
        }
        return branchLookUp;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Branch saveOrUpdateBranch(@RequestBody Branch branch) {
        return branchRepository.save(branch);
    }

    @RequestMapping(value = "/{branchId}", method = RequestMethod.DELETE)
    public void deleteBranch(@PathVariable("branchId") Integer branchId) {
        branchRepository.deleteByBranchId(branchId);
    }


}
