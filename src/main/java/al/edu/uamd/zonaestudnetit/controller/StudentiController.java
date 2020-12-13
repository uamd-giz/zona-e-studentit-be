package al.edu.uamd.zonaestudnetit.controller;

import al.edu.uamd.zonaestudnetit.model.Student;
import al.edu.uamd.zonaestudnetit.service.StudentiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.List;

@RestController
public class StudentiController {

    Logger logger = LoggerFactory.getLogger(StudentiController.class);

    @Autowired
    StudentiService ss;

    @GetMapping(value = "/studentet" )
    public ResponseEntity<List<Student>> ngarkoStudentet(){
        try {

            return new ResponseEntity<>(ss.ngarkoStudentet(), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/studentet" )
    public ResponseEntity<Student> ruajStudentet(@RequestBody Student student){
        try {
            logger.info("Thirrje per ruajtjen e te dhenave te studentit!");
            ss.ruajTeDhenatEStudentit(student);
            return new ResponseEntity<Student>(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            logger.error("Ruajtja e studentit nuk u realizua me sukses!", e);
            return new ResponseEntity<Student>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
