package com.sofrecom.sofid.boundedcontext.process;


import javax.validation.constraints.NotNull;

import com.sofrecom.sofid.boundedcontext.service.dto.BoundedContextDto;

/**
 * @author sofid@sofrecom.com
 */
public interface BoundedContextProcess {

    /**
     * @see <a href="https://smnomadg6.sofrecom.fr/sofid/sofid-wiki/wikis/nomad-msxx/boundedcontext/process/smo_get">spec</a>
     */
	BoundedContextDto get(@NotNull Integer id);

}
