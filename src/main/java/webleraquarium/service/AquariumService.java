package webleraquarium.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import webleraquarium.model.AquariumModel;
import webleraquarium.repository.AquariumRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AquariumService {

    private final AquariumRepository aquariumRepository;

    public List<AquariumModel> getAllAquariums() {
        return aquariumRepository.findAll();
    }



}
