package CNAM.example.CNAM.BACKEND.Controllers;

import CNAM.example.CNAM.BACKEND.Models.BordereauCnam;
import CNAM.example.CNAM.BACKEND.Repositories.BordereauCnamRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cnam/bordereauCnam")
public class BordereauCnamController {

    private final BordereauCnamRepository bordereauCnamRepository;

    // @Autowired
    public BordereauCnamController(BordereauCnamRepository bordereauCnamRepository) {
        this.bordereauCnamRepository = bordereauCnamRepository;
    }

    @GetMapping
    public List<BordereauCnam> getAllBordereaux() {
        return bordereauCnamRepository.findAll();
    }

    @PostMapping("/saveBordereau")
    public BordereauCnam saveBordereau(@RequestBody BordereauCnam bordereauCnam) {
        return bordereauCnamRepository.save(bordereauCnam);
    }

    // @PostMapping("/saveBordereauWithBulletinNum")
    // public void saveBordereauWithBulletinNum(@RequestBody BordereauCnam bordereauCnam) {
    //     bordereauCnamRepository.saveBordereauWithBulletinNum(bordereauCnam);
    // }
    
}
