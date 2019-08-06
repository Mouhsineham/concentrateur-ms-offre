package com.sofrecom.sofid.boundedcontext.service;


import javax.validation.constraints.NotNull;

import com.sofrecom.sofid.boundedcontext.domain.BoundedContext;

/**
 * @author sofid@sofrecom.com
 */
public interface BoundedContextService {

    /**
     * @see <a href="https://smnomadg6.sofrecom.fr/sofid/sofid-wiki/wikis/nomad-msxx/boundedcontext/service/smu_get">spec</a>
     */
    BoundedContext get(@NotNull Integer id);
}
