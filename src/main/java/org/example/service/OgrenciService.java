package org.example.service;

import com.github.dozermapper.core.Mapper;
import org.example.dto.OgrenciDto;
import org.example.entity.Ogrenci;
import org.example.repository.OgrenciRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static javax.swing.UIManager.put;

@Service
public class OgrenciService {

    @Autowired
    OgrenciRepository ogrenciRepository;
    @Autowired
    private Mapper dozerMapper;

    public List<OgrenciDto> getAllOgrenciler() {
        List<OgrenciDto> ogrenciler = new ArrayList<>( );
                ogrenciRepository.findAll().forEach(
                ogrenci -> {
                    ogrenciler.add(dozerMapper.map(ogrenci, OgrenciDto.class));
                }
        );
        return ogrenciler;
    }

    public OgrenciDto getOgrenci(int id) {
        Optional<Ogrenci> foundPoint = ogrenciRepository.findById(id);
            if (foundPoint.isPresent()) {
                return dozerMapper.map(foundPoint.get(), OgrenciDto.class);
            }
            String mesaj = "Öğrenci bulunamadı! (" + id +  ")";
        throw new RuntimeException(mesaj);

    }

    public OgrenciDto ekleOgrenci(OgrenciDto ogrenciDto) {

            Ogrenci ogrenci = dozerMapper.map(ogrenciDto, Ogrenci.class);
            ogrenciRepository.save(ogrenci);
            return dozerMapper.map(ogrenci, OgrenciDto.class);
        }


    public OgrenciDto guncelleOgrenci(OgrenciDto ogrenciDto) {
        Optional<Ogrenci> foundOgrenci = ogrenciRepository.findById(ogrenciDto.getId());
        if (foundOgrenci.isPresent()) {
            foundOgrenci.get().setName(ogrenciDto.getName());
            foundOgrenci.get().setLastName(ogrenciDto.getLastName());
            foundOgrenci.get().setDepartment(ogrenciDto.getDepartment());
            ogrenciRepository.save(foundOgrenci.get());
            return dozerMapper.map(foundOgrenci.get(), OgrenciDto.class);
        }
        String mesaj = "Öğrenci bulunamadı! (" + ogrenciDto.getId() +  ")";
        throw new RuntimeException(mesaj);
    }
}