package pe.edu.upc.gift_service.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.gift_service.dtos.PersonalizedProductDetailDTO;
import pe.edu.upc.gift_service.entities.PersonalizedProductDetail;
import pe.edu.upc.gift_service.servicesinterfaces.IPersonalizedProductDetailService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/personalizedproductdetails")
@CrossOrigin(origins = "http://localhost:4200")
//@PreAuthorize("hasAnyAuthority('EMPRENDIMIENTO','ADMIN')")
public class PersonalizedProductDetailController {
    @Autowired
    private IPersonalizedProductDetailService ppdS;

    @GetMapping
    public List<PersonalizedProductDetailDTO> list(){
        return ppdS.list().stream().map(y->{
            ModelMapper m=new ModelMapper();
            return m.map(y, PersonalizedProductDetailDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    //@PreAuthorize("hasAnyAuthority('USUARIO')")
    public void insert(@RequestBody PersonalizedProductDetailDTO personalizedProductDetailDTO){
        ModelMapper m=new ModelMapper();
        PersonalizedProductDetail pp=m.map(personalizedProductDetailDTO,PersonalizedProductDetail.class);
        ppdS.insert(pp);
    }

    @DeleteMapping("/{id}")
    //@PreAuthorize("hasAnyAuthority('USUARIO')")
    public void delete(@PathVariable("id") Integer id) {
        ppdS.delete(id);
    }
    @PutMapping
    //@PreAuthorize("hasAnyAuthority('USUARIO','EMPRENDIMIENTO', 'ADMIN')")
    public void update(@RequestBody PersonalizedProductDetailDTO personalizedProductDetailDTO) {
        ModelMapper m = new ModelMapper();
        PersonalizedProductDetail pp = m.map(personalizedProductDetailDTO, PersonalizedProductDetail.class);
        ppdS.insert(pp);
    }

    @GetMapping("/{id}")
    //@PreAuthorize("hasAnyAuthority('ADMIN')")
    public PersonalizedProductDetailDTO listById(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        PersonalizedProductDetail pp = ppdS.listId(id);
        return m.map(pp, PersonalizedProductDetailDTO.class);
    }
}
