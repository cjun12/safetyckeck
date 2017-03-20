-- phpMyAdmin SQL Dump
-- version 4.7.0-beta1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: 2017-03-20 01:26:32
-- 服务器版本： 5.7.11
-- PHP Version: 5.6.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_safety`
--

-- --------------------------------------------------------

--
-- 表的结构 `tb_dns_detail`
--

CREATE TABLE `tb_dns_detail` (
  `id` int(11) NOT NULL,
  `itemid` int(11) NOT NULL,
  `target` text NOT NULL,
  `status` int(11) NOT NULL,
  `create_time` datetime NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `tb_http_detail`
--

CREATE TABLE `tb_http_detail` (
  `id` int(11) NOT NULL,
  `itemId` int(11) NOT NULL,
  `status_code` char(8) NOT NULL,
  `create_time` datetime NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `tb_message`
--

CREATE TABLE `tb_message` (
  `id` int(11) NOT NULL,
  `uid` int(11) NOT NULL,
  `dtime` datetime NOT NULL,
  `have_read` int(11) NOT NULL,
  `text` varchar(50) NOT NULL,
  `subject` varchar(30) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `tb_message`
--

INSERT INTO `tb_message` (`id`, `uid`, `dtime`, `have_read`, `text`, `subject`) VALUES
(1, 1, '2017-03-11 19:12:03', 0, '测试测试', '从厕所测试'),
(2, 1, '2017-03-11 19:12:08', 0, '测试大概', '吧 范德萨');

-- --------------------------------------------------------

--
-- 表的结构 `tb_monitoring_item`
--

CREATE TABLE `tb_monitoring_item` (
  `id` int(11) NOT NULL,
  `uid` int(11) NOT NULL,
  `target` varchar(255) DEFAULT NULL,
  `name` varchar(30) NOT NULL,
  `task_type` int(10) NOT NULL,
  `frequency` int(11) NOT NULL,
  `state` int(10) NOT NULL,
  `enabled` tinyint(4) NOT NULL,
  `create_time` timestamp NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `tb_monitoring_item`
--

INSERT INTO `tb_monitoring_item` (`id`, `uid`, `target`, `name`, `task_type`, `frequency`, `state`, `enabled`, `create_time`) VALUES
(1, 1, '127.0.0.1', 'PING测试', 1, 1, 1, 1, '2017-03-12 13:46:40'),
(2, 1, 'http://127.0.0.1', 'PING测试', 0, 1, 1, 1, '2017-03-12 13:46:53');

-- --------------------------------------------------------

--
-- 表的结构 `tb_ping_detail`
--

CREATE TABLE `tb_ping_detail` (
  `id` int(11) NOT NULL,
  `itemid` int(11) NOT NULL,
  `status` varchar(50) NOT NULL,
  `create_time` datetime NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `tb_snmp_detail`
--

CREATE TABLE `tb_snmp_detail` (
  `id` int(11) NOT NULL,
  `itemid` int(11) NOT NULL,
  `sysdesc` text NOT NULL,
  `cpuInfo` text NOT NULL,
  `swapDisk` text NOT NULL,
  `create_time` datetime NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `tb_user`
--

CREATE TABLE `tb_user` (
  `id` int(11) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(32) NOT NULL,
  `email` varchar(50) NOT NULL,
  `token` varchar(32) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `tb_user`
--

INSERT INTO `tb_user` (`id`, `username`, `password`, `email`, `token`) VALUES
(1, 'admin', '21232f297a57a5a743894a0e4a801fc3', 'www.dianbiao.com', 'ee506dbdfc031b625ce1ce0e6dd4fa88');

-- --------------------------------------------------------

--
-- 表的结构 `tb_waring_message`
--

CREATE TABLE `tb_waring_message` (
  `id` int(11) NOT NULL,
  `mid` int(11) NOT NULL,
  `dtime` timestamp NOT NULL,
  `text` text NOT NULL,
  `duration` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_dns_detail`
--
ALTER TABLE `tb_dns_detail`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tb_http_detail`
--
ALTER TABLE `tb_http_detail`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tb_message`
--
ALTER TABLE `tb_message`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tb_monitoring_item`
--
ALTER TABLE `tb_monitoring_item`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tb_ping_detail`
--
ALTER TABLE `tb_ping_detail`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tb_snmp_detail`
--
ALTER TABLE `tb_snmp_detail`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tb_user`
--
ALTER TABLE `tb_user`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tb_waring_message`
--
ALTER TABLE `tb_waring_message`
  ADD PRIMARY KEY (`id`);

--
-- 在导出的表使用AUTO_INCREMENT
--

--
-- 使用表AUTO_INCREMENT `tb_dns_detail`
--
ALTER TABLE `tb_dns_detail`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- 使用表AUTO_INCREMENT `tb_http_detail`
--
ALTER TABLE `tb_http_detail`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- 使用表AUTO_INCREMENT `tb_message`
--
ALTER TABLE `tb_message`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- 使用表AUTO_INCREMENT `tb_monitoring_item`
--
ALTER TABLE `tb_monitoring_item`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- 使用表AUTO_INCREMENT `tb_ping_detail`
--
ALTER TABLE `tb_ping_detail`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- 使用表AUTO_INCREMENT `tb_snmp_detail`
--
ALTER TABLE `tb_snmp_detail`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- 使用表AUTO_INCREMENT `tb_user`
--
ALTER TABLE `tb_user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
