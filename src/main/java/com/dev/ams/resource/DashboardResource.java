package com.dev.ams.resource;

import com.dev.ams.model.Batch;
import com.dev.ams.model.DashBoard;
import com.dev.ams.model.PieData;
import com.dev.ams.model.Standard;
import com.dev.ams.repository.BatchRepository;
import com.dev.ams.repository.StandardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/admin/dashboard")
public class DashboardResource {

    @Autowired
    StandardRepository standardRepository;

    private static Map<Integer, String> STANDARD_COLOR = new HashMap<>();
    static {
        STANDARD_COLOR.put(1, "#3bb773");
        STANDARD_COLOR.put(2, "#9E7BFF");
        STANDARD_COLOR.put(3, "#852b99");
        STANDARD_COLOR.put(4, "#FF2800");
        STANDARD_COLOR.put(5, "#2d64cb");
        STANDARD_COLOR.put(6, "#7EF9FF");
        STANDARD_COLOR.put(7, "#0D98BA");
        STANDARD_COLOR.put(8, "#FCE205");
        STANDARD_COLOR.put(9, "#FFB3DE");
        STANDARD_COLOR.put(10, "#EFC0FE");
        STANDARD_COLOR.put(11, "#FFA600");
        STANDARD_COLOR.put(12, "#A2CFFE");
    }
    @RequestMapping(value = "/{branchId}", method = RequestMethod.GET)
    public DashBoard getDashBoardData(@PathVariable Integer branchId) {
        Iterable<Standard> standards = standardRepository.findAllStandardByBranchId(branchId);
        Iterator iterator = standards.iterator();
        int count = 1;
        List<PieData> pieDataList = new ArrayList<>();
        List<Standard> standardList = new ArrayList<>();
        while (iterator.hasNext()) {
            Standard standard = (Standard)iterator.next();
            standard.setColor(STANDARD_COLOR.get(count));
            int studentCount = 0;
            PieData pieData = new PieData();
            pieData.setName(standard.getName());
            pieData.setLegendFontColor("#7F7F7F");
            pieData.setLegendFontSize("15");
            for (Batch batch : standard.getBatchs()) {
                studentCount += batch.getStudentDetailses().size();
            }
            pieData.setStudentCount(studentCount);
            pieData.setColor(STANDARD_COLOR.get(count));
            pieDataList.add(pieData);
            standardList.add(standard);
            count++;
        }
        DashBoard dashBoard = new DashBoard();
        dashBoard.setPieDataList(pieDataList);
        dashBoard.setStandardList(standardList);
        return dashBoard;
    }
}
