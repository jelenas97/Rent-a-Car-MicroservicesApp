package com.advertisement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CodeBookDTO {

    private List<CarBrandDTO> carBrands;
    private List<CarClassDTO> carClasses;
    private List<FuelTypeDTO> fuelTypes;
    private List<TransmissionTypeDTO> transmissionTypes;
}
