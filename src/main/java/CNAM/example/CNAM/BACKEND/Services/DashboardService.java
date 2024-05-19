package CNAM.example.CNAM.BACKEND.Services;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CNAM.example.CNAM.BACKEND.Models.Facture;
import CNAM.example.CNAM.BACKEND.Repositories.AdherentRepository;
import CNAM.example.CNAM.BACKEND.Repositories.AffilieRepository;
import CNAM.example.CNAM.BACKEND.Repositories.BulletinAssuranceRepository;
import CNAM.example.CNAM.BACKEND.Repositories.BulletinCnamRepository;
import CNAM.example.CNAM.BACKEND.Repositories.EtablissementMedecinRepository;
import CNAM.example.CNAM.BACKEND.Repositories.FactureRepository;
import CNAM.example.CNAM.BACKEND.Repositories.PharmacieRepository;
import CNAM.example.CNAM.BACKEND.Repositories.UtilisateurRepository;

@Service
public class DashboardService {

  @Autowired
    private BulletinCnamRepository bulletinCnamRepository;

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private FactureRepository factureRepository;

    @Autowired
    private BulletinAssuranceRepository bulletinAssuranceRepository;

    @Autowired
    private AdherentRepository adherentRepository;

    @Autowired
    private AffilieRepository affilieRepository;

    @Autowired
    private EtablissementMedecinRepository etablissementMedecinRepository;

    @Autowired
    private PharmacieRepository pharmacieRepository;

    public int[] getBulletinsValidesChartData() {
        int bulletinsValides = bulletinCnamRepository.countByValide(true);
        int bulletinsNonValides = bulletinCnamRepository.countByValide(false);
        return new int[] { bulletinsValides, bulletinsNonValides };
    }

    public int[] getConnectedUsersChartData() {
        int usersConnected = utilisateurRepository.countByStatus("connected");
        int usersNotConnected = utilisateurRepository.countByStatus("never_connected");
        return new int[] { usersConnected, usersNotConnected };
    }

 
   public int[] getFactureChartData() {
        List<Facture> factures = factureRepository.findAllByDateFinIsNotNull();
        int[] facturesParMois = new int[12]; 

        for (Facture facture : factures) {
           
            LocalDate dateFin = facture.getDateFin().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            int mois = dateFin.getMonthValue() - 1; 
            facturesParMois[mois]++;
        }

        return facturesParMois;
    }


    public int[] getBulletinsCnamChartData() {
        int bulletinsCnamValides = bulletinCnamRepository.countByValide(true);
        int bulletinsCnamNonValides = bulletinCnamRepository.countByValide(false);
        return new int[] { bulletinsCnamValides, bulletinsCnamNonValides };
    }

    public int[] getBulletinsAssuranceChartData() {
        int bulletinsAssuranceValides = bulletinAssuranceRepository.countByValide(true);
        int bulletinsAssuranceNonValides = bulletinAssuranceRepository.countByValide(false);
        return new int[] { bulletinsAssuranceValides, bulletinsAssuranceNonValides };
    }
    public int[] getAdherentsAffiliesMedecinsPharmaciesCount() {
        int adherentsCount = (int) adherentRepository.count();
        int affiliesCount = (int) affilieRepository.count();
        int medecinsConventionnesCount = (int) etablissementMedecinRepository.count();
        int pharmaciesConventionneesCount = (int) pharmacieRepository.count();
        return new int[] { adherentsCount, affiliesCount, medecinsConventionnesCount, pharmaciesConventionneesCount };
    }

}
