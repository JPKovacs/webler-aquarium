package webleraquarium.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import webleraquarium.model.OwnerModel;
import webleraquarium.repository.OwnerRepository;
import webleraquarium.util.OwnerMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class OwnerService {

    private final OwnerRepository ownerRepository;

    public List<OwnerModel> getAllOwners() {
        return OwnerRepository.findAll()
                .stream()
                .map(OwnerMapper::mapOwnerEntityToOwnerModel)
                .collect(Collectors.toList());
    }





}
