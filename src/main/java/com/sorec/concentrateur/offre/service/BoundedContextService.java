package com.sorec.concentrateur.offre.service;


import javax.validation.constraints.NotNull;

import com.sorec.concentrateur.offre.domain.BoundedContext;


public interface BoundedContextService {
 
    BoundedContext get(@NotNull Integer id);
}
