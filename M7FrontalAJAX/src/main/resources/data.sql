DROP TABLE IF EXISTS `products`;

CREATE TABLE `products` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `detail` text NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
);

INSERT INTO `products` VALUES (1,'PT01','Producto de test','2018-12-31 23:00:00','2019-08-02 08:50:31');
INSERT INTO `products` VALUES (2,'PT02','Producto de test','2018-12-31 23:00:00','2019-07-31 22:00:00');
INSERT INTO `products` VALUES (3,'PT03','Producto de test','2019-08-01 07:40:09','2019-08-01 07:40:09');
INSERT INTO `products` VALUES (4,'PT04','Producto de test','2019-08-01 07:40:09','2019-08-01 07:40:09');
INSERT INTO `products` VALUES (5,'PT05','Producto de test','2019-08-01 07:40:09','2019-08-01 07:40:09');
INSERT INTO `products` VALUES (6,'PT06','Producto de test','2019-08-01 07:40:09','2019-08-01 07:40:09');
INSERT INTO `products` VALUES (7,'PT07','Producto de test','2019-08-01 07:40:09','2019-08-01 07:40:09');
INSERT INTO `products` VALUES (8,'PT08','Producto de test','2019-08-01 07:40:09','2019-08-01 07:40:09');
INSERT INTO `products` VALUES (9,'PT09','Producto de test','2018-12-31 23:00:00','2018-12-31 23:00:00');
INSERT INTO `products` VALUES (10,'PT10','Producto de test','2019-08-02 07:34:42','2019-08-02 07:34:42');
INSERT INTO `products` VALUES (11,'PT11','Producto de test','2019-08-02 08:49:07','2019-08-02 08:49:07');
INSERT INTO `products` VALUES (12,'PT10','Producto de test','2019-09-04 17:02:53','2019-09-04 17:02:53');
INSERT INTO `products` VALUES (15,'PT99','Producto de test AJAX','2019-09-04 17:32:16','2019-09-04 17:32:16');
INSERT INTO `products` VALUES (16,'PT99','Producto de test AJAX','2019-09-04 18:13:09','2019-09-04 18:13:09');