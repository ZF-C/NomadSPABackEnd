package com.nomadspa.backend.SpaService;

import java.util.List;
import java.util.stream.Collectors;

public class SpaServiceMapper {
    public static List<SpaServiceDTO> toDTOList(List<SpaService> spaServices) {
        return spaServices.stream()
                .map(SpaServiceMapper::toDTO)
                .collect(Collectors.toList());
    }
    public static SpaServiceDTO toDTO(SpaService spaService) {
        SpaServiceDTO dto = new SpaServiceDTO();
        //add exception Handling
        if(spaService == null){
            throw new IllegalStateException(
                    "Mapper cannot map null spaService");
        }
        if(spaService.getCustomer() == null){
            throw new IllegalStateException(
                    "Mapper cannot map null spaService.getCustomer()");
        }
        if(spaService.getTherapist() == null){
            throw new IllegalStateException(
                    "Mapper cannot map null spaService.getTherapist()");
        }
        if(spaService.getSpaServiceCatalog() == null){
            throw new IllegalStateException(
                    "Mapper cannot map null spaService.getSpaServiceCatalog()");
        }
        dto.setCustomerId(spaService.getCustomer().getCustomerId());
        dto.setTherapistId(spaService.getTherapist().getTherapistId());
        dto.setSpaServiceCatalogId(spaService.getSpaServiceCatalog().getSpaServiceCatalogId());
        dto.setStartTime(spaService.getStartTime());
        dto.setEndTime(spaService.getEndTime());
        dto.setPaymentMethod(spaService.getPaymentMethod());
        dto.setCardPayment(spaService.getCardPayment());
        dto.setCashPayment(spaService.getCashPayment());
        dto.setMemberShipPayment(spaService.getMemberShipPayment());
        return dto;
    }
}
