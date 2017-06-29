USE `travelservice2`;
INSERT INTO `admin` (`id_admin`, `login`, `password`, `id_role`) VALUES
(1, 'tour', 'f0a4025b3b49b3e256004503ee31df8c', 2),(2, 'hotel', 'e919c49d5f0cd737285367810a3394d0', 3),(3, 'auto', '9df22f196a33acd0b372fe502de51211', 4);
INSERT INTO `apartment` (`id_apartment`, `id_hotel`, `id_room`, `room_capacity`, `price`, `status`, `image`) VALUES
(1, 4, 2, 2, 30.00, 'FREE', 'http://res.cloudinary.com/javadevgroup/image/upload/v1497805539/hotel/2noall_ibf5vm.jpg'),
(2, 4, 3, 2, 40.00, 'FREE', 'http://res.cloudinary.com/javadevgroup/image/upload/v1497805537/hotel/tv3_mrc5n1.jpg'),
(3, 4, 2, 1, 25.00, 'FREE', 'http://res.cloudinary.com/javadevgroup/image/upload/v1497853428/hotel/11.jpg'),
(4, 8, 3, 1, 20.00, 'FREE', 'http://res.cloudinary.com/javadevgroup/image/upload/v1497853428/hotel/1.jpg'),
(5, 8, 3, 2, 35.00, 'FREE', 'http://res.cloudinary.com/javadevgroup/image/upload/v1497805537/hotel/tv3_mrc5n1.jpg'),
(6, 9, 2, 1, 21.00, 'FREE', 'http://res.cloudinary.com/javadevgroup/image/upload/v1497853428/hotel/1.jpg'),
(7, 9, 3, 2, 37.00, 'FREE', 'http://res.cloudinary.com/javadevgroup/image/upload/v1497805534/hotel/2notv2_d1z64u.jpg'),
(8, 9, 3, 2, 37.00, 'FREE', 'http://res.cloudinary.com/javadevgroup/image/upload/v1497805534/hotel/2notv2_d1z64u.jpg'),
(9, 1, 4, 2, 50.00, 'FREE', 'http://res.cloudinary.com/javadevgroup/image/upload/v1497853428/hotel/1baltv.jpg'),
(10, 1, 8, 2, 48.00, 'FREE', 'http://res.cloudinary.com/javadevgroup/image/upload/v1497853428/hotel/2all3.jpg'),
(11, 1, 4, 1, 45.00, 'FREE', 'http://res.cloudinary.com/javadevgroup/image/upload/v1497853428/hotel/11111.jpg'),
(12, 5, 8, 2, 50.00, 'FREE', 'http://res.cloudinary.com/javadevgroup/image/upload/v1497805539/hotel/tv4_vkohcp.jpg'),
(13, 5, 8, 2, 50.00, 'FREE', 'http://res.cloudinary.com/javadevgroup/image/upload/v1497805539/hotel/tv4_vkohcp.jpg'),
(14, 10, 4, 1, 51.00, 'FREE', 'http://res.cloudinary.com/javadevgroup/image/upload/v1497853428/hotel/111.jpg'),
(15, 10, 4, 1, 51.00, 'FREE', 'http://res.cloudinary.com/javadevgroup/image/upload/v1497853428/hotel/111.jpg'),
(16, 10, 4, 2, 60.00, 'FREE', 'http://res.cloudinary.com/javadevgroup/image/upload/v1497805533/hotel/2notv_ildeop.jpg'),
(17, 2, 4, 3, 90.00, 'FREE', 'http://res.cloudinary.com/javadevgroup/image/upload/v1497805535/hotel/balc_wlaq7r.jpg'),
(18, 2, 8, 1, 75.00, 'FREE', 'http://res.cloudinary.com/javadevgroup/image/upload/v1497853429/hotel/1111.jpg'),
(19, 3, 4, 2, 80.00, 'FREE', 'http://res.cloudinary.com/javadevgroup/image/upload/v1497805539/hotel/tv4_vkohcp.jpg'),
(20, 3, 4, 1, 70.00, 'FREE', 'http://res.cloudinary.com/javadevgroup/image/upload/v1497853427/hotel/1all.jpg'),
(21, 6, 8, 2, 80.00, 'FREE', 'http://res.cloudinary.com/javadevgroup/image/upload/v1497805535/hotel/tv1_bkvotw.jpg'),
(22, 6, 8, 2, 80.00, 'FREE', 'http://res.cloudinary.com/javadevgroup/image/upload/v1497805535/hotel/tv1_bkvotw.jpg'),
(23, 7, 8, 2, 83.00, 'FREE', 'http://res.cloudinary.com/javadevgroup/image/upload/v1497805534/hotel/all_dje6yq.jpg'),
(24, 7, 8, 2, 83.00, 'FREE', 'http://res.cloudinary.com/javadevgroup/image/upload/v1497805534/hotel/all_dje6yq.jpg'),
(25, 7, 4, 1, 75.00, 'FREE', 'http://res.cloudinary.com/javadevgroup/image/upload/v1497853429/hotel/1111.jpg'),
(26, 5, 4, 1, 45.00, 'FREE', 'http://res.cloudinary.com/javadevgroup/image/upload/v1497853427/hotel/1tvcon.jpg');
INSERT INTO `auto` (`id_auto`, `id_brand`, `model`, `year`, `transmition`, `wheel_drive`, `fuil_type`, `id_color`, `id_body_type`, `image`) VALUES
(1, 3, 'Mustang', '1969', 'MANUAL', 'FULL', 'PETROL', 3, 2, 'http://res.cloudinary.com/javadevgroup/image/upload/v1497805554/auto/1969-Mustang-Pro-Street_tfthgb.jpg'),
(2, 1, 'X5', '2011', 'MANUAL', 'FRONT', 'PETROL', 1, 1, 'http://res.cloudinary.com/javadevgroup/image/upload/v1497805525/auto/bmw-x5-suv_gqaopv.jpg'),
(3, 2, 'C300', '2010', 'AUTO', 'FULL', 'DIESEL', 5, 2, 'http://res.cloudinary.com/javadevgroup/image/upload/v1497805529/auto/2015_mercedes-benz_c-class_sedan_c300_xbc5ol.jpg'),
(4, 3, 'Mustang', '1975', 'MANUAL', 'REAR', 'PETROL', 3, 2, 'http://res.cloudinary.com/javadevgroup/image/upload/v1497805531/auto/Lovely-Ford-Mustang_ploeiz.jpg'),
(5, 3, 'Flex', '2012', 'AUTO', 'FULL', 'GAS', 4, 1, 'http://res.cloudinary.com/javadevgroup/image/upload/v1497805525/auto/Ford-Flex-suv_rlhzej.jpg'),
(6, 2, 'AMG', '2015', 'MANUAL', 'REAR', 'ELECTRO', 3, 4, 'http://res.cloudinary.com/javadevgroup/image/upload/v1497805525/auto/Mercedes-AMG-C63S-Coupe_wqxpnc.jpg');
INSERT INTO `body_type` (`id_body_type`, `name`) VALUES
(1, 'SUV'),
(2, 'Sedan'),
(3, 'Minivan'),
(4, 'Coupe');
INSERT INTO `brand` (`id_brand`, `Name`) VALUES
(1, 'BMW'),
(2, 'Mercedes'),
(3, 'Ford');
INSERT INTO `bus` (`id_bus`, `name`, `capacity`, `registration_number`) VALUES
(1, 'MAZ 256170', 24, 'AH 6637-7'),
(6, 'Iveco', 22, 'AH 6347-7'),
(7, 'Mercedes Sprinter', 8, 'AH 6897-7'),
(8, 'Scania', 30, 'AH 6027-7');
INSERT INTO `city` (`id_city`, `Name`) VALUES
(1, 'Minsk'),
(2, 'Mogilev'),
(3, 'Brest'),
(4, 'Vitebsk');
INSERT INTO `color` (`id_color`, `name`) VALUES
(1, 'black'),
(2, 'white'),
(3, 'blue'),
(4, 'red'),
(5, 'silver');
INSERT INTO `hotel` (`id_hotel`, `id_city`, `title`, `stars`, `address`) VALUES
(1, 1, '"Minsk"', '4', '11 Nezavisimocti Ave.'),
(2, 1, '"Renaissance"', '5', '1E Dzerzhinskogo Ave.'),
(3, 1, '"President"', '5', '18 Kirova Str.'),
(4, 1, '"Tourist"', '3', '81 Partizanskiy Ave.'),
(5, 1, '"Victoria Olimp"', '4', '103 Pobediteley Ave.'),
(6, 1, '"Beijing"', '5', '36 Krasnoarmeiskaya Str.'),
(7, 1, '"Marriott"', '5', '20 Pobediteley Ave.'),
(8, 1, '"Planeta"', '3', '31 Pobediteley Ave'),
(9, 1, '"Belarus"', '3', '15 Storozhevskaya Str.'),
(10, 1, '"Victoria"', '4', '59 Pobediteley Ave.');
INSERT INTO `rent_auto` (`id_rent_auto`, `id_auto`, `id_salon_start`, `status`, `price`) VALUES
(1, 1, 1, 'FREE', 30.00),
(2, 2, 1, 'FREE', 25.00),
(3, 3, 2, 'FREE', 35.00),
(4, 4, 1, 'FREE', 30.00),
(5, 6, 3, 'FREE', 25.00),
(6, 5, 1, 'FREE', 35.00);
INSERT INTO `role` (`id_role`, `name`) VALUES
(1, 'customer'),
(2, 'admin_tour'),
(3, 'admin_hotel'),
(4, 'admin_auto'),
(5, 'vip_customer');
INSERT INTO `room` (`id_room`, `tv`, `balcony`, `conditioner`) VALUES
(1, 'No', 'No', 'No'),
(2, 'Yes', 'No', 'No'),
(3, 'Yes', 'Yes', 'No'),
(4, 'Yes', 'Yes', 'Yes'),
(5, 'No', 'Yes', 'Yes'),
(6, 'No', 'No', 'Yes'),
(7, 'No', 'Yes', 'No'),
(8, 'Yes', 'No', 'Yes');
INSERT INTO `salon` (`id_salon`, `id_city`, `address`) VALUES
(1, 1, '2 Vsnetsova Str.'),
(2, 1, '14 Pushkina Str.'),
(3, 2, '13 Lermontov Str.'),
(4, 3, '25A Gogol Str. '),
(5, 4, '17 Mayakovsky Str.');
INSERT INTO `tour` (`id_tour`, `destination`, `name`, `type`, `description`, `image`) VALUES
(1, 'Stankovo', 'Miracles of Stankovo Forest', 'REST', 'New Year\'s atmosphere lives here!', 'http://res.cloudinary.com/javadevgroup/image/upload/v1497429711/tourpics/stankovo_dtzzvp.jpg'),
(5, 'Belovezhskaya Puscha', 'National Park Belovezhskaya Puscha', 'TRIP', 'Belovezhskaya Puscha is included in the UNESCO World Heritage List.', 'http://res.cloudinary.com/javadevgroup/image/upload/v1497429704/tourpics/belobezhskaya_puscha_ecsm5n.jpg'),
(6, 'Naroch Land', 'Naroch Lakes', 'TRIP', 'The land of magnificent landscapes.', 'http://res.cloudinary.com/javadevgroup/image/upload/v1497429705/tourpics/narochansky_n460g1.jpg'),
(7, 'Postavy', 'Holiday in Solovyinaya Roscha (Postavy)', 'TRIP', 'Agroecotourist complex Solovyinaya Roscha looks like in a fairytale.', 'http://res.cloudinary.com/javadevgroup/image/upload/v1497429709/tourpics/pastavy_pficyz.jpg'),
(8, 'Berezinsky Biosphere Reserve', 'Berezinsky Biosphere Reserve', 'TRIP', 'Berezinsky Biosphere Reserve is a reserve, which is situated in the North of Belarus.', 'http://res.cloudinary.com/javadevgroup/image/upload/v1497429703/tourpics/berezinsky_rymh3u.jpg'),
(9, 'Novogrudok', 'Architectural memorials of Novogrudok', 'TRIP', 'Novogrudok is a city with a long history, the first capital of the Grand Duchy of Lithuania.', 'http://res.cloudinary.com/javadevgroup/image/upload/v1497429707/tourpics/novogrudok_bfioqa.jpg'),
(10, 'Mir', 'Architectural memorials of Mir', 'TRIP', 'In Mir you\'ll get to know the miracle ofbelarusian architecture — Mir castle.', 'http://res.cloudinary.com/javadevgroup/image/upload/v1497429706/tourpics/mirzamok_xlebe9.jpg'),
(11, 'Grodno', 'Shopping tour in Grodno', 'SHOP', 'Yuzhny market is considered to be the cheapest.', 'http://res.cloudinary.com/javadevgroup/image/upload/v1497429703/tourpics/grodno_ecgyw3.jpg'),
(12, 'Moscow', 'Shopping tour in Moscow', 'SHOP', 'Shopping complex Lyublino is the first multifunctional complex.', 'http://res.cloudinary.com/javadevgroup/image/upload/v1497429707/tourpics/moscow_x5jfxd.jpg'),
(13, 'Byalostok', 'Shopping tour in Byalostok', 'SHOP', 'Byalostok is assotiated with city-market, where each person finds something suitable for himself.', 'http://res.cloudinary.com/javadevgroup/image/upload/v1497429701/tourpics/bialystok_vzkpmo.jpg'),
(14, 'Vilnius', 'Shopping tour in Vilnius', 'SHOP', 'Garyunai market consists of two equal parts, the market is one of the largest markets in Eastern Europe.', 'http://res.cloudinary.com/javadevgroup/image/upload/v1497429711/tourpics/vilnius_mtto0b.jpg'),
(15, 'Red Pinewood', 'Rest in Red Pinewood', 'REST', 'Stay in a luxurious apartments in Red Pinewood, dinner in an elegant restaurant facing the lake, use finnish sauna and gym without limits.', 'http://res.cloudinary.com/javadevgroup/image/upload/v1497429719/tourpics/krasnybor_ywoeag.jpg'),
(16, 'Borovoe Sanatorium', 'Holiday in Borovoe Sanatoruim', 'REST', 'Belorussian sanatorium Borovoe is situated far from large cities and heavy traffic. ', 'http://res.cloudinary.com/javadevgroup/image/upload/v1497429709/tourpics/borovoe_kqwqoh.jpg'),
(17, 'Naroch', 'Priozerny Sanatorium', 'REST', 'Unique landsape and natural resources of Naroch has always attrached lots of tourists.', 'http://res.cloudinary.com/javadevgroup/image/upload/v1497429708/tourpics/priozerny_zpukgu.jpg'),
(18, 'Sosny', 'Sosny Sanatorium', 'REST', 'Sosny is one of the best belausian sanatoriums with 40-years experience in  resort therapy.', 'http://res.cloudinary.com/javadevgroup/image/upload/v1497429713/tourpics/sosny_v9ielg.jpg');
INSERT INTO `tour_offer` (`id_offer`, `id_tour`, `id_bus`, `date_start`, `date_end`, `passengers_per_order`, `price`, `hot`) VALUES
(1, 1, 1, '2017-12-20', '2017-12-21', 24, 55.00, 'NO'),
(10, 5, 8, '2017-06-27', '2017-06-28', 30, 40.00, 'NO'),
(11, 6, 6, '2017-07-03', '2017-07-05', 22, 76.00, 'NO'),
(14, 7, 1, '2017-06-28', '2017-07-03', 24, 89.00, 'NO'),
(15, 8, 6, '2017-06-18', '2017-06-19', 22, 45.00, 'NO'),
(16, 9, 7, '2017-06-20', '2017-06-21', 8, 62.00, 'NO'),
(17, 10, 8, '2017-06-20', '2017-06-21', 30, 58.00, 'NO'),
(18, 11, 8, '2017-06-18', '2017-06-19', 30, 54.00, 'NO'),
(19, 12, 1, '2017-06-19', '2017-06-21', 24, 35.00, 'NO'),
(20, 13, 6, '2017-07-08', '2017-07-11', 22, 40.00, 'NO'),
(21, 14, 8, '2017-07-22', '2017-07-24', 30, 51.00, 'NO'),
(22, 15, 7, '2017-07-12', '2017-07-20', 8, 157.00, 'NO'),
(23, 16, 6, '2017-07-13', '2017-07-26', 22, 116.00, 'NO'),
(24, 17, 1, '2017-07-08', '2017-07-18', 24, 140.00, 'NO'),
(25, 18, 1, '2017-07-21', '2017-06-28', 24, 95.00, 'NO');
