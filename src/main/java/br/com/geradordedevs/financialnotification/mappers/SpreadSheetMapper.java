package br.com.geradordedevs.financialnotification.mappers;

import br.com.geradordedevs.financialnotification.dtos.responses.SpreadSheetResponseDTO;
import br.com.geradordedevs.financialnotification.entites.SpreadSheetEntity;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
public class SpreadSheetMapper {

    @Autowired
    private ModelMapper mapper;

    public SpreadSheetResponseDTO toDTO (SpreadSheetEntity spreadSheetEntity){
        log.info("converting entity to dto: {}", spreadSheetEntity);
        return mapper.map(spreadSheetEntity, SpreadSheetResponseDTO.class);
    }

    public List<SpreadSheetResponseDTO> toListDTO(Iterable<SpreadSheetEntity> list){
        log.info("converting entity list to dto list: {}", list);
        List<SpreadSheetEntity> result = new ArrayList<>();
        list.forEach(result::add);
        return result.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}
