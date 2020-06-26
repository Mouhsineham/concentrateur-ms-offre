package com.sorec.concentrateur.offre.remote.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.sorec.concentrateur.framework.dto.SelectItemDto;
import com.sorec.concentrateur.framework.exception.RemoteException;
import com.sorec.concentrateur.offre.remote.dto.ReferenceDataDto;


@FeignClient("refData")
public interface ReferenceDataClient {

    @GetMapping("/api/v1/refdatatypes/{typeId}/refdata/select")
    List<SelectItemDto<Integer>> select(@PathVariable("typeId") Integer typeId,
                                        @RequestParam(name = "keyword", required = false) String keyword,
                                        @RequestParam(name = "ids", required = true) List<Integer> ids,
                                        @RequestParam(name = "importCodes", required = false) List<String> importCodes) throws RemoteException;

    @GetMapping("/api/v1/refdatatypes/{typeId}/refdata")
    List<ReferenceDataDto> getByIds(@PathVariable("typeId") Integer typeId,
                                    @RequestParam(name = "ids", required = true) List<Integer> ids) throws RemoteException;

    @GetMapping("/api/v1/refdatatypes/{typeId}/refdata/{id}")
    ReferenceDataDto get(@PathVariable("typeId") Integer typeId,@PathVariable("id") Integer id) throws RemoteException;
}
