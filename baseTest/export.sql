--
-- MySQL 5.1.53
-- Mon, 02 Dec 2013 16:23:56 +0000
--

CREATE TABLE `cart` (
   `id` bigint(20) not null,
   `client_id` bigint(20),
   PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- [Table `cart` is empty]

CREATE TABLE `category` (
   `id` bigint(20) not null,
   `name` text,
   PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- [Table `category` is empty]

CREATE TABLE `client` (
   `id` bigint(20) not null auto_increment,
   `last_name` text,
   `first_name` text,
   `email` text,
   `phone` text,
   `coordinates_id` bigint(20),
   `cart_id` bigint(20),
   PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1;

-- [Table `client` is empty]

CREATE TABLE `coordinates` (
   `id` bigint(20) not null,
   `number` int(11),
   `qualifier` text,
   `name` text,
   `city` text,
   `country` text,
   PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- [Table `coordinates` is empty]

CREATE TABLE `product` (
   `id` bigint(20) not null,
   `category` bigint(20),
   `price` double,
   PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- [Table `product` is empty]