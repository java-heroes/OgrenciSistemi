  
package org.example.controller;

import org.example.dto.OgrenciDto;
import org.example.service.OgrenciService;
import org.example.entity.Ogrenci;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OgrenciController {

    @Autowired
    OgrenciService ogrenciService ;

    @RequestMapping(value = "/ogrenci", method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<List<OgrenciDto>> list(){
        List<OgrenciDto> ogrenciListesi = ogrenciService.getAllOgrenciler();
        return ResponseEntity.ok(ogrenciListesi);
    }

    @RequestMapping(value = "/ogrenci/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<OgrenciDto> getOgrenciById(@PathVariable int id) {
        return ResponseEntity.ok(ogrenciService.getOgrenci(id));
    }

    @RequestMapping(value = "/ogrenciler", method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<OgrenciDto> ekleOgrenci(@RequestBody OgrenciDto ogrenciDto) {
        return ResponseEntity.ok(ogrenciService.ekleOgrenci(ogrenciDto));
    }


    @RequestMapping(value = "/ogrenciler", method = RequestMethod.PUT, headers = "Accept=application/json")
    public ResponseEntity<OgrenciDto>  guncelleOgrenci(@RequestBody OgrenciDto ogrenciDto){
        return ResponseEntity.ok(ogrenciService.guncelleOgrenci(ogrenciDto));
    }
}
