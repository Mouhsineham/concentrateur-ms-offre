package com.sorec.concentrateur.offre.exception;


import com.sorec.concentrateur.framework.exception.BusinessException;
import com.sorec.concentrateur.framework.exception.ErrorCode;

public class PartantException extends BusinessException {


	/**
	 * 
	 */
	private static final long serialVersionUID = 6960922383150060575L;
	

	public PartantException(ErrorCode code) {
        super(code);
    }

    public PartantException(ErrorCode code, Object[] args) {
        super(code, args);
    }

    public enum Error implements ErrorCode {

        PARTANT_NOT_FOUND(400, "partant.not.found");

        Error(Integer code, String i18nCode) {
            this.code = code;
            this.i18nCode = i18nCode;
        }

        String i18nCode;

        Integer code;

        @Override
        public Integer getCode() {
            return code;
        }

        @Override
        public String getI18nCode() {
            return i18nCode;
        }
    }
}
