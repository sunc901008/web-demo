CREATE TABLE `table_info` (
  `id`          bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `fk`          bigint(20) unsigned NOT NULL,
  `tbl_name`    varchar(255)                 DEFAULT NULL,
  `description` varchar(45)                  DEFAULT NULL,
  `user_fk`     bigint(20) unsigned          DEFAULT '0',
  `create_time` datetime                     DEFAULT NULL,
  `update_time` datetime                     DEFAULT NULL,
  `version`     bigint(20) unsigned NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE `column_info` (
  `id`          bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `tbl_fk`      bigint(20) unsigned NOT NULL,
  `col_name`    varchar(255)                 DEFAULT NULL,
  `create_time` datetime                     DEFAULT NULL,
  `update_time` datetime                     DEFAULT NULL,
  `version`     bigint(20) unsigned NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;