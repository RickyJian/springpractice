USE [master]
GO

/****** Object:  Database [springpractice]    Script Date: 2019/1/26 �U�� 09:25:56 ******/
CREATE DATABASE [springpractice]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'springpractice', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.SQLEXPRESS\MSSQL\DATA\springpractice.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'springpractice_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.SQLEXPRESS\MSSQL\DATA\springpractice_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
GO

ALTER DATABASE [springpractice] SET COMPATIBILITY_LEVEL = 140
GO

IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [springpractice].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO

ALTER DATABASE [springpractice] SET ANSI_NULL_DEFAULT OFF 
GO

ALTER DATABASE [springpractice] SET ANSI_NULLS OFF 
GO

ALTER DATABASE [springpractice] SET ANSI_PADDING OFF 
GO

ALTER DATABASE [springpractice] SET ANSI_WARNINGS OFF 
GO

ALTER DATABASE [springpractice] SET ARITHABORT OFF 
GO

ALTER DATABASE [springpractice] SET AUTO_CLOSE OFF 
GO

ALTER DATABASE [springpractice] SET AUTO_SHRINK OFF 
GO

ALTER DATABASE [springpractice] SET AUTO_UPDATE_STATISTICS ON 
GO

ALTER DATABASE [springpractice] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO

ALTER DATABASE [springpractice] SET CURSOR_DEFAULT  GLOBAL 
GO

ALTER DATABASE [springpractice] SET CONCAT_NULL_YIELDS_NULL OFF 
GO

ALTER DATABASE [springpractice] SET NUMERIC_ROUNDABORT OFF 
GO

ALTER DATABASE [springpractice] SET QUOTED_IDENTIFIER OFF 
GO

ALTER DATABASE [springpractice] SET RECURSIVE_TRIGGERS OFF 
GO

ALTER DATABASE [springpractice] SET  DISABLE_BROKER 
GO

ALTER DATABASE [springpractice] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO

ALTER DATABASE [springpractice] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO

ALTER DATABASE [springpractice] SET TRUSTWORTHY OFF 
GO

ALTER DATABASE [springpractice] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO

ALTER DATABASE [springpractice] SET PARAMETERIZATION SIMPLE 
GO

ALTER DATABASE [springpractice] SET READ_COMMITTED_SNAPSHOT OFF 
GO

ALTER DATABASE [springpractice] SET HONOR_BROKER_PRIORITY OFF 
GO

ALTER DATABASE [springpractice] SET RECOVERY SIMPLE 
GO

ALTER DATABASE [springpractice] SET  MULTI_USER 
GO

ALTER DATABASE [springpractice] SET PAGE_VERIFY CHECKSUM  
GO

ALTER DATABASE [springpractice] SET DB_CHAINING OFF 
GO

ALTER DATABASE [springpractice] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO

ALTER DATABASE [springpractice] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO

ALTER DATABASE [springpractice] SET DELAYED_DURABILITY = DISABLED 
GO

ALTER DATABASE [springpractice] SET QUERY_STORE = OFF
GO

USE [springpractice]
GO

ALTER DATABASE SCOPED CONFIGURATION SET IDENTITY_CACHE = ON;
GO

ALTER DATABASE SCOPED CONFIGURATION SET LEGACY_CARDINALITY_ESTIMATION = OFF;
GO

ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET LEGACY_CARDINALITY_ESTIMATION = PRIMARY;
GO

ALTER DATABASE SCOPED CONFIGURATION SET MAXDOP = 0;
GO

ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET MAXDOP = PRIMARY;
GO

ALTER DATABASE SCOPED CONFIGURATION SET PARAMETER_SNIFFING = ON;
GO

ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET PARAMETER_SNIFFING = PRIMARY;
GO

ALTER DATABASE SCOPED CONFIGURATION SET QUERY_OPTIMIZER_HOTFIXES = OFF;
GO

ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET QUERY_OPTIMIZER_HOTFIXES = PRIMARY;
GO

ALTER DATABASE [springpractice] SET  READ_WRITE 
GO

