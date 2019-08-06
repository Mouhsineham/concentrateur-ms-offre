package com.sofrecom.sofid.boundedcontext.remote.service;

import com.sofrecom.sofid.framework.dto.SelectItemDto;
import com.sofrecom.sofid.framework.exception.RemoteException;
import com.sofrecom.sofid.boundedcontext.remote.dto.ReferenceDataDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author sofid@sofrecom.com
 */

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
