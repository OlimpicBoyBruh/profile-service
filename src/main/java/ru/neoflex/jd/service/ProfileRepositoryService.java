package ru.neoflex.jd.service;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ru.neoflex.jd.dto.ProfileDto;
import ru.neoflex.jd.dto.enumerated.Application;
import ru.neoflex.jd.mapping.ProfileMapper;
import ru.neoflex.jd.repository.ProfileRepository;
import ru.neoflex.jd.valid.ValidateProfileDto;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@Validated
@RequiredArgsConstructor
public class ProfileRepositoryService {
    private final ProfileRepository profileRepository;
    private final ProfileMapper profileMapper;

    public void createProfile(ProfileDto profileDto, Application application) {
        ValidateProfileDto.validate(profileDto, application);
        log.info("Invoke ProfileRepositoryService, method createProfile, profileDto {}, application: {}",
                profileDto, application);
        profileRepository.save(profileMapper.toEntity(profileDto));
        log.info("Profile successfully created.");
    }

    public ProfileDto getProfileById(UUID id) {
        log.info("Invoke ProfileRepositoryService, method getProfileById, id: {}", id);
        ProfileDto profileDto = profileMapper.toDto(profileRepository.findById(id).orElseThrow());
        log.info("Profile successfully found.");
        return profileDto;
    }

    public List<ProfileDto> searchProfile(ProfileDto profileDto) {
        log.info("Invoke ProfileRepositoryService, method searchProfile, profileDto: {}", profileDto);
        return profileRepository.findAll(Example.of(profileMapper.toEntity(profileDto),
                ExampleMatcher.matching().withIgnoreNullValues())).stream().map(profileMapper::toDto).toList();
    }


}
