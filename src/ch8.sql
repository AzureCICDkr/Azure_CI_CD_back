CREATE TABLE `board` (
                         `bno` int NOT NULL AUTO_INCREMENT,
                         `title` varchar(100) COLLATE utf8mb3_bin NOT NULL,
                         `writer` varchar(45) COLLATE utf8mb3_bin NOT NULL,
                         `content` varchar(2000) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
                         `write_date` date DEFAULT NULL,
                         `update_date` date DEFAULT NULL,
                         `board_like` int DEFAULT NULL,
                         `deleted_yn` char(1) COLLATE utf8mb3_bin DEFAULT 'N',
                         PRIMARY KEY (`bno`)
) ENGINE=InnoDB AUTO_INCREMENT=767 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='  ';




CREATE TABLE `board_comment` (
                                 `cno` int NOT NULL AUTO_INCREMENT,
                                 `pcno` int NOT NULL,
                                 `commenter` varchar(100) NOT NULL,
                                 `comment` varchar(2000) NOT NULL,
                                 `register_date` date DEFAULT NULL,
                                 `deleted_yn` varchar(1) DEFAULT 'N',
                                 PRIMARY KEY (`cno`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;



CREATE TABLE `user_info` (
                             `email` varchar(100) NOT NULL,
                             `name` varchar(100) NOT NULL,
                             `password` varchar(100) DEFAULT NULL,
                             `birth_date` date DEFAULT NULL,
                             `reg_date` date NOT NULL,
                             `sns` varchar(100) DEFAULT NULL,
                             PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;


#insert test user data

insert into user_info(email,name,password,reg_date) values(
                                                           'aaa@aaa.com',
                                                           'test_user',
                                                           '111111',
                                                           now()
                                                          );


# insert board data


INSERT INTO board (bno, title, writer, content, write_date, update_date, board_like, deleted_yn) VALUES (767, 'hello', 'aaa@aaa.com', 'hello', '2024-05-24', null, null, 'N');
INSERT INTO board (bno, title, writer, content, write_date, update_date, board_like, deleted_yn) VALUES (768, 'test title0', 'test writer', 'test content0', '2024-05-24', null, null, 'N');
INSERT INTO board (bno, title, writer, content, write_date, update_date, board_like, deleted_yn) VALUES (769, 'test title1', 'test writer', 'test content1', '2024-05-24', null, null, 'N');
INSERT INTO board (bno, title, writer, content, write_date, update_date, board_like, deleted_yn) VALUES (770, 'test title2', 'test writer', 'test content2', '2024-05-24', null, null, 'N');
INSERT INTO board (bno, title, writer, content, write_date, update_date, board_like, deleted_yn) VALUES (771, 'test title3', 'test writer', 'test content3', '2024-05-24', null, null, 'N');
INSERT INTO board (bno, title, writer, content, write_date, update_date, board_like, deleted_yn) VALUES (772, 'test title4', 'test writer', 'test content4', '2024-05-24', null, null, 'N');
INSERT INTO board (bno, title, writer, content, write_date, update_date, board_like, deleted_yn) VALUES (773, 'test title5', 'test writer', 'test content5', '2024-05-24', null, null, 'N');
INSERT INTO board (bno, title, writer, content, write_date, update_date, board_like, deleted_yn) VALUES (774, 'test title6', 'test writer', 'test content6', '2024-05-24', null, null, 'N');
INSERT INTO board (bno, title, writer, content, write_date, update_date, board_like, deleted_yn) VALUES (775, 'test title7', 'test writer', 'test content7', '2024-05-24', null, null, 'N');
INSERT INTO board (bno, title, writer, content, write_date, update_date, board_like, deleted_yn) VALUES (776, 'test title8', 'test writer', 'test content8', '2024-05-24', null, null, 'N');
INSERT INTO board (bno, title, writer, content, write_date, update_date, board_like, deleted_yn) VALUES (777, 'test title9', 'test writer', 'test content9', '2024-05-24', null, null, 'N');
INSERT INTO board (bno, title, writer, content, write_date, update_date, board_like, deleted_yn) VALUES (778, 'test title10', 'test writer', 'test content10', '2024-05-24', null, null, 'N');
INSERT INTO board (bno, title, writer, content, write_date, update_date, board_like, deleted_yn) VALUES (779, 'test title11', 'test writer', 'test content11', '2024-05-24', null, null, 'N');
INSERT INTO board (bno, title, writer, content, write_date, update_date, board_like, deleted_yn) VALUES (780, 'test title12', 'test writer', 'test content12', '2024-05-24', null, null, 'N');
INSERT INTO board (bno, title, writer, content, write_date, update_date, board_like, deleted_yn) VALUES (781, 'test title13', 'test writer', 'test content13', '2024-05-24', null, null, 'N');
INSERT INTO board (bno, title, writer, content, write_date, update_date, board_like, deleted_yn) VALUES (782, 'test title14', 'test writer', 'test content14', '2024-05-24', null, null, 'N');
INSERT INTO board (bno, title, writer, content, write_date, update_date, board_like, deleted_yn) VALUES (783, 'test title15', 'test writer', 'test content15', '2024-05-24', null, null, 'N');
INSERT INTO board (bno, title, writer, content, write_date, update_date, board_like, deleted_yn) VALUES (784, 'test title16', 'test writer', 'test content16', '2024-05-24', null, null, 'N');
INSERT INTO board (bno, title, writer, content, write_date, update_date, board_like, deleted_yn) VALUES (785, 'test title17', 'test writer', 'test content17', '2024-05-24', null, null, 'N');
INSERT INTO board (bno, title, writer, content, write_date, update_date, board_like, deleted_yn) VALUES (786, 'test title18', 'test writer', 'test content18', '2024-05-24', null, null, 'N');
INSERT INTO board (bno, title, writer, content, write_date, update_date, board_like, deleted_yn) VALUES (787, 'test title19', 'test writer', 'test content19', '2024-05-24', null, null, 'N');
INSERT INTO board (bno, title, writer, content, write_date, update_date, board_like, deleted_yn) VALUES (788, 'test title20', 'test writer', 'test content20', '2024-05-24', null, null, 'N');
INSERT INTO board (bno, title, writer, content, write_date, update_date, board_like, deleted_yn) VALUES (789, 'test title21', 'test writer', 'test content21', '2024-05-24', null, null, 'N');
INSERT INTO board (bno, title, writer, content, write_date, update_date, board_like, deleted_yn) VALUES (790, 'test title22', 'test writer', 'test content22', '2024-05-24', null, null, 'N');
INSERT INTO board (bno, title, writer, content, write_date, update_date, board_like, deleted_yn) VALUES (791, 'test title23', 'test writer', 'test content23', '2024-05-24', null, null, 'N');
INSERT INTO board (bno, title, writer, content, write_date, update_date, board_like, deleted_yn) VALUES (792, 'test title24', 'test writer', 'test content24', '2024-05-24', null, null, 'N');
INSERT INTO board (bno, title, writer, content, write_date, update_date, board_like, deleted_yn) VALUES (793, 'test title25', 'test writer', 'test content25', '2024-05-24', null, null, 'N');
INSERT INTO board (bno, title, writer, content, write_date, update_date, board_like, deleted_yn) VALUES (794, 'test title26', 'test writer', 'test content26', '2024-05-24', null, null, 'N');
INSERT INTO board (bno, title, writer, content, write_date, update_date, board_like, deleted_yn) VALUES (795, 'test title27', 'test writer', 'test content27', '2024-05-24', null, null, 'N');
INSERT INTO board (bno, title, writer, content, write_date, update_date, board_like, deleted_yn) VALUES (796, 'test title28', 'test writer', 'test content28', '2024-05-24', null, null, 'N');
INSERT INTO board (bno, title, writer, content, write_date, update_date, board_like, deleted_yn) VALUES (797, 'test title29', 'test writer', 'test content29', '2024-05-24', null, null, 'N');
INSERT INTO board (bno, title, writer, content, write_date, update_date, board_like, deleted_yn) VALUES (798, 'test title30', 'test writer', 'test content30', '2024-05-24', null, null, 'N');