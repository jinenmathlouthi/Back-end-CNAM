package CNAM.example.CNAM.BACKEND.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import CNAM.example.CNAM.BACKEND.Services.SapConnectionService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/sap")
public class SapConnectionController {

    @Autowired
    private SapConnectionService sapConnectionService;

    @GetMapping("/connect")
    public ResponseEntity<?> createConnection() {
        try {
            
            return new ResponseEntity<>(sapConnectionService.createSapConnection(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getdata")
    public ResponseEntity<?> getUsers() {
        try {
            
            return new ResponseEntity<>(sapConnectionService.getUsers(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
