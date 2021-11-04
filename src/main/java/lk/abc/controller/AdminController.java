package lk.abc.controller;


import lk.abc.dto.AdminDTO;
import lk.abc.exception.NotFoundException;
import lk.abc.service.AdminService;
import lk.abc.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * @author Tharushi Welarathna <nirmanitharushi1@gmail.com>
 * @since 10/25/2021
 */
@RestController
@RequestMapping("api/v1/admin")
@CrossOrigin
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveAdmin(@RequestBody AdminDTO dto) {
        if (dto.getAdminemail().trim().length() <= 0) {
            throw new NotFoundException("Admin id cannot be empty");
        }
        adminService.addAdmin(dto);
        return new ResponseEntity(new StandardResponse("201", "Done", dto), HttpStatus.CREATED);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllAdmins() {
        ArrayList<AdminDTO> allAdmins= adminService.getAllAdmin();
        return new ResponseEntity(new StandardResponse("200", "Done", allAdmins), HttpStatus.OK);
    }


    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity searchAdmin(@PathVariable String id) {
        AdminDTO adminDTO = adminService.searchAdmin(id);
        return new ResponseEntity(new StandardResponse("200", "Done", adminDTO), HttpStatus.OK);
    }

    @DeleteMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteAdmin(@RequestParam String id) {
        adminService.deleteAdmin(id);
        return new ResponseEntity(new StandardResponse("200", "Done", null), HttpStatus.OK);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateAdmin(@RequestBody AdminDTO dto) {
        if (dto.getAdminemail().trim().length() <= 0) {
            throw new NotFoundException("No id provided to update");
        }
        adminService.updateAdmin(dto);
        return new ResponseEntity(new StandardResponse("200", "Done", dto), HttpStatus.OK);
    }


}
