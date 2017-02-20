/*
Navicat MySQL Data Transfer

Source Server         : LocalConnect
Source Server Version : 50707
Source Host           : localhost:3306
Source Database       : musicstore

Target Server Type    : MYSQL
Target Server Version : 50707
File Encoding         : 65001

Date: 2017-02-20 19:54:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for album
-- ----------------------------
DROP TABLE IF EXISTS `album`;
CREATE TABLE `album` (
  `AlbumId` int(11) NOT NULL AUTO_INCREMENT,
  `GenreId` int(11) NOT NULL,
  `ArtistId` int(11) NOT NULL,
  `Title` varchar(160) NOT NULL,
  `Price` decimal(18,2) NOT NULL,
  `AlbumArtUrl` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`AlbumId`),
  KEY `IX_ArtistId` (`ArtistId`) USING HASH,
  KEY `IX_GenreId` (`GenreId`) USING HASH,
  CONSTRAINT `FK_Album_Artist_ArtistId` FOREIGN KEY (`ArtistId`) REFERENCES `artist` (`ArtistId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_Album_Genre_GenreId` FOREIGN KEY (`GenreId`) REFERENCES `genre` (`GenreId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=247 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of album
-- ----------------------------
INSERT INTO `album` VALUES ('3', '1', '4', 'Let There Be Rock', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('4', '1', '5', 'Balls to the Wall', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('5', '1', '5', 'Restless and Wild', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('6', '1', '7', 'Big Ones', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('7', '1', '9', 'Jagged Little Pill', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('8', '1', '10', 'Facelift', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('9', '1', '15', 'Audioslave', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('10', '1', '37', 'Chronicle, Vol. 1', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('11', '1', '37', 'Chronicle, Vol. 2', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('12', '1', '38', 'Into The Light', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('13', '1', '39', 'Come Taste The Band', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('14', '1', '39', 'Deep Purple In Rock', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('15', '1', '39', 'Fireball', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('16', '1', '39', 'Machine Head', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('17', '1', '39', 'MK III The Final Concerts [Disc 1]', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('18', '1', '39', 'Purpendicular', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('19', '1', '39', 'Slaves And Masters', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('20', '1', '39', 'Stormbringer', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('21', '1', '39', 'The Battle Rages On', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('22', '1', '39', 'The Final Concerts (Disc 2)', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('23', '1', '43', 'Un-Led-Ed', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('24', '1', '50', 'King For A Day Fool For A Lifetime', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('25', '1', '52', 'In Your Honor [Disc 1]', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('26', '1', '52', 'In Your Honor [Disc 2]', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('27', '1', '52', 'The Colour And The Shape', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('28', '1', '53', 'Bongo Fury', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('29', '1', '59', 'Appetite for Destruction', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('30', '1', '59', 'Use Your Illusion I', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('31', '1', '61', 'A Matter of Life and Death', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('32', '1', '61', 'Brave New World', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('33', '1', '61', 'Fear Of The Dark', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('34', '1', '61', 'Live At Donington 1992 (Disc 1)', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('35', '1', '61', 'Live At Donington 1992 (Disc 2)', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('36', '1', '61', 'Rock In Rio [CD2]', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('37', '1', '61', 'The Number of The Beast', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('38', '1', '61', 'The X Factor', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('39', '1', '61', 'Virtual XI', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('40', '1', '63', 'Emergency On Planet Earth', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('41', '1', '64', 'Are You Experienced?', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('42', '1', '65', 'Surfing with the Alien (Remastered)', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('43', '1', '70', 'Greatest Kiss', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('44', '1', '70', 'Unplugged [Live]', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('45', '1', '71', 'BBC Sessions [Disc 1] [Live]', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('46', '1', '71', 'BBC Sessions [Disc 2] [Live]', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('47', '1', '71', 'Coda', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('48', '1', '71', 'Houses Of The Holy', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('49', '1', '71', 'In Through The Out Door', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('50', '1', '71', 'IV', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('51', '1', '71', 'Led Zeppelin I', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('52', '1', '71', 'Led Zeppelin II', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('53', '1', '71', 'Led Zeppelin III', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('54', '1', '71', 'Physical Graffiti [Disc 1]', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('55', '1', '71', 'Physical Graffiti [Disc 2]', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('56', '1', '71', 'Presence', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('57', '1', '71', 'The Song Remains The Same (Disc 1)', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('58', '1', '71', 'The Song Remains The Same (Disc 2)', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('59', '1', '73', 'Greatest Hits', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('60', '1', '77', 'Misplaced Childhood', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('61', '1', '88', 'Nevermind', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('62', '1', '89', 'Compositores', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('63', '1', '93', 'Bark at the Moon (Remastered)', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('64', '1', '93', 'Blizzard of Ozz', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('65', '1', '93', 'Diary of a Madman (Remastered)', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('66', '1', '93', 'No More Tears (Remastered)', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('67', '1', '93', 'Speak of the Devil', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('68', '1', '94', 'Walking Into Clarksdale', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('69', '1', '95', 'The Beast Live', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('70', '1', '96', 'Live On Two Legs [Live]', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('71', '1', '96', 'Riot Act', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('72', '1', '96', 'Ten', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('73', '1', '96', 'Vs.', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('74', '1', '97', 'Dark Side Of The Moon', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('75', '1', '98', 'Greatest Hits I', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('76', '1', '98', 'Greatest Hits II', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('77', '1', '98', 'News Of The World', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('78', '1', '99', 'New Adventures In Hi-Fi', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('79', '1', '100', 'Raul Seixas', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('80', '1', '101', 'By The Way', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('81', '1', '101', 'Californication', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('82', '1', '104', 'Retrospective I (1974-1980)', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('83', '1', '105', 'Santana - As Years Go By', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('84', '1', '105', 'Santana Live', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('85', '1', '105', 'Supernatural', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('86', '1', '109', 'Maquinarama', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('87', '1', '109', 'O Samba Poconé', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('88', '1', '110', 'A-Sides', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('89', '1', '113', 'Core', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('90', '1', '116', '[1997] Black Light Syndrome', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('91', '1', '119', 'Beyond Good And Evil', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('92', '1', '120', 'The Doors', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('93', '1', '122', 'The Police Greatest Hits', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('94', '1', '123', 'Every Kind of Light', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('95', '1', '124', 'Hot Rocks, 1964-1971 (Disc 1)', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('96', '1', '124', 'No Security', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('97', '1', '124', 'Voodoo Lounge', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('98', '1', '125', 'My Generation - The Very Best Of The Who', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('99', '1', '128', 'Achtung Baby', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('100', '1', '128', 'B-Sides 1980-1990', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('101', '1', '128', 'How To Dismantle An Atomic Bomb', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('102', '1', '128', 'Pop', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('103', '1', '128', 'Rattle And Hum', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('104', '1', '128', 'The Best Of 1980-1990', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('105', '1', '128', 'War', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('106', '1', '128', 'Zooropa', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('107', '1', '130', 'Diver Down', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('108', '1', '130', 'The Best Of Van Halen, Vol. I', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('109', '1', '130', 'Van Halen III', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('110', '1', '130', 'Van Halen', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('111', '1', '132', 'Contraband', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('112', '2', '2', 'A Copland Celebration, Vol. I', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('113', '2', '6', 'Górecki: Symphony No. 3', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('114', '2', '16', 'The Last Night of the Proms', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('115', '2', '17', 'Sibelius: Finlandia', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('116', '2', '18', 'Mozart: Symphonies Nos. 40 & 41', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('117', '2', '22', 'Carmina Burana', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('118', '2', '23', 'A Soprano Inspired', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('119', '2', '30', 'Scheherazade', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('120', '2', '34', 'SCRIABIN: Vers la flamme', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('121', '2', '45', 'Adams, John: The Chairman Dances', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('122', '2', '47', 'Pachelbel: Canon & Gigue', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('123', '2', '49', 'Respighi:Pines of Rome', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('124', '2', '49', 'Strauss: Waltzes', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('125', '2', '58', 'Nielsen: The Six Symphonies', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('126', '2', '62', 'Mascagni: Cavalleria Rusticana', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('127', '2', '69', 'Weill: The Seven Deadly Sins', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('128', '2', '74', 'Tchaikovsky: The Nutcracker', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('129', '2', '79', 'Szymanowski: Piano Works, Vol. 1', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('130', '2', '81', 'Berlioz: Symphonie Fantastique', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('131', '2', '81', 'Prokofiev: Romeo & Juliet', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('132', '2', '86', 'Mozart: Chamber Music', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('133', '2', '87', 'The Best of Beethoven', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('134', '2', '91', 'Bach: The Brandenburg Concertos', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('135', '2', '102', 'Purcell: The Fairy Queen', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('136', '2', '103', 'Haydn: Symphonies 99 - 104', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('137', '2', '106', 'Handel: The Messiah (Highlights)', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('138', '2', '107', 'Prokofiev: Symphony No.1', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('139', '2', '108', 'Wagner: Favourite Overtures', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('140', '2', '117', 'South American Getaway', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('141', '2', '121', 'English Renaissance', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('142', '2', '127', 'Bach: Toccata & Fugue in D Minor', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('143', '2', '134', 'Bach: Goldberg Variations', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('144', '2', '135', 'Bartok: Violin & Viola Concertos', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('145', '2', '136', 'Bach: The Cello Suites', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('146', '3', '3', 'Worlds', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('147', '3', '8', 'Quiet Songs', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('148', '3', '13', 'Warner 25 Anos', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('149', '3', '19', 'The Best Of Billy Cobham', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('150', '3', '40', 'Outbreak', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('151', '3', '55', 'Quanta Gente Veio ver--Bônus De Carnaval', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('152', '3', '60', 'Blue Moods', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('153', '3', '82', 'Miles Ahead', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('154', '3', '82', 'The Essential Miles Davis [Disc 1]', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('155', '3', '82', 'The Essential Miles Davis [Disc 2]', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('156', '3', '111', 'Heart of the Night', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('157', '3', '111', 'Morning Dance', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('158', '4', '11', 'Frank', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('159', '4', '131', 'Axé Bahia 2001', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('160', '5', '12', 'Ring My Bell', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('161', '5', '29', 'Le Freak', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('162', '5', '42', 'MacArthur Park Suite', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('163', '6', '13', 'Chill: Brazil (Disc 2)', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('164', '6', '25', 'Prenda Minha', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('165', '6', '25', 'Sozinho Remix Ao Vivo', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('166', '6', '28', 'Cássia Eller - Sem Limite [Disc 1]', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('167', '6', '31', 'Minha Historia', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('168', '6', '32', 'Afrociberdelia', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('169', '6', '32', 'Da Lama Ao Caos', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('170', '6', '36', 'Na Pista', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('171', '6', '41', 'Djavan Ao Vivo - Vol. 02', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('172', '6', '41', 'Djavan Ao Vivo - Vol. 1', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('173', '6', '44', 'The Best of Ed Motta', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('174', '6', '46', 'Elis Regina-Minha História', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('175', '6', '48', 'Unplugged', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('176', '6', '51', 'Deixa Entrar', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('177', '6', '54', 'Roda De Funk', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('178', '6', '55', 'Quanta Gente Veio Ver (Live)', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('179', '6', '57', 'Meus Momentos', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('180', '6', '66', 'Jorge Ben Jor 25 Anos', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('181', '6', '67', 'Jota Quest-1995', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('182', '6', '72', 'Mais Do Mesmo', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('183', '6', '75', 'Duos II', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('184', '6', '76', 'Chill: Brazil (Disc 1)', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('185', '6', '78', 'Barulhinho Bom', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('186', '6', '83', 'Milton Nascimento Ao Vivo', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('187', '6', '83', 'Minas', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('188', '6', '90', 'Olodum', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('189', '6', '92', 'Acústico MTV', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('190', '6', '92', 'Arquivo II', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('191', '6', '92', 'Arquivo Os Paralamas Do Sucesso', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('192', '6', '126', 'Serie Sem Limite (Disc 1)', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('193', '6', '126', 'Serie Sem Limite (Disc 2)', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('194', '6', '131', 'Sambas De Enredo 2001', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('195', '6', '131', 'Vozes do MPB', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('196', '6', '133', 'Vinicius De Moraes', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('197', '6', '137', 'Ao Vivo [IMPORT]', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('198', '7', '14', 'Plays Metallica By Four Cellos', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('199', '7', '20', 'Alcohol Fueled Brewtality Live! [Disc 1]', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('200', '7', '20', 'Alcohol Fueled Brewtality Live! [Disc 2]', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('201', '7', '21', 'Black Sabbath Vol. 4 (Remaster)', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('202', '7', '21', 'Black Sabbath', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('203', '7', '24', 'Chemical Wedding', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('204', '7', '56', 'Faceless', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('205', '7', '59', 'Use Your Illusion II', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('206', '7', '61', 'A Real Dead One', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('207', '7', '61', 'A Real Live One', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('208', '7', '61', 'Live After Death', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('209', '7', '61', 'No Prayer For The Dying', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('210', '7', '61', 'Piece Of Mind', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('211', '7', '61', 'Powerslave', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('212', '7', '61', 'Rock In Rio [CD1]', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('213', '7', '61', 'Rock In Rio [CD2]', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('214', '7', '61', 'Seventh Son of a Seventh Son', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('215', '7', '61', 'Somewhere in Time', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('216', '7', '61', 'The Number of The Beast', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('217', '7', '68', 'Living After Midnight', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('218', '7', '73', 'Greatest Hits', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('219', '7', '80', '...And Justice For All', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('220', '7', '80', 'Black Album', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('221', '7', '80', 'Garage Inc. (Disc 1)', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('222', '7', '80', 'Garage Inc. (Disc 2)', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('223', '7', '80', 'Load', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('224', '7', '80', 'Master Of Puppets', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('225', '7', '80', 'ReLoad', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('226', '7', '80', 'Ride The Lightning', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('227', '7', '80', 'St. Anger', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('228', '7', '84', 'Motley Crue Greatest Hits', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('229', '7', '85', 'Ace Of Spades', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('230', '7', '93', 'Tribute', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('231', '7', '114', 'Mezmerize', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('232', '8', '15', 'Revelations', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('233', '8', '26', 'Cake: B-Sides and Rarities', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('234', '8', '27', 'Carried to Dust (Bonus Track Version)', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('235', '8', '33', 'Carry On', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('236', '8', '115', 'Temple of the Dog', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('237', '9', '35', 'Acústico MTV [Live]', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('238', '9', '35', 'Cidade Negra - Hits', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('239', '9', '73', 'Greatest Hits', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('240', '9', '129', 'UB40 The Best Of - Volume Two [UK]', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('241', '10', '48', 'The Cream Of Clapton', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('242', '10', '48', 'Unplugged', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('243', '10', '61', 'Iron Maiden', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('244', '10', '112', 'In Step', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('245', '10', '118', 'Live [Disc 1]', '8.99', 'Resource/images/placeholder.gif');
INSERT INTO `album` VALUES ('246', '10', '118', 'Live [Disc 2]', '8.99', 'Resource/images/placeholder.gif');

-- ----------------------------
-- Table structure for artist
-- ----------------------------
DROP TABLE IF EXISTS `artist`;
CREATE TABLE `artist` (
  `ArtistId` int(11) NOT NULL AUTO_INCREMENT,
  `Name` longtext,
  PRIMARY KEY (`ArtistId`)
) ENGINE=InnoDB AUTO_INCREMENT=138 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of artist
-- ----------------------------
INSERT INTO `artist` VALUES ('1', 'Men At Work');
INSERT INTO `artist` VALUES ('2', 'Aaron Copland & London Symphony Orchestra');
INSERT INTO `artist` VALUES ('3', 'Aaron Goldberg');
INSERT INTO `artist` VALUES ('4', 'AC/DC');
INSERT INTO `artist` VALUES ('5', 'Accept');
INSERT INTO `artist` VALUES ('6', 'Adrian Leaper & Doreen de Feis');
INSERT INTO `artist` VALUES ('7', 'Aerosmith');
INSERT INTO `artist` VALUES ('8', 'Aisha Duo');
INSERT INTO `artist` VALUES ('9', 'Alanis Morissette');
INSERT INTO `artist` VALUES ('10', 'Alice In Chains');
INSERT INTO `artist` VALUES ('11', 'Amy Winehouse');
INSERT INTO `artist` VALUES ('12', 'Anita Ward');
INSERT INTO `artist` VALUES ('13', 'Antônio Carlos Jobim');
INSERT INTO `artist` VALUES ('14', 'Apocalyptica');
INSERT INTO `artist` VALUES ('15', 'Audioslave');
INSERT INTO `artist` VALUES ('16', 'Barry Wordsworth & BBC Concert Orchestra');
INSERT INTO `artist` VALUES ('17', 'Berliner Philharmoniker & Hans Rosbaud');
INSERT INTO `artist` VALUES ('18', 'Berliner Philharmoniker & Herbert Von Karajan');
INSERT INTO `artist` VALUES ('19', 'Billy Cobham');
INSERT INTO `artist` VALUES ('20', 'Black Label Society');
INSERT INTO `artist` VALUES ('21', 'Black Sabbath');
INSERT INTO `artist` VALUES ('22', 'Boston Symphony Orchestra & Seiji Ozawa');
INSERT INTO `artist` VALUES ('23', 'Britten Sinfonia, Ivor Bolton & Lesley Garrett');
INSERT INTO `artist` VALUES ('24', 'Bruce Dickinson');
INSERT INTO `artist` VALUES ('25', 'Caetano Veloso');
INSERT INTO `artist` VALUES ('26', 'Cake');
INSERT INTO `artist` VALUES ('27', 'Calexico');
INSERT INTO `artist` VALUES ('28', 'Cássia Eller');
INSERT INTO `artist` VALUES ('29', 'Chic');
INSERT INTO `artist` VALUES ('30', 'Chicago Symphony Orchestra & Fritz Reiner');
INSERT INTO `artist` VALUES ('31', 'Chico Buarque');
INSERT INTO `artist` VALUES ('32', 'Chico Science & Nação Zumbi');
INSERT INTO `artist` VALUES ('33', 'Chris Cornell');
INSERT INTO `artist` VALUES ('34', 'Christopher O\'Riley');
INSERT INTO `artist` VALUES ('35', 'Cidade Negra');
INSERT INTO `artist` VALUES ('36', 'Cláudio Zoli');
INSERT INTO `artist` VALUES ('37', 'Creedence Clearwater Revival');
INSERT INTO `artist` VALUES ('38', 'David Coverdale');
INSERT INTO `artist` VALUES ('39', 'Deep Purple');
INSERT INTO `artist` VALUES ('40', 'Dennis Chambers');
INSERT INTO `artist` VALUES ('41', 'Djavan');
INSERT INTO `artist` VALUES ('42', 'Donna Summer');
INSERT INTO `artist` VALUES ('43', 'Dread Zeppelin');
INSERT INTO `artist` VALUES ('44', 'Ed Motta');
INSERT INTO `artist` VALUES ('45', 'Edo de Waart & San Francisco Symphony');
INSERT INTO `artist` VALUES ('46', 'Elis Regina');
INSERT INTO `artist` VALUES ('47', 'English Concert & Trevor Pinnock');
INSERT INTO `artist` VALUES ('48', 'Eric Clapton');
INSERT INTO `artist` VALUES ('49', 'Eugene Ormandy');
INSERT INTO `artist` VALUES ('50', 'Faith No More');
INSERT INTO `artist` VALUES ('51', 'Falamansa');
INSERT INTO `artist` VALUES ('52', 'Foo Fighters');
INSERT INTO `artist` VALUES ('53', 'Frank Zappa & Captain Beefheart');
INSERT INTO `artist` VALUES ('54', 'Funk Como Le Gusta');
INSERT INTO `artist` VALUES ('55', 'Gilberto Gil');
INSERT INTO `artist` VALUES ('56', 'Godsmack');
INSERT INTO `artist` VALUES ('57', 'Gonzaguinha');
INSERT INTO `artist` VALUES ('58', 'Göteborgs Symfoniker & Neeme Järvi');
INSERT INTO `artist` VALUES ('59', 'Guns N\' Roses');
INSERT INTO `artist` VALUES ('60', 'Incognito');
INSERT INTO `artist` VALUES ('61', 'Iron Maiden');
INSERT INTO `artist` VALUES ('62', 'James Levine');
INSERT INTO `artist` VALUES ('63', 'Jamiroquai');
INSERT INTO `artist` VALUES ('64', 'Jimi Hendrix');
INSERT INTO `artist` VALUES ('65', 'Joe Satriani');
INSERT INTO `artist` VALUES ('66', 'Jorge Ben');
INSERT INTO `artist` VALUES ('67', 'Jota Quest');
INSERT INTO `artist` VALUES ('68', 'Judas Priest');
INSERT INTO `artist` VALUES ('69', 'Kent Nagano and Orchestre de l\'Opéra de Lyon');
INSERT INTO `artist` VALUES ('70', 'Kiss');
INSERT INTO `artist` VALUES ('71', 'Led Zeppelin');
INSERT INTO `artist` VALUES ('72', 'Legião Urbana');
INSERT INTO `artist` VALUES ('73', 'Lenny Kravitz');
INSERT INTO `artist` VALUES ('74', 'London Symphony Orchestra & Sir Charles Mackerras');
INSERT INTO `artist` VALUES ('75', 'Luciana Souza/Romero Lubambo');
INSERT INTO `artist` VALUES ('76', 'Marcos Valle');
INSERT INTO `artist` VALUES ('77', 'Marillion');
INSERT INTO `artist` VALUES ('78', 'Marisa Monte');
INSERT INTO `artist` VALUES ('79', 'Martin Roscoe');
INSERT INTO `artist` VALUES ('80', 'Metallica');
INSERT INTO `artist` VALUES ('81', 'Michael Tilson Thomas & San Francisco Symphony');
INSERT INTO `artist` VALUES ('82', 'Miles Davis');
INSERT INTO `artist` VALUES ('83', 'Milton Nascimento');
INSERT INTO `artist` VALUES ('84', 'Mötley Crüe');
INSERT INTO `artist` VALUES ('85', 'Motörhead');
INSERT INTO `artist` VALUES ('86', 'Nash Ensemble');
INSERT INTO `artist` VALUES ('87', 'Nicolaus Esterhazy Sinfonia');
INSERT INTO `artist` VALUES ('88', 'Nirvana');
INSERT INTO `artist` VALUES ('89', 'O Terço');
INSERT INTO `artist` VALUES ('90', 'Olodum');
INSERT INTO `artist` VALUES ('91', 'Orchestra of The Age of Enlightenment');
INSERT INTO `artist` VALUES ('92', 'Os Paralamas Do Sucesso');
INSERT INTO `artist` VALUES ('93', 'Ozzy Osbourne');
INSERT INTO `artist` VALUES ('94', 'Page & Plant');
INSERT INTO `artist` VALUES ('95', 'Paul D\'Ianno');
INSERT INTO `artist` VALUES ('96', 'Pearl Jam');
INSERT INTO `artist` VALUES ('97', 'Pink Floyd');
INSERT INTO `artist` VALUES ('98', 'Queen');
INSERT INTO `artist` VALUES ('99', 'R.E.M.');
INSERT INTO `artist` VALUES ('100', 'Raul Seixas');
INSERT INTO `artist` VALUES ('101', 'Red Hot Chili Peppers');
INSERT INTO `artist` VALUES ('102', 'Roger Norrington, London Classical Players');
INSERT INTO `artist` VALUES ('103', 'Royal Philharmonic Orchestra & Sir Thomas Beecham');
INSERT INTO `artist` VALUES ('104', 'Rush');
INSERT INTO `artist` VALUES ('105', 'Santana');
INSERT INTO `artist` VALUES ('106', 'Scholars Baroque Ensemble');
INSERT INTO `artist` VALUES ('107', 'Sergei Prokofiev & Yuri Temirkanov');
INSERT INTO `artist` VALUES ('108', 'Sir Georg Solti & Wiener Philharmoniker');
INSERT INTO `artist` VALUES ('109', 'Skank');
INSERT INTO `artist` VALUES ('110', 'Soundgarden');
INSERT INTO `artist` VALUES ('111', 'Spyro Gyra');
INSERT INTO `artist` VALUES ('112', 'Stevie Ray Vaughan & Double Trouble');
INSERT INTO `artist` VALUES ('113', 'Stone Temple Pilots');
INSERT INTO `artist` VALUES ('114', 'System Of A Down');
INSERT INTO `artist` VALUES ('115', 'Temple of the Dog');
INSERT INTO `artist` VALUES ('116', 'Terry Bozzio, Tony Levin & Steve Stevens');
INSERT INTO `artist` VALUES ('117', 'The 12 Cellists of The Berlin Philharmonic');
INSERT INTO `artist` VALUES ('118', 'The Black Crowes');
INSERT INTO `artist` VALUES ('119', 'The Cult');
INSERT INTO `artist` VALUES ('120', 'The Doors');
INSERT INTO `artist` VALUES ('121', 'The King\'s Singers');
INSERT INTO `artist` VALUES ('122', 'The Police');
INSERT INTO `artist` VALUES ('123', 'The Posies');
INSERT INTO `artist` VALUES ('124', 'The Rolling Stones');
INSERT INTO `artist` VALUES ('125', 'The Who');
INSERT INTO `artist` VALUES ('126', 'Tim Maia');
INSERT INTO `artist` VALUES ('127', 'Ton Koopman');
INSERT INTO `artist` VALUES ('128', 'U2');
INSERT INTO `artist` VALUES ('129', 'UB40');
INSERT INTO `artist` VALUES ('130', 'Van Halen');
INSERT INTO `artist` VALUES ('131', 'Various Artists');
INSERT INTO `artist` VALUES ('132', 'Velvet Revolver');
INSERT INTO `artist` VALUES ('133', 'Vinícius De Moraes');
INSERT INTO `artist` VALUES ('134', 'Wilhelm Kempff');
INSERT INTO `artist` VALUES ('135', 'Yehudi Menuhin');
INSERT INTO `artist` VALUES ('136', 'Yo-Yo Ma');
INSERT INTO `artist` VALUES ('137', 'Zeca Pagodinho');

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart` (
  `RecordId` int(11) NOT NULL AUTO_INCREMENT,
  `CartId` longtext,
  `AlbumId` int(11) NOT NULL,
  `Count` int(11) NOT NULL,
  `DateCreated` datetime NOT NULL,
  PRIMARY KEY (`RecordId`),
  KEY `IX_AlbumId` (`AlbumId`) USING HASH,
  CONSTRAINT `FK_Cart_Album_AlbumId` FOREIGN KEY (`AlbumId`) REFERENCES `album` (`AlbumId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cart
-- ----------------------------
INSERT INTO `cart` VALUES ('1', '1311a0d8-5939-486b-b0ca-9f456a7246bb', '62', '1', '2017-02-19 23:26:39');
INSERT INTO `cart` VALUES ('5', '2fe6c111-fdf9-45d6-a451-dfe0e9db57b9', '3', '2', '2017-02-20 10:37:49');
INSERT INTO `cart` VALUES ('6', '423bdfd4-27e0-4674-94e6-dfb4938b426c', '19', '1', '2017-02-20 16:33:49');
INSERT INTO `cart` VALUES ('7', '423bdfd4-27e0-4674-94e6-dfb4938b426c', '3', '1', '2017-02-20 16:51:56');
INSERT INTO `cart` VALUES ('9', 'f25a4f65-e5b2-4d0a-8c9e-474380566183', '55', '1', '2017-02-20 18:41:27');
INSERT INTO `cart` VALUES ('10', '162ad029-e3df-43ba-8502-89c0c9b2d673', '3', '1', '2017-02-20 18:46:27');
INSERT INTO `cart` VALUES ('11', '0121ff0f-304f-4ca0-8a3e-4679fb4a139c', '187', '3', '2017-02-20 18:52:56');
INSERT INTO `cart` VALUES ('12', '0121ff0f-304f-4ca0-8a3e-4679fb4a139c', '3', '1', '2017-02-20 19:04:49');
INSERT INTO `cart` VALUES ('13', 'cf4038f0-db44-4e57-9ca4-f458779189e7', '146', '1', '2017-02-20 19:46:48');
INSERT INTO `cart` VALUES ('14', 'cf4038f0-db44-4e57-9ca4-f458779189e7', '3', '1', '2017-02-20 19:49:52');

-- ----------------------------
-- Table structure for genre
-- ----------------------------
DROP TABLE IF EXISTS `genre`;
CREATE TABLE `genre` (
  `GenreId` int(11) NOT NULL AUTO_INCREMENT,
  `Name` longtext,
  `Description` longtext,
  PRIMARY KEY (`GenreId`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of genre
-- ----------------------------
INSERT INTO `genre` VALUES ('1', 'Rock', null);
INSERT INTO `genre` VALUES ('2', 'Classical', null);
INSERT INTO `genre` VALUES ('3', 'Jazz', null);
INSERT INTO `genre` VALUES ('4', 'Pop', null);
INSERT INTO `genre` VALUES ('5', 'Disco', null);
INSERT INTO `genre` VALUES ('6', 'Latin', null);
INSERT INTO `genre` VALUES ('7', 'Metal', null);
INSERT INTO `genre` VALUES ('8', 'Alternative', null);
INSERT INTO `genre` VALUES ('9', 'Reggae', null);
INSERT INTO `genre` VALUES ('10', 'Blues', null);

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `OrderId` int(11) NOT NULL AUTO_INCREMENT,
  `Username` longtext,
  `OrderDate` datetime NOT NULL,
  `FirstName` varchar(160) NOT NULL,
  `LastName` varchar(160) NOT NULL,
  `Address` varchar(70) NOT NULL,
  `City` varchar(40) NOT NULL,
  `State` varchar(40) NOT NULL,
  `PostalCode` varchar(10) NOT NULL,
  `Country` varchar(40) NOT NULL,
  `Phone` varchar(24) NOT NULL,
  `Email` longtext NOT NULL,
  `Total` decimal(18,2) NOT NULL,
  PRIMARY KEY (`OrderId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES ('1', 'Tom', '2017-02-20 19:28:37', 'Fan', 'ss', 'ss', 'ss', 'ss', 'ss', 'ss', '1545', '56555@qq.com', '35.96');

-- ----------------------------
-- Table structure for orderdetail
-- ----------------------------
DROP TABLE IF EXISTS `orderdetail`;
CREATE TABLE `orderdetail` (
  `OrderDetailId` int(11) NOT NULL AUTO_INCREMENT,
  `OrderId` int(11) NOT NULL,
  `AlbumId` int(11) NOT NULL,
  `Quantity` int(11) NOT NULL,
  `UnitPrice` decimal(18,2) NOT NULL,
  PRIMARY KEY (`OrderDetailId`),
  KEY `IX_AlbumId` (`AlbumId`) USING HASH,
  KEY `IX_OrderId` (`OrderId`) USING HASH,
  CONSTRAINT `FK_OrderDetail_Album_AlbumId` FOREIGN KEY (`AlbumId`) REFERENCES `album` (`AlbumId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_OrderDetail_Order_OrderId` FOREIGN KEY (`OrderId`) REFERENCES `order` (`OrderId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderdetail
-- ----------------------------

-- ----------------------------
-- Table structure for __migrationhistory
-- ----------------------------
DROP TABLE IF EXISTS `__migrationhistory`;
CREATE TABLE `__migrationhistory` (
  `MigrationId` varchar(150) NOT NULL,
  `ContextKey` varchar(300) NOT NULL,
  `Model` longblob NOT NULL,
  `ProductVersion` varchar(32) NOT NULL,
  PRIMARY KEY (`MigrationId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of __migrationhistory
-- ----------------------------
INSERT INTO `__migrationhistory` VALUES ('201702171624139_InitialCreate', 'MusicStore.EntityContext.MusicStoreEntities', 0x1F8B0800000000000400DD5C5B6FDCB6127E2F70FE83A0C70374D749D3A62758B770D77161B48E7DBC4E5F0D5AA2D74475D9525CC3FE6D7DE84FEA5F28A92BAF12A9DB6EFA126C2872389C19CE8C46F3F9EF3FFF5AFDF81247DE33C4194A9353FFCDE2C4F76012A4214AB6A7FE9E3C7EFDBDFFE30FFFF96AF5318C5FBCDFAA79DFB0797465929DFA4F84EC3E2C9759F00463902D6214E0344B1FC92248E32508D3E5DB9393FF2DDFBC59424AC2A7B43C6F75BB4F088A61FE1FFADF759A047047F620BA4A431865E5387DB2C9A97A9F400CB31D08E0A97FB5CF50B02129868B8F940879A58B097C21BE77162140F9D9C0E8D1F74092A40410CAED87CF19DC109C26DBCD8E0E80E8EE7507E9BC471065B03CC58766BAED814EDEB2032D9B85BD04E2D747A5872DCEC3D8CB0F7CEA9F450F7B610A9DF40B7C1506E8D00D4E771093D75BF8C82FBC0C7D6F292E5ECAABEBB5F242C6C5A97F99906FDEFADEA77D14818708D642E3A49BABE26798400C080C6F00211053215E86303F8DC282B4215D8961F786ED44CE304119194AE50E91085624A8C5D02BE07B57E0E557986CC913BD1CDF51A3BF402F30AC464AB29F13446F0C5D44F01E3A6F7B8351506F7B0E031483C8F76E30FD555ECAEF7D6F130046B087689842A97C3EE3A8ED68276FDF599D4DDAEC137846DBDC0EB41AF1BD5B18E58FB327B42BAEE622E7E8BE9A7081D3F8368D2A4ECBF1FB4DBAC7B95452CDC33B80B790D83393DB989697FCC97D4E3CE379E1C7EBED2A5E848715A3B6BC5CE310E27348008A322D4BDC84620F9E2FE5A1C29C3A43C7E16AD9F89A760F54A8A98F0BAAEFA4B30FB2BCCDE33921F66FCBEDA03F9D2F87B5840BE3EC21E0DA73BACAD7D2E51EB578D54DCE611660B42B22F1D87B99FD5CE93AFAFA16D9CF691D4F2FBBE21C411FEBE296F7B13169F95C96966F3B389BB0CB81DA89FC7F0F4A8E8750A1564946CE0FDA4D798C9024DBB4396839054D336BF762509578139EEAE3A5386550C02C58ED7BE17A5FB5392F197D9FC2C91C2EBDD00AE5B1B67EFAFB0EC5EE39F605C219E9084313A5F7BF8243ED7C1686186659CBC6EF27D977CDB93DCDA6EF26D97443383B996DD79B3423205A5302AD2F57934839DD2704CF2FE89BA734693BADE58BA4E3AE1F6396C70C7738AE2501EA32A31962AFDD5BA14B9CD306617D28EC15E7D600F77A2DBC85418AC33E71AE593957A063676CF69B2CCC8D926FE6EE601809165DD7183251B907DC1E692513AF9A4F36A38A0D738F5C6CF72CCBD200E5BBF33CDD6B6B1B1F93D06BAB4715A650D7B1A839EC238276110AE8CEA7FE7F15C11808D6792847B02C898914DFF8F2A5BA4ECE610409F4CE82A260BD065900425527541EA13842EF21C4CCF859D04A3282014A887A695112A01D885AF896D63855801867F51EF29373B88309BB9F2D5A18BA79BD8724AE2EE9AC969C29B55B98F0F26F32087D25A03188B26E39A13D1878D119A79DB5F732309D1C6C746CA88039D997EEDC03F79EC1BCD43772935E5B5ECF1BE5F2B5220787D6528DEE309CC33B3523EF56CE45FF79CDC9F08C8A19C8C05CD62726A3AD2662C84C25FB9BC9D1B5D5847ADE88FE06A8958C8D0118AA45EE16A895C4400E6630412E7734295A9748360ACEDF5F1C7C9D26F73C7E27A7323D977753857F6C6EAD691EA12B202E3968BA4BF2E708AAAE8D2DDB40227D006A5E3D4493500C4A5A9EA7A9DAF5E5DB4007813C0FD1AD2F93C78EE56245412122B8411B5246229DCB99C5E8561717555ACCE9545245DD58C04DD1351EC806D6F1DE5773DB685CB1D18E373D9E44A575F9DA8BE7B238B3F891513DB3F93DA4FB4D8463B8B2B296336B5F203AC5D6E3C89AAF51EAB93B1264CB1499635FBC282D723027C5930943AA0B1AA4D192B0D9A66CB23C2C24A1CFB42C05DB43207C51491584296DE84A1C387E4B3FD5726E4DAA3044F55559AB0E55F5B3D5B2688F2C07564B431FE5EA0AEC7628D9727D95E588B7299A2AD75F6FDCDB17E382C63210AC490EACF54E34A8822D949EB2C26508F3CF73E7808007C04A8BEB3056A6D907E66A43213EABDAAAC24C359DFD967300B1C374A1359C469817F47C314B811A363995ABEB3CD6DE0A22804DF5E0751AEDE3A4233532D3A94B143C1D63DDA2859FBA942630642CB09929951D963C9972C89E46D90EC1D328871C4EC437452A52AE1EA8F4564B49D54A9AAAD89592D78B566A67C365BA308E116BF31F1B2B362C9CDE6C8ACFE73C9562E4681454A647A3E847D30F68A51EC3BAA99D83BD6E4C1484C63D9E90F0E06874DD9145F5D0B8B153CF4AEFADAB4D3297DAF378A9B736FE75D2D452730C372385BFA6038F27D48CDA53E2BAF07852DCF07159E79876D9D7221D6D7104BB69DAD20425D5A38E965CF49DA937231FB6A7C5759EF1B4B8617B5A4D2B194FAA1975B863556B9870C7AA417B3A6BE57EAD1DEF56D9B7C59328871C5242AE0B4BC80BB9718733558D55C2B1AA4107AE8A462981A162C89E46D9F6C4D328871C92EEA2874948BA8BA1A3F15AC53BF5284E4BED4BCA6975F92CFD3293489B56245EAAA6D6A6364A558B91606BE5D8FC21B36C22520CDF299DE3BB8884748E7F30B3E9293514794ABD7B5D4B916A26ABB27ED10D50550A1AC514D636983EA3302F66BC6EFE8816ECF922FFB98E106452AE665C81043DC28CDCA5BFC3E4D4FF76F15E42B7F6409A2EB32C8C34859A63829B222684CEA63DC7B63609EE94EF31105FDA8786802E4D9E010E9E0056DBC0878047C319C0A37ACE73F868437C001CEE18008793986191A2151B4429955B8E591F45660787101E89C0541A1A50E0C8B23F4298DD24DA905046BDBCA8C6D90F44D5F5A1A160EA06BACD2F071A368961C868B0BE5755017B85F437C97BCF39BDB8474805FA355AEC95915DA31196805B5ABAEFDDC9F2B82C2DCD77EE3405D8D5584455549521EB180A9A1A8D611E13A5252AE647EE9027DDAD724730CDE5E90E0F0E9AC4D58978A0BE8E6E843028807DFA10D0407D7AB9DBB1213765EFD6BCA018A96F6B36D883F14BEC94509A7F1778E6607099792DC5F44D781A488CBD9D7C2920184B6D4D8938A89A6867C51838DCF871112D47D7ED3D1CC47258C0CA41CCC7F4017842388A83F91C3D00E5B05EA7E89B7746BC7C017EC6F089EF18E1246A73ABAC2E0D9AC40C2629BE24D15CFD21A5AA2DB272179C490BCC444BDA01826246A0E8283B8353BAB029BA4D9CC12B66EC8A91BC15ACC5886AD1919D1FEF229806DFEAD90971511BDB8F0CD2A282580E74A8D1412B96AC9A3309430BE1F1425254968FE0B023C04DFA6892F72A4DFFCA249812B5EF814649EECF77D3F09CA16D4382FD31EF0406427CACE75C268F6915A7258EAA2952A5EA8A6A2AA4C193B9A4471010FA38805996FF259EDF40B4CF0BA50F30BC4CAEF764B727F4C8307E88844E2D16EEDBF6CF813322CFABEBFCA36136C611289B8855D7AE939FF6280A6BBE2F34F5340309964794854CA64BC20A9ADBD79AD227A5ADCC44A8145F9DFEDCC178175162D975B201CFD0CC5BB70C4589ADCE11D8621067258D663DFD2F35BF307EF9E11F98CA5175805E0000, '6.0.2-21211');
