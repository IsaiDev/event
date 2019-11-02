CREATE TABLE `event` (
`id` bigint(20) NOT NULL AUTO_INCREMENT,
`id_organizer` bigint(255) NULL DEFAULT NULL,
`id_category` bigint(255) NULL DEFAULT NULL,
`name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
`description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
`urlImage` varchar(255) NULL,
`originCity` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
`country` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
`latitude` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
`longitude` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
`status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
PRIMARY KEY (`id`) 
)
ENGINE = InnoDB
AUTO_INCREMENT = 1
AVG_ROW_LENGTH = 0
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_general_ci
KEY_BLOCK_SIZE = 0
MAX_ROWS = 0
MIN_ROWS = 0
ROW_FORMAT = Dynamic;
CREATE TABLE `Organizer` (
`id` bigint NOT NULL AUTO_INCREMENT,
`name` varchar(255) NULL,
`status` varchar(255) NULL,
PRIMARY KEY (`id`) 
);
CREATE TABLE `Catageory` (
`id` bigint NOT NULL AUTO_INCREMENT,
`name` varchar(255) NULL,
`status` varchar(255) NULL,
PRIMARY KEY (`id`) 
);

ALTER TABLE `Organizer` ADD CONSTRAINT `fk_Organizer_event_1` FOREIGN KEY (`id`) REFERENCES `event` (`id_organizer`);
ALTER TABLE `Catageory` ADD CONSTRAINT `fk_Catageory_event_1` FOREIGN KEY (`id`) REFERENCES `event` (`id_category`);

