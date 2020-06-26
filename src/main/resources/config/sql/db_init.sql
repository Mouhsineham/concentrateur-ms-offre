-- create table i18n_text(
-- 								`id` INT NOT NULL AUTO_INCREMENT,
-- 								`code` VARCHAR(255) NOT NULL,
-- 								UNIQUE KEY UK_CODE (code),
-- 								PRIMARY KEY(id)
-- );
-- 
-- 
-- create table i18n_text_translation(
-- 								`id` INT NOT NULL AUTO_INCREMENT,
-- 								`lang` VARCHAR(45) NOT NULL,
-- 								`translation` VARCHAR(512) NOT NULL,
-- 								`i18n_text_id` INT NOT NULL,
-- 								PRIMARY KEY(id)
-- );
-- 
CREATE TABLE boundedcontext(
                                 `id`                       INT          NOT NULL AUTO_INCREMENT,
                                 `username`                 varchar(255) NOT NULL,
                                 `password`                 varchar(64)  DEFAULT NULL,
                                 PRIMARY KEY (id)
);