package CNAM.example.CNAM.BACKEND.Controllers;

import CNAM.example.CNAM.BACKEND.Models.BordereauAssurance;
import CNAM.example.CNAM.BACKEND.Repositories.BordereauAssuranceRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cnam/bordereauAssurance")
public class BordereauAssuranceController {

    private final BordereauAssuranceRepository bordereauAssuranceRepository;

    // @Autowired
    public BordereauAssuranceController(BordereauAssuranceRepository bordereauAssuranceRepository) {
        this.bordereauAssuranceRepository = bordereauAssuranceRepository;
    }

    @GetMapping
    public List<BordereauAssurance> getAllBordereaux() {
        return bordereauAssuranceRepository.findAll();
    }

    @PostMapping("/saveBordereau")
    public BordereauAssurance saveBordereau(@RequestBody BordereauAssurance bordereauAssurance) {
        return bordereauAssuranceRepository.save(bordereauAssurance);
    }

    
}
