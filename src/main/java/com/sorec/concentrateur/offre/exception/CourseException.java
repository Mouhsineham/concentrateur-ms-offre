package com.sorec.concentrateur.offre.exception;


import com.sorec.concentrateur.framework.exception.BusinessException;
import com.sorec.concentrateur.framework.exception.ErrorCode;

public class CourseException extends BusinessException {


	/**
	 * 
	 */
	private static final long serialVersionUID = 6960922383150060575L;
	

	public CourseException(ErrorCode code) {
        super(code);
    }

    public CourseException(ErrorCode code, Object[] args) {
        super(code, args);
    }

    public enum Error implements ErrorCode {

        COURSE_NOT_FOUND(400, "course.not.found");

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
