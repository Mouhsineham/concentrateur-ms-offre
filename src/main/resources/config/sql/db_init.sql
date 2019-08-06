-- -----------------------------------------------------
-- Table `boundedcontext`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS boundedcontext(
                                 `id`                       INT          NOT NULL AUTO_INCREMENT,
                                 `username`                 varchar(255) NOT NULL,
                                 `password`                 varchar(64)  DEFAULT NULL,
                                 PRIMARY KEY (`id`),
                                 UNIQUE KEY `UK_USERNAME` (`username`)
);

CREATE TABLE IF NOT EXISTS bulk_operation_log(
								id INT NOT NULL AUTO_INCREMENT,
								operation_type VARCHAR (45) DEFAULT NULL,
								input_file VARCHAR(255) DEFAULT NULL,
								creation_date DATETIME DEFAULT NULL,
								start_date DATETIME DEFAULT NULL,
								end_date DATETIME DEFAULT NULL,
								status VARCHAR (45) DEFAULT NULL,
								user_id INT DEFAULT NULL,
								success_count INT DEFAULT 0,
								failure_count INT DEFAULT 0,
								error_file VARCHAR(255) DEFAULT NULL,
								PRIMARY KEY(id)
);
ALTER TABLE bulk_operation_log ADD CONSTRAINT FK_BULK_OPERATION_LOG_USER_ID FOREIGN KEY (user_id) REFERENCES boundedcontext(id);

CREATE TABLE IF NOT EXISTS bulk_operation_detail(
								id INT NOT NULL AUTO_INCREMENT,
								line INT NOT NULL DEFAULT 0,
								field_code VARCHAR(100) DEFAULT NULL,
								error VARCHAR(512) DEFAULT NULL,
								operation_id INT NOT NULL,
								PRIMARY KEY(id)
);

ALTER TABLE bulk_operation_detail ADD CONSTRAINT FK_BULK_OPERATION_DETAIL_OPERATION_ID FOREIGN KEY (operation_id) REFERENCES bulk_operation_log(id);


create table `i18n_text`(
								`id` INT NOT NULL AUTO_INCREMENT,
								`code` VARCHAR(255) NOT NULL,
								UNIQUE KEY UK_CODE (code),
								PRIMARY KEY(id)
);


create table `i18n_text_translation`(
								`id` INT NOT NULL AUTO_INCREMENT,
								`lang` VARCHAR(45) NOT NULL,
								`translation` VARCHAR(512) NOT NULL,
								`i18n_text_id` INT NOT NULL,
								PRIMARY KEY(id)
);