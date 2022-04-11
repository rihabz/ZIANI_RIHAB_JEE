package ma.enset.activitepratique.web;

import lombok.AllArgsConstructor;
import ma.enset.activitepratique.entities.Etudiant;
import ma.enset.activitepratique.repositories.EtudiantRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@AllArgsConstructor
public class EtudiantController {
    private EtudiantRepository etudiantRepository;
    @GetMapping(path = "/user/index")
    public String etudaints(Model model,@RequestParam(name = "page",defaultValue = "0") int page,
                            @RequestParam(name = "size",defaultValue = "5") int size,
                            @RequestParam(name = "keyword",defaultValue = "") String keyword){
        Page<Etudiant> pageEtudiant=etudiantRepository.findByNomContains(keyword, PageRequest.of(page,size));
        model.addAttribute("listEtudients",pageEtudiant.getContent());
        model.addAttribute("pages",new int[pageEtudiant.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("keyword",keyword);
        return "etudiants";
    }

    @GetMapping("/")
    public String home(){
        return  "home";
    }
    @GetMapping("/user/etudients")
    @ResponseBody
    public List<Etudiant> listEtudients(){
        return etudiantRepository.findAll();
    }

    @GetMapping("/admin/formPatients")
    public String formPatient(Model model){
        model.addAttribute("patient",new Etudiant());
        return "formEtudients";
    }
    @PostMapping(path = "/admin/save")
    public String save(Model model, @Valid Etudiant etudiant, BindingResult bindingResult,
                       @RequestParam(defaultValue = "0") int page,
                       @RequestParam(defaultValue = "") String keyword){
        if(bindingResult.hasErrors()) return "formEtudients";
        etudiantRepository.save(etudiant);
        return "redirect:/user/index?page="+page+"&keyword"+keyword;
    }
    //1- on ajoute dependance
    //2- On ajoute annotationt dans class patient.java
    //3- on ajoute ici annotation valid
    //4-on ajoute th dans fichier html
    @GetMapping("/admin/editPatient")
    public String editEtudient(Model model, Long id, String keyword, int page){
        Etudiant etudiant=etudiantRepository.findById(id).orElse(null);
        if(etudiant==null) throw new RuntimeException("Etudiant introuvable");
        model.addAttribute("etudiant",etudiant);
        model.addAttribute("page",page);
        model.addAttribute("keyword",keyword);
        return "editEtudient";
    }
}
