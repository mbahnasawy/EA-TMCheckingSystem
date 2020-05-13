SET foreign_key_checks = 0;

INSERT INTO `tmchecking`.`User`
(`id`,
`email`,
`firstName`,
`gender`,
`lastName`,
`password`,
`userName`)
VALUES
('1',
'admin@miu.edu',
'admin',
'Male',
'admin',
'123',
'admin');
INSERT INTO `tmchecking`.`User`
(`id`,
`email`,
`firstName`,
`gender`,
`lastName`,
`password`,
`userName`)
VALUES
('2',
'mbahnasawy@miu.edu',
'Moustafa',
'Male',
'Bahnasawy',
'123',
'mbahnasawy');

INSERT INTO `tmchecking`.`User`
(`id`,
`email`,
`firstName`,
`gender`,
`lastName`,
`password`,
`userName`)
VALUES
('3',
'sweldemichael@miu.edu',
'Simon',
'Male',
'Weld',
'123',
'sweldemichael');

INSERT INTO `tmchecking`.`Role`
(`id`,
`roleName`)
VALUES
('1',
'ADMIN');

 INSERT INTO `tmchecking`.`Role`
(`id`,
`roleName`)
VALUES
('2',
'PROVIDER');


INSERT INTO `tmchecking`.`Role`
(`id`,
`roleName`)
VALUES
('3',
'CONSUMER');

INSERT INTO `tmchecking`.`User_Role`
(`User_id`,
`roles_id`)
VALUES
('1',
'1');

INSERT INTO `tmchecking`.`User_Role`
(`User_id`,
`roles_id`)
VALUES
('3',
'3');

INSERT INTO `tmchecking`.`User_Role`
(`User_id`,
`roles_id`)
VALUES
('2',
'2');