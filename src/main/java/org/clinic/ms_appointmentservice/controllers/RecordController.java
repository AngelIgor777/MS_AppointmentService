package org.clinic.ms_appointmentservice.controllers;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.clinic.ms_appointmentservice.entity.Record;
import org.clinic.ms_appointmentservice.service.DoctorService;
import org.clinic.ms_appointmentservice.service.RecordService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/records")
@RequiredArgsConstructor
@Slf4j
public class RecordController {
    private final RecordService recordService;
    private final DoctorService doctorService;


    @PostMapping
    //todo test record availability
    public ResponseEntity<Record> createRecord(@RequestBody Record record) {
        boolean checkTimeAvailability = doctorService.checkTimeAvailability(record.getDoctorId(), record.getTime());
        if (checkTimeAvailability){
            Record createdRecord = recordService.saveRecord(record);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdRecord);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping
    public ResponseEntity<List<Record>> getAllRecords() {
        List<Record> allRecords = recordService.findAll();
        if (allRecords.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(allRecords);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Record> getRecordByID(@PathVariable Long id) {
        Optional<Record> optionalRecord = Optional.ofNullable(recordService.findById(id));
        if (optionalRecord.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(optionalRecord.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Record> editRecord(@PathVariable Long id, @RequestBody Record record) {
        Record changedRecord = recordService.updateRecord(id, record);
        return ResponseEntity.ok(changedRecord);
    }


}
