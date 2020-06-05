package com.advertisement.dto;

import com.advertisement.model.CarBrand;
import com.advertisement.model.CarClass;
import com.advertisement.model.FuelType;
import com.advertisement.model.TransmissionType;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
public class CodeBookModelDTO {
    private List<CarBrand> carBrands;
    private List<CarClass> carClasses;
    private List<FuelType> fuelTypes;
    private List<TransmissionType> transmissionTypes;
    private List<PriceListDTO> priceLists;

    public CodeBookModelDTO(List<CarBrand> carBrands, List<CarClass> carClasses, List<FuelType> fuelTypes, List<TransmissionType> transmissionTypes, List<PriceListDTO> priceLists) {
        this.carBrands = carBrands;
        this.carClasses = carClasses;
        this.fuelTypes = fuelTypes;
        this.transmissionTypes = transmissionTypes;
        this.priceLists = priceLists;
    }
}
